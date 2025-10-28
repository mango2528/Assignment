#include <stdio.h>

int main() {
	int num;
	int divisor = 0;
	
	scanf("%d", &num);
	
	for (int i = 2; i <= num / 2; i++) {
		if (num % i == 0)
			divisor++;
	}
	
	printf("%d", divisor);
	
	return 0;
}

