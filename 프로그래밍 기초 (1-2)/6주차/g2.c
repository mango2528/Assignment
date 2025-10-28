#include <stdio.h>

int main() {
	int nums[100000];
	int i = 0;
	
	while(1) {
        scanf("%d", &nums[i]);
        
        if (nums[i] == 0)
        	break;
        	
    	i++;
	}
	
	int evenCount = 0;
	int oddCount = 0;
	int evenSum = 0;
	int oddSum = 0;
	double evenAverage = 0;
	double oddAverage = 0;
	
//	for (int j = 0; j < i; j++) {
//		printf("%d ", nums[j]);
//	}
	
	for (int j = 0; j < i; j++) {
		if (nums[j] % 2 == 0) {
			evenCount++;
			evenSum += nums[j];
		}
		else {
			oddCount++;
			oddSum += nums[j];
		}
	}
	
	if (evenCount != 0)
		evenAverage = (double)evenSum / evenCount;
	else 
		evenAverage = 0;
		
	if (oddCount != 0)
		oddAverage = (double)oddSum / oddCount;
	else
		oddAverage = 0;
	
	printf("%d %.2lf %d %.2lf", evenCount, evenAverage, oddCount, oddAverage);
	
	return 0;
}
