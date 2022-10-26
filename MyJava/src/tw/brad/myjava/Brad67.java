package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad67 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9527);
			Socket socket = server.accept();
			
			String ip = socket.getInetAddress().getHostAddress();
			
			InputStream in = socket.getInputStream();
			BufferedInputStream bin = new BufferedInputStream(in);
			int len; byte[] buf = new byte[1024*1024*1024];
			len = bin.read(buf);
			
			if (len > 0) {
				FileOutputStream fout = new FileOutputStream("D:/dir1/" + ip + ".jpg");
				BufferedOutputStream bout = new BufferedOutputStream(fout);
				bout.write(buf, 0, len);
				
				bout.flush();
				bout.close();
			}
			
			bin.close();
			server.close();
			
			System.out.println("RecieveV2 Success:" + ip);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
