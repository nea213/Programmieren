/**
 * @author Christian Cezanne
 **/

package app;
import java.util.Scanner;

import processing.core.*;


public class Aufgaben extends PApplet {
  public static void main(String[] args) {
      PApplet.main("app.Aufgaben");
  }

  public void settings() {

  }

  public void setup() {
      // Aufgabe1();
      Aufgabe3();
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
    Scanner noteScanner = new Scanner(System.in); 

    for (int i = 0; i < 11; i++) {
      println("Bitte geben sie für das Lernfeld-" + (i + 1) + " eine Note ein");
      lernfeldNoten[i] = noteScanner.nextInt();
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
}