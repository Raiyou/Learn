package tw.brad.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Brad60 {

	public static void main(String[] args) {
		String msg = "Hello, Brad";
		byte[] msgData = msg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = 
					new DatagramPacket(msgData, msgData.length, 
							InetAddress.getByName("10.0.102.45"), 8888);
			socket.send(packet);
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
