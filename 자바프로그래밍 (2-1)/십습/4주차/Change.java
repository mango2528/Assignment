public class Change {
	public static void main(String[] args) {
		final int W50K = 50000;
		final int W10K = 10000;
		final int W5K = 5000;
		final int W1K = 1000;
		final int W500 = 500;
		final int W100 = 100;
		final int W50 = 50;
		final int W10 = 10;
		final int W5 = 5;
		final int W1 = 1;
		
		int N50K;
		int N10K;
		int N5K;
		int N1K;
		int N500;
		int N100;
		int N50;
		int N10;
		int N5;
		int N1;
		
		int money = W50K * 3 + W10K * 2 + W5K * 1;
		int temp = money;
		
		N50K = temp / W50K;
		temp %= W50K;
		N10K = temp / W10K;
		temp %= W10K;
		N5K = temp / W5K;
		temp %= W5K;
		N1K = temp / W1K;
		temp %= W1K;
		N500 = temp / W500;
		temp %= W500;
		N100 = temp / W100;
		temp %= W100;
		N50 = temp / W50;
		temp %= W50;
		N10 = temp / W10;
		temp %= W10;
		N5 = temp / W5;
		temp %= W5;
		N1 = temp / W1;
		N1 %= W1;
		
		System.out.printf("%d 원은 오만원 %d, 만원 %d장, 오천원 %d장, 천원 %d장, 오백원 동전 %d개, 백원 동전 %d개, 오십원 동전 %d개, 십원 동전 %d개, 오원 동전 %d개, 일원 동전 %d개이다.\n", money, N50K, N10K, N5K, N1K, N500, N100, N50, N10, N5, N1);
	}
}
