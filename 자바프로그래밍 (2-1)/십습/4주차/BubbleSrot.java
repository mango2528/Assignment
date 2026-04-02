public class BubbleSrot {
	public static void main(String[] args) {
		
		int[] numbers = new int[Rand.r(10, 50)];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Rand.r(i, 50);
		}
		
		bubbleSort(numbers);
	}
	
	void bubbleSort(int[] arr) {
	    int temp = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j= 1 ; j < arr.length-i; j++) {
				if(arr[j]<arr[j-1]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(numbers.toString(arr));
	}
}
