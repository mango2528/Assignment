#import <stdio.h>

int main() {
	double input;
		
	scanf("%lf", &input);
	printf("%e\n", (input * 950) / 3.0e-23);
	
	return 0;
}
