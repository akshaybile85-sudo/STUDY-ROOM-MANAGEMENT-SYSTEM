
import java.sql.Connection;
import java.sql.DriverManager;


public class Dbconnect {
	
	String username="postgres";
	String pass="password";
	static final String DB_URL="jdbc:mysql://localhost:3306/student";
	
	public Connection getConnection()
	{
		Connection conn=null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,username,pass);
			
			System.out.println("connection successful");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return conn;
	}

}
