#import <stdio.h>

int main() {
	double a, b, c;
	
	scanf("%lf %lf %lf", &a, &b, &c);
	printf("%.1lf", (a * b * c) / (a + b + c));
	
	return 0;
}
