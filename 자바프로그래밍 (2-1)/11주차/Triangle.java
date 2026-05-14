public class Triangle extends Figure{
	public Triangle() {
		type = null;
		x = -1;
		y = -1;
		width = -1;
		height = -1;
	}
	
	public Triangle(String type, int x, int y, int width, int height) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setArea();
	}
	
	protected void setArea() {
		this.area = width * height / 2;
	}
	
	public String toString() {
		return String.format("%s-[X:%d, Y:%d] 밑변[%d], 높이[%d] 면적[%.2f]", type, x, y, width, height, area);
	}
}
