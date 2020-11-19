using System;

namespace assignment2
{
    class Program
    {
        public static void Reverse(int[] array)
        {
            int t, length = array.Length;
            for(int i=0; i < length/2; i++)
            {
                t = array[i];
                array[i] = array[length - i - 1];
                array[length - i - 1] = t;
            }
        }
        static void Main(string[] args)
        {
            int[] arr = {2, 7, -5, 4};
            int length = arr.Length;
            Reverse(arr);
            Console.Write("result=[");
            for (int i = 0; i < length-1; i++)
            {
                Console.Write(arr[i] + ",");
            }
            Console.WriteLine(arr[length-1] + "]");
        }
    }
}
