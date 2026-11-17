import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiThread_Example extends JFrame implements Runnable {
	private static int OFFSET_Y = 24;
	private static double G = 9.81;
	
	int n = 0;
	java.awt.Point pos;
	java.awt.Dimension size;
	
	double velx = 0;
	double vely = 0;
	
	int beforex = 0;
	int beforey = 0;
	
	int dx = 0;
	
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	
	public MultiThread_Example() {
		super("");
		setSize(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		
		button1.setSize(100, 33);
		button2.setSize(100, 33);
		container.add(button1);
		container.add(button2);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		KeyListener key = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_D) {
					velx = 0;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_D) {
					System.out.println("ㅇㅇ");
					velx = 5;
				}
			}
		};
		addKeyListener(key);
		
		Thread thread = new Thread(this);
		thread.run();
	}
	
	public static void main(String[] args) {
//		TimerThread hiThread = new TimerThread("hi");
//		TimerThreadMk2 byeThread = new TimerThreadMk2("bye");
//		
//		hiThread.start();
//		byeThread.run();
		
		new MultiThread_Example();
	}

	@Override
	public void run() {
		while (n <= 90) {
			setSize((int)EaseOutQuart(128, 640, (float)n / 90), (int)EaseOutQuart(108, 480, (float)n / 90));
			setLocationRelativeTo(null);
			
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				
			}
			
			n++;
		}
		
		size = getSize();
		beforex = getLocationOnScreen().x;
		
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e) {
			
		}
		
		while (true) {
			pos = getLocationOnScreen();
//			System.out.println(getLocationOnScreen());
//			System.out.println(getSize());
			
//			setLocation(getLocationOnScreen().x + velx / 10, getLocationOnScreen().y + vely / 10);
			setLocation(getLocationOnScreen().x + (int)velx, getLocationOnScreen().y + (int)vely);
			
			if (pos.y + size.height <= 1080)
				vely += G / 60;
			else {		
				if (vely > 1.5) {		
					vely = -vely / 1.66;
					setLocation(getLocationOnScreen().x, 1080 - size.height);
					setLocation(getLocationOnScreen().x, getLocationOnScreen().y + (int)vely);
				}
				else {
					vely = 0;
					setLocation(getLocationOnScreen().x, 1080 - size.height);
				}
			}
			
			if (Math.abs(velx) > 0.166) {
				velx -= 3 / 60;
			}
			else {
				velx = 0;
			}
			
			try {
				Thread.sleep(16);
			}
			catch (InterruptedException e) {
				
			}
			
			button1.setText(String.format("%.2f", vely));
			button2.setText(String.format("%d", beforex));
			
			if (velx > 0 && pos.x + size.width > 1920) {
				velx = -velx;
			}
			else if (velx < 0 && pos.x < 0) {
				velx = -velx;
			}
			
//			if (vely > 0 && pos.y + size.height > 1080) {
//				vely = -vely;
//			}
//			else if (vely < 0 && pos.y < 0) {
//				vely = -vely;
//			}
		}
	}
	
    public static float EaseOutQuart(float a, float b, float t)
    {
        t--;
        b -= a;
        return -b * (t * t * t * t - 1) + a;
    }
    

	class Flash implements Runnable {
		@Override
		public void run() {
			setBackground(Color.LIGHT_GRAY);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			setBackground(Color.WHITE);
		}
	}
}

class TimerThread extends Thread {
	int n = 0;
	
	public TimerThread(String s) {
		super(s);
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.printf("Saying %s for %d times.\n", getName(), n);
			
			try {
				sleep(n);
			}
			catch (InterruptedException e) {
				
			}
			
			n++;
		}
	}
}

class TimerThreadMk2 implements Runnable {
	String name = "name";
	int n = 0;
	
	public TimerThreadMk2(String s) {
		name = s;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.printf("Saying %s for %d times.\n", name, n);
			
			try {
				Thread.sleep(n);
			}
			catch (InterruptedException e) {
				
			}
			
			n++;
		}
	}
}
