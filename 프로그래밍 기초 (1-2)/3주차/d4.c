#include <stdio.h>
#include <string.h>

int main() {
	char ln[30], fn[30];
	int age;
	
	scanf("%s %s", ln, fn);
	scanf("%d", &age);
	
	printf("%d %d", strlen(ln) + strlen(fn), age);
	
	return 0;
}
