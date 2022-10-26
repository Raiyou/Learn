package tw.brad.myclass;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private LinkedList<HashMap<String, Integer>> line; 
//	private LinkedList<LinkedList<HashMap<String, Integer>>> lines;	// line<line<point>>
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);		
		
		line = new LinkedList<>();
//		lines = new LinkedList<>();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
//		for (LinkedList<HashMap<String, Integer>> line : lines) {
			for (int i=1; i<line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i-1);
				HashMap<String, Integer> p1 = line.get(i);
	//			g2d.drawLine(0, 0, 200, 100);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
//		}
		
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
//			System.out.println("Press:" + e.getX() + " x " + e.getY());
			
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());

			line.add(point);
//			lines.add(line);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
//			System.out.println("Drag:" + e.getX() + " x " + e.getY());

			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());

			line.add(point);
//			lines.add(point);
			
			repaint();	// 
		}
	}
}



