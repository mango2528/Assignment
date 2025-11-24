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
	int n1, n2;
	int array[n1];
	int t_sum = 0;
	int c_sum = 0;
	double t_mean = 0;
	double c_mean = 0;
	
	scanf("%d %d", &n1, &n2);
	
	for (int i = 0; i < n1; i++) {
		scanf("%d", &array[i]);
	}
	
	qsort(array, n1, sizeof(int), compare);
	
	for (int i = n2; i < n1 - n2; i++) {
		t_sum += array[i];
	}
	
	t_mean = (double)t_sum / (n1 - n2 * 2);
	
	for (int i = 0; i < n2; i++) {
		c_sum += array[n2];
	}
	
	for (int i = 0; i < n2; i++) {
		c_sum += array[n1 - 1 - n2];
	}
	
	c_mean = (double)(t_sum + c_sum) / n1;
	
	printf("%.1lf %.1lf", t_mean, c_mean);
	
	return 0;
}
