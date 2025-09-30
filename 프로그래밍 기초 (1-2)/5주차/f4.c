#include <stdio.h>

int main() {
	int start, end;
	
	scanf("%d %d", &start, &end);
	
	for (int i = start; i <= end; i++) {
		printf("%d %d %d\n", i, i * i, i * i * i);
	}
	
	return 0;
}
