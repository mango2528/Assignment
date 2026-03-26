public class BitEx {
	public static void main(String[] args) {
		short numShort = (short) 0b10000000_01011010;
		short masking = 		 0b00000000_01111000;
		int numInt = numShort;
		long numLong = numShort;
		
		System.out.printf(getBinary(numShort, Short.SIZE) + "\n");
		System.out.printf(getBinary(numInt >> 17, Integer.SIZE) + "\n");
		System.out.printf(getBinary(numLong >> 17, Long.SIZE) + "\n");
	}
	
	public static String getBinary(long n, int size) {
		String temp = "";
		
		for (int i = size - 1; i >= 0; i--) {	
			temp += (n >> i) & 1;
		}
		
		return temp;
	}
}

// 0000
// 3210
