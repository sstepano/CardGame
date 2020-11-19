using System;
using System.Linq;

namespace assignment4
{
    class Program
    {
        static void Main(string[] args)
        {
            int i;
            double middle;
            int[] arr = {1, 3, 4, -7, 9, 11};
            middle = arr.Average();
            Array.Sort(arr);
            for (i = arr.Length-1; i >= 0 && arr[i] > middle; i--) ;
            if (arr[i + 1] - middle < middle - arr[i])
            {
                Console.WriteLine("The closest element to the middle value({0:0.00}) is " + arr[i+1], middle);
            }
            else 
            {
                Console.WriteLine("The closest element to the middle value({0:0.00}) is " + arr[i], middle);
            }
        }
    }
}
