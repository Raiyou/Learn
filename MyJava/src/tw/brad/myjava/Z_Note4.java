package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONStringer;
import org.json.JSONWriter;

import tw.brad.myclass.Member;

public class Z_Note4 {

    public static void main(String[] args) {
    	try {
			
		String sql = "SELECT StringT, StringS FROM zhConvtT2S";
		Connection conn = 
				DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/eeit53", "root", "root");
		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println(stmt.execute(sql));
		
//		JSONStringer js = new JSONStringer();
//		JSONWriter jw = js.array();
//		int i = 0;
//		while (rs.next()) {
//			String name = rs.getString("lastname");
//			String sum = rs.getString("sum");
//			/* 驗算
//			System.out.printf("%s:%s\n", name, sum);
//			*/
//			jw.object();
//			jw.key("lastname").value(name);
//			jw.key("sum").value(sum);
//			jw.key("rank").value(++i);
//			jw.endObject();
//		}
//		jw.endArray();
//		System.out.println(jw.toString());
		
		stmt.close();
//		rs.close();
		conn.close();
    	
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    }
}
