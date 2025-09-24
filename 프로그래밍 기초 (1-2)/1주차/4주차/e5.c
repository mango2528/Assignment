#include <stdio.h>

int main() {
	int totalSeconds, days, hours, minutes, seconds = 0;
	
	scanf("%d", &totalSeconds);
	
	while (totalSeconds > 0) {
		days = totalSeconds / 24 / 60 / 60;
		hours = totalSeconds / 60 / 60 - days * 24;
		minutes = totalSeconds / 60 - days * 24 * 60- hours * 60;
		seconds = totalSeconds - days * 24 * 60 * 60 - hours * 60 * 60 - minutes * 60;
	
		printf("%d second(s) = %d day(s) %d hour(s) %d minute(s) and %d second(s)\n", totalSeconds, days, hours, minutes, seconds);
		scanf("%d", &totalSeconds);	
	}
	
	return 0;
}
