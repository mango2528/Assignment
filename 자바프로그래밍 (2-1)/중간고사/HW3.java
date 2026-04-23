import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class HW3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner line;
		int[][] integers = new int[999][999];
		int[] integerSum = new int[1001];
		int tempX = 0;
		int tempY = 0;
		
		while(scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			
			while (line.hasNext()) {
				integers[tempX][tempY] = line.nextInt();
				tempX++;
			}
			
			tempX = 0;
			tempY++;
		}
		
		int n = 0;
		int temp = 0;
		
		for (int i = 0; i < 999; i++) {
			if (integers[i][0] == 0) {
				n = temp;
				break;
			}
			
			temp++;
		}
		
		for (int i = 0; i < 999; i++) {
			System.out.printf("       ");
			
			for (int j = 0; j < 999; j++) {
				if (integers[j][i] == 0) {
					break;
				}
				
				System.out.printf("%6d ", integers[j][i]);
			}
			
			if (integers[0][i] != 0) {
				System.out.println();
			}
		}
		
		temp = n - 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == temp) {
					integerSum[0] += integers[temp][i];
					temp--;
					break;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (integers[i][j] != 0) {
					integerSum[i + 1] += integers[i][j];
				}
			}
		}
		
		temp = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == temp) {
					integerSum[n + 1] += integers[temp][i];
					temp++;
					break;
				}
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < n + 2; i++) {
			if (i == 0) {
				System.out.printf("      ");
			}
			
			System.out.printf("%6d ", integerSum[i]);
		}
	}
}
