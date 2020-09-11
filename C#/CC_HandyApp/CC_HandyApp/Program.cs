using System;
using CC_HandyClass;

namespace CC_HandyApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var handy = new Handy();
            handy.Id = 1;
            handy.Producer = "Apple";
            handy.Model = "XS";
            handy.SerialNumber = "XSAP";
            handy.Price = 120.00;

            Console.WriteLine(handy.Id);
            Console.WriteLine(handy.Producer);
            Console.WriteLine(handy.Model);
            Console.WriteLine(handy.SerialNumber);
            Console.WriteLine(handy.Price);
        }
    }
}