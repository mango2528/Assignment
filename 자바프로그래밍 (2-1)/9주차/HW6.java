public class HW6 {
	public static void main(String[] args) {
		String s1 = "abcdabcdabcde";
		String s2 = s1 + "ABCDABCD";
		
		System.out.println(getSet(s1));
		System.out.println(getSet(s2));
		System.out.println(getSet(s1 + s2));
		System.out.println(getDifference(getSet(s2), getSet(s1)));
	}
	
	private static String getSet(String s) {
		String temp = "";
		
		for (char ch : s.toCharArray()) {
			if (temp.indexOf(ch) < 0) {
				temp += ch;
			}
		}
		
		return temp;
	}
	
	private static String getDifference(String s1, String s2) {
		String temp = "";
		
		for (char ch : s1.toCharArray()) {
			if (s2.indexOf(ch) < 0) {
				temp += ch;
			}
		}
		
		return temp;
	}
}

//public class HW6 {
//	public static void main(String[] args) {
//		String op = args[0];
//		String a = args[1];
//		String b = args[2];
//		
//		boolean[] aCh = new boolean[26];
//		boolean[] bCh = new boolean[26];
//		
//		for (int i = 0; i < aCh.length; i++) {
//			for (int j = 0; j < a.length(); j++) {
//				if (a.charAt(j) == 'a' + i) {
//					aCh[i] = true;
//					break;
//				}
//			}
//		}
//		
//		for (int i = 0; i < bCh.length; i++) {
//			for (int j = 0; j < b.length(); j++) {
//				if (b.charAt(j) == 'a' + i) {
//					bCh[i] = true;
//					break;
//				}
//			}
//		}
//		
//		for (int i = 0; i < aCh.length; i++) {
//			System.out.printf("%c : %b ", 'a' + i , aCh[i]);
//		}
//		
//		System.out.println();
//		
//		for (int i = 0; i < bCh.length; i++) {
//			System.out.printf("%c : %b ", 'a' + i, bCh[i]);
//		}
//		
//		System.out.println();
//		
//		if (op == "union") {
//			String temp = "";
//			
//			for (int i = 0; i < 26; i++) {
//				if (aCh[i] == bCh[i]) {
//					temp += 'a' + i;
//				}
//			}
//		}
//	}
//}
