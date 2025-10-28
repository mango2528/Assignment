#include <stdio.h>

int main() {
	char ch;
	int check = 0;
	int count = 0;
	
	while(1) {
		ch = getchar();
		
		if (check == 1 && ch == 'i') {
			check = 0;
			count++;
		}
		else
			check = 0;
		
		if (ch == 'e')
			check = 1;
		
		if (ch == '#')
			break;
	}
	
	printf("%d", count);
	
	return 0;
}
