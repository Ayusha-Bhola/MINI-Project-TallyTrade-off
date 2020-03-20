import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.xml.soap.Text;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Panel;

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
		
		JTextArea txtrIM = new JTextArea();
		txtrIM.setFont(new Font("Gabriola", Font.PLAIN, 25));
		txtrIM.setText("\r\n-M/ s. Vishwa Traders is a partnership firm constituted by Bhola family and Chatla family,\r\ncarrying on the business of manufacturing towels since at A/ 21 / 2 MIDC, Akkalkot Road Solapur\r\n413006. With a view to modernize, and keep pace with the changing times, it is not proposed to\r\nset up fully automated new unit for manufacturing wide range of napkins and towels.\r\n-Copy Of the partnership deed is enclosed herewith . Copies Of the profit and loss\r\naccounts and balance sheets of the firm M/ s. Vishwa Traders for last three years are enclosed\r\nherewith \r\nIt is proposed to set up 30 Rapier looms with 250 RPM, which are way ahead of the\r\ncurrently used manual power looms. Initially, occupancy of 55% is expected in the first year.\r\n-Capacity utilization is expected to reach 80% eventually by the second year.\r\nCivil work for the project is in the completion stage, and machinery is expected to be\r\ninstalled and ready for production in the first week of December, 2018\r\n");
		txtrIM.setForeground(SystemColor.text);
		txtrIM.setBackground(SystemColor.desktop);
		txtrIM.setBounds(12, 79, 757, 552);
		frame.getContentPane().add(txtrIM);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Sponsers.class.getResource("/image/towel info.jpeg")));
		label.setBounds(763, 590, 451, 430);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Sponsers.class.getResource("/image/rsz_vtcard.jpg")));
		label_1.setBounds(235, 740, 369, 170);
		frame.getContentPane().add(label_1);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sponsers.class.getResource("/image/rsz_210888.jpg")));
		panel.add(lblNewLabel);
		
		
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
