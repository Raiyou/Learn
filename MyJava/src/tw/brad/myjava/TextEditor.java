package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor extends JFrame {
	private JButton open, save, saveas, exit;
	private JTextArea txtarea;
	private JPanel top;
	
	public TextEditor() {
		super("TXT Editor");
		setLayout(new BorderLayout());

		open = new JButton("Open");
		save = new JButton("Save");
		saveas = new JButton("SaveAs");
		exit = new JButton("Exit");
		txtarea = new JTextArea("");
		txtarea.setLineWrap(true);	// 自動換行
		
		top = new JPanel(new FlowLayout());

		top.add(open); top.add(save); top.add(saveas); top.add(exit); 
		add(top, BorderLayout.NORTH);
		add(txtarea, BorderLayout.CENTER);
		
		
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	
	public static void main(String[] args) {
		new TextEditor();
	}

}
