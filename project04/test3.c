void main()
{

   int a;
   int b;
   int i;
   int j;

   a = 0;
   b = 100;
   b = a + b;

   for (i = 0; i < 10; i = i + 1)
   {
      a = a + 1;
      for (j = 0; j < 10; j = j + 1)
      {
         a = a + 1;
      }
   }
   printf("%d\n", a);
}
