#include <stdio.h>
#include <stdlib.h>

int main() {
	int x1, y1, x2, y2, x3, y3;
	long long int areaA, areaB;
	long long int area, perimeter;
	
	scanf("%d %d %d %d %d %d", &x1, &y1, &x2, &y2, &x3, &y3);
	areaA = (long long int)x2 * y1;
	areaB = (long long int)(x2 - x3) * (y1 - y2);
	area = areaA - areaB;
	perimeter = perimeter + y1 - y2;
	perimeter = perimeter + x3 - x1;
	perimeter = perimeter + y1 - y3;
	perimeter = perimeter + x2 - x3;
	perimeter = perimeter + y3 - y2;
	perimeter = perimeter + x2 - x1;
	
	printf("%d %d\n", areaA, areaB);
	printf("Area = %lld, Perimeter = %d", area, perimeter);
	
	return 0;
}
