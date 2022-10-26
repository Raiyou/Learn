package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad71 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvSuggestTravel.aspx");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.connect();
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
			
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {	// 僅適合文字資料
				sb.append(line);
			}
			
			reader.close();
			
//			System.out.println(sb.toString());
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	static void parseJSON(String json) {
		try {
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String city = row.getString("City");
				String town = row.getString("Town");
				System.out.printf("%s, %s-%s\n", name, city, town);
			}
//			System.out.println(root.length());	// 確認資料數量
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
