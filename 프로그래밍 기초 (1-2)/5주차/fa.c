#include <stdio.h>

int main() {
	double currency;
	double interest;
	int years;
	
	scanf("%lf %lf %d", &currency, &interest, &years);
	
	for (int i = 0; i < years; i++) {
		currency += currency * interest;
	}
	
	printf("%.5lf", currency);
	
	return 0;
}
