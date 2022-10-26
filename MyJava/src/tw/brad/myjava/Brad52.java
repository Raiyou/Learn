package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad52 {

	public static void main(String[] args) {
		String source = "D:/JavaLearn/dir1/sample";
		String target = "D:/JavaLearn/dir2/sample";
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream(target);
			FileInputStream fin = new FileInputStream(source);
			int c;
			while ( (c = fin.read()) != -1 ) {	// 一個個資料寫入
				fout.write(c);
			}
			
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("Save as ... OK:" + (System.currentTimeMillis()- start));
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
