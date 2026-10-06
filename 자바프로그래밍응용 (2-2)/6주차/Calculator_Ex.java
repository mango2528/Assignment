import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculator_Ex extends JFrame {
	// ---------- 소수 연산 활성화 ----------
	
	public static boolean allowDecimal = false;
	
	// ----------------------------------
	
	public static final String DIV = "\u00F7", PLUS = "\u002B", MINUS = "\u2212", DOT = "\u2219", EQ = "\u003D", SIGNS="\u00B1", MULTI="\u00D7", MOD="\u0025", CE="CE";
	private JTextField	resultPanel = new JTextField("0");
	private static String[][] p = {
			{DIV, MULTI, MINUS, PLUS},
			{"7","8","9",MOD},
			{"4","5","6",CE},
			{"1","2","3",EQ},
			{SIGNS,"0",DOT}	
	};
	private final int WIDTH = 450, HEIGHT = 400, RESULT_RATE = 70;
	
	private static String lhs = "0";
	private static String rhs = "0";
	private static String operator = "";
	private static boolean isRight = false;
	private static boolean isNegative = false;
	private static boolean isDecimal = false;
	
	public Calculator_Ex()	{
		setTitle("[과제 #2] 계산기");
		JPanel	main = new JPanel(new GridBagLayout()), out_pan = new JPanel(new GridBagLayout());
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridBagConstraints gc = new GridBagConstraints();
		JButton	btn;
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.1; gc.weighty = 0.1;
		
		gc.gridx = 0; gc.gridy = 0;
		gc.gridwidth = 1; gc.gridheight = 1;
		gc.ipadx = (int)(WIDTH*(RESULT_RATE/100.0));
		gc.ipady = 10;
		out_pan.add(resultPanel, gc);
		resultPanel.setHorizontalAlignment(JTextField.RIGHT);
		resultPanel.setFont(new Font("Arial Black", Font.BOLD, 26));
		resultPanel.setForeground(new Color(42, 140, 27));
		resultPanel.setBackground(new Color(205, 204, 0));
		resultPanel.setMargin(new Insets(0, 5, 0, 5));
		resultPanel.setEditable(false);
		gc.gridx = 1; gc.gridy = 0;
		gc.gridwidth = 1; gc.gridheight = 1;
		gc.ipadx = 0;
		gc.insets = new Insets(1, 1, 1, 1);
		out_pan.add(btn = new JButton("DEL"),gc);
//		btn.setForeground(Color.white); btn.setBackground(Color.red);
//		btn.setFont(new Font("Arial Black", Font.BOLD, 26));
		btn.addActionListener(new ActionMod());
		c.add(out_pan, BorderLayout.NORTH);
		
		for(int row=0;row < p.length;row++) {
			for(int col=0;col < p[row].length;col++) {
				int gridHeight = 1;
				
				if (p[row][col].equals(EQ)) {
					gridHeight = 2;
				}
				else {
					gridHeight = 1;
				}
				
				addComp(main, btn = new JButton(p[row][col]), col, row, 1, gridHeight, gc);
				
				if (Character.isDigit(p[row][col].charAt(0))) {
					btn.addActionListener(new ActionNumeric());
				}
				else {
					btn.addActionListener(new ActionMod());
				}
			}
		}
		c.add(main, BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pack();
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private void addComp(Container c, JComponent jc, int x, int y, int col_pan, int row_span, GridBagConstraints gc) {
		gc.gridx = x; gc.gridy = y;
		gc.gridwidth = col_pan; gc.gridheight = row_span;
		gc.weighty = 1;
		c.add(jc, gc);
	}
	
	private class ActionMod implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton	btn = (JButton) e.getSource();
			String	b_txt = btn.getText();
			
			switch (b_txt) {
			case "EXIT" :
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(ABORT);
				
			case "DEL" :
				if (!isDigit()) {
					update("0");
					break;
				}
				
				if (getText().length() > 1) {
					StringBuilder sb = new StringBuilder(getText());
					
					if (sb.charAt(sb.length() - 1) == '.') {
						isDecimal = false;
					}				
					
					sb.deleteCharAt(sb.length() - 1);
					update(sb.toString());
				}
				else {
					update("0");
				}
				
				break;
				
			case CE :
				update("0");
				isNegative = false;
				isDecimal = false;
				break;
				
			case PLUS :
				tryMoveToRight(PLUS);
				break;
				
			case MINUS :
				tryMoveToRight(MINUS);
				break;
				
			case MULTI :
				tryMoveToRight(MULTI);
				break;
				
			case DIV :
				tryMoveToRight(DIV);	
				break;
				
			case MOD :
				tryMoveToRight(MOD);
				break;
				
			case SIGNS :
				if (isZero() || !isDigit()) {
					break;
				}
				
				isNegative = !isNegative;
				
				StringBuilder sb = new StringBuilder(getText());
				
				if (isNegative) {
					sb.insert(0, '-');
					isNegative = true;
					update(sb.toString());
				}
				else {
					sb.deleteCharAt(0);
					isNegative = false;
					update(sb.toString());
				}
				
				break;
				
			case DOT :
				if (!allowDecimal) {
					break;
				}
				
				if (!isDigit()) {
					break;
				}
				
				sb = new StringBuilder(getText());
				
				if (isDecimal && getText().charAt(getText().length() - 1) == '.') {
					sb.deleteCharAt(sb.length() - 1);
					isDecimal = false;
				}			
				else if (!isDecimal) {
					sb.append('.');
					isDecimal = true;
				}
				
				update(sb.toString());
				
				break;
				
			case EQ :
				if (isRight) {
					Calculate();
				}
				
				break;
			}
		}
	}
	
	private class ActionNumeric implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton	btn = (JButton) e.getSource();
			String buttonValue = btn.getText();
			String str = "";
			
			if (!getText().equals("0") && isDigit()) {
				str = (resultPanel.getText() + buttonValue);
			}
			else {
				str = (buttonValue);
			}
			
			update(str);
		}	
	}
	
	private void update(String str) {
		resultPanel.setText(str);
	}
	
	private void tryMoveToRight(String op) {
		if (isRight) {
			return;
		}
		else if (isZero()) {
			return;
		}
		else if (op.equals(MOD) && isDecimal) {
			return;
		}
		
		lhs = resultPanel.getText();
		isRight = true;
		isNegative = false;
		isDecimal = false;
		operator = op;
		update("0");
	}
	
	private void Calculate() {
		if (operator.equals(MOD) && isDecimal) {
			return;
		}
		
		rhs = resultPanel.getText();
		isRight = false;
		isNegative = false;
		isDecimal = false;
		
		if ((operator.equals(DIV) || operator.equals(MOD)) && (int)Integer.parseInt(rhs) == 0) {
			divZero();
			return;
		}
		
		boolean isFloat = false;
		
		if (lhs.contains(".")) {
			isFloat = true;
		}
		
		if (rhs.contains(".")) {
			isFloat = true;
		}
		
//		System.out.println(lhs);
//		System.out.println(rhs);
//		System.out.println(isFloat);
		
		if (!isFloat) {
			if (operator.equals(DIV) ) {
				update(String.format("%.3f", Float.parseFloat(Calculation.compute(lhs, operator, rhs))));
			}
			else {
				update(String.format("%d", (int)Float.parseFloat(Calculation.compute(lhs, operator, rhs))));	
			}
		}
		else {
			if (allowDecimal) {
				update(String.format("%f", Float.parseFloat(Calculation.compute(lhs, operator, rhs))));
			}
			else {
				update(String.format("%.0f", Float.parseFloat(Calculation.compute(lhs, operator, rhs))));
			}
		}
	}
	
	private String getText() {
		return resultPanel.getText();
	}
	
	private boolean isZero() {
		if (isDecimal) {
			return Float.parseFloat(getText()) == 0;
		}
		else {
			return getText().equals("0");
		}
	}
	
	private boolean isDigit() {
		if (isNegative) {
			return Character.isDigit(getText().charAt(1));
		}
		
		return Character.isDigit(getText().charAt(0));
	}
	
	private void divZero() {
		update("Divide By Zero");
	}
	
	public static void main(String[] args) {
		new Calculator_Ex();
	}
}
