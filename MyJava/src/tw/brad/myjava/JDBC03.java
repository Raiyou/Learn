package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/eeit53",
				prop);
			// 3. SQL statement
			String sql1 = "INSERT INTO cust (cname,tel,birthday) VALUES" + "('tony','111','1999-01-02')";
			String sql2 = "SELECT * FROM cust";
			Statement stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql1);

			conn.close();
			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
