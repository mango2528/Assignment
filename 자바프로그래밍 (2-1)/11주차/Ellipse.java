public class Ellipse extends Figure {
	public int major;
	public int minor;
	private final double PI = Math.PI;
	
	public Ellipse() {
		type = null;
		x = -1;
		y = -1;
		major = -1;
		minor = -1;
	}
	
	public Ellipse(String type, int x, int y, int major, int minor) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.major = major;
		this.minor = minor;
		setArea();
	}
	
	protected void setArea() {
		this.area = major * minor * PI;
	}
	
	public String toString() {
		return String.format("%s-[X:%d, Y:%d] 반지름[%d], 짧은반지름[%d] 면적[%.2f]", type, x, y, major, minor, area);
	}
}
