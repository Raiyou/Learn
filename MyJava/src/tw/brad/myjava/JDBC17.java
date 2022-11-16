package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC17 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String sql = "SELECT * FROM food";
		try {
			Connection conn = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/eeit53", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
//			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			System.out.println("------");
			// 移動至首筆資料
//			rs.first();
			// 移動至前一筆資料
			rs.previous();
			rs.previous();
			String name = rs.getString("name");
			System.out.println(name);
			System.out.println("---");
			// 移動至指定列數資料
			rs.absolute(5);
			name = rs.getString("name");
			System.out.println(name);
			// 刪除資料
//			rs.deleteRow();
			// 變更資料
			rs.updateString("name", "Brad大酒店");
			rs.updateString("tel", "7777");
			rs.updateRow();
			// 新增資料
			rs.moveToInsertRow();
			rs.updateString("name", "Brad大酒店");
			rs.updateString("tel", "9999");
			rs.updateString("addr", "test");
			rs.updateString("city", "test");
			rs.updateString("town", "test");
			rs.updateString("picurl", "test");
			rs.updateDouble("lat", 0);
			rs.updateDouble("lng", 0);
			rs.insertRow();

		} catch (Exception e) {
			System.out.println(e);
		}
			
	}

}
