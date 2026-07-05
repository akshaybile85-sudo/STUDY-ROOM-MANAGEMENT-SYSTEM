import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SetupDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "tiger";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            
            System.out.println("Connected to MySQL server!");
            
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS student");
            System.out.println("Database 'student' created or already exists.");
            
            stmt.executeUpdate("USE student");
            
            String createTable = "CREATE TABLE IF NOT EXISTS registeredstudent ("
                + "id INT PRIMARY KEY, "
                + "name VARCHAR(255), "
                + "mobile_no VARCHAR(20), "
                + "email VARCHAR(255), "
                + "parentmob VARCHAR(20), "
                + "college VARCHAR(255), "
                + "edu VARCHAR(255), "
                + "slot VARCHAR(50))";
                
            stmt.executeUpdate(createTable);
            System.out.println("Table 'registeredstudent' created or already exists.");
            
            System.out.println("Database setup complete!");
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
