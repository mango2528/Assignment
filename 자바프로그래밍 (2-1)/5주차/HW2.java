public class HW2 {
	public static void main(String[] args) {
		int[] array = new int[random(1, 100)];
		
		int sum = 0;
		float average = 0;
		int moreThanAverage = 0;
		int smallerThanAverage = 0;
		
		int counter = 0;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random(-100, 100);
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%4d", array[i]);
			
			sum += array[i];
			counter++;
			
			if (counter >= Integer.parseInt(args[0])) {
				System.out.printf("\n");
				counter = 0;
			}
		}
		
		System.out.println("\n");
		
		average = sum / array.length;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= average) {
				moreThanAverage++;
			}
			else {
				smallerThanAverage++;
			}
		}
		
		System.out.printf("평균 : %.3f\n", average);
		System.out.printf("평균 이상 : %d개\n", moreThanAverage);
		System.out.printf("평균 미만 : %d개\n", smallerThanAverage);
	}
	
	public static int random(int min, int max)  {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}