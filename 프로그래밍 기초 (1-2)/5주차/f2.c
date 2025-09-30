#include <stdio.h>

int main() {
	
    int len1;
    int len2 = 1;
    
    scanf("%d", &len1);
	
//	for (int i = 0; i < len1; i++) {
//		for (char c = 65 + len1 - 1; c >= 65 + len2 - 1; c--) {
//			printf("%c", c);
//		}
//		printf("\n");
//		len2++;
//	}

	for (int i = 0; i < len1; i++) {
		for (char c = 'A' + len1 - 1; c >= 'A' + len1 - len2; c--) {
			printf("%c", c);
		}
		printf("\n");
		len2++;
	}
		
	return 0;
}
