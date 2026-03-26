import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Grading {

	public static void main(String[] args) throws FileNotFoundException {
		String	fName = "3_1000", ext_name=".txt", ext_out=".out";
		String	number, name;
		int 	kor, eng, math, ksum, esum, msum, cnt;
		File	in_f = new File(fName+ext_name);
		File	out_f = new File(fName+ext_out);
		if(!in_f.exists()) {
			System.out.println(fName+ext_name+" does not exist..");
			System.exit(0);
		}
		ksum = esum = msum = cnt = 0;
		PrintWriter	oFile = new PrintWriter(out_f);
		Scanner	in = new Scanner(in_f), line;
		while (in.hasNextLine()) {
			float average;
			
			line = new Scanner(in.nextLine());
			number = line.next(); name = line.next();
			kor = line.nextInt(); eng = line.nextInt(); math = line.nextInt();
			ksum += kor; esum += eng; msum += math;
			cnt++;
			System.out.printf("%s(%s) %5d %5d %5d %7.2f\n", name, number, kor, eng, math, (kor+eng+math)/3.0f), getPoint((int)average);
			// oFile.printf("%s(%s) %5d %5d %5d %7.2f\n", name, number, kor, eng, math, average = (kor+eng+math)/3.0f);
		}
		//System.out.printf("%22s%.2f %.2f %.2f\n"," ", (float)ksum/cnt, (float)esum/cnt, (float)msum/cnt);
		// oFile.printf("%22s%.2f %.2f %.2f\n"," ", (float)ksum/cnt, (float)esum/cnt, (float)msum/cnt);
		oFile.close();
	}
	
	public static char getPoint(int average) {
		char ch = 'F';
		
		switch (average / 10) {
		case 10 :
			break;
		case 9 :
			ch = 'A';
			break;
		case 8 :
			ch = 'B';
			break;
		case 7 :
			ch = 'C';
			break;
		case 6 :
			ch = 'D';
			break;
		default :
			break;
		}
		
		return ch;
	}
}










