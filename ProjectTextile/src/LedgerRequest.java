import java.io.*;
import java.net.*;


public class LedgerRequest{
   String n,year;
    public String CreateRequest()
    {       
    	n=Tallygui.cb;//Selected company name
    	year=Tallygui.getYear();
    	/*n="PRABHAKAR TEXTILE";
    	year="2018-2019";*/
        String TXML = null;

        TXML = "<ENVELOPE>"
        		+"<HEADER>"
        		+"<VERSION>1</VERSION>"
        		+"<TALLYREQUEST>Export</TALLYREQUEST>"
        		+"<TYPE>Collection</TYPE>"
        		+"<ID>Collection of Ledgers</ID>"
        		+"<SessionID></SessionID>"
        		+"</HEADER>"
        		+"<BODY>"
        		+"<DESC>"
        		+"<STATICVARIABLES>"
        		+"<SVCurrentCompany>"
        		+n+"</SVCurrentCompany>"
        		+"</STATICVARIABLES>"
        		+"<TDL>"
        		+"<TDLMESSAGE>"
        		+"<COLLECTION NAME='Collection of Ledgers' ISMODIFY='No'>"
        		+"<TYPE>Ledger</TYPE>"
        		+"</COLLECTION>"
        		+"</TDLMESSAGE>"
        		+"</TDL>"
        		+"</DESC>"
        		+"</BODY>"
        		+"</ENVELOPE>";;
        return TXML;
    }
   
    public void SendToTally() throws Exception{
        String Url = TallyRequest.Url;      

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
       CreatetableLedger.createNewTable(n.replaceAll(" ", ""));
        //System.out.println("Create");
        while ((inputLine = in.readLine()) != null) {
        	String i=inputLine;
	        			boolean isFoundl1 = i.indexOf("<LEDGER NAME=") !=-1? true: false;
	        			if(isFoundl1)
	        			{
	        				
	        				i=i.replace("<LEDGER NAME=", "");
	        				i=i.replace("RESERVEDNAME=","");
	        				i=i.replace("</LEDGER>", "");
	        				i=i.replace(">", "");
	        				i=i.replace("\"", "");
	        				i=(i.trim());
	        				//System.out.println(i);
	        				CreatetableLedger.addElements(n.replaceAll(" ", ""),i,year);
	        			}
	        		
            //System.out.println(inputLine);
            
        
        }
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
        LedgerRequest r = new LedgerRequest();
        r.SendToTally();
    }
}