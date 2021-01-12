package ECBEncryption;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Quellcodevorlage fuer das Projekt
 *
 * ECB Verschluesselung
 *
 * KLASSE: 11IT 2B
 *
 * @author Kesmiris Stefanos, Cezanne Christian
 */
public class ECBEncryption {

    static HashMap<Character, String> encryptionCodeMap = createEncryptionCodeMap();
    static HashMap<String, Character> decryptionCodeMap = createDecryptionCodeMap();

    public ECBEncryption() {

    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        while (true) {
            System.out.println("Willkommen bei PlanetExpress!");
            System.out.println("Welchen Modus möchten Sie nutzen?");
            System.out.println("1) Verschlüsselung einer Nachricht");
            System.out.println("2) Entschlüsselung einer Nachricht");
            System.out.println("3) Starten der GUI");
            System.out.println("4) Beenden");

            Scanner sc = new Scanner(System.in); // anlegen von einem Scanner Objekt
            int userInput = sc.nextInt(); // Einlesen der Auswahl

            // Verschluesselung einer Nachricht
            if (userInput == 1) {
                System.out.println("Geben Sie den zu verschlüsselnden Text ein:");
                String inputText = sc.next().toUpperCase(); // Einlesen des Textes
                if (isTextOke(inputText)) {
                    System.out.println("Geben Sie die Länger der Blöcke (r) an:");
                    int blockSize = sc.nextInt(); // Einlesen der laenge r
                    if (isBlockSizeOk(inputText, blockSize)) {
                        String encryptedText = encrypt(inputText, blockSize); // Verschluesseln der Nachricht
                        System.out.println(encryptedText); // Ausgabe auf der Konsole
                    }
                }
            }
            // Entschluesselung einer Nachricht
            if (userInput == 2) {
                System.out.println("Geben Sie den zu entschlüsselnden Text ein:");
                String inputText = sc.next().toUpperCase(); // Einlesen des Textes
                if (isTextOke(inputText)) {
                    System.out.println("Geben Sie die Länger der Blöcke (r) an:");
                    int blockSize = sc.nextInt(); // Einlesen der Laenge r
                    if(isBlockSizeOk(inputText, blockSize)) {
                        String decryptedText = decrypt(inputText, blockSize); // Entschluesseln der Nachricht
                        System.out.println(decryptedText); // Ausgabe auf der Konsole
                    }
                }
            }

            if(userInput == 3) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                ECBEncryptionGUI gui = new ECBEncryptionGUI();
                gui.runGUI();
                sc.close(); // schliessen des Scanner Objekts
                break;
            }

            if (userInput == 4) {
                sc.close(); // schliessen des Scanner Objekts
                break;
            }
        }
        System.out.println("Danke für Ihre Nutzung und auf Wiedersehen!");

    }

    // ************************************************************
    //
    // AB HIER BEGINNT IHR QUELLCODE
    //
    // ************************************************************

    //
    // Darstellung eines Textes als Binaercode
    //

    /**
     * Mit dem Symbol den String aus der encryptionCodeMap herraussuchen und zum char[] umwandeln
     *
     * @param symbol
     *
     * @return symbol als Binär
     */
    static char[] symbolToBits(char symbol) {
        String result = encryptionCodeMap.get(symbol);
        return result.toCharArray();
    }

    /**
     * Den Text in zu Binär umwandeln
     *
     * @param text
     *
     * @return den umgewandelten Text
     */
    static char[] textToBits(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(encryptionCodeMap.get(text.charAt(i)));
        }
        return result.toString().toCharArray();
    }

    //
    // Zerteilung in Bloecke der Laenge r
    //

    /**
     * Die ersten n-bits herraus suchen
     *
     * @param bits
     *
     * @param n
     *
     * @return n-bits
     */
    static char[] firstN(char[] bits, int n) {
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = bits[i];
        }
        return result;
    }

    /**
     * Die letzen n bist herraus suchen
     *
     * @param bits
     *
     * @param n
     *
     * @return n-bits
     */
    static char[] lastN(char[] bits, int n) {
        char[] result = new char[bits.length - n];
        int counter = 0;
        for (int i = n; i < bits.length; i++) {
            result[counter] = bits[i];
            counter++;
        }

        return result;
    }

    /**
     * Das char[] bits zerteilen und zu einem char[][] umwandeln
     *
     * @param bits
     *
     * @param size
     *
     * @return zerteilte bits
     */
    static char[][] bitsToBlocks(char[] bits, int size) {
        var numberOfBlocks = bits.length / size;
        char[][] result = new char[numberOfBlocks][];

        for (int i = 0; i < numberOfBlocks; i++) {
            char[] temp = new char[size];
            for (int j = 0; j < size; j++) {
                temp[j] = bits[(i * size) + j];
            }
            result[i] = temp;
        }

        return result;
    }

    //
    // Verschluesselung von Bloecken
    //

    /**
     * Mit hilfe der shiftRight-Funktion die einzelnen Blöcke verschlüssen
     *
     * @param blocks
     *
     * @return verschlüsselten Blöcke
     */
    static char[][] encryptBlocks(char[][] blocks) {
        char[][] result = new char[blocks.length][];
        for (int i = 0; i < blocks.length; i++) {
            result[i] = shiftRight(blocks[i]);
        }
        return result;
    }

    //
    // Zusammenfuegen von Bloecken
    //

    /**
     * Die zerteilten Blöcke wieder zu einem char[] zusammen fügen
     *
     * @param blocks
     *
     * @return zusammen gefügten Blöcke
     */
    static char[] blocksToBits(char[][] blocks) {
        int lengthOfResultArray = blocks.length * blocks[0].length;
        char[] result = new char[lengthOfResultArray];

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                int posToSet = (i * blocks[i].length) + j;
                result[posToSet] = blocks[i][j];
            }
        }
        
        return result;
    }

    //
    // Umwandlung eines Binaercodes als Text
    //

    /**
     * Herraus suchen des Symbols aus der decryptionCodeMap
     *
     * @param bits
     *
     * @return umgewandelte bits
     */
    static char bitsToSymbol(char[] bits) {
        return decryptionCodeMap.get(new String(bits));
    }

    /**
     * Die Bits zu Text umwandeln
     *
     * @param bits
     *
     * @param size
     *
     * @return umgewandelte Text
     */
    static char[] bitsToText(char[] bits, int size) {
        int numberOfBlocks = bits.length / size;
        char[][] splitInBlock = bitsToBlocks(bits, size);
        char[] result = new char[numberOfBlocks];
        for (int i = 0; i < numberOfBlocks; i++) {
            result[i] = bitsToSymbol(splitInBlock[i]);
        }
        return result;
    }

    //
    // Verschluesselung eines Textes
    //

    /**
     * Aufrufen der einzelen Funktionen zu verschlüsseln einen Textes
     *
     * @param text
     *
     * @param blockSize
     *
     * @return den verschlüsselten Text
     */
    static String encrypt(String text, int blockSize) {
        var textInBits = textToBits(text);
        var bitsToBlocks = bitsToBlocks(textInBits, blockSize);
        var blockShift = encryptBlocks(bitsToBlocks);
        var blockToBits = blocksToBits(blockShift);

        for (int i = 0; i < textInBits.length; i++) {
            if(i < blockToBits.length) {
                textInBits[i] = blockToBits[i];
            } else {
                break;
            }
        }

        var bitsToText = bitsToText(textInBits, symbolLenght());
        return new String(bitsToText);
    }

    //
    // Entschluesselung von Bloecken
    //

    /**
     * Mit Hilfe der shiftLeft-Funtion die einzelen Blöcken wieder entschlüsseln
     *
     * @param blocks
     *
     * @return die entschlüsselten Blöcke
     */
    static char[][] decryptBlocks(char[][] blocks) {
        char[][] result = new char[blocks.length][];
        for (int i = 0; i < blocks.length; i++) {
            result[i] = shiftLeft(blocks[i]);
        }
        return result;
    }

    //
    // Entschluesselung eines Textes
    //

    /**
     * Aufrufen der einzelen Funktionen zu entschlüsseln einen Textes
     *
     * @param text
     *
     * @param blockSize
     *
     * @return den entschlüsselten Text
     */
    static String decrypt(String text, int blockSize) {
        var textInBits = textToBits(text);
        var bitsToBlocks = bitsToBlocks(textInBits, blockSize);
        var blockShift = decryptBlocks(bitsToBlocks);
        var blockToBits = blocksToBits(blockShift);

        for (int i = 0; i < textInBits.length; i++) {
            if(i < blockToBits.length) {
                textInBits[i] = blockToBits[i];
            } else {
                break;
            }
        }

        var bitsToText = bitsToText(textInBits, symbolLenght());
        return new String(bitsToText);
    }

    // Zusatz Aufgaben

    /**
     * Schauen ob der eingebene Text Zeichen enthält die nicht verschlüsselt werden können
     *
     * @param text
     *
     * @return false => Text enthält unzulässige Zeichen, default true
     */
    static boolean isTextOke(String text) {
        for (int i = 0; i < text.length(); i++) {
            if(!encryptionCodeMap.containsKey(text.charAt(i))) {
                System.out.println("Es tut mir leid aber ihr Text enthält unzulässige Zeichen!");
                System.out.println("Das Zeichen ( " + text.charAt(i) + " ) ist unzulässig\n");
                return false;
            }
        }
        return true;
    }

    /**
     * Checken ob die Blockgröße zu groß ist
     *
     * @param text
     *
     * @param blockSize
     *
     * @return false => Blöckgröße zu groß, default true
     */
    static boolean isBlockSizeOk(String text, int blockSize) {
        int textLength = text.length() * symbolLenght();
        if(textLength < blockSize) {
            System.out.println("Blockgröße ist zu groß\n");
            return false;
        }
        return true;
    }

    // ************************************************************
    // HIER ENDET IHR QUELLCODE
    //
    // Quellcodevorlage
    //
    // BITTE NEHMEN SIE AB HIER KEINE AENDERUNGEN MEHR VOR!
    // ************************************************************

    /**
     * Gibt ein uebergebenes Character Array auf der Konsole aus.
     * @param text - a Character array
     */
    static void printCharArray(char[] text) {
        for (int i = 0; i < text.length; i++) {
            System.out.print(text[i]);
        }
        System.out.println();
    }

    /**
     * Bekommt ein Array uebergeben und verschiebt den Inhalt um eine
     * Position nach rechts. Das letzte Element wird somit zum ersten.
     * Das verschobene Array wird zurueckgegeben.
     */
    static char[] shiftRight(char[] bits) {
        char[] shiftedBits = new char[bits.length];
        for (int i = 0; i < bits.length; i++) {
            int targetPos = i + 1;
            if (targetPos >= bits.length) {
                targetPos = i - (bits.length - 1);
            }
            shiftedBits[targetPos] = bits[i];
        }
        return shiftedBits;
    }

    /**
     * Bekommt ein Array uebergeben und verschiebt den Inhalt um eine
     * Possition nach links im Array. Das erste Element wird somit zum letzten.
     * Das verschobene Array wird zurueckgegeben.
     */
    static char[] shiftLeft(char[] bits) {
        char[] shiftedBits = new char[bits.length];
        for (int i = 0; i < bits.length; i++) {
            int targetPos = i - 1;
            if (targetPos < 0) {
                targetPos = i + (bits.length - 1);
            }
            shiftedBits[targetPos] = bits[i];
        }
        return shiftedBits;
    }

    static int symbolLenght() {
        return 5;
    }

    /**
     * Erstellung des Binaercode fuer die Verschluesselung
     */
    static HashMap<Character, String> createEncryptionCodeMap() {
        HashMap<Character, String> codeMap = new HashMap<>();
        codeMap.put('A', "00000");
        codeMap.put('C', "00001");
        codeMap.put('E', "00010");
        codeMap.put('G', "00011");
        codeMap.put('I', "00100");
        codeMap.put('K', "00101");
        codeMap.put('M', "00110");
        codeMap.put('O', "00111");
        codeMap.put('Q', "01000");
        codeMap.put('S', "01001");
        codeMap.put('U', "01010");
        codeMap.put('W', "01011");
        codeMap.put('Y', "01100");
        codeMap.put('!', "01101");
        codeMap.put('?', "01110");
        codeMap.put('Z', "01111");

        codeMap.put('X', "10000");
        codeMap.put('V', "10001");
        codeMap.put('T', "10010");
        codeMap.put('R', "10011");
        codeMap.put('P', "10100");
        codeMap.put('N', "10101");
        codeMap.put('L', "10110");
        codeMap.put('J', "10111");
        codeMap.put('H', "11000");
        codeMap.put('F', "11001");
        codeMap.put('D', "11010");
        codeMap.put('B', "11011");
        codeMap.put('_', "11100");
        codeMap.put('=', "11101");
        codeMap.put('+', "11110");
        codeMap.put('-', "11111");
        return codeMap;
    }

    /**
     * Erstellung des Binaercode fuer die Entschluesselung
     */
    static HashMap<String, Character> createDecryptionCodeMap() {
        HashMap<String, Character> codeMap = new HashMap<>();
        codeMap.put("00000", 'A');
        codeMap.put("00001", 'C');
        codeMap.put("00010", 'E');
        codeMap.put("00011", 'G');
        codeMap.put("00100", 'I');
        codeMap.put("00101", 'K');
        codeMap.put("00110", 'M');
        codeMap.put("00111", 'O');
        codeMap.put("01000", 'Q');
        codeMap.put("01001", 'S');
        codeMap.put("01010", 'U');
        codeMap.put("01011", 'W');
        codeMap.put("01100", 'Y');
        codeMap.put("01101", '!');
        codeMap.put("01110", '?');
        codeMap.put("01111", 'Z');

        codeMap.put("10000", 'X');
        codeMap.put("10001", 'V');
        codeMap.put("10010", 'T');
        codeMap.put("10011", 'R');
        codeMap.put("10100", 'P');
        codeMap.put("10101", 'N');
        codeMap.put("10110", 'L');
        codeMap.put("10111", 'J');
        codeMap.put("11000", 'H');
        codeMap.put("11001", 'F');
        codeMap.put("11010", 'D');
        codeMap.put("11011", 'B');
        codeMap.put("11100", '_');
        codeMap.put("11101", '=');
        codeMap.put("11110", '+');
        codeMap.put("11111", '-');
        return codeMap;
    }
}