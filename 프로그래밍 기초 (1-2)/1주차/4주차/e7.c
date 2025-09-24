#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main() {
	double x1, y1 = 0.0;
	int a, b, c = 0;
	double distance = 0.0;
	
	scanf("%lf %lf", &x1, &y1);
	scanf("%d %d %d", &a, &b, &c);
	
	distance = fabs(a * x1 + b * y1 + c) / sqrt(a * a + b * b);
	printf("%.3lf", distance);
	
	return 0;
}
