#include <stdio.h>

int w = 0;
int x = 0;
int y = 0;
int z = 0;
int f = 0;

int op1 = 0;
int op2 = 0;
int op3 = 0;
int op4 = 0;
int op5 = 0;

void add_binary(void) {
	z += 1;
	
	if (z == 2) {
		z = 0;
		y += 1;
	}
	
	if (y == 2) {
		y = 0;
		x += 1;
	}
	
	if (x == 2) {
		x = 0;
		w += 1;
	}
}

int int_to_operator(int od1, int od2, int n) {
	switch (n) {
		case 1:
			return od1 || od2;
		case 2:
			return od1 && od2;
		case 3:
			return !(od1 || od2);
		case 4:
			return !(od1 && od2);
		case 5:
			return od1 ^ od2;
	}
}

int main(void) {
	
	int a, b, c;
	
	scanf("%d %d %d", &a, &b, &c);
	
	printf("w x y z F\n");
	
	for (int i = 0; i < 16; i++) {

		op1 = int_to_operator(0, w, a);
		op2 = int_to_operator(x, y, 4);
		op3 = int_to_operator(y, z, b);
		op4 = int_to_operator(op1, op2, 3);
		op5 = int_to_operator(op2, op3, c);
		f = int_to_operator(op4, op5, 5);
		
		printf("%d %d %d %d %d\n", w, x, y, z, f);
		
		add_binary();
	}

	
	return 0;
}
