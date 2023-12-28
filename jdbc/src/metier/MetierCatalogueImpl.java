package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MetierCatalogueImpl implements IMetier {

	Connection conn = null;

	@Override
	public void addCategorie(Categorie c) {
		// Obtient la connexion à la base de données
		conn = SingletonConnection.getConnection();
		try {
			// Requête SQL pour insérer une nouvelle catégorie
			String query = "insert into categorie (nomCategorie) values (?)";
			// Prépare la requête SQL
			PreparedStatement ps = conn.prepareStatement(query);
			// Enregistre le nom de la catégorie comme premier paramètre
			ps.setString(1, c.getNomCategorie());
			// Exécute l'insertion
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduit(Produit c, int idCategorie) {
		// Obtient la connexion à la base de données
		conn = SingletonConnection.getConnection();
		try {
			// Prépare la requête SQL pour insérer un nouveau produit
			PreparedStatement ps = conn.prepareStatement("insert into produit values (?,?,?,?,?)");
			// Définit les valeurs pour les paramètres de la requête
			ps.setString(1, c.getIdProduit());
			ps.setString(2, c.getDesignationProduit());
			ps.setDouble(3, c.getPrix());
			ps.setInt(4, c.getQuantite());
			ps.setInt(5, idCategorie);
			// Exécute l'insertion
			ps.executeUpdate();
			// Ferme la connexion
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produit> getProduiParMotCle(String mc) {
		List<Produit> listeProduits = new ArrayList<>();
		// Obtient la connexion à la base de données
		conn = SingletonConnection.getConnection();
		try {
			// Prépare la requête SQL pour récupérer les produits par mot-clé
			PreparedStatement ps = conn.prepareStatement("select * from produit where designationProduit like ?");
			ps.setString(1, "%" + mc + "%");
			// Exécute la requête SQL
			ResultSet rs = ps.executeQuery();
			// Parcourt chaque ligne du résultat
			while (rs.next()) {
				Produit produit = new Produit();
				produit.setIdProduit(rs.getString("idProduit"));
				produit.setDesignationProduit(rs.getString("designationProduit"));
				produit.setPrix(rs.getDouble("prix"));
				produit.setQuantite(rs.getInt("quantite"));

				int idCategorie = rs.getInt("idCategorie");
				// Obtient les informations sur la catégorie associée au produit
				PreparedStatement ps1 = conn.prepareStatement("select * from categorie where idCategorie=?");
				ps1.setInt(1, idCategorie);
				ResultSet rs1 = ps1.executeQuery();

				if (rs1.next()) {
					Categorie categorie = new Categorie();
					categorie.setIdCategorie(rs1.getInt("idCategorie"));
					categorie.setNomCategorie(rs1.getString("nomCategorie"));

					produit.setCategorie(categorie);
					// Ferme la connexion
					ps1.close();
				}
				// Ajoute le produit à la liste
				listeProduits.add(produit);
			}
			// Ferme la connexion
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Retourne la liste de produits
		return listeProduits;
	}

	@Override
	public List<Produit> getProduitParIDCategorie(int idCategorie) {
		List<Produit> listeProduits = new ArrayList<>();
		// Obtient la connexion à la base de données
		conn = SingletonConnection.getConnection();
		try {
			// Prépare la requête SQL pour récupérer les produits par ID de catégorie
			PreparedStatement ps = conn.prepareStatement("select *  from produit where idCategorie=?");
			ps.setInt(1, idCategorie);
			// Exécute la requête SQL
			ResultSet rs = ps.executeQuery();
			// Parcourt chaque ligne du résultat
			while (rs.next()) {
				Produit produit = new Produit();
				produit.setIdProduit(rs.getString("idProduit"));
				produit.setDesignationProduit(rs.getString("designationProduit"));
				produit.setPrix(rs.getDouble("prix"));
				produit.setQuantite(rs.getInt("quantite"));

				// Obtient les informations sur la catégorie associée au produit
				PreparedStatement ps1 = conn.prepareStatement("select * from categorie where idCategorie=?");
				ps1.setInt(1, idCategorie);
				ResultSet rs1 = ps1.executeQuery();

				if (rs1.next()) {
					Categorie categorie = new Categorie();
					categorie.setIdCategorie(rs1.getInt("idCategorie"));
					categorie.setNomCategorie(rs1.getString("nomCategorie"));

					produit.setCategorie(categorie);
					// Ferme la connexion
					ps1.close();
				}
				// Ajoute le produit à la liste
				listeProduits.add(produit);
			}
			// Ferme la connexion
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Retourne la liste de produits
		return listeProduits;
	}

	@Override
	public List<Categorie> getAllCategorie() {
		List<Categorie> listeCategories = new ArrayList<>();
		// Obtient la connexion à la base de données
		conn = SingletonConnection.getConnection();
		try {
			// Prépare la requête SQL pour récupérer toutes les catégories
			PreparedStatement ps = conn.prepareStatement("select * from categorie");
			// Exécute la requête SQL
			ResultSet rs = ps.executeQuery();
			// Parcourt chaque ligne du résultat
			while (rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setIdCategorie(rs.getInt("idCategorie"));
				categorie.setNomCategorie(rs.getString("nomCategorie"));
				// Ajoute la catégorie à la liste
				listeCategories.add(categorie);
			}
			// Ferme la connexion
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Retourne la liste de catégories
		return listeCategories;
	}

	@Override
	public Categorie getCategorie(int idCategorie) {
		Categorie categorie = new Categorie();
		// Obtient la connexion à la base de données
		conn = SingletonConnection.getConnection();
		try {
			// Prépare la requête SQL pour récupérer une catégorie par ID
			PreparedStatement ps = conn.prepareStatement("select * from categorie where idCategorie=?");
			ps.setInt(1, idCategorie);
			// Exécute la requête SQL
			ResultSet rs = ps.executeQuery();
			// Si une catégorie est trouvée
			if (rs.next()) {
				categorie.setIdCategorie(rs.getInt("idCategorie"));
				categorie.setNomCategorie(rs.getString("nomCategorie"));
				// Obtient la liste des produits associés à la catégorie
				List<Produit> listeProduits = this.getProduitParIDCategorie(idCategorie);
				categorie.setListeProduits(listeProduits);
			}
			// Ferme la connexion
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Retourne la catégorie avec la liste des produits associés
		return categorie;
	}
}