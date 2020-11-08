import java.util.Scanner;

/**
 * Ein Programm zu berechnen des Speicherplatzes
 *
 * @author Christian Cezanne
 */


public class calculate_memory_space {
    public static void calculate(int length, int height, int colorType, int compression) {
        var temp = ((length * height) * colorType) / compression;

        System.out.println("Die größe ist: " + temp);
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

        while (true) {
            System.out.println("Bitte geben sie die die Farbiefe in Bytes an: ");
            colorType = input.nextInt();
            if (IsPowerOfTwo(colorType)) {
                break;
            } else {
                System.out.println("Es handelt sich hier bei nicht um eine 2-Potenz");
            }
        }

        System.out.println("Bitte geben sie den Komprimierungsfactor ein: ");
        compression = input.nextInt();

        calculate(length, height, colorType, compression);
    }

    static boolean IsPowerOfTwo(int x)
    {
        return (x != 0) && ((x & (x - 1)) == 0);
    }
}
