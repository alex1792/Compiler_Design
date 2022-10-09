void main()
{
	int a;
	float b;
	int i;

	a = b + 1;
	if (a)
	{
		a = (2 + 4) - 3;
	}
	else
	{
		a = 4 + 5;
	}

	if (a)
		a = a + 1;

	while (a)
	{
		a = a + 1;
	}

	for (i = 1; i < 10; i++)
	{
		a = a + i;
	}

	for (i = 1;;)
		printf("hello world\n");

	printf("abcdefg");
	printf("%d\n", a);

	if (a > 10)
	{
		a = a + 1;
	}
}
