

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class TallyRequest{
   
    public static String Url= "http://127.0.0.1:";
	public static String temp="<html>\r\n";

	public String CreateRequest()
    {             
        String TXML = null;

        TXML ="<ENVELOPE>" +
        		" <HEADER>" + 
        		"    <TALLYREQUEST>Export Data</TALLYREQUEST>" + 
        		"  </HEADER>" + 
        		"  <BODY>" + 
        		"    <EXPORTDATA>" + 
        		"      <REQUESTDESC>" + 
        		"        <REPORTNAME>List of Companies</REPORTNAME>" + 
        		"        <STATICVARIABLES>" + 
        		"          <SVEXPORTFORMAT>$$SysName:XML</SVEXPORTFORMAT>" + 
        		"        </STATICVARIABLES>" + 
        		"    </REQUESTDESC>" + 
        		"    </EXPORTDATA>" + 
        		"  </BODY>" + 
        		"</ENVELOPE>";
        		
       return TXML;
    }
   
    public ArrayList<String> SendToTally() throws Exception{
    	 
        Url=Tallygui.Url;  

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
        temp = "";
        ArrayList<String> list=new ArrayList<String>();
        //list.add("");
        while ((inputLine = in.readLine()) != null) {
        	String i=inputLine;
        	boolean isFound = i.indexOf("<COMPANYNAME>") !=-1? true: false;
        	if(isFound)
        	{
        		i=i.replace("<COMPANYNAME>", "");
        		i=i.replace("</COMPANYNAME>", "");
        		//System.err.println(i);
        		list.add(i);
        	}
            //System.out.println(inputLine);
            temp+=inputLine+"<br>\r\n";
        	
        }

        in.close();
        temp+="</html>\r\n";
        //System.out.println(temp);
        
        return list;
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
        TallyRequest r = new TallyRequest();
        r.SendToTally();
    }
}