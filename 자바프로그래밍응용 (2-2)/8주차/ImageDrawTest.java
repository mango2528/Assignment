import javax.swing.*;
import java.awt.*;

public class ImageDrawTest extends JFrame {
	private PanelEx panel = new PanelEx();
	
	public ImageDrawTest() {
		setTitle("ㅇㅇ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(new Dimension(1280, 720));
		setLocationRelativeTo(null);
		
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setUndecorated(true);
		
		setVisible(true);
	}
	
	public class PanelEx extends JPanel {
		private ImageIcon icon = new ImageIcon("Image_Example.png");
		private Image image = icon.getImage();
		
		@Override
		public void paint(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}
	
	private void fullscreen() {
		
	}
	
	public static void main(String[] args) {
		new ImageDrawTest();
	}
}
