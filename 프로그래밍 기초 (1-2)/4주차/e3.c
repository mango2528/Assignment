#include <stdio.h>

int main() {
	int days;
	long long int total = 0;
	
	scanf("%d", &days);
	
	for (int i = 1; i < days + 1; i++) {
		total += i * 1000;
	}
	
	printf("%lld", total);
	
	return 0;
}
