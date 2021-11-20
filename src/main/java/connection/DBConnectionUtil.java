package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private Connection connection;
	
	public DBConnectionUtil(String dbURL ,String username, String password)throws ClassNotFoundException, SQLException {
		
		//Register Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Get connection object 
		
		connection =DriverManager.getConnection(dbURL,username,password);
	}
	public Connection getConnection()
	{
		return this.connection;
	}
	

}
