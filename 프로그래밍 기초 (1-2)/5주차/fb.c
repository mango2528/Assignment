#include <stdio.h>

int main() {
	int initPrize;
	int prize;
	int interest;
	int withdraw;
	int years = 0;
	
	scanf("%d %d %d", &prize, &interest, &withdraw);
	initPrize = prize;
	
	// printf("%d\n", (int)(prize * (1 + ((double)interest / 100))));
	
	prize = (int)(prize * (1 + ((double)interest / 100)));
	prize -= withdraw;
	years++;
	
	// printf("%d %d\n", prize, initPrize);
	
	if (prize >= initPrize) {
		printf("NO");
		return 0;
	}
	
	while (prize > 0) {
		prize = (int)(prize * (1 + ((double)interest / 100)));
		prize -= withdraw;
		years++;
	}
	
	printf("%d\n", years);
	
	return 0;
}
