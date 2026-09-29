import java.awt.Color;

public class Rand {
	public static int r(int min, int max)  {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
	
	public static Color randomColor() {
		return new Color(r(0, 255), r(0, 255), r(0, 255));
	}
}