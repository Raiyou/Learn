package tw.brad.myjava;

import java.io.File;

public class Brad47 {

	public static void main(String[] args) {
		File f1 = new File("D:/JavaLearn/dir1");
		if (f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
//			f1.mkdir();	// 新增資料夾
		}
		System.out.println("---");
		File here = new File("dir1");
		System.out.println(here.getAbsolutePath());
		if (here.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}
}
