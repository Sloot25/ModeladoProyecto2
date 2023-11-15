package Aliados;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Entity.Enemy;
import Entity.Player;
import Game.GamePanel;

public class Fisico implements Aliado {
  GamePanel gp;
  BufferedImage imagen;
  boolean onScreen;
  int counter = 120;
  Rectangle box;
  private Player player;   
  public Fisico(GamePanel gp, Player player){
    this.gp = gp;
    this.player = player;
    box = new Rectangle(player.getX()-200,player.getY()-200,400,400);
    onScreen = false;
    set();
  }
    /*
   * Prepara la imagen de la clase Fisico
   */
  public void set(){
    imagen = gp.getRutas().getImagen("fisico.png");
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
  public void paint(Graphics g){
    if(onScreen){
      g.drawImage(imagen, player.getX()-300, player.getY()-100,200, 200, null);
    }
  }
  public boolean onScreen() {
    return onScreen;
  }
  public void setOnScreen(boolean onScreen) {
    this.onScreen = onScreen;
  }
  public Rectangle getBox(){
    return new Rectangle(player.getX()-200, player.getY()-200, 400, 400);
  }
  public int getAtaque(){
    return 400;
  }
}
