#include <stdio.h>

int main() {
	int q1, q2, q3, q4;
	int total;
	
	scanf("%d %d %d %d", &q1, &q2, &q3, &q4);
	total = q1 + q2 + q3 +q4;
	printf("%.2lf%%\n", (double)q4 / total * 100);
	
	return 0;
}
