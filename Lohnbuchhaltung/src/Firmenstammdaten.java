public class Firmenstammdaten {
    private String _addresse;
    private int _IDN;
    private String _name;


    public Firmenstammdaten(String addresse, Integer IDN, String name) {
        this._addresse = addresse;
        this._IDN = IDN;
        this._name = name;
    }

    public String get_addresse() {
        return this._addresse;
    }

    public void set_addresse(String addresse) {
        this._addresse = addresse;
    }

    public Integer get_IDN() {
        return this._IDN;
    }

    public void set_IDN(Integer IDN) {
        this._IDN = IDN;
    }

    public String get_name() {
        return this._name;
    }

    public void set_name(String name) {
        this._name = name;
    }
}
