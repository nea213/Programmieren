public class Personenstammdaten {

    public Personenstammdaten(Integer personalnummer, String vorname, String nachname, String adresse, Integer steuerklasse, String konfession, String iban) {
        this._personalnummer = personalnummer;
        this._vorname = vorname;
        this._nachname = nachname;
        this._adresse = adresse;
        this._steuerklasse = steuerklasse;
        this._konfession = konfession;
        this._IBAN = iban;
    }

    private int _personalnummer;
    private String _vorname;
    private String _nachname;
    private String _adresse;
    private int _steuerklasse;
    private String _konfession;
    private String _IBAN;


    public Integer get_personalnummer() {
        return this._personalnummer;
    }

    public void set_personalnummer(Integer personalnummer) {
        this._personalnummer = personalnummer;
    }

    public String get_vorname() {
        return this._vorname;
    }

    public void set_vorname(String vorname) {
        this._vorname = vorname;
    }

    public String get_nachname() {
        return this._nachname;
    }

    public void set_nachname(String nachname) {
        this._nachname = nachname;
    }

    public String get_adresse() {
        return this._adresse;
    }

    public void set_adresse(String adresse) {
        this._adresse = adresse;
    }

    public Integer get_steuerklasse() {
        return this._steuerklasse;
    }

    public void set_steuerklasse(Integer steuerklasse) {
        this._steuerklasse = steuerklasse;
    }

    public String get_konfession() {
        return this._konfession;
    }

    public void set_konfession(String konfession) {
        this._konfession = konfession;
    }

    public String get_IBAN() {
        return this._IBAN;
    }

    public void set_IBAN(String iban) {
        this._IBAN = iban;
    }
}
