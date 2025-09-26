#include <stdio.h>

int main() {
	const double GALLON = 3.785;
	const double MILE = 1.609;
	double distance, gasoline;
	
	scanf("%lf %lf", &distance, &gasoline);
	// printf("%.1lf %.1lf\n", distance * MILE, (gasoline * GALLON) / (distance * MILE / 100));
	printf("%.1lf mpg or %.1lf liters / 100Km.", distance / gasoline, (gasoline * GALLON) / (distance * MILE / 100));
	
	return 0;
}
