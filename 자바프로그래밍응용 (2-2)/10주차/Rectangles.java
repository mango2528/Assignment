import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.*;
import javax.swing.*;

public class Rectangles extends JFrame {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final boolean ISFREEDRAWING = true;
	private static int brushSize = 4;
	
	public Rectangles() {
		super("");
		
		PanelEx panel = new PanelEx();
		panel.setBackground(Color.LIGHT_GRAY);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	private class PanelEx extends JPanel {
		Line curLine;
		ArrayList<Line> lines = new ArrayList<>();
		ArrayList<Point> points = new ArrayList<>();
		
		public PanelEx() {
			curLine = null;
			addMouseListener(new MouseAction());
			addMouseMotionListener(new MouseAction());
//			addMouseWheelListener(null);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (curLine != null) {
				curLine.setGraphics(g);
				curLine.draw();
			}
			
			for (Line l : lines) {
				l.setGraphics(g);
				l.draw();
			}
			
			for (Point p : points) {
				p.setGraphics(g);
				p.draw();
			}
		}
		
		class MouseAction implements MouseListener, MouseMotionListener, MouseWheelListener {
			int x1 = 0;
			int y1 = 0;
			int x2 = 0;
			int y2 = 0;
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if (isControlDown(e)) {
					if (ISFREEDRAWING) {
						x2 = e.getX();
						y2 = e.getY();
						
						points.add(new Point("", x2, y2, brushSize, brushSize, Color.LIGHT_GRAY));
						repaint();
						return;
					}
					else
						return;
				}
				
				x2 = e.getX();
				y2 = e.getY();
				
				if (!ISFREEDRAWING)				
					curLine.setEndPoint(x2, y2);
				else		
					points.add(new Point("", x2, y2, brushSize, brushSize, Color.BLACK));
				
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (ISFREEDRAWING)
					return;
				
				if (isControlDown(e)) {
					if (lines.size() == 0)
						return;
					
					lines.removeLast();
					curLine = new Line("", 0, 0, 0, 0, Color.WHITE);
					repaint();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (ISFREEDRAWING)
				{
					if (e.isAltDown()) {
						brushSize++;
						System.out.println(brushSize);
					}
					else if (e.isShiftDown()) {
						brushSize--;
						System.out.println(brushSize);
					}
					
					return;
				}
				
				if (isControlDown(e))
					return;
				
				x1 = e.getX();
				y1 = e.getY();
				
				if (curLine == null)
					curLine = new Line("" + lines.size(), x1, y1, x1, y1, Color.WHITE);
				else
				{
					curLine.setName("" + lines.size());
					curLine.setStartPoint(x1, y1);
					curLine.setEndPoint(x1, y1);
				}
				
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (ISFREEDRAWING)
					return;
				
				if (isControlDown(e))
					return;
				
				x2 = e.getX();
				y2 = e.getY();
				
				curLine.setEndPoint(x2, y2);
				lines.add(new Line("" + lines.size(), x1, y1, x2, y2, Color.WHITE));
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				
			}
			
			private boolean isControlDown(MouseEvent e) { return e.isControlDown(); }
		}
	}
	
	public static void main(String[] args) {
		new Rectangles();
	}
}

// LIFECYCLE
//
// Component.setVisible(true) -> Component.paintComponent()
// repaint() -> paintComponent()
