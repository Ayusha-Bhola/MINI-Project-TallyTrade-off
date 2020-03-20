import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminDashboard {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
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
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setTitle("Administrator Dashboard");
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUploadFile = new JButton("Upload File");
		btnUploadFile.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnUploadFile.setBounds(317, 285, 211, 55);
		frame.getContentPane().add(btnUploadFile);
		
		JButton btnView = new JButton("View");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserloginDashboard.main(null);
			}
		});
		btnView.setBounds(387, 533, 133, 55);
		frame.getContentPane().add(btnView);
		
		JButton btnChooseFile = new JButton("Browse");
		btnChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChooseFile.setBounds(706, 141, 154, 33);
		frame.getContentPane().add(btnChooseFile);
		
		textField = new JTextField();
		textField.setBounds(262, 140, 413, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblChooseFile = new JLabel("Choose File");
		lblChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChooseFile.setBounds(141, 140, 133, 34);
		frame.getContentPane().add(lblChooseFile);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
