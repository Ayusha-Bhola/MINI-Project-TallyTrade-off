
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

public class Tallygui {
	

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;
	private  static ArrayList<String> l;
	public static String Url="";
	public static String cb="";
	public static JComboBox comboBox1;
	private static JTextField textField_2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tallygui window = new Tallygui();
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
	
	public Tallygui() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static String getViewData() {
		return comboBox1.getSelectedItem().toString();
	}
	public static String getURl() {
		return Tallygui.Url;
		
	}
	public static String getYear() {
		return textField_2.getText();
	}

	
	public static String getComboboxText() {
		// TODO Auto-generated method stub
		return Tallygui.cb;
	}

	private void initialize() {
		
		frame = new JFrame("Tally connection");
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 lblNewLabel = new JLabel("Port Number :");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel.setBounds(125, 186, 192, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Company Name :");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_1.setBounds(125, 254, 192, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField.setBounds(353, 186, 326, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		/*JComboBox comboBox = new JComboBox();
		comboBox.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				comboBox.setToolTipText("First add port number");
			}
		});
		comboBox.setBounds(396, 258, 283, 30);
		frame.getContentPane().add(comboBox);
		*/
		 
		JButton btnAdd = new JButton("ADD");
		btnAdd.setToolTipText("Click to add Port Number");
		btnAdd.setForeground(SystemColor.text);
		btnAdd.setBackground(SystemColor.desktop);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "Added Port Number.",
					    "Conformation Message",
					    JOptionPane.PLAIN_MESSAGE);
				Tallygui.Url+=(TallyRequest.Url+textField.getText()+"/");
				
				//System.out.println(Tallygui.Url);
				TallyRequest r = new TallyRequest();
		        try {
					l=r.SendToTally();//List of companies returned
					
					JComboBox<String> comboBox = new JComboBox<String>(l. toArray(new String[l. size()]));
					comboBox.setBounds(353, 263, 283, 30);
					comboBox.setToolTipText("Click to select");

					comboBox.setVisible(true);
					comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 17));
					frame.getContentPane().add(comboBox);
					comboBox.addActionListener(new ActionListener() {
					 	public void actionPerformed(ActionEvent arg0) {
					 		cb=comboBox.getSelectedItem().toString();
					 		//System.out.println(cb);
					 	}
					 });
					
					//cb=comboBox.getSelectedItem().toString();
					
					
				} catch (ConnectException e1)
		        {
					TallyRequest.Url="http://127.0.0.1:";
				    JOptionPane.showMessageDialog(null, "Please enter valid Tally Port Number and KEEP Tally server on","Alert!", JOptionPane.ERROR_MESSAGE);

		        }
		        catch(Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});	
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnAdd.setBounds(862, 190, 108, 31);
		frame.getContentPane().add(btnAdd);
		
		
		
		JLabel lblPleaseNoteThe = new JLabel("<html>Please note :<br>\r\n1) KEEP Tally Server ON<br>\r\n2)Please enter Tally Port Number<br> \r\n(Open Tally --->Configure(F12)--->Adavance Configuration--->Client/Server Configuration --> <br>Tally acting :Both-->Enable ODBC server:YES--->Port )<br>enter the port number</html>");
		lblPleaseNoteThe.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblPleaseNoteThe.setBounds(143, 27, 710, 131);
		frame.getContentPane().add(lblPleaseNoteThe);
		
		JButton btnNewButton = new JButton("Store Trial Balance Data");
		btnNewButton.setToolTipText("Click to add Trial Balance");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Please select Company Name And year ","Alert!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					try {
				        TrialBalanceRequest.main(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame,
						    "Updated.",
						    "Conformation Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
				
				
				
				
			}
			
		});
		btnNewButton.setBounds(125, 457, 267, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblFinanchial = new JLabel("Financial Year :");
		lblFinanchial.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblFinanchial.setBounds(125, 326, 192, 35);
		frame.getContentPane().add(lblFinanchial);
		
		
		
		JButton btnUpdateLedger = new JButton("Store Ledger Data");
		btnUpdateLedger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "Please select Company Name And year ","Alert!", JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					
				        try {
							LedgerRequest.main(null);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					JOptionPane.showMessageDialog(frame,
						    "Updated.",
						    "Conformation Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		btnUpdateLedger.setToolTipText("Click to add Ledger Data");
		btnUpdateLedger.setForeground(SystemColor.text);
		btnUpdateLedger.setBackground(SystemColor.desktop);
		btnUpdateLedger.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnUpdateLedger.setBounds(621, 457, 247, 35);
		frame.getContentPane().add(btnUpdateLedger);
		
		JLabel lblViewData = new JLabel("View Data :");
		lblViewData.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblViewData.setBounds(125, 571, 192, 35);
		frame.getContentPane().add(lblViewData);
		
		String []listViewData= {"TrialBalance","LedgerData"};
		 comboBox1 = new JComboBox(listViewData);
		comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		comboBox1.setBounds(353, 576, 326, 31);
		frame.getContentPane().add(comboBox1);
		
		JButton btnFetchData = new JButton("Fetch Data");
		btnFetchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelectApp.main(null);
			}
		});
		btnFetchData.setForeground(SystemColor.text);
		btnFetchData.setBackground(SystemColor.desktop);
		btnFetchData.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnFetchData.setBounds(760, 571, 146, 36);
		frame.getContentPane().add(btnFetchData);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_2.setBounds(353, 322, 326, 35);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
 

