package Entity;

import Game.GamePanel;
import Item.Python;

public class Rosa extends NPC {
  private boolean dropped = false;
  private long ultimaPulsacion; 
  private long cooldown = 500;
  private boolean primerPulsacion = false;
  public Rosa(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, 2*width, 2*height);
  }
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("Rosa.png");
  }
  public void interact(){
    long time = System.currentTimeMillis();
    if(!primerPulsacion)
      gp.player.startTalking("¿Sabian que pueden subir y bajar escaleras con w y s?");
    else if(primerPulsacion){
      gp.player.startTalking("No sean como Banco Azteca y aprendan Python. Presiona Q");
    }
    if(gp.kb.pressQ() && !primerPulsacion){
      primerPulsacion = true;
      ultimaPulsacion = time;
    }
      if(time > ultimaPulsacion + cooldown && gp.kb.pressQ() && !dropped){
        gp.player.setAtributos(new Python(gp.player.getAtributos(),gp.player));
        dropped = true;
      }
  }
}
