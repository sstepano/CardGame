using System;

namespace assignment1
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] a = {1, 2, 3, 6, 8, 1, 6};
            int sum = 5;

            for (int i = 0; i < a.Length; i++)
                for (int j = i+1; j < a.Length; j++)
                    if (a[i] + a[j] == sum)
                    {
                        Console.WriteLine("result=[" + a[i] + "," + a[j] + "]");
                        System.Environment.Exit(0);
                    }
            Console.WriteLine("There is no any pair whose sum equals to " + sum);
        }
    }
}
