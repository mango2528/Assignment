#include <stdio.h>

int main() {
	int type;
	double profits;
	double taxes;
	
	scanf("%d %lf", &type, &profits);
	
	switch (type) {
		case 1 :
			if (profits <= 17850)
				taxes = 0.15 * profits;
			else
				taxes = 0.15 * 17850 + 0.28 * (profits - 17850);
			break;
		case 2 :
			if (profits <= 23900)
				taxes = 0.15 * profits;
			else
				taxes = 0.15 * 23900 + 0.28 * (profits - 23900);
			break;
		case 3 :
			if (profits <= 29750)
				taxes = 0.15 * profits;
			else
				taxes = 0.15 * 29750 + 0.28 * (profits - 29750);
			break;
		case 4 :
			if (profits <= 14875)
				taxes = 0.15 * profits;
			else
				taxes = 0.15 * 14875 + 0.28 * (profits - 14875);
			break;
	}
	
	printf("%.2lf", taxes);
	
	return 0;
}
