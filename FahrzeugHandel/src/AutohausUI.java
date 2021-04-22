public class AutohausUI {
    public static void moveCars(Filiale fromFiliale, Filiale toFiliale, int fahrzeugId) {
        var tempFahrzeug =fromFiliale.get_Fahrzeug(fahrzeugId);
        if (tempFahrzeug == null) {
            System.out.println("Es wurde kein Fahrzeug mit der Id: " + fahrzeugId + "gefunden");
            return;
        }
        fromFiliale.entferne_Fahrzeug(fahrzeugId);
        toFiliale.set_Fahrzeug(tempFahrzeug);
    }

    public static void main(String[] args) {
        var filale1 = new Filiale("Frankfurt", "Autohaus Herrmann", 1);
        var auto1 = new Fahrzeug("Audi", 10, "Grau", 33333.33, false, TreibstoffType.BENZIN);
        var filale2 = new Filiale("Rüsselsheim", "Autohaus Opel", 2);
        var auto2 = new Fahrzeug("Opel", 10, "Rot", 30000.00, false, TreibstoffType.BENZIN);
        var auto3 = new Fahrzeug("Opel", 10, "Gelb", 30000.00, true, TreibstoffType.BENZIN);
        var auto4 = new Fahrzeug("Opel", 10, "Blau", 30000.00, false, TreibstoffType.DIESEL);
        var auto5 = new Fahrzeug("Opel", 10, "Pink", 30000.00, true, TreibstoffType.ELEKTRO);

        filale1.set_Fahrzeug(auto1);
        filale2.set_Fahrzeug(auto2);
        filale1.set_Fahrzeug(auto3);
        filale1.set_Fahrzeug(auto4);
        filale1.set_Fahrzeug(auto5);

        // normale ausgabe von fahrzeugen
//        filale1.ausgabeAllerFahrzeugDaten();
//        filale2.ausgabeAllerFahrzeugDaten();

        // Fahrzeuge von einer Filiale zu einer andern bewegen
//        moveCars(filale1, filale2, auto1.get_FahrzeugId());
//        filale2.ausgabeAllerFahrzeugDaten();
//        filale1.ausgabeAllerFahrzeugDaten();

        // Nur gebraucht oder Neu Waggen anzeigen
//        filale1.ausgabeGebrauchtOderNeu(true);

        // Ausgabe prozentuale anzahl an Treibstoff typen
//        filale1.prozentualeAnzahl(TreibstoffType.Uran);
    }
}
