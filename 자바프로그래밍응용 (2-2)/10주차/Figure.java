import java.awt.*;

public abstract class Figure {
	protected String name;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Color color;
	protected Graphics graphics;
	
	public Figure(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.color = c;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void drawString() {
		graphics.drawString(name, x, y);
	}
	
	public void setGraphics(Graphics g) {
		this.graphics = g;
	}
	
	abstract void draw();
}

class Rect extends Figure {
	public Rect(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}
	
	public Rect(String n, int x, int y, int w, int h, Color c) {
		this(x, y, w, h, c);
		this.name = n;
	}
	
	@Override
	public void draw() {
		graphics.setColor(color);
		graphics.drawRect(x, y, width, height);
		drawString();
	}
}

class Line extends Figure {
	public Line(int x1, int y1, int x2, int y2, Color c) {
		super(x1, y1, x2, y2, c);
	}
	
	public Line(String n, int x1, int y1, int x2, int y2, Color c) {
		this(x1, y1, x2, y2, c);
		this.name = n;
	}
	
	public void setStartPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setEndPoint(int x, int y) {
		this.width = x;
		this.height = y;
	}
	
	@Override
	public void draw() {
		graphics.setColor(color);
		graphics.drawLine(x, y, width, height);
		drawString();
	}
}

class Point extends Figure {
	public Point(int x1, int y1, int x2, int y2, Color c) {
		super(x1, y1, x2, y2, c);
	}
	
	public Point(String n, int x1, int y1, int x2, int y2, Color c) {
		this(x1, y1, x2, y2, c);
		this.name = n;
	}

	@Override
	void draw() {
		graphics.setColor(color);
		graphics.fillOval(x - width / 2, y - height / 2, width, height);
		drawString();
	}
}