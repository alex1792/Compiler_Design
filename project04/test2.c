void main()
{
   float a;
   float b;

   a = 0.4134 + 0.4149;
   b = a + 100.0 + 123.0;
   /*printf("%f\n", b);*/
   if (a == b)
   {
      printf("a is equal to b\n");
   }
   else
   {
      if (a > b)
      {
         printf("a is greater than b\n");
      }
      else if (a < b)
      {
         printf("a is less than b\n");
      }
   }
}
