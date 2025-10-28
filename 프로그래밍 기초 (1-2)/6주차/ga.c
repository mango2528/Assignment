#include <stdio.h>
#include <math.h>

int main() {
	double a, b, c;
	double x1, x2;
	double d = 0;
	
	while (scanf("%lf %lf %lf", &a, &b, &c) == 3) {		
		d = b * b - 4 * a * c;
		
		// printf("%lf\n", d);
	
		if (d > 0) {
			x1 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
			x2 = (-b - sqrt(b * b - 4 * a * c)) / (2 * a);
			printf("%.3lf %.3lf\n", x1, x2);
		}
		else if (d == 0) {
			x1 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
			printf("%.3lf\n", x1);
		}
		else if (d < 0) {
			printf("Imaginary root\n");
		}	
	}
	
	return 0;
}
