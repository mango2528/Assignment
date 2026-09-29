import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class HW2 extends JFrame {
	private static enum MenuNames {
		EVEN("짝수", 0),
		ODD("홀수", 1),
		CHANGE("교환", 2),
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
	
	private final Color colorEven = new Color(140, 3, 3);
	private final Color colorOdd = new Color(3, 76, 140);
	
	private final Color colorDefault = new Color(242, 236, 148);
	private final Color colorText = new Color(28, 77, 140);
	
	public HW2() {
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
				
				button.setBackground(colorDefault);
				button.setForeground(colorText);
				
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
						for (JButton b : buttons) {
							if (Integer.parseInt(b.getText()) % 2 == 0) {
								b.setBackground(colorEven);
								b.setForeground(Color.white);
							}
						}
						
						break;
					case 1 :
						for (JButton b : buttons) {
							if (Integer.parseInt(b.getText()) % 2 != 0) {
								b.setBackground(colorOdd);
								b.setForeground(Color.white);
							}
						}
						
						break;
					case 2 : 
						int first = Rand.r(0, buttons.length - 1);
						int second = Rand.r(0, buttons.length - 1);
						JButton buttonFirst = buttons[first];
						JButton buttonSecond = buttons[second];
						
						buttonFirst.setBackground(Rand.randomColor());
						buttonFirst.setForeground(Rand.randomColor());
						buttonSecond.setBackground(Rand.randomColor());
						buttonSecond.setForeground(Rand.randomColor());
						
						buttonFirst.setText(Integer.toString(second + 1));
						buttonSecond.setText(Integer.toString(first + 1));
						
						break;
					case 3 :
						int index = 1;
						
						for (JButton b : buttons) {
							b.setBackground(colorDefault);
							b.setForeground(colorText);
							b.setText(Integer.toString(index));
							
							index++;
						}
						break;
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
		new HW2();
	}
}
