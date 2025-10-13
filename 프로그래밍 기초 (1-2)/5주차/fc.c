#include <stdio.h>

int main() {
	int size;
	long long int sum = 0;
	
	scanf("%d", &size);
	
	int array[size];
	
    for (int i = 0; i < size; i++) {
        scanf("%d", &array[i]);
    }
    
    for (int i = size - 1; i >= 0; i--) {
    	sum += array[i];
    }
    
    printf("%lld", sum);
	
	return 0;
}
