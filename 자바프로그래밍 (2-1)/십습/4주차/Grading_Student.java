import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Grading_Student{
	final static int NAME = 0;
	final static int NUMBER = 1;
	final static int AVERAGE = 5;
	final static int KOR = 0;
	final static int ENG = 1;
	final static int MATH = 2;
	
	public static void main(String[] args) throws FileNotFoundException {
		final int SIZE = 2000;
		
		String fileName = "2_100", extensionName=".txt";
		File file = new File(fileName + extensionName);
		
		Student[] students = new Student[SIZE];
		float studentsAverageSum = 0;
		float studentsAverage = 0;
		
		if(!file.exists()) {
			System.out.println(fileName + extensionName + " does not exist..");
			System.exit(0);
		}
		
		Scanner scanner = new Scanner(file);
		Scanner line;
		
		int count = 0;
		
		while (scanner.hasNextLine()) {
			line = new Scanner(scanner.nextLine());
			
			students[count] = new Student(line.next(), line.next(), line.nextInt(), line.nextInt(), line.nextInt());
			
			studentsAverageSum += students[count].getAverage();
			count++;
		}
		
		studentsAverage = studentsAverageSum / count;
		
		for (int i = 0; i < count; i++) {
			System.out.printf("%s %s\n", students[i], students[i].getAverage() >= studentsAverage ? "평균이상" : "평균미만");
		}
	}
}
