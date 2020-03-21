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
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSponsersOfThe = new JLabel("Sponser's of the Project");
		lblSponsersOfThe.setForeground(SystemColor.text);
		lblSponsersOfThe.setFont(new Font("Gabriola", Font.BOLD, 40));
		lblSponsersOfThe.setBounds(12, 34, 462, 50);
		
		frame.getContentPane().add(lblSponsersOfThe);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Sponsers.class.getResource("/image/towel info.jpeg")));
		label.setBounds(763, 590, 451, 430);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Sponsers.class.getResource("/image/rsz_vtcard.jpg")));
		label_1.setBounds(235, 740, 369, 170);
		frame.getContentPane().add(label_1);
		
		JButton btnX = new JButton("X");
		btnX.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Homepage.main(null);
			}
		});
		btnX.setForeground(new Color(128, 128, 128));
		btnX.setBackground(new Color(255, 0, 0));
		btnX.setBounds(1851, 0, 69, 25);
		frame.getContentPane().add(btnX);
		
		JLabel lblNewLabel = new JLabel(
				"<html>-M/ s. Vishwa Traders is a partnership firm constituted by Bhola family and Chatla family,<br>carrying on the business of manufacturing towels since at A/ 21 / 2 MIDC, Akkalkot Road Solapur 413006.<br> With a view to modernize, and keep pace with the changing times, it is not proposed toset up fully automated new unit for manufacturing wide range of napkins and towels.<br>\r\n-Copy Of the partnership deed is enclosed herewith . Copies Of the profit and loss<br>\r\n accounts and balance sheets of the firm M/ s. Vishwa Traders for last three years are enclosed\r\n herewith <br>It is proposed to set up 30 Rapier looms with 250 RPM, which are way ahead of thecurrently used manual power looms. Initially, occupancy of 55% is expected in the first year.<br>-Capacity utilization is expected to reach 80% eventually by the second year.<br>\r\n Civil work for the project is in the completion stage, and machinery is expected to be installed and ready for production in the first week of December, 2018<br></html>\r\n"  );
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(22, 71, 958, 511);
		frame.getContentPane().add(lblNewLabel);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Sponsers.class.getResource("/image/rsz_210888.jpg")));
		panel.add(lblNewLabel_1);
		
		
		frame.setBounds(0, 0, 1920, 1080);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setVisible(true);
	}
}
