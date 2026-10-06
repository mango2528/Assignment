public class Calculation {
	public static String compute(String AS, String oper, String BS) {
		float		A, B;
		float	result=0;
		A = Float.parseFloat(AS);
		B = Float.parseFloat(BS);
		
		if (!Calculator_Ex.allowDecimal) {
			A = (int)A;
			B = (int)B;
		}
		
		switch (oper) {
		case Calculator_Ex.PLUS:
			result = A + B;
			break;
		case  Calculator_Ex.MINUS:
			result = A - B;
			break;
		case  Calculator_Ex.DIV:
			result = (float)A / B;
			break;
		case  Calculator_Ex.MULTI:
			result = A * B;
			break;		
		case Calculator_Ex.MOD :
			result = A % B;
			break;
		default:
			break;
		}
		return (""+result);
	}
}
