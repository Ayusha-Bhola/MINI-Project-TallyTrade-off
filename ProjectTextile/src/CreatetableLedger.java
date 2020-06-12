import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class CreatetableLedger {

    /**
     * Create a new table in the test database
     *
     */
	static String url = "jdbc:sqlite:C:\\Users\\bhola\\LedgerData.db";
	/**
     * Connect to the Ledger.db database
     *
     * @return the Connection object
     */
    private static  Connection connect() {
        // SQLite connection string
        String url1 =url;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void createNewTable(String tablename) {
        // SQLite connection string
        
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS "+tablename+" (\n"
        		+ "	listLedger text ,\n"
                + "	year text,\n"
                +"PRIMARY KEY(listLedger,year)"
                + " );";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addElements(String tablename,String listLedger,String year)
    {
    	String sql = "INSERT OR IGNORE INTO "+tablename+"(listLedger,year) VALUES(?,?)";

        try (Connection conn = CreatetableLedger.connect();
        		PreparedStatement pstmt = conn.prepareStatement(sql))
                 {
            
            pstmt.setString(1,listLedger);
            pstmt.setString(2,year);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*createNewTable("NagrajTextile");
        addElements("NagrajTextile","Loans", "2017");
        System.out.println("Added");*/
    }

}