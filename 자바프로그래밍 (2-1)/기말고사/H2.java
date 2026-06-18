public class H2 {
	public static void main(String[] args) {
		int maxLength = 0;
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].length() > maxLength) {
				maxLength = args[i].length();
			}
		}
		
		for (int j = 0; j < maxLength; j++) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].length() > j) {
					System.out.print(args[i].charAt(j));
				}
			}
		}
	}
}
