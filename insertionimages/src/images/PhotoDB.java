package images;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PhotoDB extends JFrame{
	/*
	 * liste variable
	 */
	private JButton btnAjouter;
	private JButton btnParcourir;
	private JButton btnSupprimer;
	private JLabel label;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextArea area;
	private JScrollPane pane;
	private String s;
	
	public PhotoDB() {
		
		// Initialisation des boutons et des champs de texte
		
		super("insérer une photo dans une base de donnée");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.btnAjouter = new JButton("Ajouter");
		this.btnAjouter.setBounds(200,300,100,40);
		
		this.btnParcourir = new JButton("Parcourir");
		this.btnParcourir.setBounds(80,300,100,40);
		
		this.btnSupprimer = new JButton("Supprimer");
		this.btnSupprimer.setBounds(80, 300, 100, 40);
		
		this.txtId = new JTextField("ID");
		this.txtId.setBounds(320,290,100,20);
		
		this.txtNom = new JTextField("Nom");
		this.txtNom.setBounds(320,330,100,20);
		
		this.area = new JTextArea("DESCRIPTION", 100, 100);
		this.pane = new JScrollPane(area);
		
		this.label = new JLabel();
		this.label.setBounds(10,10,670,250);
		
		this.btnParcourir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Création d'un sélecteur de fichiers
				JFileChooser fileChooser = new JFileChooser();
				
				// Définition du répertoire de départ du sélecteur de fichiers
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE","jpg", "gif", "png");
				fileChooser.addChoosableFileFilter(filter);
				
				// Affichage du sélecteur de fichiers et récupération du résultat
				int result = fileChooser.showSaveDialog(null);
				
                // Si un fichier est sélectionné, mettre à jour l'icône et le chemin du fichier

				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					label.setIcon(ResizeImage(path));
					s = path;
				}else if(result == JFileChooser.CANCEL_OPTION) {
					System.out.println("pas de données");
				}
			}
		});
		
		this.btnAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try { 
					// Connexion a la base de donnée
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_images","root","");
					
					// Préparation de la requête SQL pour l'insertion d'une nouvelle image
					PreparedStatement ps = con.prepareStatement("INSERT INTO monImage(id,nom,description,image) VALUES(?,?,?,?)");
					
					// Ajout du fichier à la base de donnée
					FileInputStream is = new FileInputStream(new File(s));
					ps.setString(1, txtId.getText());
					ps.setString(2, txtNom.getText());
					ps.setString(3, area.getText());
					ps.setBlob(4,is);
					ps.executeUpdate();
					
					// Affichage d'une boîte de dialogue informant que l'enregistrement a été effectué avec succès
					JOptionPane.showMessageDialog(null, "Enregistrement effectué");
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		//Ajout des composants à la fenetre
		this.add(label);
		this.add(txtId);
		this.add(txtNom);
		this.add(pane);
		this.add(btnAjouter);
		this.add(btnParcourir);
		this.add(btnSupprimer);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,420);
		this.setVisible(true);
	
	}
	
	/*
	 * Méthode pour redimensionner l'image
	 * 
	 */
	public ImageIcon ResizeImage(String imgPath) {
		ImageIcon myImage = new ImageIcon(imgPath);
		Image img = myImage.getImage();
		Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); //Redimensionne l'image selon le label
		ImageIcon image = new ImageIcon(newImage);
		
		return image; //Retourne l'image
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhotoDB application = new PhotoDB();
	}

}
