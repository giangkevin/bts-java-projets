package metier;

import java.util.List;

public interface IMetier {
	public void addCategorie(Categorie c);
	public void addProduit(Produit c, int idCategorie);
	public List<Produit> getProduiParMotCle(String mc);
	public List<Produit> getProduitParIDCategorie(int idCategorie);
	public List<Categorie> getAllCategorie();
	public Categorie getCategorie(int idCategorie);
}
