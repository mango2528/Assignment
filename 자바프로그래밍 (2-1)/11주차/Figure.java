public abstract class Figure {
	String type;
	public int x;
	public int y;
	public int width;
	public int height;
	public double area;
	
	protected abstract void setArea();
	
	public abstract String toString();
}

//public static void main(String[] args) {
//	Rectangle rectangle = new Rectangle("?", 960, 540, 1080, 720);
//	System.out.println(rectangle);
//}
