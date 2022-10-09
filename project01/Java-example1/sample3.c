#include <stdio.h>

int main()
{
    int a = 0;
    int b = 0;

    if (a > b)
    {
        a++;
    }
    else if (a == b)
    {
        b++;
    }
    else
    {
        a *= b;
    }
    int *c = malloc(10);
    int d = sizeof(a);
    scanf("%d", &a);

    return 0;
}
