#include <stdio.h>
#include <math.h>

int main() {
	int side;
	double volume, area, height;
	
	scanf("%d", &side);
	volume = sqrt(2) * pow(side, 3) / 12;
	area = sqrt(3) * pow(side, 2);
	height = sqrt(6) * side / 3;
	
	printf("%.2lf %.2lf %.2lf", volume, area, height);
	
	return 0;
}
