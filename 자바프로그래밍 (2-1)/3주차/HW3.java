public class HW3 {
	public static void main(String[] args) {				
		if (args.length != 3) {
			switch (args.length) {
			case 1 :
				System.out.printf("%s = 수식 오류", args[0]);
				System.exit(0);
				
			case 2 :
				if (Character.isDigit(args[0].charAt(0)) && Character.isDigit(args[1].charAt(0))) {
					System.out.printf("%s %s = 연산자 없음", args[0], args[1]);
					System.exit(0);
				}
				else if (Character.isDigit(args[0].charAt(0)) && !Character.isDigit(args[1].charAt(0))) {
					System.out.printf("%s %s = 피연산자 부족", args[0], args[1]);
					System.exit(0);
				}
				else if (!Character.isDigit(args[0].charAt(0)) && Character.isDigit(args[1].charAt(0))) {
					System.out.printf("%s %s = 피연산자 부족", args[0], args[1]);
					System.exit(0);
				}
			}
			
			System.out.printf("%d %c %d = 수식 오류", Integer.parseInt(args[0]), args[1].charAt(0), Integer.parseInt(args[2]));
			System.exit(0);
		}
		
		long aInt = 0, bInt = 0;
		double aFloat = 0, bFloat = 0, result = 0;
		char op = args[1].charAt(0);
		
		try {
			aInt = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException e) {
			aFloat = Double.parseDouble(args[0]);
		}
		
		try {
			bInt = Integer.parseInt(args[2]);
		}
		catch (NumberFormatException e) {
			bFloat = Double.parseDouble(args[2]);
		}
		
		switch (op) {
		case '+' :
			if (aInt != 0 && bInt != 0) {
				result = (float)aInt + bInt;
			}
			else if (aInt != 0 && bFloat != 0) {
				result = (float)aInt + bFloat;
			}
			else if (aFloat != 0 && bInt != 0) {
				result = (float)aFloat + bInt;
			}
			else {
				result = aFloat + bFloat;
			}
			
			break;
		
		case '-' :
			if (aInt != 0 && bInt != 0) {
				result = (float)aInt - bInt;
			}
			else if (aInt != 0 && bFloat != 0) {
				result = (float)aInt - bFloat;
			}
			else if (aFloat != 0 && bInt != 0) {
				result = (float)aFloat - bInt;
			}
			else {
				result = aFloat - bFloat;
			}
			
			break;
			
		case 'x' :
			if (aInt != 0 && bInt != 0) {
				result = (float)aInt * bInt;
			}
			else if (aInt != 0 && bFloat != 0) {
				result = (float)aInt * bFloat;
			}
			else if (aFloat != 0 && bInt != 0) {
				result = (float)aFloat * bInt;
			}
			else {
				result = aFloat * bFloat;
			}
			
			break;
			
		case 'X' :
			if (aInt != 0 && bInt != 0) {
				result = (float)aInt * bInt;
			}
			else if (aInt != 0 && bFloat != 0) {
				result = (float)aInt * bFloat;
			}
			else if (aFloat != 0 && bInt != 0) {
				result = (float)aFloat * bInt;
			}
			else {
				result = aFloat * bFloat;
			}
			
			break;
			
		case '/' :
			if (aInt != 0 && bInt != 0) {
				result = (float)aInt / bInt;
			}
			else if (aInt != 0 && bFloat != 0) {
				result = (float)aInt / bFloat;
			}
			else if (aFloat != 0 && bInt != 0) {
				result = (float)aFloat / bInt;
			}
			else {
				result = aFloat / bFloat;
			}
			
			break;
			
		case '%' :
			if (bInt == 0 && bFloat == 0) {
				System.out.printf("%s %c %s = 분모가 0인 오류", args[0], args[1].charAt(0), args[2]);
				System.exit(0);
			}
			else if (aFloat != 0 || bFloat != 0) {
				System.out.printf("%s %c %s = %%는 실수에 적용 불가!", args[0], args[1].charAt(0), args[2]);
				System.exit(0);
			}
			
			result = aInt % bInt;
			break;
		default :
			System.out.printf("%s %c %s = 연산자 오류", args[0], args[1].charAt(0), args[2]);
			System.exit(0);
		}
		
		if (op != '/')
			System.out.printf("%s %c %s = %.3f", args[0], args[1].charAt(0), args[2], result);
		else 
			System.out.printf("%s %c %s = %.3f", args[0], args[1].charAt(0), args[2], result);
	}
}
