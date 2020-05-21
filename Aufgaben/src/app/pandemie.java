package app;

import processing.core.*;

public class pandemie extends PApplet {
  boolean[] infectedGlobal;
  int lastY;
  boolean[] allInfected;

  int days = 0;
  public static void main(String[] args) {
    PApplet.main("app.pandemie");
  }

  public void setup() { 
    frameRate(1);
    infectedGlobal = calcInfested(100, 5);
    
  }
  
  public void settings() {
    size(500, 500);  
  }
  
  public void draw() {
    background(0);
    fill(255);
    textSize(25);
    textAlign(CENTER);
    text("Pandemie", width/2, 35);
    text("Tage: " + days, width/2, 60);
    drawRects(infectedGlobal);
    if(!infectedGlobal.equals(allInfected)) {
      infectPeople(infectedGlobal);
      textSize(20);
      textAlign(LEFT);
      fill(255);
      text("Anzahl der Personen: " + infectedGlobal.length, 100, (lastY + 30));
      text("Warscheinlichkeit: 5%", 100, (lastY + 60));
    }
  }
  
  public boolean[] calcInfested(int people, double chance) {
    boolean[] infected = new boolean[people];
    
    for (int i = 0; i < infected.length; i++) {
      if(Math.random() * 100 < chance) {
        infected[i] = true;
      } else {
        infected[i] = false;
      }
    }
    
    for (int i = 0; i < infected.length; i++) {
      print(infected[i] + " ");
    }
    return infected;
  }

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

  public void infectPeople(boolean[] infected) {
    for (int i = 0; i < infected.length; i++) {
      if(infected[i]) {
        if(i == 0) {
          infected[i + 1] = true;
          i++;
        } else if (i == infected.length - 1) {
          infected[i - 1] = true;
        } else { 
          infected[i + 1] = true;
          infected[i - 1] = true;
          i++;
        }
      }
    }
    infectedGlobal = infected;
    days++;
  }
}