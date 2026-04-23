import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		int n = Integer.parseInt(args[1]);
		Scanner scanner = new Scanner(file);
		Scanner line;
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			int num = line.nextInt();
			int temp = 0;
			
			System.out.printf("%-3d", num);
			
			for (int i = 0; i < num; i++) {
				System.out.printf("#");
				temp++;
				
				if (temp >= n) {
					System.out.println();
					System.out.printf("   ");
					temp = 0;
				}
			}
			
			System.out.println();
		}
		
		scanner.close();
	}
}
