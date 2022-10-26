package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad53 {

	public static void main(String[] args) {
		String source = "D:/JavaLearn/dir1/sample";
		String target = "D:/JavaLearn/dir2/sample";
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream(target);
			FileInputStream fin = new FileInputStream(source);
			int len; byte[] buf = new byte[16*1024];
			while ( (len = fin.read(buf)) != -1 ) {	// 
				fout.write(buf, 0, len);
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
