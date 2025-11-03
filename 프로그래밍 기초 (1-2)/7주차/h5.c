#include <stdio.h>

int main() {
	int a, b, c, d;
	int mult1 = 0;
	int mult2 = 0;
	double div1 = 0;
	double div2 = 0;
	
	scanf("%d %d %d %d", &a, &b, &c, &d);
	
	mult1 = (a * c - b * d);
	mult2 = (b * c + a * d);
	div1 = (double)(a * c + b * d) / (c * c + d * d);
	div2 = (double)(b * c - a * d) / (c * c + d * d);
	
	printf("%d %d\n", mult1, mult2);
	
	if ((c * c + d * d) == 0)
		printf("NONE"); 
	else
		printf("%.2lf %.2lf\n", div1, div2);
	
	return 0;
}
