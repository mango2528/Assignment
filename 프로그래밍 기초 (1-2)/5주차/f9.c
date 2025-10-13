#include <stdio.h>

int main() {
	int term;
	double eq1, eq2;
	
	scanf("%d", &term);
	
	for (int i = 0; i < term; i++) {
		eq1 += (double)1 / (i + 1);
	}
	
	for (int i = 0; i < term; i++) {
		
		if (i % 2 == 0)
			eq2 += (double)1 / (i + 1);
		else
			eq2 -= (double)1 / (i + 1);
	}
	
	printf("%.5llf %.5llf", eq1, eq2);
	
	return 0;
}
