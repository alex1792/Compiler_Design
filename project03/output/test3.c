void main()
{
	int num, result;
	printf("Please enter a number:");
	scanf("%d", &num);
	num = 11;
	if (num > 10)
	{
		result = 3 * (num - 1);
	}
	else
	{
		result = num * (num - 2);
	}
	printf("The result is %d\n", result);
}