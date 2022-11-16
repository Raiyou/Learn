package tw.brad.myjava;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.brad.myclass.Bike;

public class JDBC15 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		// 序列化之物件(Bike)
		Bike b1 = new Bike();
		b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); b1.upSpeed(); 
		System.out.println(b1.getSpeed());
		

		String sql = "UPDATE member SET icon = ?, bike = ? WHERE id = ?";
		try {
			Connection conn = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/eeit53", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			FileInputStream fin = new FileInputStream("D:/JavaLearn/dir1/JDBC15_pic1.png");
			
			pstmt.setBinaryStream(1, fin);
			// 經序列化之物件可轉為資料
			pstmt.setObject(2, b1);
			pstmt.setInt(3, 5);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("OK");
			} else {
				System.out.println("XX");
			}
			
 			fin.close();
 			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}