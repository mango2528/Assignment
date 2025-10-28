#include <stdio.h>
#include <string.h>

int main() {
	char str;
	
	int upperNum = 0;
	int lowerNum = 0;
	
	while((str = getchar()) != EOF) {
		
		if (isupper(str))
			upperNum++;
		else if (islower(str))
			lowerNum++;
	}
	
	printf("%d %d", upperNum, lowerNum);
	
	return 0;
}
