package Item;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Item {
  /* Dibuja el item en pantalla*/
  public void paint(Graphics g);
  //@return boolean correspondiente a si el item es solido en tiempo de ejecucion
	public boolean isSolid();
  //@return Rectangle correspondiente a la hitbox del item
  public Rectangle getBox();
  //@param boolean setea si se encuentra en rango el item
  public void setInRange(boolean b);
}
