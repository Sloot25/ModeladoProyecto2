package Entity;

public class AtributosPlayer {
  protected Player player;
  private int vida;
  public AtributosPlayer(Player player){
    this.player = player; 
    this.vida = 1000;
  }
  public int getVelocidad(){
    return 5;
  }
  public int getAtaque(){
    return 25;
  }
  public int getCadencia(){
    return 0;
  }
  public int getLife(){
    return vida; 
  }
  public void setLife(int life){
    this.vida = life;
  }
  public Player getPlayer(){
    return this.player;
  }
    
}
