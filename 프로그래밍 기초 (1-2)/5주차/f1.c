#include <stdio.h>

int main() {
	
    int len1;
    int len2 = 1;
    
    scanf("%d", &len1);
	
	for (int i = 0; i < len1; i++) {
		for (int j = 0; j < len2; j++) {
			printf("$");
		}
		printf("\n");
		len2++;
	}
		
	return 0;
}
