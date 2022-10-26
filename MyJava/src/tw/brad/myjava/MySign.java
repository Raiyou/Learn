package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.myclass.MyDrawer;	// 此處切換範例

public class MySign extends JFrame {
	private JButton clear, undo, redo, chColor, save, saveas, load;
	private MyDrawer myDrawer;	// 此處切換範例
	
	public MySign() {
		super("簽名App");
		
		setLayout(new BorderLayout());
		
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");

		JPanel top = new JPanel(new FlowLayout());
		top.add(clear); top.add(undo); top.add(redo);

		add(top, BorderLayout.NORTH);
		
		myDrawer = new MyDrawer();	// 此處切換範例
		add(myDrawer, BorderLayout.CENTER);
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new MySign();
	}

}