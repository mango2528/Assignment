public class HW {
	private static Priority_CQueue<Integer> q = new Priority_CQueue<Integer>(6);
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			q.add(new Item<Integer>(Rand.r(1, 99), Rand.r(1, 99)));
		}
		
		System.out.println(q);
		
		q.remove();
		q.remove();
		q.remove();
		
		System.out.println(q);
		
		q.add(new Item<Integer>(Rand.r(0, 99), Rand.r(0, 99)));
		
		System.out.println(q);
		
//		System.out.println(q.ToArray());
	}
}

class Rand {
	public static int r(int min, int max)  {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}