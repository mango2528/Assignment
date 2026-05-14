public class Circle extends Figure{
	public int radius;
	private final double PI = Math.PI;
	
	public Circle() {
		type = null;
		x = -1;
		y = -1;
	}
	
	public Circle(String type, int x, int y, int radius) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.radius = radius;
		setArea();
	}
	
	protected void setArea() {
		this.area = radius * radius * PI;
	}
	
	public String toString() {
		return String.format("%s-[X:%d, Y:%d] 반지름[%d] 면적[%.2f]", type, x, y, radius, area);
	}
}
