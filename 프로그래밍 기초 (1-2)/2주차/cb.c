#include <stdio.h>

int main() {
	const double G = 6.67430e-11;
	double m1, m2, r;
	
	scanf("%lf %lf %lf", &m1, &m2, &r);
	// printf("%e %e %lf\n", m1, m2, r);
	r = r * 1000;
	printf("%e", (G * m1 * m2) / (r * r));
	
	return 0;
}
