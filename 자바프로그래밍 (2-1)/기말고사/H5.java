public class H5 {
	public static void main(String[] args) {
		Bag	set1 = new Bag("gecdfzexfy");
		Bag	set2 = new Bag("dcefgd");
		Bag	result;
		
		result = set1.Union(set2);
		result = set1.Minus(set2);
		
		System.out.println(result);
	}
}

class Bag {
	String element = "";
	
	public Bag(String	e) {
		element = e;
	}
	
	public Bag Union(Bag s) {
		return new Bag(element + s.element);
	}
	
	public Bag Minus(Bag s) {
		String temp = element;
		
		for (char c : s.element.toCharArray()) {
			temp = temp.replace(c, ' ');
		}
		
		temp = temp.trim();
		
		return new Bag(temp);
	}
	
	public Bag Intersect(Bag s) {
		return null; 
	}
	
	public int Inclusion(Bag s) {	// 집합 this와 s의 포함관계를 -1, 0, 1로 반환한다.
		return 0;
	}
	
	public String toString() { return element.toString(); }
}

class Set extends Bag {

	public Set(String e) {  // 문자열 e를 집합 형태의 문자열로 element에 초기화
		super(e);
	}
	// Bag의 연산들을 Set에 맞게 Overriding
}
