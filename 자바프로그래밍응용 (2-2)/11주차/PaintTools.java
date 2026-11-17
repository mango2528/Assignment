import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.*;
import javax.swing.*;

public class PaintTools extends JFrame {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	private static final boolean ISFREEDRAWING = false;
	private static int brushSize = 4;
	
	private enum DrawMode {
		Point,
		Line,
		Rect
	}
	
	private DrawMode curMode = DrawMode.Rect;
	private Figure curFigure;
	private ArrayList<Line> lines = new ArrayList<>();
	private ArrayList<Point> points = new ArrayList<>();
	private ArrayList<Rectangle> rects = new ArrayList<>();
	
	public PaintTools() {
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
		public PanelEx() {
			curFigure = null;
			addMouseListener(new MouseAction());
			addMouseMotionListener(new MouseAction());
//			addMouseWheelListener(null);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (curFigure != null) {
				curFigure.setGraphics(g);
				curFigure.draw();
			}
			
			for (Line l : lines) {
				l.setGraphics(g);
				l.draw();
			}
			
			for (Point p : points) {
				p.setGraphics(g);
				p.draw();
			}
			
			for (Rectangle r : rects) {
				r.setGraphics(g);
				r.draw();
			}
		}
		
		class MouseAction implements MouseListener, MouseMotionListener, MouseWheelListener {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = 0;
				int y = 0;
				
				if (isControlDown(e)) {
					if (ISFREEDRAWING) {
						x = e.getX();
						y = e.getY();
						
						points.add(new Point("", x, y, brushSize, brushSize, Color.LIGHT_GRAY));
						repaint();
						return;
					}
					else
						return;
				}
				
				x = e.getX();
				y = e.getY();
				
				if (!ISFREEDRAWING)				
					curFigure.setEndPoint(x - curFigure.x, y - curFigure.y);
				else		
					points.add(new Point("", x, y, brushSize, brushSize, Color.BLACK));
				
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
					curFigure = new Line("", 0, 0, 0, 0, Color.WHITE);
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
				
				switch (curMode) {
				case Rect:
					drawRect(true, e.getX(), e.getY());
					break;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (ISFREEDRAWING)
					return;
				
				if (isControlDown(e))
					return;
				
				switch (curMode) {
				case Rect:
					drawRect(false, e.getX(), e.getY());
					break;
				}
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
		new PaintTools();
	}
	
	private void drawRect(boolean isPressed, int x, int y) {
		if (isPressed) {
			if (curFigure == null)
				curFigure = new Rectangle("" + rects.size(), x, y, 0, 0, Color.WHITE);
			else
			{
				curFigure.setName("" + rects.size());
				curFigure.setStartPoint(x, y);
				curFigure.setEndPoint(0, 0);
			}
		}
		else {
			curFigure.setEndPoint(x - curFigure.x, y - curFigure.y);
			rects.add(new Rectangle("" + rects.size(), curFigure.x, curFigure.y, x - curFigure.x, y - curFigure.y, Color.WHITE));
		}
		
		repaint();
	}
}

// LIFECYCLE
//
// Component.setVisible(true) -> Component.paintComponent()
// repaint() -> paintComponent()
