#include <stdio.h>

int main() {
	int totalMinutes, hours, minutes = 0;
	
	scanf("%d", &totalMinutes);
	
	while (totalMinutes > 0) {
		hours = 0;
		minutes = totalMinutes;
		
		if (minutes > 60) {
			while (minutes > 59) {
				hours += 1;
				minutes -= 60;
			}
		}
		
		printf("Time in minute(s): %d = %d hour(s) and %d minute(s)\n", totalMinutes, hours, minutes);
		scanf("%d", &totalMinutes);
	}
	
	return 0;
}
