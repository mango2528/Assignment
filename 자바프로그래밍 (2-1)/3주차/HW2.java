import java.util.Scanner;
import java.text.DecimalFormat;

public class HW2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] letters;
		int line = 1;
		
		int maxAverageIntLine = 0;
		float maxAverageIntValue = 0;
		int maxAverageIntCount = 0;
		int maxAverageFloatLine = 0;
		float maxAverageFloatValue = 0;
		int maxAverageFloatCount = 0;
		int maxAverageStringLine = 0;
		float maxAverageStringValue = 0;
		int maxAverageStringCount = 0;
		
		DecimalFormat decimalFormat = new DecimalFormat("#.######"); 
		
		while (scanner.hasNext()) {
			letters = scanner.nextLine().split(" ");
			
			int countInt = 0;
			int countFloat = 0;
			int countString = 0;
			int sumInt = 0;
			float sumFloat = 0;
			int sumString = 0;
			
			for (int i = 0; i < letters.length; i++) {
				try {
					sumInt += Integer.parseInt(letters[i]);
					countInt++;
					continue;
				}
				catch(NumberFormatException e) {
					
				}
				
				try {
					sumFloat += Float.parseFloat(letters[i]);
					countFloat++;
					continue;
				}
				catch(NumberFormatException e) {
					
				}
				
				countString++;
				sumString += letters[i].length();
			}
			
			System.out.printf("%d: ", line);
			
			if (countInt > 0) {
				System.out.printf("정수(%d개) %.1f", countInt, (float)sumInt / countInt);
				
				if ((float)sumInt / countInt > maxAverageIntValue) {
					maxAverageIntLine = line;
					maxAverageIntValue = (float)sumInt / countInt;
					maxAverageIntCount = countInt;
				}
				
				if (countFloat > 0 || countString > 0)
					System.out.printf(", ");
			}
			
			if (countFloat > 0) {
				System.out.printf("실수(%d개) %s", countFloat, decimalFormat.format(sumFloat / countFloat));
				
				if (sumFloat / countFloat > maxAverageFloatValue) {
					maxAverageFloatLine = line;
					maxAverageFloatValue = sumFloat / countFloat;
					maxAverageFloatCount = countFloat;
				}
				
				if (countString > 0)
					System.out.printf(", ");
			}
			
			if (countString > 0) {
				System.out.printf("문자열(%d개) %s", countString, decimalFormat.format((float)sumString / countString));
				
				if ((float)sumString / countString > maxAverageStringValue) {
					maxAverageStringLine = line;
					maxAverageStringValue = (float)sumString / countString;
					maxAverageStringCount = countString;
				}
			}
			
			System.out.printf("\n");
			line++;
		}
		
		if (maxAverageIntLine > 0)
			System.out.printf("정수 평균 최고 : %d번줄 %.1f (%s개)\n", maxAverageIntLine, maxAverageIntValue, maxAverageIntCount);
		
		if (maxAverageFloatLine > 0)
			System.out.printf("실수 평균 최고 : %d번줄 %s (%d개)\n", maxAverageFloatLine, decimalFormat.format(maxAverageFloatValue), maxAverageFloatCount);
		
		if (maxAverageStringLine > 0)
			System.out.printf("문자열 평균 최고 : %d번줄 %s (%d개)\n", maxAverageStringLine, decimalFormat.format(maxAverageStringValue), maxAverageStringCount);
	}
}
