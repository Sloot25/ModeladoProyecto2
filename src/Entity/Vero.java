package Entity;

import Game.GamePanel;
import Item.Cplusplus;

public class Vero extends NPC {
  private boolean dropped = false;
  private long ultimaPulsacion; 
  private long cooldown = 500;
  private boolean primerPulsacion = false;
  public Vero(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width*2, height*2);
  }
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("Vero.png");
  }
  public void interact(){
    long time = System.currentTimeMillis();
    if(!primerPulsacion)
      gp.player.startTalking("Inserte Frase Ingeniosa, no se tengo sueño");
    else if(primerPulsacion){
      gp.player.startTalking("Debes aprender C++ para entender Arboles. Presiona Q");
    }
    if(gp.kb.pressQ() && !primerPulsacion){
      primerPulsacion = true;
      ultimaPulsacion = time;
    }
      if(time > ultimaPulsacion + cooldown && gp.kb.pressQ() && !dropped){
        gp.player.setAtributos(new Cplusplus(gp.player.getAtributos(),gp.player));
        dropped = true;
      }
  }
}
