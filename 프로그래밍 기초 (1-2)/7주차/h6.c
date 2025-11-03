#include <stdio.h>

int main() {
	char str;
	int count = 0;
	int level1 = 0;
	int level2 = 0;
	
	while((str = getchar()) != EOF) {
		if (level2 == 2) {
			if (str == 't') {
				count++;
				level2 = 0;
			}
			else {
				level2 = 0;
			}
		}
		
		if (level1 == 2) {
			if (str == 't') {
				count++;
				level1 = 0;
			}
			else {
				level1 = 0;
			}
		}
		
		if (level2 == 1) {
			level2 = 2;
		}
		
		if (level1 == 1) {
			if (str == 'c') {
				level2 = 1;	
			}
				
			level1 = 2;
			continue;
		}
			
		if (str == 'c') {
			level1 = 1;
		}
	}
	
	printf("%d", count);
	
	return 0;
}

/*
One man, though, knows what your pet is thinking - or thinks he does. Etsy artist Christopher Rozzi's paintings of cats and dogs each come with a witty caption that deciphers what may cut very well be going trough your pet's mind at any moment.
*/
