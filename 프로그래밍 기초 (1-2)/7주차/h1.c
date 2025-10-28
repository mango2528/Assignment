#include <stdio.h>
#include <string.h>

int main() {
	char str;
	
	int blankNum = 0;
	int lineNum = 0;
	int charNum = 0;
	
	while((str = getchar()) != EOF) {
		
		if (str == '\n')
			lineNum++;
		
		if (str == ' ')
			blankNum++;
			
		if (str != ' ' && str != '\n')
			charNum++;
	}
	
	printf("%d %d %d", blankNum, lineNum, charNum);
	
	return 0;
}
