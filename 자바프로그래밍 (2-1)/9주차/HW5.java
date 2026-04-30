public class HW5 {
	public static void main(String[] args) {
		int[] nums = new int[args.length];
		int n = 0;
		
		int temp = nums.length;
		
		while (temp != 1) {
			int temp0 = temp % 2;
			temp /= 2;
			n++;
			
			if (temp0 == 1) {
				System.out.println("프로그램 인자가 2^n개가 아님.");
				System.exit(0);
			}
		}	
		
		for (int i = 0; i < args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		
		int[][] tree = new int[nums.length][n + 1];
		

		
		for (int i = 0; i < nums.length; i++) { // 초기화
			tree[i][0] = nums[i];
		}
		
		temp = 2;
		
		for (int j = 0; j < n; j++) {
			if (j % 2 == 0) {
				for (int i = 0; i < nums.length; i += temp) {
					tree[i][j + 1] = tree[i][j] + tree[i + temp / 2][j];
				}			
			}
			else {
				for (int i = 0; i < nums.length; i += temp) {
					tree[i][j + 1] = tree[i][j] - tree[i + temp / 2][j];
				}		
			}
			
			temp *= 2;
		}
		
//		for (int i = 0; i < nums.length; i += 2) {
//			tree[i][1] = tree[i][0] + tree[i + 1][0];
//		}
//		
//		for (int i = 0; i < nums.length; i += 4) {
//			tree[i][2] = tree[i][1] - tree[i + 2][1];
//		}
//		
//		for (int i = 0; i < nums.length; i += 8) {
//			tree[i][3] = tree[i][2] + tree[i + 4][2];
//		}
		
//		for (int i = 0; i < n + 1; i++) {
//			for (int j = 0; j < nums.length; j++) {
//				System.out.printf("%d ", tree[j][i]);
//			}
			
			System.out.println(tree[0][n]);
	}
}
