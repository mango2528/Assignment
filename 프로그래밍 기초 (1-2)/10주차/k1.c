#include <stdio.h>
#include <stdlib.h>

int compare(const void *first, const void *second) {
   if (*(int*)first > *(int*)second)
        return 1;
    else if (*(int*)first < *(int*)second)
        return -1;
    else
        return 0;
}

void get_median(int array[], int n) {
	if (n % 2 == 1) {
		printf("%d", array[n / 2]);
	}
	else {
		int a = array[n / 2];
		int b = array[n / 2 - 1];
		
//		printf("%d %d", a, b);
		
		printf("%.1lf", ((double)a + b) / 2);
	}
}

int main(void) {
	int n;
	
	scanf("%d", &n);
	
	int array[n];
	
	for (int i = 0; i < n; i++) {
		scanf("%d", &array[i]);
	}
	
	qsort(array, n, sizeof(int), compare);
	
//	for (int i = 0; i < n; i++) {
//		printf("%d ", array[i]);
//	}

	get_median(array, n);
	
	return 0;
}
