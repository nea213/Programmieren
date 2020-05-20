package app;

import processing.core.*;

public class pandemie extends PApplet {
  boolean[] infected;
  int days = 0;
  public static void main(String[] args) {
    PApplet.main("app.pandemie");
  }

  public void setup() { 
    background(0);
  }
  
  public void settings() {
    size(500, 500);  
    infected = calcInfestet(100, 5);
  }
  
  public void draw() {
    fill(255);
    textSize(25);
    textAlign(CENTER);
    text("Pandemie", width/2, 35);
    text("Tage: " + days, width/2, 60);
    drawRects(infected);
  }

  public boolean[] calcInfestet(int pepole, double chance) {
    boolean[] infected = new boolean[pepole];

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
  }
}