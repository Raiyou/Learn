package tw.brad.myjava;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad64 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 7777);

			OutputStream out = socket.getOutputStream();
			out.write("Hello, Brad\n".getBytes());
			out.flush();
			out.close();
			
			System.out.println("Client OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
