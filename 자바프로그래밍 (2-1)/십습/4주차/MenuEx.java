import javax.swing.*;

public class MenuEx extends JFrame{
	public MenuEx() {
		setTitle("ㅎㅇ");
		createMenu();
		setSize(640, 480);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu meetMenu = new JMenu("만남");
		
		meetMenu.add(new JMenuItem("안녕하세요"));
		meetMenu.add(new JMenuItem("잘지내요"));
		meetMenu.add(new JMenuItem("밥은드셨어요"));
		meetMenu.addSeparator();
		meetMenu.add(new JMenuItem("안녕히계세요"));
		
		menuBar.add(meetMenu);
		menuBar.add(new JMenu("관계"));
		menuBar.add(new JMenu("발전"));
		menuBar.add(new JMenu("갈등"));
		menuBar.add(new JMenu("결연"));
		
		setJMenuBar(menuBar);
	}
	
	public static void main(String args[]) {
		new MenuEx();
	}
}
