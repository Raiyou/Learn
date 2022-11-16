package tw.brad.myjava;

public class Brad81 {

	public static void main(String[] args) {
		Brad811 obj = new Brad811();
		obj.m1(65);
	}
}
class Brad811 {
	void m1(int a) {
		try {
			if (a < 0) {

			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("XX");
		} finally {
			System.out.println("finally");
		}
		System.out.println("end");
	}
}

//}