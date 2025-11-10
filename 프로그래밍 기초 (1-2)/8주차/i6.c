#include <stdio.h>

unsigned long long int f(int n) {
	unsigned long long int prev1 = 0;
	unsigned long long int prev2 = 1;
	unsigned long long int cur = 0;
	
	if (n == 0) {
		return 0;
	}
	
	if (n == 1 || n == 2) {
		return 1;
	}
	
	for (int i = 0; i < n; i++) {
		cur = prev1 + prev2;
		prev2 = prev1;
		prev1 = cur;
	}
	
	return cur;
}

int main(void) {
	int n;
	
	while (1) {
		scanf("%d", &n);
		
		if (n < 0) {
			return 0;
		}

		printf("#%d: %llu\n", n, f(n));
	}
	
	return 0;
}
