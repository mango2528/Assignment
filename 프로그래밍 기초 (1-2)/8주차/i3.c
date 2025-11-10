#include <stdio.h>

void sort(double *x, double *y, double *z) {
//	double temp;
//	temp = *x;
//	*x = *y;
//	*y = temp;

//	printf("%lf %lf %lf\n", *x, *y, *z);

	if (*x < *y && *x < *z)
		*x = *x;
	else if (*y < *x && *y < *z) {
		double temp = *x;
		*x = *y;
		*y = temp;
	}

	else if (*z < *x && *z < *y) {
		double temp = *x;
		*x = *z;
		*z = temp;
	}

	if (*y < *z)
		*y = *y;
	else {
		double temp = *y;
		*y = *z;
		*z = temp;
	}

	
}

int main(void) {
	double a, b, c;
	
	while (scanf("%lf %lf %lf", &a, &b, &c) == 3) {
		sort(&a, &b, &c);
		printf("%lf %lf %lf\n", a, b, c);
	}
	
	return 0;
}
