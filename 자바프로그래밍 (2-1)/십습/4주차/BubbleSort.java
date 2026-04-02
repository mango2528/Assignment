import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] numbers0 = new int[Rand.r(10, 50)];
		
		for (int i = 0; i < numbers0.length; i++) {
			numbers0[i] = Rand.r(i, 50);
		}
		
		int[] numbers1 = Arrays.copyOf(numbers0, numbers0.length);
		
		printArray(numbers0);
		
		sort(numbers0);
		
		printArray(numbers0);
		
		printArray(numbers1);
		
		sort_optimized(numbers1);
		
		printArray(numbers1);
	}
	
	public static String strings() {
		String temp = "";
		
		for (int i = 0; i < Rand.r(2, 10); i++) {
			temp += (char)((i % Rand.r(1, 2) == 0) ? 'a' + Rand.r(0, 25) : 'A' + Rand.r(0, 25));
		}
		
		return temp;
	}
	
	public static <T> T sort(T o) {		
		for (int i = 0; i < n.length; i++) {
			System.out.printf("%d번 째 반복\n", i);
			maxLast(n);
		}
		
		return o;
	}
	
	public static int[] sort(int[] n, int i, int j) {
		int[] m = Arrays.copyOf(n, n.length);
		for (int i = m.length; i > 1 &&)
	}
	
	public static void sort_optimized(int[] n) {
		for (int i = 0; i < n.length; i++) {
			int[] temp = n;
			int[] sorted = n;
			maxLast(sorted);
			
			System.out.printf("%d번 째 반복\n", i);
			
			if (Arrays.equals(temp, sorted))
				break;
		}
	}
	
	public static void maxLast(int[] n) {
		for (int i = 0; i < n.length - 1; i++) {
			if (n[i] > n[i+1]) {
				swap(n, i, i + 1);
			}
		}
	}
	
	public static boolean maxLast()
	
	public static void swap(int[] n, int i, int j) {
		int temp;
		temp = n[i];
		n[i] = n[j];
		n[j] = temp;
	}
	
	public static void printArray(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.printf("%3d ", n[i]);
		}
		
		System.out.println("\n\n--------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	public static void printArray(String[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.printf("%s ", n[i]);
		}
		
		System.out.println("\n\n--------------------------------------------------------------------------------------------------------------------------------\n");
	}
}
