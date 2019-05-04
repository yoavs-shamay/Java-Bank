import java.sql.*;

public class ConnectToUPT {
	private static final String DB_NAME = "jdbc:mysql://localhost:3306/bank_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_USERNAME = "yodi555";
	private static final String DB_PASSWORD = "yodi654";
	private Connection c;
	private Statement st;
	private ResultSet rs;
	
	public ConnectToUPT() {
		
	}
	public boolean isUser(String username,String password) {
		try {
			String query = "SELECT * FROM bank_upt;";
			c = DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
			st = c.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
					return true;
				}
			}
			rs.close();
			st.close();
			c.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addUser(String username,String password) {
		try {
			c = DriverManager.getConnection(DB_NAME,DB_USERNAME,DB_PASSWORD);
			st = c.createStatement();
			String query = "SELECT * FROM bank_upt;";
			rs = st.executeQuery(query);
			while (rs.next()) {
				if(rs.getString("username").equals(username)) {
					return false;
				}
			}
			query = "INSERT INTO bank_upt VALUES(\"" + username + "\", \"" + password + "\");";
			st.execute(query);
			query = "INSERT INTO bank_tc VALUES(\"" + username + "\", 0);";
			st.execute(query);
			st.close();
			c.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}