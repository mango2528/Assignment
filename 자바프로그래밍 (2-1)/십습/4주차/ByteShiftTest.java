public class ByteShiftTest {
	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			System.out.println((byte)Integer.toString(1<<i));
		}
	}
}
