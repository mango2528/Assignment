import java.util.Arrays;

public class Bubble_Sorting {
	public static String Strings() {
		String tmp = "";
		for(int i=0;i < Rand.r(2, 10);i++) {
			tmp +=(char)(((i%Rand.r(1, 2))==0)? 'a'+Rand.r(0, 25) : 'A'+Rand.r(0, 25));
		}
		return tmp;
	}
	public static String[] Sort(String[] m, boolean asc) {
		String[] n = Arrays.copyOf(m, m.length);
		for(int i=n.length;i > 1 && MaxLast(n, i, asc);i--) ;	
		return n;
	}
	public static boolean MaxLast(String[] n, int size, boolean asc) {
		boolean	sorted = false;
		for(int i=0;i < size-1;i++) {
			if((n[i].compareTo(n[i+1]) > 0 && asc) || (n[i].compareTo(n[i+1]) < 0 && !asc)) {
				swap(n, i, i+1);
				sorted = true;
			}
		}
		return sorted;
	}
	public static void swap(String[] n, int i, int j) {
		String tmp;
		tmp = n[i]; n[i] = n[j]; n[j] = tmp;
	}
	public static float[] Sort(float[] m, boolean asc) {
		float[] n = Arrays.copyOf(m, m.length);
		for(int i=n.length;i > 1 && MaxLast(n, i, asc);i--) ;
		return n;
	}
	public static boolean MaxLast(float[] n, int size, boolean asc) {
		boolean	sorted = false;
		for(int i=0;i < size-1;i++) {
			if((n[i] > n[i+1] && asc) || (n[i] < n[i+1] && !asc)) {
				swap(n, i, i+1);
				sorted = true;
			}
		}
		return sorted;
	}
	public static void swap(float[] n, int i, int j) {
		float tmp;
		tmp = n[i]; n[i] = n[j]; n[j] = tmp;
	}
	public static int[][] Sort(int[][] m, boolean asc) {
		int[][] n = Arrays.copyOf(m, m.length);
		for(int i=n.length;i > 1 && MaxLast(n, i, asc);i--) ;
		return n;
	}
	public static boolean MaxLast(int[][] n, int size, boolean asc) {
		boolean	sorted = false;
		for(int i=0;i < size-1;i++) {
			if((n[i][0] > n[i+1][0] && asc) || (n[i][0] < n[i+1][0] && !asc)) {
				swap(n, i, i+1);
				sorted = true;
			}
		}
		return sorted;
	}
	public static void swap(int[][] n, int i, int j) {
		int[] tmp;
		tmp = n[i]; n[i] = n[j]; n[j] = tmp;
	}
	public static void swap(String[][] n, int i, int j) {
		String[] tmp;
		tmp = n[i]; n[i] = n[j]; n[j] = tmp;
	}
	public static int[] Sort(int[] m, boolean asc) {
		int[] n = Arrays.copyOf(m, m.length);
		for(int i=n.length;i > 1 && MaxLast(n, i, asc);i--) ;
		return n;
	}
	public static boolean MaxLast(int[] n, int size, boolean asc) {
		boolean	sorted = false;
		for(int i=0;i < size-1;i++) {
			if((n[i] > n[i+1] && asc) || (n[i] < n[i+1] && !asc)) {
				swap(n, i, i+1);
				sorted = true;
			}
		}
		return sorted;
	}
	public static void swap(int[] n, int i, int j) {
		int tmp;
		tmp = n[i]; n[i] = n[j]; n[j] = tmp;
	}
	public static void PrintArray(int[] n) {
		for(int d:n)
			System.out.printf("%3d ",d);
		System.out.println("\n-----------------------------------------------");
	}
	public static void PrintArray(int[][] n) {
		//for(int[] d:n)
		for(int i=0;i < n.length;i++)
			PrintArray(n[i]);
	}
	public static void PrintArray(float[] n) {
		for(float d:n)
			System.out.printf("%.3f ",d);
		System.out.println("\n-----------------------------------------------");
	}
	public static void PrintArray(String[] n) {
		for(String d:n)
			System.out.printf("%s ",d);
		System.out.println("\n-----------------------------------------------");
	}
}