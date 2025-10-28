#include <stdio.h>

int main() {
	int a, r1, w, h;
	double r2 = 0;
	double bac = 0;
	
	scanf("%d %d %d %d", &r1, &a, &w, &h);
	
	if (r1 == 0)
		r2 = 0.73;
	else if (r1 == 1)
		r2 = 0.6;
		
	// printf("%lf %d %d %d\n", r2, a, w, h);
	
	bac = (a * 5.14) / (r2 * w) - (0.015 * h);
	
	if (bac > 0)
		printf("%.5lf", bac);
	else
		printf("0.00000");
	
	
	return 0;
}
