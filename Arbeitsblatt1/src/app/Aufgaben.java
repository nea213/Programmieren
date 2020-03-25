/**
 * @author Christian Cezanne
 **/

package app;
import processing.core.*;

public class Aufgaben extends PApplet {
  public static void main(String[] args) {
      PApplet.main("app.Aufgaben");
  }

  public void settings() {

  }

  public void setup() {
      Aufgabe1();
  }

  public void draw() {

  }

  private void Aufgabe1() {
    int[] lernfeldNoten = {};
    double summe = 0;
    double mittelwertArithmetischFeld = 0;

    for (int i = 0; i < lernfeldNoten.length; i++) {
          summe += lernfeldNoten[i];
    }
    mittelwertArithmetischFeld = summe / lernfeldNoten.length;

    println("Noten: ");
    println(lernfeldNoten);
    println("arithmetischer Mittelwert: " + mittelwertArithmetischFeld);
  }
}