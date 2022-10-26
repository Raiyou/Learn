package tw.brad.myjava;

import java.awt.FontFormatException;
import java.nio.channels.AlreadyBoundException;

import javax.management.BadAttributeValueExpException;

public class Brad45 {
	public static void main(String[] args) {
		Brad451 obj = new Brad451();
		try {
			obj.m2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Brad451{
	void m1() throws Exception {
		System.out.println("Brad451:m1()");
	}
	void m2() throws Exception {
		m3();
	}
	void m3() throws Exception {
		m4(3);
	}
	void m4(int a) throws Exception {
		if (a < 10) {
			System.out.println("OK");
		}else {
			throw new Exception();
		}
	}
}
class Brad452 extends Brad451{
//	void m1() throws Exception {	// 父類別並未拋出例外，故錯誤
	void m1() throws AlreadyBoundException, BadAttributeValueExpException {
		System.out.println("Brad452:m1()");
	}
}
class Brad453 extends Brad452{
//	void m1() throws FontFormatException {
//		System.out.println("Brad453:m1()");
//	}
}


