import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.awt.Font;
import java.awt.SystemColor;

class AdminDashboard extends JFrame implements ActionListener {

    JFileChooser fc;
    JButton b, b1,b2;
    JTextField tf;
    FileInputStream in;
    Socket s;
    DataOutputStream dout;
    DataInputStream din;
    JLabel l;
    int i;

    AdminDashboard() {
    	
        super("Admin dashboard");
        getContentPane().setBackground(SystemColor.info);
       
        tf = new JTextField();
       
        tf.setBounds(426, 289, 689, 51);
        tf.setFont(new Font("Arial",Font.PLAIN, 25));
        getContentPane().add(tf);
        l=new JLabel();
        l.setBounds(250,289,589,51);
        l.setText("Choose File:");
        l.setFont(new Font("Gabriola", Font.BOLD, 40));
        getContentPane().add(l);
        b = new JButton("Browse");
        b.setBounds(1156, 289, 190, 51);
        b.setFont(new Font("Gabriola", Font.BOLD, 40));
        b.setForeground(SystemColor.text);
		b.setBackground(SystemColor.desktop);
        getContentPane().add(b);
        b.addActionListener(this);
        b1 = new JButton("Upload");
        b1.setBounds(715, 467, 230, 66);
        b1.setFont(new Font("Gabriola", Font.BOLD, 40));
        b1.setForeground(SystemColor.text);
		b1.setBackground(SystemColor.desktop);
        getContentPane().add(b1);
        b1.addActionListener(this);
        b2 = new JButton("View Details");
        b2.setBounds(1115, 467, 230, 66);
        b2.setFont(new Font("Gabriola", Font.BOLD, 40));
        b2.setForeground(SystemColor.text);
		b2.setBackground(SystemColor.desktop);
        getContentPane().add(b2);
        b2.addActionListener(this);
        fc = new JFileChooser();
        getContentPane().setLayout(null);
        setBounds(0,0,1920,1080);
        setVisible(true);
        try {
            s = new Socket("localhost", 10);
            dout = new DataOutputStream(s.getOutputStream());
            din = new DataInputStream(s.getInputStream());
            send();
        } catch (Exception e) {
        }
    }
    

    public void actionPerformed(ActionEvent e) {
    File fileToBeSent;
    File f1 = fc.getSelectedFile();
    try {
           if (e.getSource() == b) {
               int x = fc.showOpenDialog(null);
               if (x == JFileChooser.APPROVE_OPTION) {
                   fileToBeSent = fc.getSelectedFile();
                   tf.setText(fileToBeSent.getAbsolutePath());
                   b1.setEnabled(true);
               } else {
                   fileToBeSent = null;
                   tf.setText(null);
                   b1.setEnabled(false);
               }
               
           }
           if (e.getSource() == b1) {
               send();
           }
           if(e.getSource()==b2)
           {
        	   UserloginDashboard.main(null);
           }
       } catch (Exception ex) {
       }
    }

    public void copy() throws IOException {
        File f1 = fc.getSelectedFile();
        tf.setText(f1.getAbsolutePath());
        in = new FileInputStream(f1.getAbsolutePath());
        while ((i = in.read()) != -1) {
            System.out.print(i);
        }
    }

    public void send() throws IOException {
        dout.write(i);
        dout.flush();

    }

    public static void main(String... d) {
    	
        new AdminDashboard();
       
    }
}

