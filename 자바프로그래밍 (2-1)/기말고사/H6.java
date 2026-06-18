import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class H6 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("P100.txt"));
		ArrayList<Product> prod = new ArrayList<>();
		
		while(in.hasNextLine()) {
			prod.add(new Product(in.next(), in.next(), in.next(), in.nextFloat(), in.nextInt()));
		}
		
		System.out.println("1번 결과 출력 : ====================================== ");
		
		ArrayList<Product> result1 = new ArrayList<>(prod);
		Collections.sort(result1);
		
		result1.forEach(System.out::println);
		
		System.out.println("2번 결과 출력 : ====================================== ");

		ArrayList<Product> result2 = new ArrayList<>(prod);
		Collections.sort(result2, Product.releasedCmp);
		
		result2.forEach(System.out::println);
		
		System.out.println("3번 결과 출력 : ====================================== ");

		ArrayList<Product> result3 = new ArrayList<>(prod);
		Collections.sort(result3, Product.name_stock_Cmp);
		
		result3.forEach(System.out::println);
		
		System.out.println("4번 결과 출력 : ====================================== ");
		
		ArrayList<Product> result4 = new ArrayList<>(prod);
		Collections.sort(result4, Product.weight_no_Cmp);
		
		result4.forEach(System.out::println);
		
		System.out.println("5번 결과 출력 : ====================================== ");
		// 제품 번호를 키로 Product 객체를 HashMap에 저장한 후 제품 번호의 역순으로 HashMap의 내용을 출력
		
		HashMap<String, Product> result5 = new HashMap<>();
		
		for (Product p : prod) {
			result5.put(p.no, p);
		}
		
		result5.values().stream().sorted(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				if (o1.no.equals(o2.no)) {
					return 0;
				}
				
				return o2.no.compareTo(o1.no);
			}
			
		}).forEach(System.out::println);
	}
}

class Product implements Comparable<Product> {
	String	name; // 제품명
	String	no;  // 제품 번호 (중복되지 않게 설정)
	String	released;	// 제품 출시 날짜 - "2024년9월12일"의 날짜 형태
	float	weight;  // 무게(kg)
	int		inStock;  // 재고 수량
	
	public Product(String n, String no, String r, float w, int st) {
		name = n;
		this.no = no;
		released = r;
		weight = w;
		inStock = st;
	}
	
	public String toString() {
		return String.format("[%s] %s, 출시날짜:%s, 무게 %fKg, 재고 %d개",no, name, released, weight, inStock);
	}

	@Override
	public int compareTo(Product o) {
		if (this.inStock == o.inStock) {
			if (this.weight == o.weight) {
				if (this.name.equals(o.name)) {
					return 0;
				}
				
				return o.name.compareTo(this.name);
			}
			
			return (int)(this.weight - o.weight);
		}
		
		return o.inStock - this.inStock;
	}
	
	public static Comparator<Product> releasedCmp = new Comparator<Product>() {
		@Override
		public int compare(Product o1, Product o2) {
			if (o1.released.equals(o2.released)) {
				return 0;
			}
			
			return o1.released.compareTo(o2.released);
		}
	};
	
	public static Comparator<Product> name_stock_Cmp = new Comparator<Product>() {
		@Override
		public int compare(Product o1, Product o2) {
			if (o1.name.equals(o2.name)) {
				if (o1.inStock == o2.inStock) {
					return 0;
				}
				
				return o2.inStock - o1.inStock;
			}
			
			return o1.name.compareTo(o2.name);
		}
	};
	
	public static Comparator<Product> weight_no_Cmp = new Comparator<Product>() {
		@Override
		public int compare(Product o1, Product o2) {
			if (o1.weight == o2.weight) {
				if (o1.no.equals(o2.no)) {
					return 0;
				}
				
				return o2.no.compareTo(o1.no);
			}
			
			return (int)(o2.weight - o1.weight);
		}
	};
}
