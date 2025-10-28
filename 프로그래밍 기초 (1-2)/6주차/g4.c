#include <stdio.h>

int main() {
	int hours;
	double gpay, taxes, npay;
	
	scanf("%d", &hours);
	
	if (hours <= 40) {
		gpay = hours * 10;
	}
	else {
		gpay = 400 + (hours - 40) * 15;
	}
	
	if (gpay <= 300) {
		taxes = gpay * 0.15;
	}
	else if (gpay <= 450) {
		taxes = 45 + (gpay - 300) * 0.2;
	}
	else {
		taxes = 75 + (gpay - 450) * 0.25;
	}
	
	npay = gpay - taxes;
	
	printf("%.2lf %.2lf %.2lf", gpay, taxes, npay);
	
	return 0;
}
