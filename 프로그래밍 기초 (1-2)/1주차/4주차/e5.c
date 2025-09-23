#include <stdio.h>

int main() {
	int totalSeconds, days, hours, minutes, seconds = 0;
	
	scanf("%d", &totalSeconds);
	
	days = totalSeconds / 24 / 60 / 60;
	hours = totalSeconds / 60 / 60 - days * 24;
	minutes = totalSeconds / 60 - hours * 60;
	seconds = totalSeconds - minutes * 60;
	
	printf("%d %d %d %d", days, hours, minutes, seconds);
	
	return 0;
}
