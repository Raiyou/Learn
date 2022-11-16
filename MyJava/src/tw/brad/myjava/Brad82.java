package tw.brad.myjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class Brad82 {

	public static void main(String[] args) {
		try {
			File file = new File("D:/JavaLearn/dir1/Brad82_pic1.png");
			FileInputStream fin = new FileInputStream(file);
			byte[] buf = new byte[(int)file.length()];
			fin.read(buf);
			
			fin.close();
			
			byte[] base64 = Base64.getEncoder().encode(buf);
			System.out.println("source byte length = " + buf.length);
			System.out.println("BASE64 byte length = " + base64.length);
			
			String base64String = new String (base64, "UTF-8");
			System.out.println("String = " + base64String.length());
			System.out.println(base64String);	// data:image/png;base64,iv...
			System.out.println("-----------");
			
			byte[] debase64 = Base64.getDecoder().decode(base64String);
			System.out.println("decode byte length = " + debase64.length);
			FileOutputStream fout = new FileOutputStream("D:/JavaLearn/dir1/Brad82_pic2.png");
			fout.write(debase64);
			fout.flush();
			fout.close();
			
			System.out.println("OK");
		} catch (Exception e) {

		}
		
		
	}

}
