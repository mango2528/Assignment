#include <stdio.h>

int main() {
    int n;
    
    scanf("%d", &n);
    
    int numbers[10000+1] = {0};
    int num;
    
    for (int i = 0; i < n; i++) {
        scanf("%d", &num);
        numbers[num]++;
    }
    
    int uniques = 0;
    
    for (int i = 1; i <= 10000; i++) {
        if (numbers[i] > 0) {
        	uniques++;
        }
    }
    
    printf("%d\n", uniques);
    
    return 0;
}

