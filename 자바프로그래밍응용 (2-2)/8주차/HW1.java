import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * !대각선 판정 만드셈!
 */

public class HW1 extends JFrame {
	private static boolean isGameStarted = false; // 차례 선택 / 인게임 상태 구분
	private static boolean isGameEnded = false; // 게임 종료
	private static boolean isOTurn = true; // 기본 차례는 O
	private static JButton mainUI = new JButton("");
	private String[][] board = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
	
	public HW1() throws HeadlessException {
		Container container = getContentPane();
		container.setLayout(null);
		setContentPane(container);
		
		setTitle("과젱");
		setSize(new Dimension(480, 480));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		int mainWidth = container.getSize().width;
		int mainHeight = container.getSize().height - 40;
		
//		System.out.printf("%d %d\n", mainWidth, mainHeight);
		
		mainUI.setBorder(null);
		mainUI.setText("X 또는 O 키를 눌러 시작 순서 선택");
		mainUI.setSize(getSize().width, 40);
		mainUI.setLocation(0, 0);
		mainUI.setBackground(Color.blue);
		mainUI.setForeground(Color.white);
		
		container.add(mainUI);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				BoardButton button = new BoardButton("");
				
				button.posX = j;
				button.posY = i;
				
				button.setSize(mainWidth / 3, mainHeight / 3);
				button.setLocation((mainWidth / 3) * j, (mainHeight / 3) * i + 40);
				button.setBackground(Color.white);
				button.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent e) {
						if (isGameEnded) {
							return;
						}
						
						if (isGameStarted) {
							if (isOTurn) {
								button.isVisible = true;
								button.isO = true;
								board[button.posX][button.posY] = "O";
								setTurn(false);
								check();
							}
							else {
								button.isVisible = true;
								button.isO = false;
								board[button.posX][button.posY] = "X";
								setTurn(true);
								check();
							}
						}
					}
				});
				
				container.add(button);
			}
		}
		
		repaint();
		getKey();
	}
	
	private void getKey() {
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				switch (key) {
				case KeyEvent.VK_ESCAPE :
					if (isGameStarted) {
						resetGame();
					}
					
					break;
				case KeyEvent.VK_O :
					if (!isGameStarted) {
						setTurn(true);
					}

					break;
				case KeyEvent.VK_X :
					if (!isGameStarted) {
						setTurn(false);
					}
					
					break;
				}
			}
		};
		
		this.addKeyListener(keyAdapter);
	}
	
	private class Icon extends JPanel {
		private ImageIcon icon = new ImageIcon("O.png");
		private Image image = icon.getImage();
		
		@Override
		public void paint(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 200, 200, this);
		}
	}
	
	private void setTurn(boolean isO) {
		isGameStarted = true;
		isOTurn = isO;
		
		if (isOTurn) {
			mainUI.setText("다음 차례는 O");
		}
		else {
			mainUI.setText("다음 차례는 X");
		}
	}
	
	private void endGame(boolean isO) {
		if (isO) {
			mainUI.setText("[O:X]=[1:0] O가 승리함");
		}
		else {
			mainUI.setText("[O:X]=[0:1] X가 승리함");
		}
		
		isGameEnded = true;
	}
	
	private void resetGame() {
		isGameStarted = false;
	}
	
	private void check() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i].equals("")) {
					System.out.printf("-");
				}
				else {
					System.out.printf(board[j][i]);
				}
			}
			
			System.out.println();
		}
		
		for (int i = 0; i < board.length; i++) {
			if (board[0][i].equals("O") && board[1][i].equals("O") && board[2][i].equals("O")) {
				endGame(true);
				return;
			}
			else if (board[0][i].equals("X") && board[1][i].equals("X") && board[2][i].equals("X")) {
				endGame(false);
				return;
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			if (board[i][0].equals("O") && board[i][1].equals("O") && board[i][2].equals("O")) {
				endGame(true);
				return;
			}
			else if (board[i][0].equals("X") && board[i][1].equals("X") && board[i][2].equals("X")) {
				endGame(false);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		new HW1();
	}
	
	class BoardButton extends JButton{
		public int posX = 0;
		public int posY = 0;
		public boolean isVisible = false;
		public boolean isO = true;
		
		private ImageIcon iconO = new ImageIcon("O.png");
		private ImageIcon iconX = new ImageIcon("X.png");
		private Image imageO = iconO.getImage();
		private Image imageX = iconX.getImage();
		
		BoardButton(String s) {
			super(s);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			repaint();
			super.paintComponent(g);
			
			if (!isVisible) {
				return;
			}
			
			if (isO) {
				g.drawImage(imageO, 0, 0, this);
			}
			else {
				g.drawImage(imageX, 0, 0, this);
			}
		}
	}
}
