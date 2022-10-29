package tw.brad.myjava;

public class Brad76 {

	private static final int DIR_STOP = 0;
	private static final int DIR_LEFT = 1;
	private static final int DIR_RIGHT = 2;
	private static final int DIR_UP = 3;
	private static final int DIR_DOWN = 4;
	
	public static void main(String[] args) {
		int dir = DIR_STOP;
		dir = DIR_LEFT;
		dir = 123;
		
		Dir dir2 = Dir.STOP;
		dir2 = Dir.LEFT;
		System.out.println(dir2);
		System.out.println(dir2.getV());

		switch(dir2) {
			case STOP: break;
			case LEFT: break;
			case RIGHT: break;
			case UP: break;
			case DOWN: break;
		}
	
	}

}


// 列舉 可限制
enum Dir {	// enum屬於一種特殊類別 第一行便產生5個物件實體
	STOP(0),UP(1),DOWN(2),LEFT(3),RIGHT(4);
	private int v;
	Dir(int v){
		this.v = v;
	}
	int getV() {return v;}
}


