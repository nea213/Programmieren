public class Fahrzeug {
    private String _Hersteller;
    private int _Laufzeit;
    private String _Farbe;
    private double _Preis;
    private boolean _IstGebrauchtWaggen;
    private int _FahrzeugId;
    private TreibstoffType _TreibstoffType;

    public Fahrzeug(String _Hersteller, int _Laufzeig, String _Farbe, double _Preis, boolean _IstGebrauchtWaggen, TreibstoffType treibstoffType) {
        this._Hersteller = _Hersteller;
        this._Laufzeit = _Laufzeig;
        this._Farbe = _Farbe;
        this._Preis = _Preis;
        this._IstGebrauchtWaggen = _IstGebrauchtWaggen;
        this._TreibstoffType = treibstoffType;
    }

    public TreibstoffType get_TreibstoffType() {
        return _TreibstoffType;
    }

    public void set_TreibstoffType(TreibstoffType _TreibstoffType) {
        this._TreibstoffType = _TreibstoffType;
    }

    public int get_FahrzeugId() {
        return _FahrzeugId;
    }

    public void set_FahrzeugId(int _FahrzeugId) {
        this._FahrzeugId = _FahrzeugId;
    }

    public String get_Hersteller() {
        return _Hersteller;
    }

    public void set_Hersteller(String _Hersteller) {
        this._Hersteller = _Hersteller;
    }

    public int get_Laufzeit() {
        return _Laufzeit;
    }

    public void set_Laufzeit(int _Laufzeit) {
        this._Laufzeit = _Laufzeit;
    }

    public String get_Farbe() {
        return _Farbe;
    }

    public void set_Farbe(String _Farbe) {
        this._Farbe = _Farbe;
    }

    public double get_Preis() {
        return _Preis;
    }

    public void set_Preis(double _Preis) {
        if (_Preis < 200.00) {
            System.out.println("Der Preis darf nicht weniger kosten als 200€");
            return;
        }
        this._Preis = _Preis;
    }

    public boolean is_IstGebrauchtWaggen() {
        return _IstGebrauchtWaggen;
    }

    public void set_IstGebrauchtWaggen(boolean _IstGebrauchtWaggen) {
        this._IstGebrauchtWaggen = _IstGebrauchtWaggen;
    }
}
