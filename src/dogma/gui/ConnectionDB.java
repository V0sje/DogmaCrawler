package dogma.gui;

import java.sql.*;
import java.util.LinkedList;

public class ConnectionDB {

    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://127.0.0.1/crawler";
    private static Connection conn = null;

    public static void OpenConnection() {
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Database Connected!");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void CloseConnection() {
        try {
            conn.close();
            System.out.println("Database Connection Closed!");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public static void dbClearDomain() throws SQLException {
        OpenConnection();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            try {
                String sql = "TRUNCATE TABLE Domain";
                stmt.executeUpdate(sql);
                System.out.println("EMPTIED DATABASE");
            } catch (SQLException se) {
                //Handle errors for JDBC
                System.err.println(se.getMessage());
            }
        }
        CloseConnection();
    }

    public static void dbCreateDomain(String url) throws Exception {
        Domain domain = new Domain(url);
        if (conn != null) {
            Statement stmt = conn.createStatement();
            try {
                String sql = "INSERT INTO Domain (domainUrl, domainHash) VALUES ('"+domain.getDomainUrl()+"', '"+domain.getDomainHash()+"')";
                stmt.executeUpdate(sql);
            } catch (SQLException se) {
                //Handle errors for JDBC
                System.err.println(se.getMessage());
            }
        }
    }
    
    public static LinkedList<String> dbGetCrawledUrls() throws SQLException {
        LinkedList<String> links = new LinkedList();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset;
                rset = stmt.executeQuery("SELECT domainUrl FROM Domain");
                while (rset.next()) {
                    links.add(rset.getString(1));
                }
            } catch (SQLException se) {
                //Handle errors for JDBC
                System.err.println(se.getMessage());
            }
        }
        return links;
    }
}

    
        
