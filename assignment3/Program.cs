using System;
using System.Linq;

namespace assignment3
{
    class Program
    {
        static void Main(string[] args)
        {
            String str = "abcdzefazz";
            String sortedStr = String.Concat(str.OrderBy(c => c));
            char c;
            int i = 0, lastOccurance, length = str.Length;
            while(i < length-1)
            {
                c = sortedStr[i];
                lastOccurance = sortedStr.LastIndexOf(c);
                if (c == sortedStr[i+1])
                {
                    Console.Write("Character " + c + " has " + (lastOccurance - sortedStr.IndexOf(c) + 1) + " occurrences. ");
                }
                i = lastOccurance + 1;
            }
            Console.WriteLine();
        }
    }
}
