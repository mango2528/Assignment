import java.util.Arrays;

public class HW1 {
	public static void main(String[] args) {
		int[] integers = new int[0];
		float[] floats = new float[0];
		String[] strings = new String[0];
		
		for (int i = 0; i < args.length; i++) {
			try {
				integers = Arrays.copyOf(integers, integers.length + 1);
				integers[integers.length - 1] = Integer.parseInt(args[i]);
			}
			catch (Exception e0)
			{
				try {
					floats = Arrays.copyOf(floats, floats.length + 1);
					floats[floats.length - 1] = Float.parseFloat(args[i]);
				}
				catch (Exception e1) {
					strings = Arrays.copyOf(strings, strings.length + 1);
					strings[strings.length - 1] = args[i];
				}
			}
		}
		
//		for (int i = 0; i < integers.length; i++) {
//			System.out.printf("%d ", integers[i]);
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < floats.length; i++) {
//			System.out.printf("%f ", floats[i]);
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < strings.length; i++) {
//			System.out.printf("%s ", strings[i]);
//		}
//		
//		System.out.println();
		
		int oddSum = 0;
		int oddCount = 0;
		float oddAverage = 0;
		int evenSum = 0;
		int evenCount = 0;
		float evenAverage = 0;
		float floatSum = 0;
		int floatCount = 0;
		float floatAverage = 0;
		int stringSum = 0;
		float stringAverage = 0;
		float totalSum = 0;
		float totalAverage = 0;
		
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] == 0) {
				continue;
			}
			
			if (integers[i] % 2 != 0) {
				oddSum += integers[i];
				oddCount++;
			}
			else {
				evenSum += integers[i];
				evenCount++;
			}	
		}
		
		oddAverage = (float)oddSum / oddCount;
		evenAverage = (float)evenSum / evenCount;
		
		for (int i = 0; i < floats.length; i++) {
			if (floats[i] == 0) {
				continue;
			}
			
			floatSum += floats[i];
			floatCount++;
		}
		
		floatAverage = floatSum / floatCount;
		
		for (int i = 0; i < strings.length; i++) {
			stringSum += strings[i].length();
		}
		
		stringAverage = (float)stringSum / strings.length;
		
		totalSum = oddSum + evenSum + floatSum + stringSum;
		totalAverage = (totalSum) / (oddCount + evenCount + floatCount + strings.length);
		
		System.out.printf("홀수 : 합계 %d, 평균 %.3f \n", oddSum, oddAverage);
		System.out.printf("짝수 : 합계 %d, 평균 %.3f \n", evenSum, evenAverage);
		System.out.printf("실수 : 합계 %.3f, 평균 %.3f \n", floatSum, floatAverage);
		System.out.printf("문자열 : 합계 %d, 평균 %.3f \n", stringSum, stringAverage);
		System.out.printf("총 합계 : %.3f, 평균 %.3f \n", totalSum, totalAverage);
	}
}
