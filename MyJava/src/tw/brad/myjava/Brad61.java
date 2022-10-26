package tw.brad.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Brad61 {

	public static void main(String[] args) {
		while (true) {
			byte[] buf = new byte[1024];
			try {
				DatagramSocket socket = new DatagramSocket();
				DatagramPacket packet = new	DatagramPacket(buf, buf.length);
				System.out.println("before");
				socket.receive(packet);
				System.out.println("after");
				socket.close();
				String remoteIp = packet.getAddress().getHostAddress();
				byte[] data = packet.getData();
				int len = packet.getLength();
				String msg = new String (data,0,len);
				System.out.println("Recieved from" + remoteIp + ":" + msg);
				if (msg.equals("bye")) {
					break;
				}
			}catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
