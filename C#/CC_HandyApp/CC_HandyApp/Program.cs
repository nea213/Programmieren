using System;
using CC_HandyClass;

namespace CC_HandyApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var handy = new Handy();
            handy.SetId(1);
            handy.SetProducer("Apple");
            handy.SetModel("XS");
            handy.SetSerialNumber("XSAP");
            handy.SetPrice(120.00);

            Console.WriteLine(handy.GetId());
            Console.WriteLine(handy.GetProducer());
            Console.WriteLine(handy.GetModel());
            Console.WriteLine(handy.GetSerialNumber());
            Console.WriteLine(handy.GetPrice());
        }
    }
}