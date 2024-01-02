package swing_exemple_authentification;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChangerMdp extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JLabel lblEnterNewPassword;
	private JButton btnSearch;
	
	public ChangerMdp(String nom) {
		this.setBounds(150, 50, 1024, 400);
		this.setResizable(false);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		this.passwordField = new JPasswordField();
		this.passwordField.setFont(new Font("Tahoma", Font.PLAIN, 34));
		this.passwordField.setBounds(480, 80, 300, 67);
		this.contentPane.add(passwordField);
		this.passwordField.setColumns(10);
		this.btnSearch = new JButton("Valider");
		this.btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pswd = passwordField.getText();
				try{
					System.out.println("mettre a jour l'identifiant " +nom);
					System.out.println("mettre à jour le mot de passe");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo","root","");
					PreparedStatement st = (PreparedStatement) con.prepareStatement("UPDATE etudiant set mdp=? WHERE nom=?");
					st.setString(1, pswd);
					st.setString(2, nom);
					st.executeUpdate();
					JOptionPane.showMessageDialog(btnSearch, "Le mot de passe est changé avec succès");
					
				}catch(SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		
		this.btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 29));
		this.btnSearch.setBackground(new Color(240,240,240));
		this.btnSearch.setBounds(438, 200, 170 ,59);
		this.contentPane.add(btnSearch);
		this.lblEnterNewPassword = new JLabel("Entrer le nouveau mot de passe:" );
		this.lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.lblEnterNewPassword.setBounds(10, 80, 500, 67);
		this.contentPane.add(lblEnterNewPassword);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					
				}catch(Exception e ) {
					e.printStackTrace();
				}
			}
		});
	}

}
