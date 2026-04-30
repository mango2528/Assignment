import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HW2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		
		if (!file.exists()) {
			System.exit(0);
		}
		
		Scanner scanner = new Scanner(file);
		int columnSize = Integer.parseInt(args[1]);
		
		while (scanner.hasNextLine()) {
			int size = new Scanner(scanner.nextLine()).nextInt();
			int temp = 0;
			
			System.out.printf("%-3d ", size);
			
			for (int i = 0 ; i < size / columnSize; i++) {
				System.out.println(getSharps(columnSize));
				System.out.print("    ");
			}
			
			System.out.println(getSharps(size % columnSize));
		}
		
		scanner.close();
	}
	
	private static String getSharps(int s) {
		String temp = "";
		
		for (int i = 0; i < s; i++) {
			temp += "#";
		}
		
		return temp;
	}
}

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class HW2 {
//	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File(args[0]);
//		int n = Integer.parseInt(args[1]);
//		Scanner scanner = new Scanner(file);
//		Scanner line;
//		
//		while (scanner.hasNextLine()) {
//			line = new Scanner(scanner.nextLine());
//			int num = line.nextInt();
//			int temp = 0;
//			
//			System.out.printf("%-3d", num);
//			
//			for (int i = 0; i < num; i++) {
//				System.out.printf("#");
//				temp++;
//				
//				if (temp >= n) {
//					System.out.println();
//					System.out.printf("   ");
//					temp = 0;
//				}
//			}
//			
//			System.out.println();
//		}
//		
//		scanner.close();
//	}
//}
