#include <stdio.h>

int main() {
	double f, c, k;
	
	scanf("%lf", &f);
	
	c = 5.0 / 9.0 * (f - 32.0);
	k = c + 273.16;
	
	printf("Fahrenheit: %.2lf = Celsius: %.2lf = Kelvin: %.2lf", f, c, k);
	
	return 0;
}
