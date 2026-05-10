import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class HW1 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		Scanner line;
		
		StudentHW1[] students = new StudentHW1[1];
		
		int index = 0;
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			
			if (index >= students.length) {
				students = Arrays.copyOf(students, students.length * 2);
			}
			
			students[index] = new StudentHW1(line.nextInt(), line.next(), line.nextInt(), line.nextInt(), line.nextInt());
			
			index++;
		}
		
		StudentHW1.setEvaluation(students);
		
		try {
			int no = Integer.parseInt(args[1]);
			
			StudentHW1.printSpecific(students, no);
		}
		catch (Exception e) {
			String name = args[1];
			
			StudentHW1.printSpecific(students, name);
		}
		
		scanner.close();
	}
}

class StudentHW1 {
	int no;
	String name;
	int kor;
	int eng;
	int mat;
	double average;
	String eval;
	
	public StudentHW1(int no, String name, int kor, int eng, int mat) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		setAverage();
	}
	
	public String toString() {
		return String.format("%d %s %3d %3d %3d %.2f %s", no, name, kor, eng, mat, average, eval);
	}
	
	public static void printStudents(StudentHW1[] arr) {
		System.out.println("학번     이름   국어 영어 수학 평균   평가");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			System.out.println(arr[i]);
		}
	}
	
	public static void printSpecific(StudentHW1[] arr, String name) {
		boolean flag = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			if (arr[i].name.equals(name)) {
				flag = true;
			}
		}
		
		if (!flag) {
			System.out.printf("이름이 %s인 학생 정보 없음", name);
			System.exit(0);
		}
		
		System.out.println("학번     이름   국어 영어 수학 평균   평가");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			if (arr[i].name.equals(name)) {
				System.out.println(arr[i]);
			}
		}
		
		System.out.printf("\n학생 전체 평균 : %.1f", getAverage(arr));
	}
	
	public static void printSpecific(StudentHW1[] arr, int no) {
		boolean flag = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			if (arr[i].no == no) {
				flag = true;
			}
		}
		
		if (!flag) {
			System.out.printf("학번이 %d인 학생 정보 없음", no);
			System.exit(0);
		}
		
		System.out.println("학번     이름   국어 영어 수학 평균   평가");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			if (arr[i].no == no) {
				System.out.println(arr[i]);
			}
		}
		
		System.out.printf("\n학생 전체 평균 : %.1f", getAverage(arr));
	}
	
	private void setAverage() {
		average = (double)(kor + eng + mat) / 3;
	}
	
	public static void setEvaluation(StudentHW1[] arr) {
		double temp = getAverage(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			if (arr[i].average >= temp) {
				arr[i].eval = "평균이상";
			}
			else {
				arr[i].eval = "평균이하";
			}
		}
	}
	
	private static double getAverage(StudentHW1[] arr) {
		double temp = 0;
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			temp += arr[i].average;
			count++;
		}
		
		return temp / count;
	}
}