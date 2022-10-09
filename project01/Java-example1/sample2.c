#include <stdio.h>

int main()
{
	int a = 0;
	while (1)
	{
		a++;
		printf("hello world\n");
		if (a == 5)
		{
			break;
		}
		else
		{
			continue;
		}
	}

	return 0;
}