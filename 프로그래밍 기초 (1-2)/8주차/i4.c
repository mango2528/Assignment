#include <stdio.h>
#include <ctype.h>

int get_order(char c) {
	if (c >= 'A' && isupper(c)) {
		return c - 64;
	}
	else if (c >= 'A' && islower(c)) {
		return c - 96;
	}
	else if (c != ' ' && c != '\n' && c != '	') {
		return -1;
	}
	
	return 0;
}

int main(void) {
	char str;
	int value = 0;
	
	while ((str = getchar()) != EOF) {
		value = get_order(str);
			
//		printf("%d\n", value);
		
		if (value > 0) {
			printf("%c is a letter #%d.\n", str, value);
		}
		else if (value == 0) {
			
		}
		else if (value == -1){
			printf("%c is not a letter.\n", str);
		}
	}
	
	return 0;
}
