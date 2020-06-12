import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Registrationpage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrationpage window = new Registrationpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Registrationpage() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * 
	 */
	
	private void initialize() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bhola\\Database1.db");

		frame = new JFrame("Tally Trade-off");
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblRegistration.setBounds(865, 25, 265, 61);
		frame.getContentPane().add(lblRegistration);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblName.setBounds(684, 158, 83, 31);
		frame.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUsername.setBounds(684, 248, 149, 31);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblEmailid = new JLabel("EmailId");
		lblEmailid.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEmailid.setBounds(684, 340, 108, 31);
		frame.getContentPane().add(lblEmailid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword.setBounds(684, 436, 125, 31);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConformPassword = new JLabel("Confirm Password");
		lblConformPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblConformPassword.setBounds(684, 531, 252, 34);
		frame.getContentPane().add(lblConformPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBounds(1093, 160, 308, 41);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_1.setBounds(1093, 248, 308, 41);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_2.setBounds(1093, 340, 308, 41);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordField.setBounds(1093, 428, 308, 41);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passwordField_1.setBounds(1093, 520, 308, 41);
		frame.getContentPane().add(passwordField_1);
		JFrame parent=new JFrame();
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(0, 0, 0));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				String usr = textField_1.getText();
				String pass = new String(passwordField.getPassword());
				String cpass = new String(passwordField_1.getPassword());
				String email=textField_2.getText();
				String query = "insert into Admin1 values ('"+name+"','"+usr+"','"+pass+"','"+cpass+"','"+email+"')";
				//System.out.println(query);

				 
	                JFrame parent= new JFrame();
	                
	                if (usr == null || usr.isEmpty() || pass == null || pass.isEmpty()|| cpass == null || cpass.isEmpty()|| email == null || email.isEmpty()|| name == null || name.isEmpty()) {
	                    
	                    
	                    
	                    
	                    if (usr == null || usr.isEmpty()) {
	                        JOptionPane.showMessageDialog(parent,"Please enter your UserName");
	                    } else if (pass == null || pass.isEmpty()) {
	                    	 JOptionPane.showMessageDialog(parent,"Please enter your Password");
	                    }
	                    else if (cpass == null || cpass.isEmpty()) {
	                    	 JOptionPane.showMessageDialog(parent,"Please enter your  Conform Password");
	                    }
	                    else if (email == null || email.isEmpty()) {
	                    	 JOptionPane.showMessageDialog(parent,"Please enter your Email");
	                    }
	                    else if (name == null || name.isEmpty()) {
	                    	 JOptionPane.showMessageDialog(parent,"Please enter your Name");
	                    }
	                    
	                    
	                } else {
	                	int c=0,k=1;
	                	try {
					    	Class.forName("org.sqlite.JDBC");
							Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bhola\\Database1.db");

					    java.sql.Statement stmt = con.createStatement();
					    stmt.executeUpdate(query);
					    JOptionPane.showMessageDialog(parent,"Login Succeed","Message",JOptionPane.PLAIN_MESSAGE);
					    LoginAdmin1.main(null);
						frame.dispose();

					} catch (Exception e) {
						 JOptionPane.showMessageDialog(parent,"Please enter another userName");
						  c=1;
					}
	                	//JOptionPane.showMessageDialog(null, "Login Succeed","Meassage",JOptionPane.OK_OPTION);
	                	if(pass.compareTo(cpass)==0) {
	                		k=0;
					   
					}
	                	else
	                	{
	                		JOptionPane.showMessageDialog(parent,"Password MisMatch");
	                	}
	                	}
	                	
	                	
	                
			}
	                		
		});
		btnSubmit.setBounds(921, 636, 202, 48);
		frame.getContentPane().add(btnSubmit);
		
		JButton button = new JButton("BACK");
		button.setForeground(SystemColor.text);
		button.setBackground(SystemColor.desktop);
		button.setBounds(0, 0, 97, 25);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin1.main(null);
				frame.dispose();
			}
		});
		//button.setIcon(new ImageIcon(Registrationpage.class.getResource("/image/back1.png")));
		//button.setBounds(0, 0, 108, 106);
		frame.getContentPane().add(button);
	}
}
