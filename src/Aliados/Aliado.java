package Aliados;

import java.awt.Graphics;
import java.awt.Rectangle;

import Entity.Enemy;

public interface Aliado {
  public void set();
  public void update();
  public void attack(Enemy e);
  public void paint(Graphics g);
  public boolean onScreen();
  public void setOnScreen(boolean b);
  public Rectangle getBox();
}
