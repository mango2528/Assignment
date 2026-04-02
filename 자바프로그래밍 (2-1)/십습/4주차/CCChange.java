public class CCChange {
	public static void main(String[] args) {
		final int[] WONS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		final String[] NAME = {"오만원", "만원", "오천원", "천원", "오백원", "백원", "오십원", "십원", "오원", "일원"};
		int count[] = new int[WONS.length];
		
		int money = WONS[0] * 3 + WONS[1] * 2 + WONS[2] * 1;
		int temp = money;
		
		for (int i = 0; i < WONS.length; i++) {
			count[i] = temp / WONS[i];
			temp %= WONS[i];
			
			if (temp == 0)
				break;
		}
		
		System.out.printf("%d 원은 ", money);
		
		for (int i = 0; i < WONS.length; i++) {
			if (count[i] == 0)
				continue;
			
			System.out.printf("%s %d장, ", NAME[i], count[i]);
		}
		
		System.out.println("이다.");
		
		// System.out.printf("%d 원은 오만원 %d, 만원 %d장, 오천원 %d장, 천원 %d장, 오백원 동전 %d개, 백원 동전 %d개, 오십원 동전 %d개, 십원 동전 %d개, 오원 동전 %d개, 일원 동전 %d개이다.\n", money, N50K, N10K, N5K, N1K, N500, N100, N50, N10, N5, N1);
	}
}
