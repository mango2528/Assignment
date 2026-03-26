

public class GuGuDan {
	public static void main(String[] args) {
		First();
		Second();
	}
	
	public static void First() {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d x %d = %d ", i, j, i * j);
			}
			
			System.out.println();
		}
		
		System.out.printf("----------------------------------------------------\n");
	}
	
	public static void Second() {
		for (int j = 1; j <= 9; j++) {
			for (int i = 2; i <= 9; i++) {
				System.out.printf("%d x %d = %d ", i, j, i * j);
			}
			
			System.out.println();
		}
		
		System.out.printf("----------------------------------------------------\n");
	}
	
	public static void Third() {
		int i = 2;
		
		do {
			int j = 1;
			
			do {
				System.out.printf("%d x %d = %d", i, j, i * j);
				j++;
			} while (j <= 9);
			
			System.out.println();
			i++;
		} while (i <= 9);
		
		System.out.printf("----------------------------------------------------\n");
	}
}
