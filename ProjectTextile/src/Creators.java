import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Creators {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creators window = new Creators();
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
	public Creators() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnX = new JButton("X");
		btnX.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnX.setBackground(Color.RED);

			}
		});
		btnX.setForeground(Color.GRAY);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
			}
		});
		btnX.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		btnX.setBackground(Color.WHITE);
		btnX.setBounds(1850, 0, 70, 31);
		frame.getContentPane().add(btnX);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Creators.class.getResource("/image/circle-cropped.png")));
		label.setBounds(1614, 186, 247, 229);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Creators.class.getResource("/image/circle-cropped (1).png")));
		label_1.setBounds(108, 513, 360, 367);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Creators.class.getResource("/image/circle-cropped (10).png")));
		label_2.setBounds(876, 513, 360, 363);
		frame.getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Creators.class.getResource("/image/circle-cropped (11).png")));
		label_4.setBounds(1295, 500, 369, 380);
		frame.getContentPane().add(label_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Creators.class.getResource("/image/circle-cropped (7).png")));
		label_3.setBounds(485, 513, 369, 367);
		frame.getContentPane().add(label_3);
		
		JLabel lblCreators = new JLabel("Creator's ");
		lblCreators.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreators.setFont(new Font("Gabriola", Font.BOLD, 45));
		lblCreators.setBounds(12, 13, 1908, 55);
		frame.getContentPane().add(lblCreators);
		
		JLabel lblAkshataMachal = new JLabel("Akshata Machal");
		lblAkshataMachal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAkshataMachal.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblAkshataMachal.setBounds(46, 911, 369, 61);
		frame.getContentPane().add(lblAkshataMachal);
		
		JLabel lblAyushaBhola = new JLabel("Ayusha Bhola");
		lblAyushaBhola.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblAyushaBhola.setHorizontalAlignment(SwingConstants.CENTER);
		lblAyushaBhola.setBounds(522, 911, 287, 61);
		frame.getContentPane().add(lblAyushaBhola);
		
		JLabel lblMeghaKarjol = new JLabel("Megha Karjol");
		lblMeghaKarjol.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeghaKarjol.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblMeghaKarjol.setBounds(930, 914, 287, 55);
		frame.getContentPane().add(lblMeghaKarjol);
		
		JLabel lblShrutikaChendake = new JLabel("Shrutika Chendake");
		lblShrutikaChendake.setHorizontalAlignment(SwingConstants.CENTER);
		lblShrutikaChendake.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblShrutikaChendake.setBounds(1366, 911, 279, 48);
		frame.getContentPane().add(lblShrutikaChendake);
		
		JLabel lblTeamMember = new JLabel("Team Member:");
		lblTeamMember.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblTeamMember.setBounds(22, 467, 262, 55);
		frame.getContentPane().add(lblTeamMember);
		
		JLabel lblTeamGuide = new JLabel("Team Guide:");
		lblTeamGuide.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblTeamGuide.setBounds(12, 64, 229, 55);
		frame.getContentPane().add(lblTeamGuide);
		
		JLabel lblAboutPsrPatnaik = new JLabel("<html>\r\nAbout P.S.R Patnaik <br>\r\nConsulting and development in AWS, Windows Azure, Google Compute Engine, Cloud Computing, BigData & Related technologies, Outsourcing through Elance and Odesk.\r\nTeaches following Subjects/Exams <br>\r\nInternet and Web Technologies (Computer: Programming)\r\nLanguage of Instruction: English<br>\r\nAWS, Google Cloud Platform, Windows Azure, Big Data Technologies<br>\r\nTeaching Experience Assistant Professor Walchand Institute of Technology, Maharashtra, India Jan 2012 - PresentInternet and Web Technologies<br></html>");
		lblAboutPsrPatnaik.setFont(new Font("Gabriola", Font.BOLD, 27));
		lblAboutPsrPatnaik.setBounds(12, 81, 1500, 386);
		frame.getContentPane().add(lblAboutPsrPatnaik);
		
		JLabel lblProfPsrPatnaik = new JLabel("Prof. P.S.R Patnaik");
		lblProfPsrPatnaik.setBackground(new Color(0, 0, 0));
		lblProfPsrPatnaik.setForeground(new Color(0, 0, 0));
		lblProfPsrPatnaik.setFont(new Font("Gabriola", Font.BOLD, 30));
		lblProfPsrPatnaik.setBounds(255, 97, 240, 61);
		frame.getContentPane().add(lblProfPsrPatnaik);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setVisible(true);
	}
}
