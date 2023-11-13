package Entity;

import Game.GamePanel;
import Item.PHP;

public class Lemus extends NPC {
  private boolean dropped = false;
  private long ultimaPulsacion;
  private long cooldown = 500;
  private boolean primerPulsacion = false;
  public Lemus(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }   
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("lemus.png");
  }

  public void interact(){
    long time = System.currentTimeMillis();
    if(!primerPulsacion)
      gp.player.startTalking("¿Como vas con el proyecto?");
    else if(primerPulsacion){
      gp.player.startTalking("Si no crees en ti, cree en mi que yo creo en ti. Presiona Q");
    }
    if(gp.kb.pressQ() && !primerPulsacion){
      primerPulsacion = true;
      ultimaPulsacion = time;
    }
      if(time > ultimaPulsacion + cooldown && gp.kb.pressQ() && !dropped){
        gp.player.setAtributos(new PHP(gp.player.getAtributos(),gp.player));
        dropped = true;
      }
  }
}
