#import <stdio.h>

int main() {
	double a, b, c, d;
	
	scanf("%lf %lf %lf %lf", &a, &b, &c, &d);
	// printf("%lf, %lf, %lf, %lf", a, b, c, d);
	
	printf("%.2lf", (a * b - c * d) / (a - b * c - d));
	
	return 0;
}
