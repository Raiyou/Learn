package tw.brad.myjava;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

public class Z_Note3 {

	public static void main(String[] args) {
		try {
			
//	DefaultTableModel 實作了--> TableModel			
		
			
			/*
			
// Simp -> Trad
			
			fieldLeft(Content) -> fieldRight(Result)
			string to db <-> db to string
			-> built db first
			
		
			
			custom word : db.add/delete
			
			
			文字框1 -> 文字框2
			
			
			讀取 -> 字元逐一比對資料庫 -> 置換 -> 輸出
			
			讀取資料庫 col1 -> 判斷符合輸入字元 -> 返回資料庫 col2
			
					
			
			
			
			
			*/
			
		} catch (Exception e) {}

	}

	public static String getJSONString(String jsonsrc) throws Exception {
		URL url = new URL(jsonsrc); 
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.connect();
		StringBuffer sb = new StringBuffer();
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream()))) {
				String line;
				while ( (line = reader.readLine()) != null) {
					sb.append(line);
				}
		}
		return sb.toString();
	}
	
	public static void parseJSON(String json, String sqldel, String sqlinsert) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eeit53", "root", "root");
		Statement stmt = conn.createStatement();
		stmt.execute(sqldel);
		PreparedStatement pstmt = conn.prepareStatement(sqlinsert);

		JSONArray root = new JSONArray(json);
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			pstmt.setString(1, row.getString("i"));
			pstmt.setString(2, row.getString("o"));
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();
	}	

}
