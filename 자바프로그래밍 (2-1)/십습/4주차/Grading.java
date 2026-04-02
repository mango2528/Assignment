import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Grading {

	public static void main(String[] args) throws FileNotFoundException {
		final int SIZE = 2000;
		
		String	fName = "2_100", ext_name=".txt";
		File	in_f = new File(fName+ext_name);
		
		String[] number = new String[SIZE];
		String[] name = new String[SIZE];
		int[] kor = new int[SIZE]; 
		int[] eng = new int[SIZE];
		int[] math = new int[SIZE];
		float[] average = new float[SIZE];
		
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		float averageSum = 0;
		int count = 0;
		
		if(!in_f.exists()) {
			System.out.println(fName+ext_name+" does not exist..");
			System.exit(0);
		}
		
		Scanner	in = new Scanner(in_f), line;
		
		while (in.hasNextLine()) {
			line = new Scanner(in.nextLine());
			
			number[count] = line.next();
			name[count] = line.next();
			kor[count] = line.nextInt();
			eng[count] = line.nextInt();
			math[count] = line.nextInt();
			average[count] = (kor[count] + eng[count] + math[count]) / 3;
			
			korSum += kor[count];
			engSum += eng[count];
			mathSum += math[count];
			averageSum += average[count];
			
			System.out.printf("%s(%s) %5d %5d %5d %7.2f\n", name[count], number[count], kor[count], eng[count], math[count], (kor[count] + eng[count] + math[count]) / 3.0f);
			
			count++;
		}
		
		number = Arrays.copyOf(number, count); // 배열을 유효한 범위까지 자르기
		name = Arrays.copyOf(name, count);
		kor = Arrays.copyOf(kor, count);
		eng = Arrays.copyOf(eng, count);
		math = Arrays.copyOf(math, count);
		average = Arrays.copyOf(average, count);

		System.out.printf("%16s%.2f %.2f %.2f\n"," ", (float)korSum / count, (float)engSum / count, (float)mathSum / count);
	}
	
	private static boolean maxLast(float[] averages, int sizes, String[] names, String[] numbers, int[] kors, int[] engs, int[] maths, boolean asc) {
		for (int i = average.length; i > 1 && maxLast(average, i, name, number, ))
		
		return true;
	}
	
	public static char getPoint(int avg) {
		char	result = 'F';
		
		switch (avg/10) {
		case 10:
		case 9:
			result = 'A';
			break;
		case 8:
			result = 'B';
			break;
		case 7:
			result = 'C';
			break;
		case 6:
			result = 'D';
			break;
		default:
			break;
		}
		
		return result;
	}
}










