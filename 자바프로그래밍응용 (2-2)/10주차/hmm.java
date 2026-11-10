import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class hmm extends JFrame {
	private BufferedImage image;
	
	public hmm() {
		Container container = getContentPane();
		container.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1280, 720));
		
		try {
			image = ImageIO.read(new File("title.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new hmm();
	}
}

class ImageTest extends JPanel {
	
}
