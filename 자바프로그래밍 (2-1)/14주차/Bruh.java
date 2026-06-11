import java.util.ArrayList;
import java.util.List;

public class Bruh {
	public static void main(String[] args) {
		Bruh1<Integer> b1 = new Bruh1<Integer>();
		Bruh2<Integer> b2 = new Bruh2<Integer>();
		Bruh3<Integer> b3 = new Bruh3<Integer>(10);
		
		b1.Add(10);
		b1.Add(20);
		
		System.out.println(b1);
		
		b1.Remove();
		
		System.out.println(b1);
		
		b1.Remove();
		
		System.out.println(b1);
		
		b1.Add(10);
		
		b1.Add(20);
		
		Reverse(b1);
		

		
		System.out.println(b1);
		
		Reverse(b1);
		
		System.out.println(b1);
		
		List<Integer> list = new ArrayList<Integer>();
		list = b1.toList();
		
		list.forEach(System.out::println);
		
		System.out.println("\n------------------------------------\n");
		
		for (int i = 1; i <= 10; i++) {
			b2.Add(i);
		}
		
		System.out.println(b2);
		
		System.out.println(b2.Remove() + " removed.\n");
		
		Object[] array = b2.toArray();
		
		for (Object o : array) {
			System.out.println(o);
		}
		
		System.out.println("\n------------------------------------\n");
		
		for (int i = 1; i <= b3.array.length; i++) {
			b3.Add(i * i);
		}
		
		System.out.println(b3);
		
		b3.Remove();
		
		System.out.println(b3);
	}
	
	public static <T> void Reverse(Bruh1<T> bruh) {
		T temp;
		
		if (bruh.a != null && bruh.b != null) {
			temp = bruh.a;
			bruh.a = bruh.b;
			bruh.b = temp;
		}
	}
}

class Bruh1<T> {
	public T a;
	public T b;
	
	public Bruh1() {
		a = null;
		b = null;
	}
	
	public boolean Add(T item) {
		if (a == null) {
			a = item;
		}
		else if (b == null) {
			b = item;
		}
		else {
			return false;
		}
		
		return true;
	}
	
	public T Remove() {
		T temp;
		
		if (b != null) {
			temp = b;
			b = null;
		}
		else if (a != null) {
			temp = a;
			a = null;
		}
		else {
			return null;
		}
		
		return temp;
	}
	
	@Override
	public String toString() {
		String temp = "";
		
		temp = String.format("[%s] [%s]", a != null ? a : "NULL", b != null ? b : "NULL");
		
		return temp;
	}
	
	public List<T> toList() {
		List<T> temp = new ArrayList<T>();
		
		if (a != null) {
			temp.add(a);
		}
		
		if (b != null) {
			temp.add(b);
		}
		
		return temp;
	}
}

class Bruh2<T> {
	List<T> items;
	
	public Bruh2() {
		items = new ArrayList<T>();
	}
	
	public void Add(T item) {
		items.add(0, item);
	}
	
	public T Remove() {
		T temp = null;
		
		if (items.size() != 0) {
			temp = items.get(items.size() - 1);
			items.remove(items.size() - 1);
		}
		
		return temp;
	}
	
	public String toString() {
		String temp = "";
		
		for (T t : items) {
			temp += String.format("%s\n", t);
		}
		
		return temp;
	}
	
	public Object[] toArray() {
		Object[] temp = new Object[items.size()];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = items.get(i);
		}
		
		return temp;
	}
}

class Bruh3<T> {
	Object[] array;
	int curIndex = 0;
	
	public Bruh3(int size) {
		array = new Object[size];
	}
	
	public void Add(T item) {
		if (curIndex >= array.length) {
			return;
		}
		
		array[curIndex] = item;
		curIndex++;
	}
	
	public void Remove() {
		if (curIndex == 0) {
			return;
		}
		
		array[array.length - 1] = null;
		curIndex--;
	}
	
	public String toString() {
		String temp = "";
		
		for (int i = 0; i < curIndex; i++) {
			temp += String.format("%s\n", array[i]);
		}
		
		return temp;
	}
}
