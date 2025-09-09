#import <stdio.h>

int main() {
	double cups; // 1 cup = 0.5 pint, 1 cup = 8 ounces, 1 cup = 16 tablespoons, 1 cup = 48 teaspoons
	double pints, ounces, tablespoons, teaspoons;
	
	scanf("%lf", &cups);
	printf("%.6lf cups are equivalent to each of the following:\n", cups);
	printf("%.6lf pints\n", cups / 2);
	printf("%.6lf tablespoons\n", cups * 16);
	printf("%.6lf teaspoons\n", cups * 48);
	
	return 0;
}
