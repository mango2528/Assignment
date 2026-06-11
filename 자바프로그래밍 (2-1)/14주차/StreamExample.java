import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
	public static void main(String[] args) {
		List<Integer> list1 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<String> list2 = Arrays.asList("매끈매끈하다", "울퉁불퉁하다", "평평하다");
		ArrayList<Integer> list3 = new ArrayList<>(list1);
		ArrayList<String> list4 = new ArrayList<>(list2);
		
		list1.stream().filter((n) -> n % 2 == 0).forEach(System.out::println);
		
		list3.removeIf((n) -> n % 2 == 0);
		list4.removeIf((n) -> n.startsWith("매"));
		
		list4.forEach(System.out::println);
		list3.forEach(System.out::println);
	}
}
