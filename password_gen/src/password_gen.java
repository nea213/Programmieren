import java.util.Random;
import java.util.Scanner;

public class password_gen {
    public static void gen_number(int pw_count) {
        Random r = new Random();
        for (int i = 0; i < pw_count; i++) {
            StringBuilder pw = new StringBuilder();

            for (int x = 0; x < 6; x++) {
                int rnd = r.nextInt(10);
                pw.append(rnd);
            }
            System.out.println(pw);
        }
    }

    public static void gen_Chars(int pw_length, int pw_count, boolean small_large) {
        Random r = new Random();
        if (small_large) {
            for (int i = 0; i < pw_count; i++) {
                StringBuilder pw = new StringBuilder();
                for (int x = 0; x < pw_length; x++) {
                    int rnd = (r.nextInt(52));
                    char base = (rnd < 26) ? 'A' : 'a';
                    pw.append((char) (base + rnd % 26));
                }
                System.out.println(pw);
            }
        } else {
            for (int i = 0; i < pw_count; i++) {
                StringBuilder pw = new StringBuilder();

                for (int x = 0; x < pw_length; x++) {
                    int rnd = (r.nextInt(26) + 'a');
                    pw.append((char) rnd);
                }
                System.out.println(pw);
            }
        }


    }


    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1) Zahlen Passwort, 2) Zeichenpasswort[a-z] oder 3) Zeichenpasswort[a-z][A-Z]");
            var user_input = input.nextInt();

            if (user_input == 1 || user_input == 2 || user_input == 3){
                System.out.println("Wie viele Passwörter möchten sie auf einmal generrieren?");
                int pw_count = input.nextInt();
                switch (user_input) {
                    case 1:
                        while (true) {
                            gen_number(pw_count);
                            System.out.println("________________________________________");
                            Thread.sleep(1000);
                        }
                    case 2:
                        System.out.println("Bitte geben sie eine Zeichenlänge ein");
                        int pw_length = input.nextInt();
                        while (true) {
                            gen_Chars(pw_length, pw_count, false);
                            System.out.println("________________________________________");
                            Thread.sleep(1000);
                        }
                    case 3:
                        System.out.println("Bitte geben sie eine Zeichenlänge ein");
                        int pw_length_char = input.nextInt();
                        while (true) {
                            gen_Chars(pw_length_char, pw_count, true);
                            System.out.println("________________________________________");
                            Thread.sleep(1000);
                        }
                    default:
                        return;
                }
            }
        }
    }
}
