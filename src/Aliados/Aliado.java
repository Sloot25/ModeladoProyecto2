package Aliados;

import java.awt.Graphics;
import java.awt.Rectangle;

import Entity.Enemy;

public interface Aliado {
   /*
   * Prepara la imagen de la clase Aliado
   */
  public void set();
  /*
   * Se encarga de atacar a los enemigos cercanos al aliado
   */
  public void update();
  /*
   * Es el daño particular que realiza el aliado en cuestion
   */
  public void attack(Enemy e);
  /*
   * Dibuja al aliado en pantalla
   * @param Graphics  
   */
  public void paint(Graphics g);
   /*
   * Regresa si el aliado esta en la pantalla
   * @return boolean
   */
  public boolean onScreen();
    /*
   * Coloca al aliado en pantalla o fuera de la pantalla
   * @param boolean
   */
  public void setOnScreen(boolean b);
    /*
   * Regresa la caja de colisiones del aliado
   * @return Rectangle
   */
  public Rectangle getBox();
   /*
   * Regresa el ataque que hace el aliado
   */
  public int getAtaque();
}
