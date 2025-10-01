#include <stdio.h>
#include <math.h>

int main() {
	int a, b;
	int total;
	
	scanf("%d %d", &a, &b);
	
	while (a < b) {
		for (int i = 0; i < b - a + 1; i++) {
			total += (a + i) * (a + i);
		}
		
		printf("%d\n", total);
		total = 0;
		scanf("%d %d", &a, &b);
	}
	
	return 0;
}
