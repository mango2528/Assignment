public class HW1 {
	public static void main(String[] args) {
		int length = Integer.parseInt(args[0]);
		
		if (length == 1) {
			System.out.println("o");
			System.exit(0);
		}
		
		if (length == 2) {
			System.out.println("o-");
			System.out.println("-o");
			System.exit(0);
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					System.out.printf("o");
				}
				else if (j == length - i - 1) {
					System.out.printf("o");
				}
				else {
					System.out.printf("-");
				}
			}
			
			System.out.printf("\n");
		}
	}
}