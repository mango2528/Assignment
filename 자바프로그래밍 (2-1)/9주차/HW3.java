import java.util.Scanner;
import java.util.Arrays;

public class HW3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner line;
		int[][] num = new int[1][1];
		int row = 0;
		int col = 0;
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			
			if (row == 0) {
				num = new int[1][];
			}
			else {
				num = Arrays.copyOf(num, num.length + 1);
			}
			
			col = 0;
			
			while (line.hasNext()) {
				if (col == 0) {
					num[row] = new int[1];
				}
				else {
					num[row] = Arrays.copyOf(num[row], num[row].length + 1);
				}
				
				num[row][col] = line.nextInt();
				col++;
			}
			
			row++;
		}
		
		for (int i = 0; i < num.length; i++) {
			System.out.print("    ");
			
			for (int j = 0; j < num[i].length; j++) {
				System.out.printf("%3d ", num[i][j]);
			}
			
			System.out.println();
		}
		
		int temp = 0;
		int tempIndex = num[0].length - 1;
		
		for (int i = 0; i < num.length; i++) {
			for (int j = num[i].length - 1; j >= 0; j--) {
				if (j == tempIndex) {
					temp += num[i][j];
					tempIndex--;
					break;
				}
			}
		}
		
		System.out.printf("%3d ", temp);
		
		temp = 0;
		
		for (int j = 0; j < num.length; j++) {
			temp = 0;
			
			for (int i = 0; i < num.length; i++) {
				temp += num[i][j];
			}
			
			System.out.printf("%3d ", temp);
		}
		
		temp = 0;
		tempIndex = 0;
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				if (j == tempIndex) {
					temp += num[i][j];
					tempIndex++;
					break;
				}
			}
		}
		
		System.out.printf("%3d ", temp);
	}
}

//import java.util.Scanner;
//import java.lang.reflect.Array;
//import java.util.Arrays;
//
//public class HW3 {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		Scanner line;
//		int[][] integers = new int[999][999];
//		int[] integerSum = new int[1001];
//		int tempX = 0;
//		int tempY = 0;
//		
//		while(scanner.hasNextLine()) {
//			line = new Scanner(scanner.nextLine());
//			
//			while (line.hasNext()) {
//				integers[tempX][tempY] = line.nextInt();
//				tempX++;
//			}
//			
//			tempX = 0;
//			tempY++;
//		}
//		
//		int n = 0;
//		int temp = 0;
//		
//		for (int i = 0; i < 999; i++) {
//			if (integers[i][0] == 0) {
//				n = temp;
//				break;
//			}
//			
//			temp++;
//		}
//		
//		for (int i = 0; i < 999; i++) {
//			System.out.printf("       ");
//			
//			for (int j = 0; j < 999; j++) {
//				if (integers[j][i] == 0) {
//					break;
//				}
//				
//				System.out.printf("%6d ", integers[j][i]);
//			}
//			
//			if (integers[0][i] != 0) {
//				System.out.println();
//			}
//		}
//		
//		temp = n - 1;
//		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (j == temp) {
//					integerSum[0] += integers[temp][i];
//					temp--;
//					break;
//				}
//			}
//		}
//		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (integers[i][j] != 0) {
//					integerSum[i + 1] += integers[i][j];
//				}
//			}
//		}
//		
//		temp = 0;
//		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (j == temp) {
//					integerSum[n + 1] += integers[temp][i];
//					temp++;
//					break;
//				}
//			}
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < n + 2; i++) {
//			if (i == 0) {
//				System.out.printf("      ");
//			}
//			
//			System.out.printf("%6d ", integerSum[i]);
//		}
//	}
//}
