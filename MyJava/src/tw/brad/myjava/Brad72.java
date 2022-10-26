package tw.brad.myjava;

public class Brad72 {

	public static void main(String[] args) {
		// 多重執行緒 multi-thread => 
		MyThread mt1 = new MyThread("A");
		MyThread mt2 = new MyThread("B");
//		mt1.run();	// 物件方法: 可用多次; 1個跑完換下個
//		mt2.run();	
		MyRunnable mr1 = new MyRunnable("C");
		Thread t1 = new Thread(mr1);
		
		t1.run();
		System.out.println("---");
		
		mt1.start();	// 生命週期1次
		mt2.start();
		t1.start();
		
		System.out.println("main");
	}

}

class MyThread extends Thread {
	String name;
	MyThread (String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(name + ":" +i);
			try {
				Thread.sleep(100);	
			} catch (Exception e) {
				System.out.println(e);
			}
		}		
	}
}

class MyRunnable implements Runnable {
	String name;
	MyRunnable (String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(name + ":" +i);
			try {
				Thread.sleep(100);	
			} catch (Exception e) {
				System.out.println(e);
			}
		}		
	}
}

