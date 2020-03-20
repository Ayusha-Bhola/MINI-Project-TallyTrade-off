import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Homepage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
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
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sponsor's");
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
				
				btnNewButton.setToolTipText("Hello");

			}
		});
		btnNewButton.setFont(new Font("Lucida Console", Font.BOLD, 22));
		btnNewButton.setForeground(new Color(224, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		
		btnNewButton.setBounds(595, 40, 185, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Project Info");
		btnNewButton_1.setFont(new Font("Lucida Console", Font.BOLD, 22));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(224, 255, 255));
		btnNewButton_1.setBounds(839, 40, 204, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Creator's");
		btnNewButton_2.setFont(new Font("Lucida Console", Font.BOLD, 22));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(224, 255, 255));
		btnNewButton_2.setBounds(1090, 40, 204, 48);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOG IN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Lucida Console", Font.BOLD, 25));
		btnNewButton_3.setBounds(1704, 40, 153, 48);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblSaleSimulator = new JLabel("Sale Simulator");
		lblSaleSimulator.setFont(new Font("Gabriola", Font.BOLD | Font.ITALIC, 50));
		lblSaleSimulator.setBounds(240, 46, 307, 42);
		frame.getContentPane().add(lblSaleSimulator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Homepage.class.getResource("/image/comlogo.png")));
		label.setBounds(0, 0, 216, 113);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(1231, 517, 225, 225);
		frame.getContentPane().add(label_1);
		label_1.setIcon(new ImageIcon(Homepage.class.getResource("/image/graph.jpg")));
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Homepage.class.getResource("/image/image (1).png")));
		label_2.setBounds(1279, 149, 578, 321);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Homepage.class.getResource("/image/image.png")));
		label_3.setBounds(1490, 517, 388, 183);
		frame.getContentPane().add(label_3);
		
		Panel panel = new Panel();
		panel.setBounds(0,0,1920,1080);
		frame.getContentPane().add(panel);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Homepage.class.getResource("/image/bg1.jpg")));
		panel.add(label_4);
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img2=new ImageIcon("towel.jpg");
		Image img1=new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		
	}
}
