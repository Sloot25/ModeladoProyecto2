package Aliados;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Entity.Enemy;
import Entity.Player;
import Game.GamePanel;

public class Actuario implements Aliado{
  GamePanel gp;
  BufferedImage imagen;
  boolean onScreen;
  private Player player; 
  /*
   * Constructor de la clase Actuario
   */
  public Actuario(GamePanel gp, Player player){
    this.gp = gp;
    this.player = player;
    onScreen = false;
    set();
  }
  /*
   * Prepara la imagen de la clase Actuario
   */
  public void set(){
    imagen = gp.getRutas().getImagen("actuario.png");
  }
  /*
   * Se encarga de atacar a los enemigos cercanos al aliado
   */
  public void update(){
    if(onScreen){
      for(Enemy e: gp.lc.getEnemys()){
        if(e.getBox().intersects(getBox())){
            attack(e);
          }
        }
      }
    }
  /*
   * Es el daño particular que realiza el aliado en cuestion
   */
  public void attack(Enemy e){
    e.setLife(e.getLife()-150);
    e.setIsAtacked(true);
  }
  /*
   * Dibuja al aliado en pantalla
   * @param Graphics  
   */
  public void paint(Graphics g){
    if(onScreen){
      g.drawImage(imagen, player.getX()-300, player.getY()-100,200, 200, null);
    }
  }
  /*
   * Regresa si el aliado esta en la pantalla
   * @return boolean
   */
  public boolean onScreen() {
    return onScreen;
  }
  /*
   * Coloca al aliado en pantalla o fuera de la pantalla
   * @param boolean
   */
  public void setOnScreen(boolean onScreen) {
    this.onScreen = onScreen;
  }
  /*
   * Regresa la caja de colisiones del aliado
   * @return Rectangle
   */
  public Rectangle getBox(){
    return new Rectangle(player.getX()-200, player.getY()-200, 400, 400);
  }
  /*
   * Regresa el ataque que hace el aliado
   */
  public int getAtaque(){
    return 100;
  }
}
