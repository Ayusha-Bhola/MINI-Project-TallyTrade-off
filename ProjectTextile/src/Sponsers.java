import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.xml.soap.Text;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Sponsers {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sponsers window = new Sponsers();
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
	public Sponsers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sponser Desktop");
		frame.getContentPane().setForeground(SystemColor.text);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSponsersOfThe = new JLabel("Sponser's of the Project");
		lblSponsersOfThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSponsersOfThe.setBackground(new Color(240, 240, 240));
		lblSponsersOfThe.setForeground(Color.BLACK);
		lblSponsersOfThe.setFont(new Font("Gabriola", Font.BOLD, 40));
		lblSponsersOfThe.setBounds(490, 34, 737, 50);
		
		frame.getContentPane().add(lblSponsersOfThe);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Sponsers.class.getResource("/image/towel info.jpeg")));
		label.setBounds(1335, 621, 451, 430);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Sponsers.class.getResource("/image/rsz_vtcard.jpg")));
		label_1.setBounds(891, 724, 369, 170);
		frame.getContentPane().add(label_1);
		
		JButton btnX = new JButton("X");
		btnX.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnX.setBackground(Color.RED);
			}
			
		});
		btnX.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Homepage.main(null);
			}
		});
		btnX.setForeground(new Color(128, 128, 128));
		btnX.setBackground(Color.WHITE);
		btnX.setBounds(1851, 0, 69, 30);
		frame.getContentPane().add(btnX);
		
		JLabel lblNewLabel = new JLabel(
				"<html>-M/ s. Vishwa Traders is a partnership firm constituted by Bhola family and Chatla family,<br>carrying on the business of manufacturing towels since at A/ 21 / 2 MIDC, Akkalkot Road Solapur 413006.<br> With a view to modernize, and keep pace with the changing times, it is not proposed toset up fully automated new unit for manufacturing wide range of napkins and towels.<br>\r\n-Copy Of the partnership deed is enclosed herewith . Copies Of the profit and loss<br>\r\n accounts and balance sheets of the firm M/ s. Vishwa Traders for last three years are enclosed\r\n herewith <br>It is proposed to set up 30 Rapier looms with 250 RPM, which are way ahead of thecurrently used manual power looms. Initially, occupancy of 55% is expected in the first year.<br>-Capacity utilization is expected to reach 80% eventually by the second year.<br>\r\n Civil work for the project is in the completion stage, and machinery is expected to be installed and ready for production in the first week of December, 2018<br></html>\r\n"  );
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(843, 97, 958, 511);
		frame.getContentPane().add(lblNewLabel);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(panel);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Sponsers.class.getResource("/image/green-flower-bouquet-on-white-background-961402 (1).jpg")));
		panel.add(label_2);
		
		
		frame.setBounds(0, 0, 1920, 1080);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setVisible(true);
	}
}
