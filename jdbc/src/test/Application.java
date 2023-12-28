package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.Categorie;
import metier.MetierCatalogueImpl;
import metier.Produit;


public class Application extends JFrame {
	private JScrollPane jsp;
	
	private JLabel jlMc;
	private JTextField jTFMC;
	private JButton jBValider;
	private JTable jTableProduits;
	private JPanel jpN;
	private MetierCatalogueImpl metier;
	private ProduitModel model;
	private JComboBox<String> categorieBox;

	public Application() {
		
		this.metier = new MetierCatalogueImpl();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		this.jTFMC = new JTextField(12);
		this.jTFMC.setToolTipText("Mot clé:");
		this.jpN =  new JPanel();
		
		this.jpN.setLayout(new FlowLayout());
		this.jlMc = new JLabel("Mot clé:");
		this.jpN.add(jlMc);
		this.jpN.add(jTFMC);
		
		this.jBValider = new JButton("Valider");
		
		this.jpN.add(jBValider);
		this.categorieBox = new JComboBox<>();
		
		List<Categorie> list = this.metier.getAllCategorie();
		for (Categorie categorie : list) {
		    this.categorieBox.addItem(categorie.getNomCategorie());
		}
		 // Mettre à jour le modèle avec les produits associés à la première catégorie par défaut
        List<Produit> produits = metier.getProduitParIDCategorie(list.get(0).getIdCategorie());
        model = new ProduitModel();
        model.setData(produits);
        
		this.jpN.add(categorieBox);
		this.add(jpN,BorderLayout.NORTH);

		
		this.jTableProduits = new JTable(model);
		this.jsp = new JScrollPane(jTableProduits);
		
		this.add(jsp,BorderLayout.CENTER);
		this.setBounds(10,10,500,500);
		this.setVisible(true);
		
		jBValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mc = jTFMC.getText();
				List<Produit> produits = metier.getProduiParMotCle(mc);
				model.setData(produits);
			}
		});
		
		categorieBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idCat = categorieBox.getSelectedIndex()+1;
				List<Produit> produits = metier.getProduitParIDCategorie(idCat);
				model.setData(produits);
				}
			
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application app = new Application();
	}
}

