package swing_exemple_authentification;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class AuthentificationUtilisateur extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPanel contentPane;
	private JButton btnNewButton;
	
	
	public AuthentificationUtilisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1014, 597);
		setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		 this.lblNewLabel = new JLabel("Authentification");
		 this.lblNewLabel.setForeground(Color.BLACK);
		 this.contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		 this.lblNewLabel.setBounds(350, 13, 350, 120);
		 this.contentPane.add(lblNewLabel);
		 
		 this.textField = new JTextField();
		 this.textField.setFont(new Font ("Tahoma", Font.PLAIN, 32));
		 this.textField.setBounds(350, 170, 281, 68);
		 this.contentPane.add(textField);
		 this.textField.setColumns(10);
		 
		 this.passwordField = new JPasswordField();
		 this.passwordField.setFont(new Font ("Tahoma", Font.PLAIN, 32));
		 this.passwordField.setBounds(350,286,281,68);
		 this.contentPane.add(passwordField);
		 
		 this.lblUsername = new JLabel("identifiant");
		 this.lblUsername.setBackground(Color.BLACK);
		 this.lblUsername.setForeground(Color.BLACK);
		 this.lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
		 this.lblUsername.setBounds(150,166,193,52);
		 this.contentPane.add(lblUsername);
		 
		 this.lblPassword = new JLabel("mot de passe");
		 this.lblPassword.setForeground(Color.BLACK);
		 this.lblPassword.setBackground(Color.CYAN);
		 this.lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
		 this.lblPassword.setBounds(150,286,193,52);
		 this.contentPane.add(lblPassword);
		 
		 this.btnNewButton = new JButton("Valider");
		 this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN,26));
		 this.btnNewButton.setBounds(400, 420, 162, 80);
		 this.btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String identifiant = textField.getText();
				String mdp = passwordField.getText();
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo","root", "");
					PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT nom, mdp FROM etudiant WHERE nom =? AND mdp=?");
					ps.setString(1, identifiant);
					ps.setString(2, mdp);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						dispose();
						AccueilUtilisateur au = new AccueilUtilisateur(identifiant);
						au.setTitle("Bienvenue");
						au.setVisible(true);
						JOptionPane.showMessageDialog(btnNewButton, "Vous vous êtes connecté avec succès");
						
						
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "identifiant et mot de passe erronés");
					}
					
				}catch(SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		 
		 this.contentPane.add(btnNewButton);
		 
		 this.label = new JLabel("");
		 this.label.setBounds(0,0,1008,562);
		 this.contentPane.add(label);
	}
	
	/*
	 * Lance l'application
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthentificationUtilisateur frame = new AuthentificationUtilisateur();
					frame.setVisible(true);
				}catch(Exception e ) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
