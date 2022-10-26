package tw.brad.myjava;

import java.net.InetAddress;
import java.net.Socket;

public class Brad62 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(
					InetAddress.getByName("127.0.0.1"),80);	// 3306為SQL預設port
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("e");
		}
		
	}
}
