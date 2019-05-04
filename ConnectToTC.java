import java.sql.*;

public class ConnectToTC {
	private String username;
	private static final String DB_NAME = "jdbc:mysql://localhost:3306/bank_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_USERNAME = "yodi555";
	private static final String DB_PASSWORD = "yodi654";
	private Connection c;
	private Statement st;
	private ResultSet rs;
	
	public ConnectToTC(String username) {
		this.username = username;
	}
	
	public int addMoney(int amount) {
		try {
			String query = "SELECT * FROM bank_tc";
			int money = 0;
			c = DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
			st = c.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				if (rs.getString("name").equals(username)) {
					money = rs.getInt("money");
				}
			}
			query = "UPDATE bank_tc SET money = " + (money + amount) + " WHERE name = \"" + username + "\";";
			st.execute(query);
			query = "SELECT * FROM bank_tc";
			rs.close();
			rs = st.executeQuery(query);
			while(rs.next()) {
				if (rs.getString("name").equals(username)) {
					money = rs.getInt("money");
				}
			}
			rs.close();
			st.close();
			c.close();
			return money;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int removeMoney(int amount) {
		return addMoney(amount * -1);
	}
	
	public int getMoney() {
		try {
			String query = "SELECT * FROM bank_tc";
			int money = 0;
			c = DriverManager.getConnection(DB_NAME, DB_USERNAME, DB_PASSWORD);
			st = c.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				if (rs.getString("name").equals(username)) {
					money = rs.getInt("money");
				}
			}
			rs.close();
			st.close();
			c.close();
			return money;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
