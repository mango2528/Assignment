public class HW1 {
	public static void main(String[] args) {
		int money = 0;
		int k50 = 0;
		int k10 = 0;
		int k5 = 0;
		int k1 = 0;
		int o500 = 0;
		int o100 = 0;
		int o50 = 0;
		int o10 = 0;
		int o5 = 0;
		int o1 = 0;
		
		money = Integer.parseInt(args[0]);
		
		System.out.printf("%d원은 ", money);
		
		while (money >= 50000) {
			k50++;
			money -= 50000;
		}
		
		while (money >= 10000) {
			k10++;
			money -= 10000;
		}
		
		while (money >= 5000) {
			k5++;
			money -= 5000;
		}
		
		while (money >= 1000) {
			k1++;
			money -= 1000;
		}
		
		while (money >= 500) {
			o500++;
			money -= 500;
		}
		
		while (money >= 100) {
			o100++;
			money -= 100;
		}
		
		while (money >= 50) {
			o50++;
			money -= 50;
		}
		
		while (money >= 10) {
			o10++;
			money -= 10;
		}
		
		while (money >= 5) {
			o5++;
			money -= 5;
		}
		
		while (money >= 1) {
			o1++;
			money -= 1;
		}
		
		if (k50 > 0) {
			System.out.printf("오만원 %d장", k50);
			
			if (k10 > 0 || k5 > 0 || k1 >0 || o500 > 0 || o100 > 0 || o50 > 0 || o10 > 0 || o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (k10 > 0) {
			System.out.printf("만원 %d장", k10);
			
			if (k10 > 0 || k5 > 0 || k1 >0 || o500 > 0 || o100 > 0 || o50 > 0 || o10 > 0 || o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (k5 > 0) {
			System.out.printf("오천원 %d장", k5);
			
			if (k1 >0 || o500 > 0 || o100 > 0 || o50 > 0 || o10 > 0 || o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (k1 > 0) {
			System.out.printf("천원 %d장", k1);
			
			if (o500 > 0 || o100 > 0 || o50 > 0 || o10 > 0 || o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (o500 > 0) {
			System.out.printf("오백원 동전 %d개", o500);
			
			if (o100 > 0 || o50 > 0 || o10 > 0 || o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (o100 > 0) {
			System.out.printf("백원 동전 %d개", o100);
			
			if (o50 > 0 || o10 > 0 || o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (o50 > 0) {
			System.out.printf("오십원 동전 %d개", o50);
			
			if (o10 > 0 || o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (o10 > 0) {
			System.out.printf("십원 동전 %d개", o10);
			
			if (o5 > 0 || o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (o5 > 0) {
			System.out.printf("오원 동전 %d개", o5);
			
			if (o1 > 0) {
				System.out.printf(", ");
			}
		}
		
		if (o1 > 0) {
			System.out.printf("일원 동전 %d개", o1);
		}
		
		System.out.printf("이다.");
	}
}