namespace CC_HandyClass
{
    public class Handy
    {
        private int _id;
        private string _producer;
        private string _model;
        private string _serialNumber;
        private double _price;

        public int GetId()
        {
            return this._id;
        }

        public void SetId(int id)
        {
            this._id = id;
        }

        public string GetProducer()
        {
            return this._producer;
        }

        public void SetProducer(string producer)
        {
            this._producer = producer;
        }

        public string GetModel()
        {
            return this._model;
        }

        public void SetModel(string model)
        {
            this._model = model;
        }

        public string GetSerialNumber()
        {
            return this._serialNumber;
        }

        public void SetSerialNumber(string serialNumbers)
        {
            this._serialNumber = serialNumbers;
        }

        public double GetPrice()
        {
            return this._price;
        }

        public void SetPrice(double price)
        {
            this._price = price;
        }
    }
}