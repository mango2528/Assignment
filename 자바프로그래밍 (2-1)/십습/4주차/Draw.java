public class Draw {
	public static void main(String[] args) {
		final int n = 10;
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%s%c\n", chars(' ', i), '*');
		}
		
		for (int i = n - 1; i > 0; i--) {
			System.out.printf("%s%c\n", chars(' ', i), '*');
		}
	}
	
	public static String chars(char ch, int size) {
		String temp = "";
		
		for (int i = 0; i < size; i++) {
			temp += ch;
		}
		
		return temp;
	}
}
