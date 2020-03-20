import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class UserloginDashboard {

	private JFrame frame;
	public JLabel lblNewLabel,lblNewLabel_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserloginDashboard window = new UserloginDashboard();
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
	public UserloginDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 31));
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setBounds(591, 64, 251, 38);
		
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton btnSelectDate = new JButton("From:");
		btnSelectDate.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnSelectDate.setToolTipText("Click Here");
			}
		});
		btnSelectDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dateselect.main(null);
				Dateselect d=new Dateselect();
				d.putTextNow(lblNewLabel);
			}
		});
		btnSelectDate.setBackground(new Color(0, 0, 0));
		btnSelectDate.setForeground(new Color(255, 255, 255));
		btnSelectDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSelectDate.setBounds(360, 64, 187, 46);
		frame.getContentPane().add(btnSelectDate);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(591, 160, 251, 29);
		lblNewLabel_1.setFont(new Font("Gabriola", Font.PLAIN, 31));
		lblNewLabel_1.setBackground(SystemColor.info);
		frame.getContentPane().add(lblNewLabel_1);
		JButton btnNewButton = new JButton("To :");
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton.setToolTipText("Click Here");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e){
				Dateselect.main(null);
				Dateselect d=new Dateselect();
				d.putTextNow(lblNewLabel_1);
			}
		});
	btnNewButton.setBackground(new Color(0, 0, 0));
	btnNewButton.setForeground(new Color(255, 255, 255));
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(360, 152, 187, 46);
		frame.getContentPane().add(btnNewButton);
		
		
		
		frame.setTitle("UserLogin Dashboard");
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
