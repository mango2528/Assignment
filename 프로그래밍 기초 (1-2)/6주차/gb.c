#include <stdio.h>

int main() {
	int n, k;
	long long int value = 1;
	long long int t1 = 1;
	long long int t2 = 1;
	
	scanf("%d %d", &n, &k);
	
	for (int i = n; i > 1; i--) {
		value *= i;
	}
	
	for (int i = 1; i <= k; i++) {
		t1 *= i;
	}
	
	for (int i = 1; i <= n - k; i++) {
		t2 *= i;
	}
	
//	printf("%d %d\n", n, k);
//	
//	printf("%lld %lld %lld\n", value, t1, t2);

	printf("%lld", value / (t1 * t2));
	
	return 0;
}
