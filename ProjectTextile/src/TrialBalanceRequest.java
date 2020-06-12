import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;


public class TrialBalanceRequest{
	static int srno=0;
	 String n,year; //Company name and year
	 String Url;
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	
    public String CreateRequest()
    {
    	/*Scanner input =new Scanner(System.in);
    	System.out.println("enter company :");
    	n=input.nextLine();
        System.out.println("ente Current Financcial year");
        year=input.nextLine();*/
    	n=Tallygui.cb;//Selected company name
    	year=Tallygui.getYear();
         //company=input.nextLine();
        String TXML = null;
         
        TXML = "<ENVELOPE>"+
     	"<HEADER>"+
		"<VERSION>1</VERSION>"+
		"<TALLYREQUEST>Export</TALLYREQUEST>"+
		"<TYPE>Data</TYPE>"+
		"<ID>Trial Balance</ID>"+
	"</HEADER>"+
"<BODY>"+
	"<DESC>"+
					"<REQUESTDESC>"+

			 "<STATICVARIABLES>"+
				"<SVCURRENTCOMPANY>"+n+"</SVCURRENTCOMPANY>"+

				"<EXPLODEFLAG>Yes</EXPLODEFLAG>"+
				"<SVEXPORTFORMAT>$$SysName:XML</SVEXPORTFORMAT>"+
			"</STATICVARIABLES>"+

		"</REQUESTDESC>"+	
	"</DESC>"+
"</BODY>"+
"</ENVELOPE>";


        return TXML;
    }
    public String foo(double value) //Got here 6.743240136E7 or something..
    {
        DecimalFormat formatter;

        if(value - (int)value > 0.0)
            formatter = new DecimalFormat("0.00"); //Here you can also deal with rounding if you wish..
        else
            formatter = new DecimalFormat("0");

        return formatter.format(value);
    }
   
    public void SendToTally() throws Exception{
        Url=TallyRequest.Url;      

        String SOAPAction = "";
       
        String Voucher = this.CreateRequest();

// Create the connection where we're going to send the file.
        URL url = new URL(Url);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;

       
        ByteArrayInputStream bin = new ByteArrayInputStream(Voucher.getBytes());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

// Copy the SOAP file to the open connection.
       
        copy(bin, bout);     

        byte[] b = bout.toByteArray();

// Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

// Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write(b);
        out.close();

// Read the response and write it to standard out.

        InputStreamReader isr =
                new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        String inputLine;
        
       n=n.replaceAll("/", "");
      
        CreatetableTB.createNewTable(n.replaceAll("\\s", ""));
        while ((inputLine = in.readLine()) != null) {
        	String i=inputLine;
        	String particular = null,debit = null,credit=null;
        	String db1 = null;
			String cr1=null;
        	
        	boolean isFound = i.indexOf("<DSPDISPNAME>") !=-1? true: false;//Finding Particular 
        	if(isFound)
        	{
        		//System.out.println(inputLine);
        		i=i.replace("<DSPDISPNAME>", "");
        		i=i.replace("</DSPDISPNAME>", "");//replacing unwanted data
        		 particular=i;
        		inputLine =in.readLine();
        		//System.out.println(inputLine);
        		
        		inputLine=in.readLine();
            	//System.out.println(inputLine);
            	
        		i=inputLine;
            	boolean isFound1 = i.indexOf("<DSPACCINFO>") !=-1? true: false;//Find Info tag for obtaining credit and debit info
            	if(isFound1)
            	{
            		while(!(inputLine=in.readLine()).equals("</DSPACCINFO>"))//move forward until end of info tag
            		{
            			
            			i=inputLine;
            			//System.out.println(i);
            			boolean isFoundDebit = i.indexOf("<DSPCLDRAMTA>") !=-1? true: false;//for finding debit data related tag
            			if(isFoundDebit)
            			{
            				
            				i=i.replace("<DSPCLDRAMTA>", "");
            				i=i.replace("</DSPCLDRAMTA>", "");
            				
            					try {
            						db1=foo(Math.abs(Double.parseDouble(i)));
            						 //db[0]=(new BigDecimal(i)).abs();
            						debit=i;
            					}
            					catch(NumberFormatException e)
            					{
            						continue;
            					}
            						
            				
            			}
            			boolean isFoundCredit = i.indexOf("<DSPCLCRAMTA>") !=-1? true: false;//for finding credit data related tag
            			if(isFoundCredit)
            			{
            				
            				i=i.replace("<DSPCLCRAMTA>", "");
            				i=i.replace("</DSPCLCRAMTA>", "");
            				
            				try {
            					cr1=foo((Math.abs(Double.parseDouble(i))));
        						 //cr[0]=(new BigDecimal(i)).abs();
            					credit=i;
            					
        					}
        					catch(NumberFormatException e)
        					{
        						continue;
        					}
        						
            					//cr=Double.parseDouble(i);
            			}
            			
            		}
            		//System.out.println(particular+" "+db1+" "+cr1);
            		CreatetableTB.addElements(n.replaceAll("\\s", ""), particular, db1, cr1,year);
            	}
        	}
        	
            

        	
            
        }
        //System.out.println("ADDED");

        in.close();
    }

    public static void copy(InputStream in, OutputStream out)
            throws IOException {

// do not allow other threads to read from the
// input or write to the output while copying is
// taking place

        synchronized (in) {
            synchronized (out) {

                byte[] buffer = new byte[256];
                while (true) {
                    int bytesRead = in.read(buffer);
                    if (bytesRead == -1) {
                        break;
                    }
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
    }
   
    public static void main(String[] args) throws Exception {
        TrialBalanceRequest r = new TrialBalanceRequest();
        r.SendToTally();
    }
}