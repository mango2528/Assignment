#include <stdio.h>
#include <string.h>

int main() {
	char ln[30], fn[30];
	
	scanf("%s %s", ln, fn);
	printf("*%s %s*\n", ln, fn);
	printf("*%*d %*d*\n", strlen(ln), strlen(ln), strlen(fn), strlen(fn));
	printf("*%s %s*\n", ln, fn);
	printf("*%-*d %-*d*\n", strlen(ln), strlen(ln), strlen(fn), strlen(fn));
	
	return 0;
}
