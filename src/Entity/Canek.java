package Entity;

import Game.GamePanel;
import Item.Java;
public class Canek extends NPC{
  private boolean dropped = false;
  private long ultimaPulsacion;
  private long cooldown = 500;
  private boolean primerPulsacion = false;
  public Canek(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width*2, height*2);
  }
  public void getEntityImage(){
    // Ingresar la ruta del personaje de canek
    imagen = gp.getRutas().getImagen("Canek.png");
  }

  public void interact(){
    long time = System.currentTimeMillis();
    if(!primerPulsacion)
      gp.player.startTalking("¿Ya acabaste con las chinches? ¿No? Estoy terriblemente decepcionado de ti");
    else if(primerPulsacion){
      gp.player.startTalking("Planteate por que escogiste esta carrera y aprende Java. Presiona Q");
    }
    if(gp.kb.pressQ() && !primerPulsacion){
      primerPulsacion = true;
      ultimaPulsacion = time;
    }
      if(time > ultimaPulsacion + cooldown && gp.kb.pressQ() && !dropped){
        gp.player.setAtributos(new Java(gp.player.getAtributos(),gp.player));
        dropped = true;
      }
  }

}
