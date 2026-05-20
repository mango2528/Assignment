import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class HW1 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		
		if (!file.exists()) {
			System.out.printf("%s 파일 없음", args[0]);
			System.exit(-1);
		}
		
		Scanner scanner = new Scanner(file);
		Scanner line;
		
		Figure[] figures = new Figure[1];
		
		int index = 0;
		
		boolean isPrintSpecific = false;
		String[] targets = new String[4];
		
		if (args[1].equals("print")) {
			isPrintSpecific = true;
			
			if (isValidFigure(args[2])) {
				for (int i = 2; i < args.length; i++) {
					if (isValidFigure(args[i])) {
						targets[i - 2] = args[i];
					}
					else {
						System.out.println("도형 종류 오류");
						System.exit(-1);
					}
				}
			}
		}
		else if (!args[1].equals("print_info")) {
			System.out.println("없는 명령어");
			System.exit(-1);
		}
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			
			if (index >= figures.length) {
				figures = Arrays.copyOf(figures, figures.length * 2);
			}
			
			switch (line.next()) {
			case ("사각형") :
				figures[index] = new Rectangle("사각형", line.nextInt(), line.nextInt(), line.nextInt(), line.nextInt());
				break;
			case ("삼각형") :
				figures[index] = new Triangle("삼각형", line.nextInt(), line.nextInt(), line.nextInt(), line.nextInt());
				break;
			case ("원") :
				figures[index] = new Circle("원", line.nextInt(), line.nextInt(), line.nextInt());
				break;
			case ("사다리꼴") :
				figures[index] = new Trapezoid("사다리꼴", line.nextInt(), line.nextInt(), line.nextInt(), line.nextInt(), line.nextInt());
				break;
			case ("타원") :
				figures[index] = new Ellipse("타원", line.nextInt(), line.nextInt(), line.nextInt(), line.nextInt());
				break;
			}
			
			index++;
		}
		
		figures = trimArray(figures);
		
		if (!isPrintSpecific) {
			printFigures(figures);
		}
		else {
			printSpecific(figures, targets);
		}
		
		scanner.close();
	}
	
	private static Figure[] trimArray(Figure[] arr) {
		Figure[] temp = arr;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				temp = Arrays.copyOf(arr, i);
				return temp;
			}
		}
		
		return temp;
	}
	
	private static void printFigures(Figure[] arr) {
		double sum = 0;
		int[] indexLargest = findLargest(arr);
		int[] indexSmallest = findSmallest(arr);
		
		for (int i = 0; i < arr.length; i++) {
			for (int large : indexLargest) {
				if (i == large) {
					System.out.printf("L ");
					break;
				}
			}
			
			for (int small : indexSmallest) {
				if (i == small) {
					System.out.printf("S ");
					break;
				}
			}
			
			System.out.println(arr[i]);
			sum += arr[i].area;
		}
		
		System.out.printf("\n평균 면적 : %.2f", sum / arr.length);
	}
	
	private static void printSpecific(Figure[] arr, String[] targets) {
		Figure[] temp = new Figure[0];
		
		for (int i = 0; i < targets.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].type.equals(targets[i])) {
					temp = Arrays.copyOf(temp, temp.length + 1);
					temp[temp.length - 1] = arr[j];
				}
			}
		}
		
		double sum = 0;
		int count = 0;
		int[] indexLargest = findLargest(temp);
		int[] indexSmallest = findSmallest(temp);
		
		for (int i = 0; i < temp.length; i++) {
			for (int large : indexLargest) {
				if (i == large) {
					System.out.printf("L ");
					break;
				}
			}
			
			for (int small : indexSmallest) {
				if (i == small) {
					System.out.printf("S ");
					break;
				}
			}
			
			System.out.println(temp[i]);
			sum += temp[i].area;
			count++;
		}
		
		System.out.printf("\n평균 면적 : %.2f", sum / count);
	}
	
	private static int[] findLargest(Figure[] arr) {
		double temp = arr[0].area;
		int indexs[] = new int[1];
		indexs[0] = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if (temp < arr[i].area) {
				temp = arr[i].area;
				indexs = new int[1];
				indexs[0] = i;
			}
			else if (temp == arr[i].area) {
				indexs = Arrays.copyOf(indexs, indexs.length + 1);
				indexs[indexs.length - 1] = i;
			}
		}
		
		return indexs;
	}
	
	private static int[] findSmallest(Figure[] arr) {
		double temp = arr[0].area;
		int indexs[] = new int[1];
		indexs[0] = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if (temp > arr[i].area) {
				temp = arr[i].area;
				indexs = new int[1];
				indexs[0] = i;
			}
			else if (temp == arr[i].area) {
				indexs = Arrays.copyOf(indexs, indexs.length + 1);
				indexs[indexs.length - 1] = i;
			}
		}
		
		return indexs;
	}
	
	private static boolean isValidFigure(String str) {
		if (str.equals("원") || str.equals("타원") || str.equals("사각형") || str.equals("삼각형") || str.equals("사다리꼴")) {
			return true;
		}
		else {
			return false;
		}
	}
}

abstract class Figure {
	String type;
	public int x;
	public int y;
	public int width;
	public int height;
	public double area;
	
	protected abstract void setArea();
	
	public abstract String toString();
}

class Circle extends Figure{
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

class Ellipse extends Figure {
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
	
	public Ellipse(String type, int x, int y, int first, int second) {
		this.type = type;
		this.x = x;
		this.y = y;
		
		if (first > second) {
			major = first;
			minor = second;
		}
		else {
			major = second;
			minor = first;
		}
		
		setArea();
	}
	
	protected void setArea() {
		this.area = major * minor * PI;
	}
	
	public String toString() {
		return String.format("%s-[X:%d, Y:%d] 반지름[%d], 짧은반지름[%d] 면적[%.2f]", type, x, y, major, minor, area);
	}
}

class Rectangle extends Figure{
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

class Triangle extends Figure{
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

class Trapezoid extends Figure {
	public int width;
	public int widthShort;
	
	public Trapezoid() {
		type = null;
		x = -1;
		y = -1;
		width = -1;
		widthShort = -1;
		height = -1;
	}
	
	public Trapezoid(String type, int x, int y, int first, int second, int height) {
		this.type = type;
		this.x = x;
		this.y = y;
		
		if (first > second) {
			width = first;
			widthShort = second;
		}
		else {
			width = second;
			widthShort = first;
		}
		
		this.height = height;
		setArea();
	}
	
	protected void setArea() {
		this.area = (width + widthShort) * height / 2;
	}
	
	public String toString() {
		return String.format("%s-[X:%d, Y:%d] 가로[%d], 짧은가로[%d] 높이[%d] 면적[%.2f]", type, x, y, width, widthShort, height, area);
	}
}