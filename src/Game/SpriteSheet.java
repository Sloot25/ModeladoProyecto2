package Game;
import java.awt.image.BufferedImage;

public class SpriteSheet {
  private BufferedImage[] frames; 
  private boolean running;
  private int index; 
  private long time; 
  private long lastTime; 
  private int duracionFotograma;

  public SpriteSheet(BufferedImage[] frames, int duracionFotograma){
    this.frames = frames; 
    this.duracionFotograma = duracionFotograma;
    index = 0; 
    running = true; 
    time = 0; 
    lastTime = System.currentTimeMillis();
  }
  public void update(){
    time += System.currentTimeMillis()-lastTime;
    lastTime = System.currentTimeMillis();
    if(time > duracionFotograma){
      time = 0; 
      index++; 
      if(index >= frames.length){
        index = 0;
      }
    }
  }
  public boolean isRunning(){
    return running;
  }
  public BufferedImage getCurrentFrame(){
    return frames[index];
  }
}
