import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class HW extends JFrame {
    private static final String[] OPTION_TITLE = {"짝수", "홀수", "소수", "초기화"};
    private static final Color COLOR_TRUE = Color.red;
    private static final Color COLOR_FALSE = Color.yellow;
    
    private static enum OPTION {
    	ODD,
    	EVEN,
    	PRIME
    }
    private static OPTION currentOption;
	
    public static void main(String[] args) {
    	int width = Integer.parseInt(args[0]);
    	int height = Integer.parseInt(args[1]);
    	int column = Integer.parseInt(args[3]);
    	int row = Integer.parseInt(args[2]);
    	String option = args[4];
		
		switch (option) {
		case "홀수" :
			currentOption = OPTION.ODD;
			break;
			
		case "짝수" :
			currentOption = OPTION.EVEN;
			break; 
			
		case "소수" :
			currentOption = OPTION.PRIME;
			break;
		}
    	
    	new HW(row, column, width, height, option);
    }
    
	public HW(int row, int column, int width, int height, String option) {		
		super(String.format("[과제] %d행 %d열 (%dx%d) : %s", row, column, width, height, option));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setVisible(true);
		
		Container container = getContentPane();
		container.setLayout(null);
		
		int screenWidth = (int)container.getSize().getWidth();
		int screenHeight = (int)container.getSize().getHeight();
		
		// --- OPTIONS ------------------------------
		
		Size buttonOptionSize = new Size((screenWidth / 4), 40);
		
		for (int i = 0; i < 4; i++) {
			JButton button = new JButton(OPTION_TITLE[i]);
			button.setBounds(buttonOptionSize.width * i, screenHeight - buttonOptionSize.height, screenWidth / 4, buttonOptionSize.height);
			
			switch (currentOption) {
			case EVEN :
				if (i == 0) {
					button.setBackground(Color.lightGray);
				}
				
				break;
				
			case ODD : 
				if (i == 1) {
					button.setBackground(Color.lightGray);
				}
				
				break;
				
			case PRIME :
				if (i == 2) {
					button.setBackground(Color.lightGray);
				}
				
				break;
			}
			
			container.add(button);
		}
		
		// ------------------------------------------
		
		// --- BUTTONS ------------------------------
		
		Size buttonSize = new Size(screenWidth / column, (screenHeight - buttonOptionSize.height) / row);
		int index = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				index++;
				
				JButton button = new JButton(Integer.toString(index));
				button.setSize(new Dimension(buttonSize.width, buttonSize.height));
				button.setLocation(new Point(buttonSize.width * j, buttonSize.height * i));
				
				switch (currentOption) {
				case EVEN :
					if (index % 2 == 0) {
						button.setBackground(COLOR_TRUE);
					}
					else {
						button.setBackground(COLOR_FALSE);
					}
					
					break;
				case ODD : 
					if (index % 2 != 0) {
						button.setBackground(COLOR_TRUE);
					}
					else {
						button.setBackground(COLOR_FALSE);
					}
					
					break;
				case PRIME :
					boolean flag = true;
					
					for (int k = 2; k < index - 1; k++) {
						if (index % k == 0) {
							button.setBackground(COLOR_FALSE);
							flag = false;
							break;
						}
						else {
							continue;
						}
					}
					
					if (flag) {
						button.setBackground(COLOR_TRUE);
					}
					
					if (index == 1) {
						button.setBackground(COLOR_FALSE);
					}
					
					break;
				}
				
				container.add(button);
			}
		}
		
		// ------------------------------------------
		
		repaint();
		setLocationRelativeTo(null);
	}
}

class Size {
	public int width;
	public int height;
	
	public Size(int x, int y) {
		this.width = x;
		this.height = y;
	}
}
