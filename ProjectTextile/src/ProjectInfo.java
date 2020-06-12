import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class ProjectInfo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectInfo window = new ProjectInfo();
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
	public ProjectInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Project Info");
		frame.getContentPane().setFont(new Font("Gabriola", Font.BOLD, 22));
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
				frame.dispose(); //Destroy the JFrame object

			}
		});
		btnX.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		btnX.setBackground(Color.WHITE);
		btnX.setBounds(1854, 0, 66, 31);
		frame.getContentPane().add(btnX);
		
		JLabel lblNewLabel = new JLabel("<html>\r\n-> The proposed solution will have the ability to solve the problem of manual work of storing the data  and maintenance  of data.<br>\r\n-> This solution provides the connectivity between Tally and Database.<br>\r\n->  We implement efficient and user friendly application for users.<br>\r\n-> Data is Exported in Tally using XML interface using SOAP API interaction with HTTP interface<br>\r\n->Tally sends response to the XML  sent from which useful info is stored in database</html>\r\n\r\n");
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 440, 831, 372);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIdeaOfProject = new JLabel("Idea of Project:");
		lblIdeaOfProject.setFont(new Font("Gabriola", Font.BOLD, 31));
		lblIdeaOfProject.setBounds(12, 392, 248, 49);
		frame.getContentPane().add(lblIdeaOfProject);
		
		JLabel lblNewLabel_1 = new JLabel(" Software used:");
		lblNewLabel_1.setFont(new Font("Gabriola", Font.BOLD, 32));
		lblNewLabel_1.setBounds(1471, 417, 329, 56);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ProjectInfo.class.getResource("/image/logo-java.png")));
		label.setBounds(1459, 755, 216, 171);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ProjectInfo.class.getResource("/image/sqlicon.jpg")));
		label_1.setBounds(1703, 510, 248, 200);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ProjectInfo.class.getResource("/image/sysarch.jpg")));
		label_2.setBounds(859, 498, 451, 461);
		frame.getContentPane().add(label_2);
		
		JLabel lblWorking = new JLabel("Working :");
		lblWorking.setFont(new Font("Gabriola", Font.BOLD, 32));
		lblWorking.setBounds(914, 421, 160, 49);
		frame.getContentPane().add(lblWorking);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1920, 1080);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ProjectInfo.class.getResource("/image/scdemo.jpg")));
		panel.add(lblNewLabel_2);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setVisible(true);
	}
}
