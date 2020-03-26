/**
 * @author Christian Cezanne
 * 
 */

package app;

import java.util.Scanner;

import processing.core.PApplet;

public class Aufgaben2 extends PApplet {
  public static void main(String[] args) {
    PApplet.main("app.Aufgaben2");
  }
  public void settings() {
    
  }

  public void setup() {
    // Aufgabe1();
    // Aufgabe2();
    Aufgabe3();
  }

  public void draw() {
  
  }

  public void Aufgabe1() {
    int[] foo = {5, 45, -10, 20};
    int a = foo[0] + foo[1];
    int b = foo[2] + foo[3];
    println(a);
    println(b);
  }

  public void Aufgabe2() {
    int[] bar = {2,4,6};
    bar[2] = bar[0] * bar[1];
    println(bar);
  }

  public void Aufgabe3() {
    Scanner arraylength = new Scanner(System.in);
    println("Bitte die Länge des Arrays angbene");
    int[] foo = new int[arraylength.nextInt()];
    arraylength.close();
    
    for (int i = 0; i < foo.length; i++) {
      foo[i] = i+1;
    }
    println("Nach befüllen");
    println(foo);

    for (int i = 0; i < foo.length; i++) {
      foo[i] = foo[i] * 2;
    }
    println("Nach verdoppeln");
    println(foo);
  }
}