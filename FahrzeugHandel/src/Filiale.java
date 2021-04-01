import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Filiale {
    private String _Standort;
    private String _Name;
    private int _FahrzeugAnzahl;
    private final ArrayList<Fahrzeug> _Fahrzeuge;
    private int _FilialId;

    public Filiale(String _Standort, String _Name, int Id) {
        this._Standort = _Standort;
        this._Name = _Name;
        this._Fahrzeuge = new ArrayList<>();
        this._FahrzeugAnzahl = 0;
        this._FilialId = Id;
    }

    public int get_FilialId() {
        return _FilialId;
    }

    public void set_FilialId(int _FilialId) {
        this._FilialId = _FilialId;
    }

    public String get_Standort() {
        return _Standort;
    }

    public void set_Standort(String _Standort) {
        this._Standort = _Standort;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public void set_Fahrzeug(Fahrzeug fahrzeug) {
        if (this._FahrzeugAnzahl == 0) {
            fahrzeug.set_FahrzeugId(1);
        } else {
            var maxId = Objects.requireNonNull(this._Fahrzeuge.stream().max(Comparator.comparing(Fahrzeug::get_FahrzeugId)).orElse(null)).get_FahrzeugId();
            fahrzeug.set_FahrzeugId(maxId + 1);
        }
        this._FahrzeugAnzahl += 1;
        this._Fahrzeuge.add(fahrzeug);
    }

    public Fahrzeug get_Fahrzeug(int id) {
        return this._Fahrzeuge.stream().filter(fahrzeug -> fahrzeug.get_FahrzeugId() == id).findFirst().orElse(null);
    }

    public void entferne_Fahrzeug(int id) {
        this._Fahrzeuge.removeIf(fahrzeug -> fahrzeug.get_FahrzeugId() == id);
        this._FahrzeugAnzahl -= 1;
    }

    public void ausgabeGebrauchtOderNeu(boolean istGebraucht) {
        if (istGebraucht) {
            var temp = this._Fahrzeuge.stream().filter(Fahrzeug::is_IstGebrauchtWaggen).collect(Collectors.toList());
            for (var f : temp) {
                var isGebraucht = f.is_IstGebrauchtWaggen() ? "Gebrauchtwaggen" : "Neuwaggen";
                System.out.println("_____________Filiale: " + this._Name + "_______________________");
                System.out.println("Fahrzeug Id: " + f.get_FahrzeugId());
                System.out.println("Herstelller: " + f.get_Hersteller());
                System.out.println("Farbe: " + f.get_Farbe());
                System.out.println("Laufzeit in km: " + f.get_Laufzeit());
                System.out.println("Preis: " + f.get_Preis());
                System.out.println("Gebrauchtwaggen/Neuwaggen: " + isGebraucht);
                System.out.println("_____________Filiale: " + this._Name + "_______________________");
                System.out.println("\n");
            }
        } else {
            var temp = this._Fahrzeuge.stream().filter(Fahrzeug -> !Fahrzeug.is_IstGebrauchtWaggen()).collect(Collectors.toList());
            for (var f : temp) {
                var isGebraucht = f.is_IstGebrauchtWaggen() ? "Gebrauchtwaggen" : "Neuwaggen";
                System.out.println("_____________Filiale: " + this._Name + "_______________________");
                System.out.println("Fahrzeug Id: " + f.get_FahrzeugId());
                System.out.println("Herstelller: " + f.get_Hersteller());
                System.out.println("Farbe: " + f.get_Farbe());
                System.out.println("Laufzeit in km: " + f.get_Laufzeit());
                System.out.println("Preis: " + f.get_Preis());
                System.out.println("Gebrauchtwaggen/Neuwaggen: " + isGebraucht);
                System.out.println("_____________Filiale: " + this._Name + "_______________________");
                System.out.println("\n");
            }
        }

    }

    public void ausgabeAllerFahrzeugDaten() {
        for (var f : this._Fahrzeuge) {
            var isGebraucht = f.is_IstGebrauchtWaggen() ? "Gebrauchtwaggen" : "Neuwaggen";
            System.out.println("_____________Filiale: " + this._Name + "_______________________");
            System.out.println("Fahrzeug Id: " + f.get_FahrzeugId());
            System.out.println("Herstelller: " + f.get_Hersteller());
            System.out.println("Farbe: " + f.get_Farbe());
            System.out.println("Laufzeit in km: " + f.get_Laufzeit());
            System.out.println("Preis: " + f.get_Preis());
            System.out.println("Gebrauchtwaggen/Neuwaggen: " + isGebraucht);
            System.out.println("_____________Filiale: " + this._Name + "_______________________");
            System.out.println("\n");
        }
    }
}
