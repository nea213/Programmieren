import java.util.Scanner;

/**
 * Ein Programm zu berechnen des Speicherplatzes
 *
 * @author Christian Cezanne
 */


public class calculate_memory_space {
    public static void calculate(int length, int height, int colorType, int compression) {
        double bit = ((length * height) * colorType);
        double Byte = bit / 8;
        double kib = Byte / 1024;
        double mib = kib / 1024;
        double compression_byte = mib / (double) compression;
        double rounded_value = Math.round(compression_byte * 100.0) / 100.0;

        System.out.println("Der Speicherplatz beträgt: " + rounded_value + " MiB");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = 0;
        int height = 0;
        int colorType = 0;
        int compression = 0;

        System.out.println("Bitte geben sie die Breite und die Höhe an (Bitte mit ',' trennen): ");
        var length_height = input.next().split(",");
        length = Integer.parseInt(length_height[0]);
        height = Integer.parseInt(length_height[1]);

        System.out.println("Bitte geben sie die die Farbiefe in Bytes an: ");
        colorType = input.nextInt();

        System.out.println("Bitte geben sie den Komprimierungsfactor ein: ");
        compression = input.nextInt();

        calculate(length, height, colorType, compression);
    }
}
