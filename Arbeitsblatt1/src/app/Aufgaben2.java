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
    // Aufgabe3();
    // println(Aufgabe4(10));
    Aufgabe5();
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


  public int Aufgabe4(int start) {
    int[] fiboNumbers = new int[10];
    
    if(start > 9) {
      println("Bitte nur bis 9 eingben oder die Größe des Arrays anpassen");
      return (0);
    }

    if(start == 0) {
      fiboNumbers[0] = 0;
    }

    if(start == 1) {
      fiboNumbers[1] = 1;
    }

    if(fiboNumbers[start] == 0 && start > 0) {
      int tempFibo = Aufgabe4( start - 1) + Aufgabe4( start - 2);
      fiboNumbers[start] = tempFibo;
    }
    return fiboNumbers[start];
  }

  public void Aufgabe5() {
    int[] a = { 1, 2, 25, 6 };
    int[] b = { 9, 18, 5, 34 };
    int[] c = new int[4];

    for (int i = 0; i < c.length; i++) {
      c[i] = a[i] + b[i];
    }
    println(c);
  }
}