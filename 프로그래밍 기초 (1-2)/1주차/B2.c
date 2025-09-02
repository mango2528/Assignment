#include <stdio.h>

int main()
{
	int age, days;
	
	scanf("%d", &age);
	printf("The age of ");
	printf("%d", age);
	printf(" years is ");
	printf("%d", age * 365);
	printf(" days.");
	
	return 0;
}
