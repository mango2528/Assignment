import java.util.ArrayList;
import java.util.List;

public class Priority_CQueue<T> {
	private List<Item<T>> v;
	private int	f, r, limit;
	private	boolean	full;
	
	public Priority_CQueue(int s) {
		v = new ArrayList<Item<T>>();
		this.limit = s;
		
		for (int i = 0; i < s; i++) {
			v.add(null);
		}
	}
	
	public int size() {
		return v.size();
	}
	
	public int limit() {
		return limit;
	}
	
	public Item<T>	getFirst() {
		return v.get(f);
	}
	
	public Item<T>	getLast() {
		return v.get(r - 1);
	}
	
	public boolean add(Item<T> item) {
		if (full) {
			return false;
		}
		
		v.set(r, item);
		
		if (r == limit - 1) {
			r = 0;
		}
		else {
			r++;
		}
		
		if (f == r) {
			full = true;
		}
		
		sort();
		
		return true;
	}
	
	public Item<T> remove() {
		Item<T> temp;
		temp = v.get(f);
		
		v.set(f, null);
		
		if (f == limit - 1) {
			f = 0;
		}
		else {
			f++;
		}
		
		full = false;
		
		sort();
		
		return temp;
	}
	
	public Object[] ToArray() {
		if (v.size() == 0) {
			return null;
		}
		
		Object[] temp = new Object[v.size()];
		int index = f;
		
		for (int i = 0; i < v.size(); i++) {
			temp[i] = v.get(index);
			index++;
			
			if (index == limit) {
				index = 0;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			System.out.printf("%s\n", temp[i]);
		}
		
		return temp;
	}
	
	public String toString() {
		String str = "";
		
		for (int i = 0; i < limit; i++) {
			if (i == f) {
				if (i == r) {
					str += "FR "; 
				}
				else {
					str += "F  "; 
				}
			}
			else if (i == r) {
				str += "R  "; 
			}
			else {
				str += "   ";
			}
			
			if (i < v.size()) {
				if (v.get(i) == null) {
					str += String.format("[%d] null\n", i);
				}
				else {
					str += String.format("[%d] [%s : %d]\n", i, v.get(i).getElement(), v.get(i).getPriority());	
				}
			}
			else {
				str += String.format("[%d] null\n", i);
			}
		}
		
		str += String.format("LIMIT : %d, SIZE : %d, FULL : %s", limit, v.size(), full);
		
		return str;
	}
	
	@SuppressWarnings("unchecked")
	public void sort() {
		int n = 0;
		
		for (int i = f; i != r; i++) {
			if (i >= limit) {
				i -= limit;
			}
			
			if (i == r) {
				break;
			}
			
			n++;
		}
		
		Object[] a = new Object[n];
		
		int index = 0;
		
		for (int i = f; i != r; i++) {
			if (i >= limit) {
				i -= limit;
			}
			
			if (i == r) {
				break;
			}
			
			a[index] = v.get(i);
			index++;
		}
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (((Item<T>) a[j]).getPriority() <= ((Item<T>) a[j + 1]).getPriority()) {
					Item<T> temp = (Item<T>) a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		
		index = 0;
		
		for (int i = f; i != r; i++) {
			if (i >= limit) {
				i -= limit;
			}
			
			if (i == r) {
				break;
			}
			
			v.set(i, (Item<T>) a[index]);
			index++;
		}
	}
}

class Item<T> {
	private T element;
	private int	priority;
	
	public Item(T e, int p) {
		element = e;
		priority = p;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public T getElement() {
		return element;
	}
	
	public String toString() {
		return String.format("[%s:%d]", element, priority);
	}
}
/*
 * [0] 0
 * [1] 1 F
 * [2] 1 R
 */
