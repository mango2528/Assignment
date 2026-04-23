import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class HW7 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\|");
		
		People[] people = new People[10000];
		
		int temp = 0;
		
		while (scanner.hasNextLine()) {	
			people[temp] = new People(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
					
			scanner.nextLine();
			temp++;
		}
		
		people = Arrays.copyOf(people, temp);
		BubbleSort.bubbleSort(people);
		
		for (int i = 0 ; i < temp; i++) {
			if (people[i].gender == "여") {
				people[i].gender = "여자";
			}
			else if (people[i].gender == "남") {
				people[i].gender = "남자";
			}
			
			System.out.println(people[i].toString());
		}
	}
}

class BubbleSort {
	public static void bubbleSort(People[] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (People.compareGender(arr[j], arr[j + 1])) {
					People temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}

class People {
	public String name;
	public String gender;
	public String code;
	public String date;
	public String phone;
	public String add;
	
	public People(String c, String n, String g, String d, String p, String a) {
		name = n;
		gender = g;
		code = c;
		date = d;
		phone = p;
		add = a;
	}
	
	public String toString() {
		return String.format("%s(%s)[주민등록번호:%s] 생일:%s, 전화번호:%s, 주소:%s", name, gender, code, date, phone, add);
	}
	
	public static boolean compareGender(People a, People b) {		
		if (a.gender == "남" && b.gender == "여") {
			return true;
		}
		else {
			return false;
		}
	}
}
