import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class LoginAdmin1 {

	private JFrame frame;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin1 window = new LoginAdmin1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginAdmin1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize()  {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Palatino Linotype", Font.BOLD, 47));
		lblAdminLogin.setBounds(345, 0, 885, 200);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setBackground(new Color(245, 245, 220));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUsername.setBounds(729, 244, 137, 37);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword.setBounds(729, 343, 137, 43);
		frame.getContentPane().add(lblPassword);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		userNameTxt.setBounds(1000, 244, 222, 43);
		frame.getContentPane().add(userNameTxt);
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordTxt.setBounds(1000, 343, 222, 43);
		frame.getContentPane().add(passwordTxt);
		
		
		JButton btnNewRegistration = new JButton("New Registration");
		btnNewRegistration.setForeground(SystemColor.controlLtHighlight);
		btnNewRegistration.setBackground(SystemColor.activeCaptionText);
		btnNewRegistration.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrationpage.main(null);
			}
		});
		btnNewRegistration.setBounds(682, 482, 266, 64);
		frame.getContentPane().add(btnNewRegistration);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connection = null;
		        Statement selectStmt = null;

	                String userName = userNameTxt.getText();
	                String password = new String(passwordTxt.getPassword());
	                JFrame parent= new JFrame();
	                
	                if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
	                    
	                    
	                    
	                    
	                    if (userName == null || userName.isEmpty()) {
	                        JOptionPane.showMessageDialog(parent,"Please enter your UserName");
	                    } else if (password == null || password.isEmpty()) {
	                    	 JOptionPane.showMessageDialog(parent,"Please enter your Password");
	                    }
	                    
	                } else {
	                	//JOptionPane.showMessageDialog(null, "Login Succeed","Meassage",JOptionPane.OK_OPTION);
	                	
	                	try
	                	{
					    		Class.forName("org.sqlite.JDBC");
					    		connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bhola\\Database1.db");

			                	selectStmt = connection.createStatement();
			                    ResultSet rs = selectStmt.executeQuery("SELECT usr,pass FROM ADMIN1 WHERE usr = '"+userName+"'");
			                    if (rs.next() == false) 
			                    { 
			                    	JOptionPane.showMessageDialog(parent,"Please enter your Valid Username"); 
			                    }
			                    else
			                    {
			                    	do
			                    	{
			                    		if(rs.getString(2).compareTo(password)==0) {
				                    		
				                    		JOptionPane.showMessageDialog(parent,"Login Succeed","Message",JOptionPane.PLAIN_MESSAGE);
				                    		AdminDashboard.main(null);
				                    	}
				                    	else
				                    	{
					                        JOptionPane.showMessageDialog(parent,"Please enter your Valid Password");
					                        break;
				                    	}
			                    	} while (rs.next());
			                    }

			                    
			                    
			                    
			                    
	                	}
	                	catch (Exception e1) {
							// TODO: handle exception
	                        JOptionPane.showMessageDialog(parent,"Please enter your Valid Username");

						}
	            }
	        }
				
				
			
		});
		btnLogin.setForeground(SystemColor.controlLtHighlight);
		btnLogin.setBackground(SystemColor.desktop);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogin.setBounds(993, 482, 266, 64);
		frame.getContentPane().add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setForeground(SystemColor.controlLtHighlight);
		btnForgotPassword.setBackground(SystemColor.desktop);
		btnForgotPassword.setBounds(901, 604, 144, 25);
		frame.getContentPane().add(btnForgotPassword);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("adminlogo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(348, 213, 283, 234);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
			}
		});
		button.setIcon(new ImageIcon(LoginAdmin1.class.getResource("/image/back1.png")));
		button.setBounds(0, 0, 103, 109);
		frame.getContentPane().add(button);
	}
}
