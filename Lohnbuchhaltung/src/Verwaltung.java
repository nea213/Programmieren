import java.util.List;

public class Verwaltung {
    private Firmenstammdaten _firmaData;
    private Personenstammdaten _persoData;


    public void addStammdaten(Firmenstammdaten f, Personenstammdaten p) {
        this._firmaData = f;
        this._persoData = p;
    }

    public void durckeAnmeldung() {
        System.out.println("Firma: " + this._firmaData.get_name() + " - " + this._firmaData.get_addresse() + " - " + this._firmaData.get_IDN());
        System.out.println("Perosnon: " + this._persoData.get_vorname() + " - " + this._persoData.get_nachname() + " - " + this._persoData.get_adresse() + " - " + this._persoData.get_IBAN() + " - " + this._persoData.get_konfession() + " - " + this._persoData.get_personalnummer() + " - " + this._persoData.get_steuerklasse());
    }
}
