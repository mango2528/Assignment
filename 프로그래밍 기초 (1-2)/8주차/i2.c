#include <stdio.h>

double get_mean(double x, double y) {
	return 1 / (((1 / x) + (1 / y)) / 2);
}

int main(void) {
	double a, b;
	
	while (scanf("%lf %lf", &a, &b) == 2) {
		printf("%.3lf\n", get_mean(a, b));
	}
	
	return 0;
}
