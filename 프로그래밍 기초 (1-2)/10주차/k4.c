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

int main(void) {
	int n, k1, k2, k3;
	
	scanf("%d %d %d %d", &n, &k1, &k2, &k3);
	
	int array[n];
	
	for (int i = 0; i < n; i++) {
		scanf("%d", &array[i]);
	}
	
	qsort(array, n, sizeof(int), compare);
	
	printf("%d", array[k1 - 1] + array[k2 - 1] + array[k3 - 1]);
	
	return 0;
}
