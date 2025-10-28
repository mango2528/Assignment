#include <stdio.h>

int main() {
	int num;
	int primeNums = 0;
	
	scanf("%d", &num);
	
	if (num == 1)
		primeNums = 0;
	else if (num >= 2)
		primeNums++;
	
	for (int i = 3; i < num + 1; i += 2) {
		for (int j = 3; j <= i; j += 2) {
			if (i != j && i % j == 0)
				break;
			else if (i == j)
				primeNums++;
		}
	}
	
	printf("%d", primeNums);
	
	return 0;
}

