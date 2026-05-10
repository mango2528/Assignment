import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class HW2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[1]);
		Scanner scanner = new Scanner(file);
		Scanner line;
		
		StudentHW2[] students = new StudentHW2[1];
		
		int index = 0;
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			
			if (index >= students.length) {
				students = Arrays.copyOf(students, students.length * 2);
			}
			
			students[index] = new StudentHW2(line.nextInt(), line.next(), line.nextInt(), line.nextInt(), line.nextInt());
			
			index++;
		}
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students = Arrays.copyOf(students, i - 1);
				break;
			}
		}
		
		StudentHW2.setRank(students);
		
		StudentHW2.Sort(students, args[0]);
		
		StudentHW2.printStudents(students);		
		StudentHW2.printAverages(students);
		
		scanner.close();
	}
}

class StudentHW2 {
	int no;
	String name;
	int kor;
	int eng;
	int mat;
	double average;
	int rank;
	
	public StudentHW2(int no, String name, int kor, int eng, int mat) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		setAverage();
	}
	
	public String toString() {		
		return String.format("%d %s %3d   %3d   %3d   %.2f   %d", no, name, kor, eng, mat, average, rank);
	}
	
	public static void printStudents(StudentHW2[] arr) {
		System.out.println("학번     이름  국어  영어   수학   평균  등수");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			
			System.out.println(arr[i]);
		}
	}
	
	private void setAverage() {
		average = (double)(kor + eng + mat) / 3;
	}
	
	private static double getAverage(StudentHW2[] arr) {
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
	
	public static void setRank(StudentHW2[] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++ ) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].average < arr[j + 1].average) {
					StudentHW2 temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		double tempAvg = arr[0].average;
		int tempRank = 1;
		int tempRankIncrement = 1;
		
		arr[0].rank = tempRank;
		
		for (int i = 1; i < arr.length; i++) {
			if (String.format("%.2f", arr[i].average).equals((String.format("%.2f", tempAvg)))) {
				tempAvg = arr[i].average;
				tempRankIncrement++;
				arr[i].rank = tempRank;
			}
			else if (arr[i].average < tempAvg) {
				tempAvg = arr[i].average;
				tempRank += tempRankIncrement;
				tempRankIncrement = 1;
				arr[i].rank = tempRank;
			}
		}
	}
	
	public static void Sort(StudentHW2[] arr, String mode) {
		int n = arr.length;
		
		switch (mode) {
		case "number" :
			for (int i = 0 ; i < n - 1; i++) {
				for (int j = 0; j < n - i -1 ; j++) {
					if (arr[j].no > arr[j + 1].no) {
						StudentHW2 temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
			
			break;
			
		case "name" :
			for (int i = 0 ; i < n - 1; i++) {
				for (int j = 0; j < n - i -1 ; j++) {
					if (arr[j].name.compareTo(arr[j + 1].name) > 0) {
						StudentHW2 temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
			
			break;
		
		case "ranking" :
			for (int i = 0 ; i < n - 1; i++) {
				for (int j = 0; j < n - i -1 ; j++) {
					if (arr[j].rank > arr[j + 1].rank) {
						StudentHW2 temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		
			break;
		}
	}
	
	public static void printAverages(StudentHW2[] arr) {
		int korSum = 0;
		int engSum = 0;
		int matSum = 0;
		double korAvg = 0;
		double engAvg = 0;
		double matAvg = 0;
		
		for (StudentHW2 s : arr) {
			korSum += s.kor;
		}
		
		korAvg = (double)korSum / arr.length;
		
		for (StudentHW2 s : arr) {
			engSum += s.eng;
		}
		
		engAvg = (double)engSum / arr.length;
		
		for (StudentHW2 s : arr) {
			matSum += s.mat;
		}
		
		matAvg = (double)matSum / arr.length;
		
		System.out.println();
		System.out.printf("과목 평균     %.2f  %.2f %.2f %.2f", korAvg, engAvg, matAvg, getAverage(arr));
	}
}