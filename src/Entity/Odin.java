package Entity;

import Game.GamePanel;
import Item.C;

public class Odin extends NPC {
  private boolean dropped = false; 
  private long ultimaPulsacion; 
  private long cooldown = 500;
  private boolean primerPulsacion = false;
  public Odin(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width*2, height*2);
  }
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("Odin.png");
  }
  public void interact(){
    long time = System.currentTimeMillis();
    if(!primerPulsacion)
      gp.player.startTalking("Recuerda hacer tu evaluacion autentica");
    else if(primerPulsacion){
      gp.player.startTalking("No podemos enseñarte Fortran, pero tenemos C. Presiona Q");
    }
    if(gp.kb.pressQ() && !primerPulsacion){
      primerPulsacion = true;
      ultimaPulsacion = time;
    }
      if(time > ultimaPulsacion + cooldown && gp.kb.pressQ() && !dropped){
        gp.player.setAtributos(new C(gp.player.getAtributos(),gp.player));
        dropped = true;
      }
  }
}
