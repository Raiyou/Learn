package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad65 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9527);
			OutputStream out = socket.getOutputStream();
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			FileInputStream fin = new FileInputStream("D:/dir1/coffee.jpg");
			BufferedInputStream bin = new BufferedInputStream(fin);	// 串流用，效能較好
			
			int len; byte[] buf = new byte[8*1024];
			while ( (len = bin.read(buf)) != -1) {	// 客戶端傳檔
				bout.write(buf, 0, len);
				
			}	
				bin.close();
				
				bout.flush();
				bout.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
