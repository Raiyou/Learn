package tw.brad.myjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad50 {

	public static void main(String[] args) {
		FileInputStream fin = null;
		try {
			File file = new File("D:/JavaLearn/dir1/file1.txt");
			fin = new FileInputStream(file);
			byte[] buf = new byte[(int)file.length()];
			fin.read(buf);
			System.out.println(new String(buf));
			
			
//			int c1 = fin.read();
//			System.out.println((char)c1);

//			int c2 = fin.read();
//			System.out.println((char)c2);

			fin.close();
			System.out.println("OK");
		} catch (IOException fe) {
			System.out.println("XX");
//		} catch (FileNotFoundException fe) {
//			System.out.println("XX2");
//			if (fin == null && fin instanceof FileInputStream) {	// 檢查有無拿到物件實體
//				System.out.println("is null");
//			}else {
//				System.out.println("not null");
			}

	}
}
