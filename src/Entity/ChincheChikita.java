package Entity;
import Game.GamePanel;

public class ChincheChikita extends Enemy{
  //private BufferedImage[] chinchePequenia = new BufferedImage[8];
  //private SpriteSheet animationCaminando;
  private long ultimoAtaque; 
  private long cooldown = 2000;
  public ChincheChikita(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
      /* 
      for(int i= 0; i < chinchePequenia.length; i++){
        chinchePequenia[i] = this.gp.getRutas().getImagen("/Chinches chikitas/Chinche caminando "+(i+1)+".png");
      }
      animationCaminando = new SpriteSheet(chinchePequenia,175);
      */
      this.life = 150;
      this.retroceso = 100;
  }
  @Override
  public void getEntityImage(){
    if (isAtacked){
      imagen = this.gp.getRutas().getImagen("chinchedaniada.png");  
    } else{
      imagen = this.gp.getRutas().getImagen("chinche.png");
    }
  }

  @Override
  public void attack() {
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife() - 100);
      gp.player.setIsAtacked(true);
      gp.player.setRetroceso(75);
      ultimoAtaque = time;
    }
  }  
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }

  @Override
  public void retroceso(){
    if(retroceso <= 0){
      isAtacked = false; 
      retroceso = 100;
      getEntityImage();
    }else{
      retroceso -= 10; 
      x += 5 * directionReceivedAtack;
      getEntityImage();
    }
  }
}
