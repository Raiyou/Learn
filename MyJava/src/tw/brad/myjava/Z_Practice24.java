package tw.brad.myjava;

import java.util.Scanner;

public class Z_Practice24 {

	public static void main(String[] args) {
		// 1+2+...+N=?
		System.out.print("請輸入數字:");
		Scanner sncr = new Scanner(System.in);
		int n = sncr.nextInt();
		int num = 0;
		for (int i=1; i<=n; i++) {
			num += i;
		}
		System.out.println(num);
	}

}
