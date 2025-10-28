#include <stdio.h>
#include <string.h>

int main() {
	int i = 0;
	char str[1001];
	
	int blankNum = 0;
	int lineNum = 0;
	int charNum = 0;
	
	while(1) {
		str[i] = getchar();
		
		if (str[i] == '#')
			break;
		
		if (str[i] == '\n')
			lineNum++;
		
		if (str[i] == ' ')
			blankNum++;
			
		if (str[i] != ' ' && str[i] != '\n')
			charNum++;
			
		i++;
	}
	
	str[i - 1] = 0;
	printf("%d %d %d", blankNum, lineNum, charNum);
	
	return 0;
}
