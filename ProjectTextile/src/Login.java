import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tally Trade-off");
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 16));
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Administrator");
		btnNewButton.setForeground(SystemColor.controlLtHighlight);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginAdmin1.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(622, 663, 294, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAdmin = new JButton("User");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginAdmin2.main(null);
				frame.dispose();
			}
		});
		btnAdmin.setBackground(SystemColor.desktop);
		btnAdmin.setForeground(SystemColor.controlLtHighlight);
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAdmin.setBounds(1095, 663, 278, 50);
		frame.getContentPane().add(btnAdmin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		Image img1=new ImageIcon(this.getClass().getResource("user.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(1095, 294, 361, 262);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("adminstrator.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(643, 315, 260, 227);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("login.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(854, 13, 302, 234);
		
		JButton button = new JButton("BACK");
		button.setForeground(SystemColor.text);
		button.setBackground(SystemColor.desktop);
		button.setBounds(0, 0, 97, 25);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
				frame.dispose();
			}
		});
		//button.setIcon(new ImageIcon(Registrationpage.class.getResource("/image/back1.png")));
		//button.setBounds(0, 0, 108, 106);
		frame.getContentPane().add(button);
		
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBackground(new Color(0, 0, 102));
		frame.setFont(new Font("Lucida Console", Font.BOLD, 12));
		frame.setTitle("TEXTILE LOGIN PAGE");
		
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
