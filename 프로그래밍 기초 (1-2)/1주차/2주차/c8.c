#include <stdio.h>
#include <math.h>

int main() {
	double radius, area, perimeter;
	
	scanf("%lf", &radius);
	area = M_PI * radius * radius;
	perimeter = 2 * M_PI * radius;
	printf("Radius = %.1lf, Area = %.1lf, Perimeter = %.1lf", radius, area, perimeter);
	
	return 0;
}
