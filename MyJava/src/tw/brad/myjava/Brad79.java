package tw.brad.myjava;

import tw.brad.myclass.BCrypt;

public class Brad79 {

	public static void main(String[] args) {
		String hash = "$2a$10$FUs1aNz5hLOVVsIGy1of4.hy21OicpjgBN2nDNW4/.FF9vNLHmvJ.";
		String passwd = "123456";
		if (BCrypt.checkpw(passwd, hash)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
	}

}
