public class AnClassTest {
	public static void main(String[] args) {
		Operation PLUS = (a, b) -> a + b;
		Operation MINUS = (a, b) -> a - b;
		Operation MULT = (a, b) -> a * b;
		Operation DIVIDE = (a, b) -> {
			if (b == 0) {
				throw new DivZero();
			}
			
			return a / b;
		};
	}
}

interface Operation {
	Integer DoIT(int x, int y) throws Exception;
}

class Calculation{
	Operation op;
	int x, y;
	String opr;
	
	public Calculation(Operation op, String opr, int x, int y) {
		this.op = op;
		this.opr = opr;
		this.x = x;
		this.y = y;
	}
	
	public void printResult() throws Exception {
		System.out.printf("%d %s %d = %d\n", x, opr, y, op.DoIT(x, y));
	}
}

class DivZero extends Exception {
	public DivZero() {
		super("0으로 나누기 오류");
	}
}
