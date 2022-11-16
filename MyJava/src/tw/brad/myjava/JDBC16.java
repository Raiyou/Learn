package tw.brad.myjava;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.myclass.Bike;

public class JDBC16 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String sql = "SELECT * FROM member WHERE id = ?";
		try {
			Connection conn = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/eeit53", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 5);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			// 欲將資料庫中bike資料還原為物件，檢查物件是否屬於Bike
			InputStream in2 = rs.getBinaryStream("bike");
			ObjectInputStream oin = new ObjectInputStream(in2);
			Object obj = oin.readObject();
			if ( obj instanceof Bike ) {	
				System.out.println("bike");
			}else {
				System.out.println("non-bike");
			}
			
			// 欲將資料庫中bike資料還原為物件，經檢查物件不屬於Bike，無法還原
//			Object obj = rs.getObject("bike");
//			if (obj instanceof Bike) {
//				System.out.println("bike");
//			}else {
//				System.out.println("non-bike");
//			}
			
			in2.close();
			// 還原為原始物件，並測試
			Bike b2 = (Bike)obj;
			System.out.println(b2.getSpeed());
			
			
			FileOutputStream fout = new FileOutputStream("D:/JavaLearn/dir1/JDBC16_pic1.png");
			InputStream in = rs.getBinaryStream("icon");
			byte[] buf = new byte[1024]; int len;
			while ( (len = in.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			in.close();
			fout.flush();
			fout.close();
			
			rs.close();
 			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}