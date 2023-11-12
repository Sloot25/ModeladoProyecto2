package Aliados;

import java.awt.Graphics;

public interface Aliado {
  public void set();
  public void update();
  public void attack();
  public void paint(Graphics g);
  public boolean onScreen();
  public void setOnScreen(boolean b);
}
