package BaseDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private String url = "jdbc:mysql://localhost/resultados?useSSL=false";
	private String user = "root";
	private String password = "123456";
	Connection con = null;
	
	public Connection getConnection() {
		try {
			if(con==null)
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
