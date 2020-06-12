import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class CreatetableTB {
	
    /**
     * Create a new table in the test database
     *
     */
	static String url = "jdbc:sqlite:C:\\Users\\bhola\\TrialBalance.db";
	/**
     * Connect to the test.db database
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
        		+ "	Particular text ,\n"
                + "	Debit text,\n"
                + "	credit text,\n"
                + "  year text ,\n"
                +"PRIMARY KEY(Particular,year)"
                + " );";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void addElements(String tablename,String particular,String db1,String cr1,String year)
    {
    	String sql = "INSERT OR IGNORE INTO "+tablename+"(particular,debit,credit,year) VALUES(?,?,?,?)";

        try (Connection conn = CreatetableTB.connect();
        		PreparedStatement pstmt = conn.prepareStatement(sql))
                 {
            
            pstmt.setString(1,particular);
            pstmt.setString(2, db1);
            pstmt.setString(3, cr1);
            pstmt.setString(4,year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //createNewTable("NagrajTextile");
        //addElements("NagrajTextile", "loan", 2428391.020139, 29394.82910);
    }

}