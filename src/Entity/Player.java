package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList; 

import Game.GamePanel;
import Game.Keyboard;

public class Player implements Entity {
    GamePanel gp;
    Keyboard kb;
    BufferedImage image;
    int x;
    int y;
    int screenX;
    int screenY;
    double speedX;
    double speedY;
    int width;
    int height;
    int score;
    double gravity;
    Rectangle box;
    String direction;
    boolean collision;
    private long ultimoAtaque; 
    private long cooldown = 200;
    private ArrayList<Proyectiles> proyectiles = new ArrayList<Proyectiles>();
    private ArrayList<BufferedImage> imagenesProyectiles = new ArrayList<BufferedImage>();
    private int indiceProyectil = 0;
    //boolean jumping;
    boolean talking;
    //boolean falling;
    //boolean walking;
    boolean onfloor;
    private AtributosPlayer atributos;

    public Player(GamePanel gp, Keyboard kb) {
        this.gp = gp;
        this.kb = kb;
        this.imagenesProyectiles.add(gp.getRutas().getImagen("Html.png"));
        height = 50;
        width = 50;
        box = new Rectangle(50, 50, width, height); // La caja es para revisar las colisiones
        collision = false;
        talking = false;
        onfloor = false;
        x = 0;
        y = 0;
        speedX = 0;
        speedY = 0;
        gravity = 0;
        direction = "";
        atributos = new AtributosPlayer(this);
        getEntityImage();
    }
    public GamePanel getGP(){
    return gp;
  }
    public void getEntityImage() {
      image = gp.getRutas().getImagen("potato.png");
    }
    public void attack(Enemy enemigo){
      enemigo.life -= getAtaque();
    }
    public ArrayList<BufferedImage> getImagenProyectil(){
      return imagenesProyectiles;
    }
    public void update() {
        if (kb.pressUp() == true) {
            direction = "up";
        } 
        else if (kb.pressDown() == true) {
            direction = "down";
        }  
        else if (kb.pressRight() == true) {
            direction = "right";
        }
        else if (kb.pressLeft() == true) {
            direction = "left";
        }else if(kb.pressA()){
          long time = System.currentTimeMillis();
              if(time > ultimoAtaque + cooldown - getCadencia()){
                atacarDetras();
                ultimoAtaque = time;
              }
          direction="";
        }else if(kb.pressD()){
          long time = System.currentTimeMillis();
            if(time > ultimoAtaque + cooldown - getCadencia()){
              atacarEnfrente();
              ultimoAtaque = time;
            }
          direction="";
        }
        else{
            direction = "";
        }
        onfloor = gp.cc.checkOnFloor(this);
        if (onfloor == false) {
            gravity = 0.2;
            speedY += gravity;
        }
        else{
            gravity = 0;
        }
        y += speedY;
        x += speedX;
        gp.cc.checkItem(this);
        gp.cc.checkStairs(this);
        switch (direction) {
            case "up":
                if (onfloor) {
                    speedY = -10;
                    gravity = 0.2;
                    onfloor = false;
                }
                break;
            case "down":
                speedY = 0;
                break;
            case "left":
                speedX = -getVelocidad();
                break;
            case "right":
                speedX = getVelocidad();
                break;
            default:
                speedX = 0;
        }
      for(int i = 0; i < proyectiles.size(); i++){
        proyectiles.get(i).update();
        gp.cc.checkProyectilItem(proyectiles.get(i));
      }
        //System.out.println();
    }
    private void cambiarImagen(){
      indiceProyectil = (indiceProyectil < imagenesProyectiles.size()-1) ? indiceProyectil+1 : 0;
      
    }
    public void addImagenProyectil(BufferedImage imagen){
      imagenesProyectiles.add(imagen);
    }
    public ArrayList<Proyectiles> getProyectiles(){
      return proyectiles;
    }
    private void checarColisionAtaque(Proyectiles proyectil){
        Rectangle area = proyectil.getBox();
        for(Enemy enemigo : gp.enemies)
          if(area.intersects(enemigo.getBox()))
            proyectiles.remove(proyectil);
    }

    private void atacarEnfrente(){
      proyectiles.add(new Proyectiles(imagenesProyectiles.get(indiceProyectil), 1, x,y)); 
      cambiarImagen();
    }
    
    private void atacarDetras(){
      proyectiles.add(new Proyectiles(imagenesProyectiles.get(indiceProyectil), -1, x, y));
      cambiarImagen();
    }

    public void paint(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
        for(int i = 0; i < proyectiles.size(); i++)
          proyectiles.get(i).paint(g);
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getWidth(){
        return width;
    }

    public Rectangle getBox() {
        return new Rectangle(x, y, width, height);
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public Rectangle getBoxUp() {
        return new Rectangle(x+5, y, width-10, 1);
    }

    public Rectangle getBoxDown() {
        return new Rectangle(x+5, y + width - 5, width-10, 5);
    }

    public Rectangle getBoxRight() {
        return new Rectangle(x + height - 1, y+5, 1, height-10);
    }

    public Rectangle getBoxLeft() {
        return new Rectangle(x, y+5, 1, height-10);
    }

    @Override
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isOnFloor() {
        return onfloor;
    }

    public void setOnFloor(boolean onfloor) {
        this.onfloor = onfloor;
    }

    public int getLife() {
        return atributos.getLife();
    }

    public void setLife(int life) {
        atributos.setLife(life);
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getScore() {
        return score;
    }

    public boolean isTalking() {
        return false;
    }

    public void startTalking(String mensaje) {
        talking = true;
        gp.ui.talk(mensaje);
    }

    public int getAtaque() {
        return atributos.getAtaque();
    }

    public int getVelocidad() {
        return atributos.getVelocidad();
    }

    public int getCadencia() {
        return atributos.getCadencia();
    }
    public AtributosPlayer getAtributos(){
      return atributos;
    }
    public void setAtributos(AtributosPlayer atributos){
      this.atributos = atributos;
    }

}
