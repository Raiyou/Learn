package tw.brad.myjava;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBall extends JFrame {

	public MyBall() {
		super("None");
		
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyBalls();
	}
	
	public class Panel extends JPanel {
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D)g;
	
		}
	}
		
	private class MyBallsMotion {
		
	}
	
}



// 點-點->線 & mouseListener
// 
// 
// 

