public class LohnsteuerGUI {
    public static void main(String[] args) {
        Personenstammdaten personenstammdaten1 = new Personenstammdaten(1, "Hans", "Peter", "Mussterstraße 43", 1, null, "DE1231451235132");
        Firmenstammdaten firmenstammdaten1 = new Firmenstammdaten("Erste-Straße 1" , 14578456, "Speziall Firma");
        Firmenstammdaten f1 = new Firmenstammdaten("Oskar-Meixner-Straße 1 68163 Mannheim", 1234567890, "Bilfinger SE");
        Personenstammdaten p1 = new Personenstammdaten(5184, "Martin", "Carrol", "BlaBla 1 2134 Dummy", 1, "RK", "DE1234567890");
        Verwaltung verwaltung = new Verwaltung();

        verwaltung.addStammdaten(firmenstammdaten1, personenstammdaten1);
        verwaltung.durckeAnmeldung();

        verwaltung.addStammdaten(f1, p1);
        verwaltung.durckeAnmeldung();
    }
}
