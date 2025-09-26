#include <stdio.h>

int main() {
	double mbs, mb;
	
	scanf("%lf %lf", &mbs, &mb);
	printf("%.2fsec\n", (double)mb * 8 / mbs);
	
	return 0;
}
