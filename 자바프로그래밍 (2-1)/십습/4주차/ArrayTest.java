public class ArrayTest {
	public static void main(String[] args) {
		int[] array1, array2 = {1, 2, 3, 4, 5};
		int[] array3 = new int[3], array4 = new int[array2.length], array5 = array2;
		float[] array6 = {1.1f, 1.3f, 3.4f, 5.6f, 10.8f};
		String name = "Ah shit, here we go again";
		int[] count = new int[('z' - 'a' + 1) * 2];
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				count[ch - 'a']++;
			}
			else if (ch >= 'A' && ch <= 'Z') {
				count[ch - 'A' + ('z' - 'a' + 1)]++;
			}
		}
		
		for (int i = 0; i < count.length / 2; i++) {
			System.out.printf("%c : %d\n", 'a' + i, count[i]);
		}
		
		System.out.println("-------------------------");
		
		for (int i = 'A'; i < 'Z'; i++) {
			System.out.printf("%c : %d\n", 'A' + i, count[i]);
		}
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("[%d] %d \n", i, array[i]);
		}
		
		System.out.println("-----------------------");
	}
	
	public static void printArray(float[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("[%d] %f \n", i, array[i]);
		}
		
		System.out.println("-----------------------");
	}
}
