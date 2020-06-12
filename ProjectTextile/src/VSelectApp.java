

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VSelectApp extends JFrame {

private JPanel contentPane;

/**
* Launch the application.
*/

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
VSelectApp frame = new VSelectApp();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public VSelectApp() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(0, 0, 1400, 800);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

JButton viewbooks = new JButton("View data");
viewbooks.setFont(new Font("Tahoma", Font.PLAIN, 16));
viewbooks.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
try{
	Class.forName("org.sqlite.JDBC");
	DefaultTableModel dtm;
	JTable tb;
	String Db=ViewTally.getViewData();
	String yr=ViewTally.textField_2.getText();
		String CN=ViewTally.textField.getText().replaceAll(" ", "");
		
		/*String Db="TrialBalance";
		String CN="GAJJAM GROUP".replace(" ", "");
		String yr="2017-2018";*/
	//-ystem.out.println(Db+" "+CN);
		if(Db=="TrialBalance")
		{

Connection c1=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bhola\\"+Db+".db");
//System.out.println("connection true");

PreparedStatement ps = c1.prepareStatement("select * from "+CN+" where year LIKE '%"+yr+"%'");

//System.out.println("select * from "+CN+" where year LIKE '%"+yr+"%'");
ResultSet rs = ps.executeQuery();
Container con;
con = getContentPane();
con.setLayout(null);


String headers [] = {"Particular","Debit (Rs)","Credit (Rs)","Year"};
dtm = new DefaultTableModel();
dtm.setColumnIdentifiers(headers);
tb = new JTable(dtm);
JScrollPane jsp = new JScrollPane(tb);
jsp.setBounds(40,300, 1800, 300);
//jsp.setBounds(50,250, 1250, 300);
con.add(jsp);
String row[];
while(rs.next())
{
String par = rs.getString(1);
String debit= rs.getString(2);
String credit=rs.getString(3);
String year=rs.getString(4);

row = new String[] {par,debit,credit,year};
dtm.addRow(row);
}

rs.close();
ps.close();
c1.close();
}
		else if(Db=="LedgerData")
		{

Connection c1=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\bhola\\"+Db+".db");
//System.out.println("connection true");

PreparedStatement ps = c1.prepareStatement("select * from "+CN);


ResultSet rs = ps.executeQuery();
Container con;
con = getContentPane();
con.setLayout(null);


String headers [] = {"List of Ledger","Year"};
dtm = new DefaultTableModel();
dtm.setColumnIdentifiers(headers);
tb = new JTable(dtm);
JScrollPane jsp = new JScrollPane(tb);
jsp.setBounds(40,300, 1800, 300);
//jsp.setBounds(50,250, 1250, 300);
con.add(jsp);
String row[];
while(rs.next())
{
	String l=rs.getString(1);
	String year=rs.getString(2);

row = new String[] {l,year};
dtm.addRow(row);
}

rs.close();
ps.close();
c1.close();
}
}catch(Exception e){

}
}
});
viewbooks.setBounds(808, 52, 198, 42);
contentPane.add(viewbooks);
JButton btnBack = new JButton("BACK");
btnBack.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		ViewTally.main(null);
		
	}
});
btnBack.setBounds(0, 0, 97, 25);
contentPane.add(btnBack);

}
}