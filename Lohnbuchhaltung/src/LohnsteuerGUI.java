public class LohnsteuerGUI {
    public static void main(String[] args) {
        Personenstammdaten personenstammdaten1 = new Personenstammdaten(1, "Hans", "Peter", "Mussterstraße 43", 1, null, "DE1231451235132");
        Firmenstammdaten firmenstammdaten1 = new Firmenstammdaten("Erste-Straße 1" , 14578456, "Speziall Firma");
        Verwaltung verwaltung = new Verwaltung();
        verwaltung.addStammdaten(firmenstammdaten1, personenstammdaten1);
        verwaltung.durckeAnmeldung();
    }
}
