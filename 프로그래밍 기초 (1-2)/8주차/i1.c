#include <stdio.h>

void chline(char ch, int i, int j) {
	for (int k = 0; k < i - 1; k++) {
		putchar('+');
	}
	
	for (int k = i; k < j + 1; k++) {
		putchar(ch);
	}
	
	for (int k = 0; k < i - 1; k++) {
		putchar('+');
	}
}

int main(void) {
	char c;
	int x, y;
	
	scanf("%c %d %d", &c, &x, &y);
	chline(c, x, y);
//	printf("%c %d %d\n", c, x, y);
	
	return 0;
}
