#import <stdio.h>

int main() {
	double cubicMeters;
	double hobs, does, mals, liters;
	
	scanf("%lf", &cubicMeters);
	printf("%.2lf cubic meters are equivalent to each of the following:\n", cubicMeters);
	printf("%.2lf hob\n", cubicMeters * 5543.54454);
	printf("%.2lf doe\n", cubicMeters * 5543.54454 / 10);
	printf("%.2lf mal\n", cubicMeters * 5543.54454 / 100);
	printf("%.2lf liters\n", cubicMeters * 1000);
	
	return 0;
}
