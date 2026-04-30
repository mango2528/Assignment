import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class HW4 {
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		Scanner line;
		String[] strings = new String[10];
		
		System.out.println(file);
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			
			int index = 0;
			
			for (int i = 0; i < strings.length; i++) {
				strings[i] = "";
			}
			
			while(line.hasNext()) {
				strings[index] = line.next();
			}
			
			for (int i = 0; i < index; i++) {
				System.out.printf("%s", strings[i]);
			}
		}
	}
}
