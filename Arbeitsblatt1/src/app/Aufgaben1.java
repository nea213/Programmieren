/**
 * @author Christian Cezanne
 **/

package app;
import java.util.Scanner;

import processing.core.*;


public class Aufgaben1 extends PApplet {
  public static void main(String[] args) {
      PApplet.main("app.Aufgaben1");
  }

  public void settings() {

  }

  public void setup() {
      // Aufgabe1();
      // Aufgabe3();
      Aufgabe4();
  }

  public void draw() {

  }

  private void Aufgabe1() {
    int[] lernfeldNoten = new int[11];
    double summe = 0;
    double mittelwertArithmetischFeld = 0;
    Scanner noteScanner = new Scanner(System.in); 

    for (int i = 0; i < 11; i++) {
      System.out.println("Bitte geben sie für das Lernfeld"+(i+1)+" eine Note ein");
      lernfeldNoten[i] = noteScanner.nextInt();
    }

    for (int i = 0; i < lernfeldNoten.length; i++) {
          summe += lernfeldNoten[i];
    }
    mittelwertArithmetischFeld = summe / lernfeldNoten.length;

    println("Noten: ");
    println(lernfeldNoten);
    println("arithmetischer Mittelwert: " + mittelwertArithmetischFeld);
  }

  private void Aufgabe3() {
    int[] lernfeldNoten = new int[11];
    double summe = 0;
    double mittelwertArithmetischFeld = 0;
    Scanner notenScanner = new Scanner(System.in); 

    for (int i = 0; i < 11; i++) {
      println("Bitte geben sie für das Lernfeld-" + (i + 1) + " eine Note ein");
      lernfeldNoten[i] = notenScanner.nextInt();
    }

    for (int i = 0; i < lernfeldNoten.length; i++) {
          summe += lernfeldNoten[i];
    }
    mittelwertArithmetischFeld = summe / lernfeldNoten.length;

    println("Noten sind: ");
    for (int i = 0; i < lernfeldNoten.length; i++) {
      println("Lernfeld-" + (i + 1) + ": " + lernfeldNoten[i] + "; ");
    }
    println("arithmetischer Mittelwert: " + mittelwertArithmetischFeld);
    
    println("Beste Note/n");
    for (int i = 0; i < lernfeldNoten.length; i++) {
      if(lernfeldNoten[i] == min(lernfeldNoten)) {
        println("Lernfeld-" + (i + 1) + ": " + lernfeldNoten[i]);
      }
    }
  }

  private void Aufgabe4() {
    int[][] noten = {
      {2, 30},
      {3, 60},
      {4, 100},
      {1, 100},
      {2, 20},
      {5, 100},
      {3, 100},
      {1, 40},
      {2, 40},
      {3, 40},
      {2, 20},
    };
    double summ = 0;
    double average = 0;
    Scanner notenScanner = new Scanner(System.in);

    for (int i = 0; i < noten.length; i++) {
      println("Bitte geben sie für das Lernfeld-" + (i + 1) + " eine Note ein");
      noten[i][0] = notenScanner.nextInt();
    }

    for (int[] note : noten) {
      double convert = Double.valueOf(note[1]) / 100;
      summ += note[0] * convert;
      average += convert;
    }

    println(summ);
    println(average);
    println(summ/noten.length);
  }
}