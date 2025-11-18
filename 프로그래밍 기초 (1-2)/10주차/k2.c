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

int get_mode(int array[], int n) {
	int cur_value = -1;
	int streak = 0;
	
	for (int i = 0; i < n; i++) {
		if (cur_value != array[i]) {
			cur_value = array[i];
			streak = 0;
			streak++;
		}
		else {
			streak++;
		}
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
	
	for (int i = 0; i < n; i++) {
		printf("%d ", array[i]);
	}
	
	return 0;
}
