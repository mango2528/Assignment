#include <stdio.h>

int main() {
	char str;
	int parCount = 0;
	
	str = getchar();
	
	if (str == '(')
		parCount++;
	else if (str == ')') {
		printf("NO");
		return 0;
	}
	
	while((str = getchar()) != EOF) {	
		if (str == '(')
			parCount++;
		else if (str == ')')
			if (parCount == 0) {
				printf("NO");
				return 0;
			}
			else
				parCount--;
	}
	
	if (parCount == 0)
		printf("YES");
	else
		printf("NO");
	
	return 0;
}
