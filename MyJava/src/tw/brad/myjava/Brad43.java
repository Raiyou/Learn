package tw.brad.myjava;

public class Brad43 {

	public static void main(String[] args) {
		int a = 10, b = 03;
		int c;
		int[] d = {1, 2, 3, 4};
		try {	//判斷是否造成例外
			c = a / b;
			System.out.println(c);
			System.out.println(d[4]);
//		} catch (ArithmeticException ae) {	// 若有例外則捕捉並處理
//			System.out.println("XX1");
//		} catch (ArrayIndexOutOfBoundsException ie) {
//			System.out.println("XX2");
		} catch (RuntimeException re) {	// 包含所有Runtime例外
			System.out.println("XX3");
		}
		System.out.println("OK");
	}
}
