package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad49 {

	public static void main(String[] args) {
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("D:/JavaLearn/dir1/file1.txt");
			int len; byte[] buf = new byte[3];
			while ( (len = fin.read(buf)) != -1 ) {
				System.out.print(new String(buf,0,len));	// buf從0開始取長度
			}
			
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
