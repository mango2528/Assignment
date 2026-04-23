public class HW6 {
	public static void main(String[] args) {
		String op = args[0];
		String a = args[1];
		String b = args[2];
		
		boolean[] aCh = new boolean[26];
		boolean[] bCh = new boolean[26];
		
		for (int i = 0; i < aCh.length; i++) {
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) == 'a' + i) {
					aCh[i] = true;
					break;
				}
			}
		}
		
		for (int i = 0; i < bCh.length; i++) {
			for (int j = 0; j < b.length(); j++) {
				if (b.charAt(j) == 'a' + i) {
					bCh[i] = true;
					break;
				}
			}
		}
		
		for (int i = 0; i < aCh.length; i++) {
			System.out.printf("%c : %b ", 'a' + i , aCh[i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < bCh.length; i++) {
			System.out.printf("%c : %b ", 'a' + i, bCh[i]);
		}
		
		System.out.println();
		
		if (op == "union") {
			String temp = "";
			
			for (int i = 0; i < 26; i++) {
				if (aCh[i] == bCh[i]) {
					temp += 'a' + i;
				}
			}
		}
	}
}
