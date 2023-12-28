package test;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import metier.Produit;

public class ProduitModel extends AbstractTableModel {

	// Les noms des colonnes dans le tableau
	private String[] columnNames = new String[]{"idProduit", "designationProduit", "prix", "quantite", "categorie"};

	// Les valeurs du tableau, stockées dans un vecteur de tableaux de chaînes de caractères
	private Vector<String[]> tableValues = new Vector<String[]>();

	// Retourne le nombre de lignes dans le tableau
	@Override
	public int getRowCount() {
		return tableValues.size();
	}

	// Retourne le nombre de colonnes dans le tableau
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	// Retourne la valeur à l'emplacement spécifié dans le tableau
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableValues.get(rowIndex)[columnIndex];
	}

	// Retourne le nom de la colonne spécifiée
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// Met à jour les données du modèle avec la liste de produits fournie
	public void setData(List<Produit> produits) {
		// Efface les anciennes valeurs du tableau
		tableValues.clear();

		// Remplit le tableau avec les nouvelles valeurs à partir de la liste de produits
		for (Produit prods : produits) {
			tableValues.add(new String[]{prods.getIdProduit(), prods.getDesignationProduit(),
					String.valueOf(prods.getPrix()), String.valueOf(prods.getQuantite()),
					prods.getCategorie().getNomCategorie()});
		}

		// Notifie le tableau que les données ont changé
		fireTableChanged(null);
	}
}