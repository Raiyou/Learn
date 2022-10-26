package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad68 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.iii.org.tw");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

//			if (conn instanceof HttpsURLConnection) {	// 檢查
//				System.out.println("OK");
//			}else {
//				System.out.println("XX");
//			}
			
			conn.connect();
			BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
			
			String line;
			while ( (line = reader.readLine()) != null) {	// 僅適合文字資料
				System.out.println(line);
			}
			
			reader.close();
			System.out.println("---");
			System.out.println();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
