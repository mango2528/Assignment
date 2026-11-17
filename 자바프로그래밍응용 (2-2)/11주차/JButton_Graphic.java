import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButton_Graphic extends JFrame {
	public JButton_Graphic( ) {
		super("ㅇㅇ");
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		container.setLayout(null);
		MyButton button = new MyButton("ㅇㅇ");
		button.setBounds(320, 240, 100, 33);
		
		container.add(button);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JButton_Graphic();
	}
	
	private class MyButton extends JButton {
		public MyButton(String name) {
			super(name);
		}
		
		public void paint(Graphics g) {
			super.paintComponent(g);
			Rectangle rect = new Rectangle("ㄴㄴ", 20, 20, 40, 40, Color.BLACK);
			rect.setGraphics(g);
			rect.draw();
		}
	}
}
