import java.util.Random;
import java.util.Scanner;

public class password_gen {
    public static String gen_number() {
        Random r = new Random();
        StringBuilder pw = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int rnd = r.nextInt(10);
            pw.append(rnd);
        }
        return pw.toString();
    }

    public static String gen_Chars(int count) {
        Random r = new Random();

        StringBuilder pw = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int rnd = (r.nextInt(26) + 'a');
            pw.append((char) rnd);
        }

        return pw.toString();
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1) Zahlen Passwort oder 2) Zeichenpasswort");

            var user_input = input.nextInt();
            if (user_input == 1 || user_input == 2){
                if (user_input == 1) {
                    while (true) {
                        System.out.println(gen_number());
                        Thread.sleep(15000);
                    }
                } else {
                    System.out.println("Bitte geben sie eine Zeichenlänge ein");
                    var count = input.nextInt();
                    while (true) {
                        System.out.println(gen_Chars(count));
                        Thread.sleep(30000);
                    }
                }
            }
        }
    }
}
