public class Trapezoid extends Figure {
	public int upper;
	public int bottom;
	
	public Trapezoid() {
		type = null;
		x = -1;
		y = -1;
		upper = -1;
		bottom = -1;
		height = -1;
	}
	
	public Trapezoid(String type, int x, int y, int upper, int bottom, int height) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.upper = upper;
		this.bottom = bottom;
		this.height = height;
		setArea();
	}
	
	protected void setArea() {
		this.area = (upper + bottom) * height / 2;
	}
	
	public String toString() {
		return String.format("%s-[X:%d, Y:%d] 가로[%d], 짧은가로[%d] 높이[%d] 면적[%.2f]", type, x, y, upper, bottom, height, area);
	}
}
