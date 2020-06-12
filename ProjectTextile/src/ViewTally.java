
import java.io.*;
import java.net.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import java.awt.SystemColor;
import java.awt.Color;

public class ViewTally {
	

	private JFrame frame;
	private  static ArrayList<String> l;
	public static String Url="";
	public static String cb="";
	public static JComboBox comboBox1;
	public static JTextField textField_2;
	public static JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTally window = new ViewTally();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * 
	 */
	
	public ViewTally() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static String getViewData() {
		return comboBox1.getSelectedItem().toString();
	}
	public static String getURl() {
		return ViewTally.Url;
		
	}
	public static String getYear() {
		return textField_2.getText();
	}

	
	public static String getComboboxText() {
		// TODO Auto-generated method stub
		return ViewTally.cb;
	}

	private void initialize() {
		
		frame = new JFrame("View Tally");
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Company Name :");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_1.setBounds(505, 190, 192, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblFinanchial = new JLabel("Financial Year :");
		lblFinanchial.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblFinanchial.setBounds(505, 280, 192, 35);
		frame.getContentPane().add(lblFinanchial);
		
		JLabel lblViewData = new JLabel("View Data :");
		lblViewData.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblViewData.setBounds(505, 443, 192, 35);
		frame.getContentPane().add(lblViewData);
		
		String []listViewData= {"TrialBalance","LedgerData"};
		 comboBox1 = new JComboBox(listViewData);
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		comboBox1.setBounds(783, 447, 326, 31);
		frame.getContentPane().add(comboBox1);
		
		JButton btnFetchData = new JButton("Fetch Data");
		btnFetchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VSelectApp.main(null);
				frame.dispose();
			}
		});
		btnFetchData.setForeground(SystemColor.text);
		btnFetchData.setBackground(SystemColor.desktop);
		btnFetchData.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnFetchData.setBounds(689, 603, 146, 36);
		frame.getContentPane().add(btnFetchData);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_2.setBounds(783, 282, 326, 35);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(781, 193, 328, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage.main(null);
				
				frame.dispose();
			}
		});
		button.setForeground(SystemColor.text);
		button.setBackground(SystemColor.desktop);
		button.setBounds(0, 0, 97, 25);
		//button.setIcon(new ImageIcon(LoginAdmin2.class.getResource("/image/back1.png")));
		//button.setBounds(0, 0, 104, 109);
		frame.getContentPane().add(button);
		
		
		
	}
    }
 

