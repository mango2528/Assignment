import java.util.Scanner;

public class HW3 {
	public static void main(String[] args) {		
		if (args.length != 3) {
			System.out.printf("%d %c %d = 수식 오류", Integer.parseInt(args[0]), args[1].charAt(0), Integer.parseInt(args[2]));
			System.exit(0);
		}
		
		long aInt = 0;
		long bInt = 0;
		double aFloat = 0;
		double bFloat = 0;
		float resultFloat = 0;
		char op = args[1].charAt(0);
		
		switch (op) {
		case '+' :
			result = a + b;
			break;
		
		case '-' :
			result = a - b;
			break;
			
		case 'x' :
			result = a * b;
			break;
			
		case 'X' :
			result = a * b;
			break;
			
		case '/' :
			resultFloat = (float)a / b;
			break;
			
		case '%' :
			if (b == 0) {
				System.out.printf("%d %c %d = 분모가 0인 오류", Integer.parseInt(args[0]), args[1].charAt(0), Integer.parseInt(args[2]));
				System.exit(0);
			}
			
			result = a % b;
			break;
		default :
			System.out.printf("%d %c %d = 연산자 오류", Integer.parseInt(args[0]), args[1].charAt(0), Integer.parseInt(args[2]));
			System.exit(0);
		}
		
		if (op != '/')
			System.out.printf("%d%c%d = %d", Integer.parseInt(args[0]), args[1].charAt(0), Integer.parseInt(args[2]), result);
		else 
			System.out.printf("%d%c%d = %.3f", Integer.parseInt(args[0]), args[1].charAt(0), Integer.parseInt(args[2]), resultFloat);
	}
}