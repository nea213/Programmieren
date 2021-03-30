import java.util.List;

public class Verwaltung {
    private Firmenstammdaten[] _firmaData;
    private Personenstammdaten[] _persoData;


    public void addStammdaten(Firmenstammdaten f, Personenstammdaten p) {
        if (_firmaData == null || _persoData == null) {
            _firmaData = new Firmenstammdaten[1];
            _persoData = new Personenstammdaten[1];

            _firmaData[0] = f;
            _persoData[0] = p;
        } else {
            int anzahlFirma = _firmaData.length;
            int anzahlPerson = _persoData.length;

            Firmenstammdaten[] firm_temp = new Firmenstammdaten[anzahlFirma + 1];
            Personenstammdaten[] perso_temp = new Personenstammdaten[anzahlPerson + 1];

            for (int i = 0; i < anzahlFirma; i++) {
                firm_temp[i] = _firmaData[i];
            }
            for (int i = 0; i < anzahlPerson; i++) {
                perso_temp[i] = _persoData[i];
            }

            firm_temp[anzahlFirma] = f;
            perso_temp[anzahlPerson] = p;

            _firmaData = firm_temp;
            _persoData = perso_temp;
        }
    }

    public void durckeAnmeldung() {
        for(int i = 0; i < _firmaData.length; i++){
            System.out.println("----------Firmenstammdaten----------");
            System.out.println("Name: " + _firmaData[i].get_name());
            System.out.println("Adresse: " + _firmaData[i].get_addresse());
            System.out.println("Steuer-ID: " + _firmaData[i].get_IDN());
            System.out.println("----------Personenstammdaten---------");
            System.out.println("Personalnummer: " + _persoData[i].get_personalnummer());
            System.out.println("Name: " + _persoData[i].get_vorname() + " " + _persoData[i].get_nachname());
            System.out.println("Adresse: " + _persoData[i].get_adresse());
            System.out.println("Steuerklasse: " + _persoData[i].get_steuerklasse());
            System.out.println("Konfession: " + _persoData[i].get_konfession());
            System.out.println("IBAN: " + _persoData[i].get_IBAN());
            System.out.println();
        }
    }
}
