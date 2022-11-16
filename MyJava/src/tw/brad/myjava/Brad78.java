package tw.brad.myjava;

import tw.brad.myclass.BCrypt;

public class Brad78 {

	public static void main(String[] args) {
		String passwd = "123456";
		String passHash = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(passHash);
		System.out.println(passHash.length());
	
	}

}
