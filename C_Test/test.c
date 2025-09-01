#include <stdio.h>

int main()
{
    int a = 3;
    int *b;

    b = &a;

    printf("%d\n", a);

    *b = 5;

    printf("%d\n", a);

    return 0;
}