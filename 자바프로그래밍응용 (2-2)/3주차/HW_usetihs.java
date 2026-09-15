public class HW {
	static final String[] colors = {"RED","BLUE","YELLOW","PURPLE","GREY","WHITE"};
	public static void main(String[] args) {
		Priority_CQueue<Rect> cq_int	= new Priority_CQueue<>(6);
		Item<Rect>	it;
		
		for(int i=0;i < 5;i++)
			System.out.printf("%s added[%s]\n",it=getRandomReact(), cq_int.add(it));  // 5개의 random Rect 객체 추가
		System.out.println(cq_int);
		drawLine(80);
	
		for(int i=0;i < 3;i++) {
			Item<Rect> tmp = cq_int.remove();	// 3개의 random Rect 객체 삭제
			if(tmp == null) System.out.println("remove() failed because Queue is EMPTY");	// Queue가 비었는지 확인
			else System.out.printf("%s removed\n", tmp);
		}
		System.out.println(cq_int);
		drawLine(60);

		for(int i=0;i < 3;i++)
			System.out.printf("%s added[%s]\n",it=getRandomReact(), cq_int.add(it)); // 3개의 random Rect 객체 추가
		System.out.println(cq_int);
		drawLine(60);
		for(int i=0;i < 2;i++)
			System.out.printf("%s added[%s]\n",it=getRandomReact(), cq_int.add(it)); // 2개의 random Rect 객체 추가
		System.out.println(cq_int);
		drawLine(60);
		
		for(int i=0;i < 3;i++) {
			Item<Rect> tmp = cq_int.remove();	// 3개의 random Rect 객체 삭제
			if(tmp == null) System.out.println("remove() failed because Queue is EMPTY");
			else System.out.printf("%s removed\n", tmp);
		}
		System.out.println(cq_int);
		drawLine(60);
		System.out.printf("\u22A0 Highest Priority : %s, Lowest Priority : %s\n", cq_int.getFirst(), cq_int.getLast());
		System.out.println("Priority_CQueue to Array");
		Object[] arr = cq_int.ToArray();	// Queue를 Object 배열로 변환
		for(int i=0;i < arr.length;i++) System.out.printf("\t[%d] %s\n", i, arr[i]); 
	}
	static void drawLine(int size) {
		for(int i=0;i < size;i++) System.out.print('-');
		System.out.println();
	}
	static Item<Rect> getRandomReact() {
		Item<Rect>	tmp = new Item<>(new Rect(Rand.r(1, 50), Rand.r(1, 50), colors[Rand.r(0, colors.length-1)]), Rand.r(1, 20));
		return tmp;
	}
}
