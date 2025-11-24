#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int x[12] = {0};
	char ch;
	
	int sum = 0;
	
	for (int i = 0; i < 12; i++) {
		ch = getchar();
		x[i] = ch - '0';
	}
	
//	for (int i = 0; i < 12; i++) {
//		printf("%d\n", x[i]);
//	}

	sum = 3 * x[0] + x[1] + 3 * x[2] + x[3] + 3 * x[4] + x[5] + 3 * x[6] + x[7] + 3 * x[8] + x[9] + 3 * x[10]; 
	
//	printf("%d\n", sum);

	if ((sum + x[11]) % 10 == 0) {
		printf("YES");
	}
	else {
		printf("NO");
	}
	
	return 0;
}
