#include <stdio.h>

int main() {
	double principal;
	double interest;
	double withdraw;
	int years = 0;
	
	scanf("%lf %lf %lf", &principal, &interest, &withdraw);
	double initPrincipal = principal;
	
	// printf("%d\n", (int)(principal * (1 + ((double)interest / 100))));
	
	principal = principal * (1 + interest / 100.0) - withdraw;
	years++;
	
	// printf("%d %d\n", principal, initPrincipal);
	
	if (principal >= initPrincipal) {
		printf("NO");
		return 0;
	}
	
	while (principal > 0) {
		principal = principal * (1 + interest / 100.0) - withdraw;
		years++;
	}
	
	printf("%d\n", years);
	
	return 0;
}
