import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
		
		JMenuItem[] menuItems = new JMenuItem[4];
		String[] itemTitles = {"안녕하세요", "잘지내요", "밥은드셨어요", "안녕히계세요"};
		
		MenuActionListener listener = new MenuActionListener();
		
		for (int i = 0; i < menuItems.length; i++) {
			menuItems[i] = new JMenuItem(itemTitles[i]);
			menuItems[i].addActionListener(listener);
			meetMenu.add(menuItems[i]);
		}
		
//		meetMenu.add(new JMenuItem("안녕하세요"));
//		meetMenu.add(new JMenuItem("잘지내요"));
//		meetMenu.add(new JMenuItem("밥은드셨어요"));
//		meetMenu.addSeparator();
//		JMenuItem bye = new JMenuItem("안녕히계세요");
//		bye.addActionListener(new MenuActionListener());
//		meetMenu.add(bye);
		
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

class MenuActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command) {
		case "안녕하세요" :
			System.out.println("네 안녕하세요");
			break;
		case "잘지내요" :
			System.out.println("네 잘지내요");
			break;
		case "밥은드셨어요" :
			System.out.println("네 밥먹었어요");
			break;
		case "안녕히계세요" :
			System.exit(0);
			break;
		}
	}
}
