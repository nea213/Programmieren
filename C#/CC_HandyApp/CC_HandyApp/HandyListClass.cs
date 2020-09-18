using System.Collections.Generic;
using CC_HandyClass;

namespace CC_HandyApp
{
    public class HandyListClass : List<Handy>
    {
        public int CountProducer(string producer)
        {
            var count = 0;

            foreach (var handy in this)
            {
                if (handy.Producer == producer)
                {
                    count++;
                }
            }

            return count;
        }