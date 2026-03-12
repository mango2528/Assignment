import java.util.Scanner;

public class HW1 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int first = 0;
		int second = 0;
		int third = 0;
		char compare1 = ' ';
		char compare2 = ' ';
		
		System.out.println("세 정수 입력 :");
		
		while (scanner.hasNext()) {
			first = scanner.nextInt();
			second = scanner.nextInt();
			third = scanner.nextInt();
			
			if (first > second) {
				int temp = first;
				first = second;
				second = temp;
			}
			
			if (second > third) {
				int temp = second;
				second = third;
				third = temp;
			}
			
			if (first > second) {
				int temp = first;
				first = second;
				second = temp;
			}
			
			if (first < second) {
				compare1 = '<';
			}
			else if (first == second) {
				compare1 = '=';
			}
			
			if (second < third) {
				compare2 = '<';
			}
			else if (second == third) {
				compare2 = '=';
			}
			
			System.out.printf("%d %c %d %c %d\n", first, compare1, second, compare2, third);
			System.out.println("세 정수 입력 :");
		}
	}
}
