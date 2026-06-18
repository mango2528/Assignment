import java.math.*;

public class H1 {
	public static void main(String[] args) {
		int length = args[0].length();
		
		String a = "";
		
		for (int i = 0; i < Math.ceil((double)length / 2); i++) {
			a += args[0].charAt(i);
		}
		
		String b = "";
		
		for (int i = length - 1; i >= length / 2; i--) {
			b += args[0].charAt(i);
		}
		
		long result = Long.parseLong(a) + Long.parseLong(b);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(result);
	}
}
