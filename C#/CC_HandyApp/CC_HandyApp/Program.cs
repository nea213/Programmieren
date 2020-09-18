using System;
using System.Linq;
using CC_HandyClass;

namespace CC_HandyApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var handyList = new HandyListClass();
            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            var rnd = new Random();
            string[] producers = {"Apple", "Samsung", "Huawei"};
            
            for (var i = 0; i < 10; i++)
            {
                var h = new Handy
                {
                    Id = i + 1,
                    Price = Math.Round((rnd.NextDouble() * (400 - 100) + 400), 2),
                    Model = new string(chars.Select(c => chars[rnd.Next(chars.Length)]).Take(8).ToArray()),
                    Producer = producers[rnd.Next(0,3)],
                    SerialNumber = new string(chars.Select(c => chars[rnd.Next(chars.Length)]).Take(8).ToArray()),
                };
                
                handyList.Add(h);
            }

            // foreach (var h in handyList)
            // {
            //     Console.WriteLine(h.Id);
            //     Console.WriteLine(h.Producer);
            //     Console.WriteLine(h.Model);
            //     Console.WriteLine(h.SerialNumber);
            //     Console.WriteLine(h.Price);
            //     Console.WriteLine("_______________________________");
            // }
            
            Console.WriteLine($"Apple: {handyList.CountProducer("Apple")}");
            Console.WriteLine($"Samsung: {handyList.CountProducer("Samsung")}");
            Console.WriteLine($"Huawei: {handyList.CountProducer("Huawei")}");
            Console.WriteLine(($"Gesammtsumme: {handyList.SumPrice()}"));
        }
    }
}