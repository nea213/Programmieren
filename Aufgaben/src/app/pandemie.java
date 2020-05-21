/**
 * Übungsaufgabe Pandemie
 * @version 1.0, 22.05.2020 
 * @author Christian Cezanne
 */


package app;

import processing.core.*;

public class pandemie extends PApplet {
  boolean[] infectedGlobal;
  int lastY; //Benötige ich zum bessern Anpassen der Schift
  int countInfected = 0;
  String typing = "";
  String saved = "";
  boolean status;
  int infectionRate = 0;

  int days = 0;
  public static void main(String[] args) {
    PApplet.main("app.pandemie");
  }

  public void setup() { 
    status = false;
  }
  
  public void settings() {
    size(500, 500);  
  }
  
  public void draw() {
    background(0);
    if(!status) {
      fill(255);
      textSize(32);
      text("Pandemie", 200, 50);
      textSize(20);
      // Eingabeaufforderung
      text("Bitte geben Sie die Häufigkeit der Infektion in einer\nnummerischen Zahl an und " +
      "drücken Sie anschliessend\ndie Return-Taste.", 25, 100);
      text("Eingabe: " + typing, 25, 220);

    } else {
      fill(255);
      textSize(25);
      textAlign(CENTER);
      text("Pandemie", width/2, 35);
      text("Tage: " + days, width/2, 60);
      drawRects(infectedGlobal);
      if(countInfected <= 99) {
        infectPeople(infectedGlobal);
        textSize(20);
        textAlign(LEFT);
        fill(255);
        text("Anzahl der Personen: " + infectedGlobal.length, 100, (lastY + 30));
        text("Warscheinlichkeit: " + infectionRate + "%", 100, (lastY + 60));

      } else {
        textSize(20);
        textAlign(LEFT);
        fill(255);
        text("Es sind alle Personen nach " + days + " Tagen infiziert", 50, (lastY + 30));
        noLoop();
      }
    }
    
  }
  
  //Hier werden alle das erste mal infiziert
  public boolean[] calcInfested(int people, double chance) {
    boolean[] infected = new boolean[people];
    
    for (int i = 0; i < infected.length; i++) {
      if(Math.random() * 100 < chance) {
        infected[i] = true;
        countInfected++;
      } else {
        infected[i] = false;
      }
    }
    
    for (int i = 0; i < infected.length; i++) {
      print(infected[i] + " ");
    }
    return infected;
  }

  //Funktion zum zeichner der Rechtecke
  public void drawRects(boolean[] infected) {
    int posY = 100;
    int posX = 100;
    for (int i = 0; i < infected.length; i++) {
      if(posX > 400) {
        posY += 15;
        posX = 100;
      }
      if(infected[i]) {
        rectMode(CENTER);
        fill(127,25,000);
        rect(posX, posY, 10, 10);
      } else {
        rectMode(CENTER);
        fill(127,255,000);
        rect(posX, posY, 10, 10);
      }
      posX += 15;
    }
    lastY = posY;
  }

  //Funktion zu infizieren der anderen Personen
  public void infectPeople(boolean[] infected) {
    for (int i = 0; i < infected.length; i++) {
      if (!infected[i]) {
        continue;
      }
      if(i == 0 && infected[0]) {
        if(!infected[i + 1]) {
          i++;
          infected[i] = true;
          countInfected++;
        }
        continue;
      }
      if(!infected[i - 1]) {
        infected[i - 1] = true;
        countInfected++;
        i++;
      }
      if(i + 1 < infected.length && !infected[i + 1]) {
        infected[i + 1] = true;
        countInfected++;
        i++;
      }
    }
    infectedGlobal = infected;
    days++;
  }

  public void keyPressed() {
    // return-Tast schliesst die Eingabe ab, 
    // Eingabe wird in die Variable saved uebertragen
    if (key == '\n') {
     if (typing.length() != 0) {
      infectionRate = parseInt(typing);
      typing = ""; // Variable leeren
      if (infectionRate != 0) {
        infectedGlobal = calcInfested(100, infectionRate);
        status = true;
        frameRate(1);
      }
      clear();
     }
    } else {
     // Ein weiterer Buchstabe wurde eingegeben, 
     // diesen an die bisherige Eingabe anhaengen
     typing = typing + key;
    }
   }


}