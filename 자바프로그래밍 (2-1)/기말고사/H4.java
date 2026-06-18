import java.math.*;

public class H4 {
	public static void main(String[] args) {
		int length = args[0].length();
		
		String temp1 = "";
		
		for (int i = 0; i < Math.ceil((double)length / 2); i++) {
			temp1 += args[0].charAt(i);
		}
		
		String temp2 = "";
		
		for (int i = (int) Math.ceil(length / 2) + 1; i < length; i++) {
			temp2 += args[0].charAt(i);
		}
		
		long x = Long.parseLong(temp1) * Long.parseLong(temp2);
		
		int b = Integer.parseInt(args[1]);
		
		String a = Long.toString(x);
		
		String front = "";
		String back = "";
		
		String halfFront = "";
		String halfBack = "";
		
		for (int i = 0; i < length / 2; i++) {
			halfFront += a.charAt(i);
		}
		
		for (int i = length / 2; i < length - 1; i++) {
			halfBack += a.charAt(i);
		}
		
		for (int i = halfFront.length() - 1; i >= halfFront.length() - Math.ceil((double)b / 2); i--) {
			front += halfFront.charAt(i);
		}
		
		for (int i = 0; i < b / 2; i++) {
			back += halfBack.charAt(i);
		}
		
		System.out.println(front + back);
	}
}
