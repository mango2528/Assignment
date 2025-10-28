#include <stdio.h>

int main() {
	const double A = 2.05;
	const double B = 1.15;
	const double C = 1.09;
	int n;
	double cost = 0;
	int weight = 0;
	
	scanf ("%d\n", &n);
	
	char type;
	int quantity;
	
	for (int i = 0; i < n - 1; i++) {
				
		scanf("%c %d\n", &type, &quantity);
		
		switch (type) {
			case 'a' :
				cost += A * quantity;
				break;
			case 'b' :
				cost += B * quantity;
				break;
			case 'c' :
				cost += C * quantity;
				break;
		}
		
		weight += quantity;
	}
	
	scanf("%c %d", &type, &quantity);
		
	switch (type) {
		case 'a' :
			cost += A * quantity;
			break;
		case 'b' :
			cost += B * quantity;
			break;
		case 'c' :
			cost += C * quantity;
			break;
		}
		
	weight += quantity;
	
	if (cost >= 100)
		cost *= 0.95;
	
	if (weight < 5)
		cost += 6.5;
	else if (weight < 20)
		cost += 14;
	else
		cost += 14 + weight * 0.5;
		
	printf("%.2lf\n", cost);
	
	return 0;
}
