package tw.brad.myjava;

import java.io.FileOutputStream;

public class Brad51 {

	public static void main(String[] args) {
		String data = "Brad\n";
		try {
			FileOutputStream fout = 
					new FileOutputStream("D:/JavaLearn/dir1/file2.txt", true); // true為從檔案末端繼續寫入，不覆寫前面資料
			fout.write(data.getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		

	}

}
