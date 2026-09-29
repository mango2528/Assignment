import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class HW1 extends JFrame {
	private static enum MenuNames {
		EVEN("짝수", 0),
		ODD("홀수", 1),
		PRIME("소수", 2),
		RESET("초기화", 3);
		
		private final String label;
		private final int index;
		
		MenuNames(String label, int index) {
			this.label = label;
			this.index = index;
		}
		
		public String label() {
			return label;
		}
		
		public int index() {
			return index;
		}
		
		public static MenuNames getMenuByIndex(int index) {
			for (MenuNames m : MenuNames.values()) {
				if (m.index() == index) {
					return m;
				}
			}
			
			return null;
		}
	}
	
	private final Color colorNonTarget = Color.yellow;
	private final Color colorTarget = Color.red;
	
	public HW1() {
		Container container = getContentPane();
		container.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(640, 480));
		pack();
		
		int menuSizeY = 50;
		
		int x = container.getSize().width;
		int y = container.getSize().height - menuSizeY;
		int xCount = 10;
		int yCount = 10;
		
		JButton[] buttons = new JButton[xCount * yCount];
		JButton[] menuButtons = new JButton[4];
		
		for (int i = 0; i < yCount; i++) {
			for (int j = 0; j < xCount; j++) {
				int index = ((i * 10) + j);
				
				JButton button = new JButton(Integer.toString(index + 1));
				button.setSize(x / xCount, y / yCount);
				button.setLocation((x / xCount) * j, (y / yCount) * i);
				
				buttons[index] = button;
				container.add(button);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			final int index = i;
			
			JButton button = new JButton(MenuNames.getMenuByIndex(i).label());
			button.setSize(x / 4, menuSizeY);
			button.setLocation((x / 4) * i, y);
			
			button.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {			
					switch (index) {
					case 0 :
						for (int i = 0; i < buttons.length; i++) {
							if (i % 2 == 0) {
								buttons[i].setBackground(colorTarget);
							}
							else {
								buttons[i].setBackground(colorNonTarget);
							}
						}
						
						break;
					case 1 :
						for (int i = 0; i < buttons.length; i++) {
							if (i % 2 != 0) {
								buttons[i].setBackground(colorTarget);
							}
							else {
								buttons[i].setBackground(colorNonTarget);
							}
						}
						
						break;
					case 2 : 
						for (int i = 0; i < buttons.length; i++) {
							boolean flag = false;
							
							if (i == 0) {
								buttons[i].setBackground(colorNonTarget);
								continue;
							}
							
							for (int j = 2; j < i; j++) {						
								if ((i + 1) % j == 0) {
									flag = true;
									break;
								}
							}
							
							if (flag) {
								buttons[i].setBackground(colorNonTarget);
							}
							else {
								buttons[i].setBackground(colorTarget);
							}
						}
						
						break;
					case 3 :
						break;
					}
					
					for (JButton b : menuButtons) {
						b.setBackground(null);
					}
					
					if (index != 3) {
						button.setBackground(Color.green);
					}
					else {
						for (JButton b : buttons) {
							b.setBackground(null);
						}
					}
				}
			});
			
			menuButtons[i] = button;
			container.add(button);
		}
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new HW1();
	}
}
