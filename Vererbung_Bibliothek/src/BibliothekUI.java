import java.util.ArrayList;
import java.util.Arrays;

public class BibliothekUI {
    public static void main(String[] args) {
        Medium m1 = new Medium(1, "Test", 2012);
        Buch b1 = new Buch(2, "Test 2", 2012, "12ansdu123123asd21ea", new ArrayList<String>(Arrays.asList("Günter", "Hans")));
        Film f1 = new Film(3, "Test 3", 2012, new ArrayList<String>(Arrays.asList("Günter", "Hans")), 90);

        System.out.println(m1.toString());
        b1.ausleihenDurch("Mir", "Morgen");

        f1.ausleihenDurch("Dir", "Gestern");
        f1.rueckgabe();
        System.out.println(b1.toString());
        System.out.println(f1.toString());
    }
}
