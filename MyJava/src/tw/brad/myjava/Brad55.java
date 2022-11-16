package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Brad55 {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("D:/JavaLearn/dir1/file1.txt");
				InputStreamReader isr = new InputStreamReader(fin);
//				System.out.println();	// 中間不得有非自動關閉之敘述句
				BufferedReader br = new BufferedReader(isr);) {
			String line; int i = 1;
			while ( (line = br.readLine()) != null ) {
				System.out.println(i++ + ":" + line);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		// ------
		System.out.println("------");
		// ------
		
		try (FileReader reader = new FileReader("D:/JavaLearn/dir1/file1.txt");
				BufferedReader br = new BufferedReader(reader);
				){
			String line; int i = 1;
			while ( (line = br.readLine()) != null ) {
				System.out.println(i++ + ":" + line);
			}
		}catch (Exception e) {
			System.out.println(e);
		}

		// ------
		System.out.println("------");
		// ------
		
		try (FileReader reader = new FileReader("D:/JavaLearn/dir1/sieve.csv");
				BufferedReader br = new BufferedReader(reader);
				){
			String line;
			br.readLine();
			while ( (line = br.readLine()) != null ) {
				String[] data = line.split(",");
				System.out.printf("%s:%s\n", data[1], data[7]);
			}
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
