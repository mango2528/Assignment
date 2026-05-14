public class Rectangle extends Figure{
	public Rectangle() {
		type = null;
		x = -1;
		y = -1;
		width = -1;
		height = -1;
	}
	
	public Rectangle(String type, int x, int y, int width, int height) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setArea();
	}
	
	protected void setArea() {
		this.area = width * height;
	}
	
	public String toString() {
		return String.format("%s-[X:%d, Y:%d] 가로[%d], 세로[%d] 면적[%.2f]", type, x, y, width, height, area);
	}
}
