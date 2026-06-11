import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class CollectionTest{
	public static void main(String[] args) throws FileNotFoundException {
		
		HashMap<String, Student> hashMap = new HashMap<>();
		ArrayList<Student> list = new ArrayList<>();
		
		Collections.sort(list, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o1.score1 - o2.score2;
			}
		});
		
		Collections.sort(list, (o1, o2) -> o1.score2 - o2.score2);
		
		Collections.sort(list, (o1, o2) -> (o1.avg == o2.avg) ? 0 : (o1.avg > o2.avg) ? 1 : -1);
		
		Collections.sort(list, SortingOptions.score1ToScore2);
		
		list.forEach(System.out::println);
	}
}

class Student implements Comparable<Student> {
	String name;
	String number;
	int score1;
	int score2;
	int score3;
	double avg;
	
	public Student(String name, String number, int score1, int score2, int score3) {
		this.name = name;
		this.number = number;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		setAverage();
	}
	
	private void setAverage() {
		avg = (double)(score1 + score2 + score3) / 3;
	}

	@Override
	public int compareTo(Student s) {
		if (name.equals(s.name)) {
			return number.compareTo(s.number);
		}
		
		return name.compareTo(s.name);
	}
}

class SortingOptions {
	static Comparator<Student> nameToNo = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			if (o1.name.equals(o2.name)) {
				return o1.number.compareTo(o2.number);
			}
			
			return o1.name.compareTo(o2.name);
		}
	};
	
	static Comparator<Student> score1ToScore2 = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			if (o1.score1 == o2.score1) {
				return o1.score2 - o2.score2;
			}
			
			return o1.score1 - o2.score1;
		}
	};
}