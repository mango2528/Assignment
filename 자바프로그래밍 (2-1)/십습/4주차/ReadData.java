import java.util.Scanner;

public class ReadData {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int intData = 0;
		float floatData = 0;
		char charData = ' ';
		String stringData = "";
		
		while (scanner.hasNextLine()) {
			Scanner line = new Scanner(scanner.nextLine());
			
			while (line.hasNext()) {
				if (line.hasNextInt()) {
					intData = line.nextInt();
					System.out.printf("[정수 : %d] ", intData);
				}
				else if (line.hasNextFloat()) {
					floatData = line.nextFloat();
					System.out.printf("[실수 : %.3f] ", floatData);
				}
				else {		
					stringData = line.next();
				
					if (stringData.length() == 1) {
						charData = stringData.charAt(0);
						stringData = "";
						System.out.printf("[문자 : %c] ", charData);
					}
					else {
						System.out.printf("[문자열 : %s] ", stringData);
					}
				}
			}
			
			line.close();
			
			// System.out.printf("%d, %f, %s\n", intData, floatData, stringData);
		}
		
		scanner.close();
	}
}

// 12.3 2 3 3.34 korea 10 9 92.321 summer
