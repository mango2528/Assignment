#include <stdio.h>
#include <math.h>

int main() {
	double a, b;
	
	scanf("%lf %lf", &a, &b);
	// printf("%lf %lf\n", a, b);
	
	while (fabs(b) > 1e-12) {
		printf("%.3lf\n", (a - b) / (a * b));
		a, b = 0;
		scanf("%lf %lf", &a, &b);
	}
	
	return 0;
}
