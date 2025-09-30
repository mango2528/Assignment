#include <stdio.h>

int main() {
	
	// --A
	// -ABA
	// ABCBA
	
	char c;
	
	scanf("%c", &c);
	
	for (int i = 0; i <= c - 'A'; i++) { // line
		for (int j = 0; j < c - 'A' - i; j++) { // hypen
			printf("-");
		}
		
		for (char j = 'A'; j <= 'A' + i; j++) { // char front
			printf("%c", j);
		}
		
		for (char j = 'A' + i; j > 'A'; j--) { // char back
			printf("%c", j - 1);
		}
		
		printf("\n");
	}
	
	return 0;
}
