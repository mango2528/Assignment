#include <stdio.h>

int main() {
	int n, m;
	int v1, v2;
	long long int total = 0;
	
	scanf("%d %d", &n, &m);
	v1 = n - m;
	v2 = n + m;
	
	for (int i = 0; i < m * 2 + 1; i++) {
		total += (long long int)v1 + i;
	}
	
	printf("%lld", total);
	
	return 0;
}
