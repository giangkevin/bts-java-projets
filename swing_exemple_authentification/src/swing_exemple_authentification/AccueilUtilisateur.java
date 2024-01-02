package swing_exemple_authentification;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class AccueilUtilisateur extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton button;
	
	
	public AccueilUtilisateur() {
		
	}
	
	public AccueilUtilisateur(String userSes) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(150, 50, 1014, 597);
		this.setResizable(false);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		btnNewButton = new JButton("Déconnexion");
		this.btnNewButton.setForeground(new Color(0,0,0));
		this.btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN,39));
		this.btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a  = JOptionPane.showConfirmDialog(btnNewButton, "êtes-vous sûr");
				if( a == JOptionPane.YES_OPTION) {
					dispose();
					AuthentificationUtilisateur obj = new AuthentificationUtilisateur();
					obj.setTitle("Authentification");
					obj.setVisible(true);
				}
				dispose();
				AuthentificationUtilisateur obj = new AuthentificationUtilisateur();
				obj.setTitle("Authentification visiteur");
				obj.setVisible(true);
			}
		});
		
		this.btnNewButton.setBounds(247, 118, 497, 114);
		this.contentPane.add(btnNewButton);
		this.button = new JButton("Changer le mode de passe\r\n");
		this.button.setBackground(UIManager.getColor("Button.disabledForeground"));
		this.button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChangerMdp bo = new ChangerMdp(userSes);
				bo.setTitle("Changer le mot de passe");
				bo.setVisible(true);
			}
		});
		this.button.setFont(new Font("Tahoma", Font.PLAIN, 35));
		this.button.setBounds(247, 320, 491, 114);
		this.contentPane.add(button);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					AccueilUtilisateur frame  = new AccueilUtilisateur();
					frame.setVisible(true);
							
				}catch(Exception e ) {
					e.printStackTrace();
				}
			}
		});
	}
}
