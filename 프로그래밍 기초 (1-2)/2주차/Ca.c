#include <stdio.h>

int main() {
	int a, b, c, d;
	long long int areaA, areaB;
	long long int area, perimeter;
	
	scanf("%d %d %d %d", &a, &b, &c, &d);
	areaA = (long long int)a * b;
	areaB = (long long int)c * d;
	// printf("%lld %lld\n", areaA, areaB);
	area = areaA - areaB;
	printf("Area = %lld, Perimeter = %d", area, a + b + c + d + a - c + b - d);
	
	
	return 0;
}
