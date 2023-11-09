package Entity;

import java.awt.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Aliados.Aliado;
import res.Rutas.Rutas;
import Game.GamePanel;
import Game.Keyboard;
import Game.Herramientas.Gestor;

public class Player implements Entity{
  private double posicionX;
  private double posicionY; 

  private int direccion;

  private boolean enMovimiento; 
  private BufferedImage imagenActual;

  private final int ANCHO_JUGADOR = 16;
  private final int ALTO_JUGADOR = 16; 

  
  private final Rectangle LIMITE_ARRIBA = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR/2, Constantes.CENTRO_VENTANA_Y, ANCHO_JUGADOR, 1);
  private final Rectangle LIMITE_ABAJO = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR/2, Constantes.CENTRO_VENTANA_Y + ANCHO_JUGADOR, 1);
  private final Rectangle LIMITE_IZQUIERDA = new Rectangle(Constantes.CENTRO_VENTANA_X - ANCHO_JUGADOR/2, Constantes.CENTRO_VENTANA_Y, 1, ALTO_JUGADOR);
  private final Rectangle LIMITE_DERECHA = new Rectangle(Constantes.CENTRO_VENTANA_X + ANCHO_JUGADOR/2, Constantes.CENTRO_VENTANA_Y, 1, ALTO_JUGADOR);

  private int animacion; 
  private int limitePeso = 70; 
  private int pesoActual = 30; 
  private int puntuacion = 0; 
  private HojaSprites hs; 
  private Aliado aliado;
  
  protected int vida; 
  
  public Jugador(){
    // Recibir posicion a partir de la lectura del mapa; 
    posicionX = 0;
    posicionY = 0; 
    
    direccion = 0; 

    esMovimiento = false;

    // hs Agregar animaciones 
    // imagenActual = hs.obtenerSprite(0).obtenerImagen();
    // Comentar la siguiente linea cuando se agreguen animaciones 
    imagenActual = Rutas.getRutas().getImagen("potate.png");
    animacion = 0; 
    estado = 0;
    
    vida = 1000; 
  }

  public void actualizar(){
    cambiarHojaSprites();
    cambiarAnimacionEstado();
    enMovimiento = false; 
    determinarDireccion();
    animar();
  }

  private void cambiarAnimacionEstado(){
    if(animacion < 30)
      animacion++; 
    else 
      animacion = 0; 
    if(animacion < 15)
      estado = 1; 
    else 
      estado = 2; 

  }
  
  private void determinarDireccion(){
    final int velocidadX = evaluarVelocidadX();
    final int velocidadY = evaluarVelocidadY();

    if(velocidadX == 0 && velocidadY == 0 )
      return;
    
    // izquierda y abajo 
    if((velocidadX != 0 && velocidadY == 0) || (velocidadX == 0 && velocidadY != 0)){
      mover(velocidadX, velocidadY);
    } else{
      if(velocidadX == -1 && velocidadY == -1){
        if(Gestor.teclado.izquierda.obtenerUltimaPulsacion() > Gestor.teclado.abajo.obtenerUltimaPulsacion())
          mover(velocidadX, 0);
        else 
          mover(0, velocidadY);
      }
    }

    // Derecha y arriba 
    
    if(velocidadX == 1 && velocidadY == -1){
      if(Gestor.teclado.derecha.obtenerUltimaPulsacion() > Gestor.arriba.obtenerUltimaPulsacion()){
        mover(velocidadX, 0);
      } else 
        mover(0. velocidadY);
    }
    if(velocidadX == 1 && velocidadY == 1){
      if(Gestor.teclado.derecha.obtenerUltimaPulsacion() > Gestor.teclado.abajo.obtenerUltimaPulsacion()){
        mover(velocidadX, 0);
      } else {
        mover(0, velocidadY);
      }
    }
  }
  /* Regresa una velocidad de acuerdo a si nuestro usuario esta pulsando 
   *
   * si pulsa la tecla izquierda regresa -1 
   * si pulsa la tecla derecha regresa 1 
   * si pulsa ambas regresa 0, dando entender que esta estatico
   * 
   * */
  private int evaluarVelocidadX(){
    if(Gestor.teclado.izquierda.estaPulsada() && !Gestor.teclado.derecha.estaPulsada())
      return -1;
    else if(Gestor.teclado.derecha.estaPulsada() && !Gestor.teclado.izquierda.estaPulsada())
      return 1;
    return 0;
  }

  private int evaluarVelocidadY(){
    if(Gestor.teclado.arriba.estaPulsada() && !Gestor.teclado.abajo.estaPulsada())
      return -1; 
    else if(Gestor.teclado.abajo.estaPulsada() && !Gestor.teclado.arriba.estaPulsada())
      return 1; 
    return 0;
  }

  private void mover(final int velocidadX, final int velocidadY){
    enMovimiento = true; 
    cambiarDireccion(velocidadX, velocidadY);

    if(!fueraMapa(velocidadX, velocidadY)){
      if(velocidadX == -1 && !enColisionIzquierda(velocidadX)){
        posicionX += velocidadX * getVelocidad();
      }
      if(velocidadX == 1 && !enColisionDerecha(velocidadX)){
        posicionX += velocidadX * velocidad;
      }
      if(velocidadY == -1 && !enColisionArriba(velocidadY)){
        posicionY += velocidadY * velocidad;
      }
      if(velocidadY == -1 && !enColisionAbajo(velocidadY)){
        posicionY += velocidadY * velocidad; 
      }
    }
  }

  private boolean enColisionArriba(int velocidadY){
    //for(int r = 0; r < mapa.areasColisionPorActualizacion.size(); r++){
    //  final Rectangle area = mapa.areasColisionPorActualizacion.get(r);
    //
    //  int origenX = area.x;
    //  int origenY= area.y + velocidadY * getVelocidad() + 3*getVelocidad();
    //
    //  final Rectangle areaFutura() = new Rectangle(origenX, origenY, area.width, area.height);
    //
    //  if(LIMITE_ARRIBA.intersects(areaFutura))
    //    return true; 
    //  return false; 
    //}
  }

  private boolean enColisionAbajo(int velocidadY){
    /* for(int r = 0; r < mapa.areasColisionPorActualizacion.size(); r++){
     *  final Rectangle area = mapa.areasColisionPorActualizacion.get(r);
     *
     *  int origenX = area.x; 
     *  int origenY = area.y; 
     *
     *  final Rectangle areaFutura = new Rectangle(origenX, origenY, area.width, area.height);
     *
     *  if(LIMITE_ABAJO.intersects(areaFutura))
     *    return true; 
     *  return false; 
     * }
     * 
     *
     * */
  }
  private boolean enColisionDerecha(int velocidadX){
    /*
     * for(int r; r < mapa.areasColisionPorActualizacion.size(); r++){
     *  final Rectangle area = mapa.areasColisionPorActualizacion.get(r);
     *
     *  int origenX = area.x + velocidadX * getVelocidad() - 3*getVelocidad(); 
     *  int origenY = area.y; 
     *
     *  final Rectangle areaFutura = new Rectangle(origenX, origenY, area.width, area.height);
     *
     *  if(LIMITE_DERECHA.intersects(areaFutura))
     *    return true; 
     *  return false; 
     * }
     *
     * */
  }
  private boolean enColisionIzquierda(int velocidadX){
    /*
     * for(int r; r < mapa.areasColisionPorActualizacion.size(); r++){
     *  final Rectangle area = mapa.areasColisionPorActualizacion.get(r);
     *
     *  int origenX = area.x + velocidadX * getVelocidad() + 3*getVelocidad(); 
     *  int origenY = area.y; 
     *
     *  final Rectangle areaFutura = new Rectangle(origenX, origenY, area.width, area.height);
     *
     *  if(LIMITE_DERECHA.intersects(areaFutura))
     *    return true; 
     *  return false; 
     * }
     *
     * */
  }
  
  private void cambiarDireccion(final int velocidadX, final int velocidadY){
    if(velocidadX == -1)
      direccion = 3;
    else if (velocidadX == 1)
      direccion = 2;

    if(velocidadY == -1)
      direccion = 1; 
    else if(velocidadY == 1)
      direccion = 0;
  }
  private boolean fueraMapa(final int velocidadX, final int velocidadY){
    int posicionFuturaX = (int) posicionX + velocidadX * (int) getVelocidad();
    int posicionFuturaY = (int) posicionY + velocidadY * (int) getVelocidad();

    //final Rectangle bordesMapa = mapa.obtenerBordes(posicionFuturaX, posicionFuturaY);

    if(LIMITE_ARRIBA.intersects(bordesMapa) || LIMITE_ABAJO.intersects(bordesMapa) || LIMITE_IZQUIERDA.intersects(bordesMapa) || LIMITE_DERECHA.intersects(bordesMapa))
      return false;
    return true;
  }

  private void animar(){
    if(!enMovimiento){
      estado = 0; 
      animacion = 0;
    }
    // Cambia la imagen de acuerdo al estado y animacion, esto con el fin de dar movimiento al personaje 
    //imagenActual = hs.obtenerSprite(direccion, estado).obtenerImagen();
  }

  private void dibujar(Graphics g){
    final int centroX = Constantes.ANCHO_PANTALLA/2 - Constantes.LADO_SPRITE/2;
    final int centroY = Constantes.ALTO_PANTALLA /2 - Constantes.LADO_SPRITE/2;
    DibujoDebug.dibujarImagen(g, imagenActual, centroX, centroY);
  }

  public void setPosicionX(double posicionX){
    this.posicionX = posicionX;
  }
  public void setPosicionY(double posicionY){
    this.posicionY = posicionY;
  }
  public double getPosicionX(){
    return this.posicionX;
  }
  public double getPosicionY(){
    return this.posicionY;
  }
  public int getAnchoJugador(){
    return ANCHO_JUGADOR;
  }
  public int getAltoJugador(){
    return ALTO_JUGADOR;
  }
  public Rectangle getLimiteArriba(){
    return LIMITE_ARRIBA;
  }
  public Aliado getAliado(){
    return this.aliado;
  }
  public int getDireccion(){
    return this.direccion;
  }
  public Point getPosicion(){
    return new Point((int)posicionX, (int)posicionY);
  }
  
/*
    GamePanel gp;

    Keyboard kb;
    BufferedImage image;
    int x;
    int y;
    int screenX;
    int screenY;
    Double speedX;
    Double speedY;
    int accel;
    int width;
    int height;
    int score;
    int vida;
    double gravity;
    Rectangle box;
    int boxDefaultX;
    int boxDefaultY;
    String direction;
    Boolean collision;
    Boolean jumping;
    Boolean talking;

    public Player(GamePanel gp, Keyboard kb){
        this.gp = gp;
        this.kb = kb;
        height = 50;
        width = 50;
        screenX = gp.getScreenWidth()/2 - width/2;
        screenY = gp.getScreenHeight()/2 - height/2;
        box = new Rectangle(50,50,width,height); //La caja es para revisar las colisiones
        boxDefaultX = box.x;
        boxDefaultY = box.y;
        collision = false;
        jumping = false;
        talking = false;
        x = 400;
        y = 140;
        speedX = 0.0;
        speedY = 0.0;
        direction = "right";
        vida = 1000;
        getEntityImage();
    }

    public void getEntityImage(){
      image = gp.getRutas().getImagen("potato.png");
    }
    public void update(){
        if(kb.pressUp() == true){
            direction = "up";
        }
        else if(kb.pressDown() == true){
            direction = "down";
        }
        else if(kb.pressRight() == true){
            direction = "right";
        }
        else if(kb.pressLeft() == true){
            direction = "left";
        }
        else{
            direction = "";
            speedX = 0.0;
            speedY = 0.0;
        }
        collision = false;
        if(gp.cc.checkWalls(this))
            collision = true;
        if(collision == false){
            switch(direction){
                case "up":
                    if(jumping){

                    }
                    else{
                    speedY = 8.0;
                    gravity = 0.2;
                    jumping = true;
                    }
                    break;
                case "down":
                    speedY = 0.0;
                    break;
                case "left":
                    speedX = (double)1*getVelocidad();
                    break;
                case "right":
                    speedX = (double)-1*getVelocidad();
                    break;
            }
            if (jumping) {
                speedY -= gravity;
            }
            y += speedY;
            x += speedX;
        }
        else{
            speedY = 0.0;
            speedX = 0.0;
            y += 1;
            jumping = false;
            collision = false;
        }
    }

    public void paint(Graphics2D g2){
        int x = screenX;
        int y = screenY;
        if(screenX > x){
            x = (int) x;
        }
        if(screenY > y){
            y = (int) y;
        }
        if((gp.getScreenWidth()-screenX)>(gp.getWorldWidth()-x)){
            x = (int) (gp.getScreenWidth()-(gp.getWorldWidth()-x));
        }
        if((gp.getScreenHeight()-screenY)>(gp.getWorldHeight()-y)){
            y = (int) (gp.getScreenHeight()-(gp.getScreenHeight()-y));
        }
        g2.drawImage(image, x, y, width, height, null);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Rectangle getBox() {
        return box;
    }
    public int getSpeed() {
        return getVelocidad();
    }
    public void setCollision(boolean b) {
        collision = b;
    }
    public int getBoxDefaultX(){
        return boxDefaultX;
    }
    public int getBoxDefaultY(){
        return boxDefaultY;
    }
    @Override
    public String getDirection() {
        return direction;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public BufferedImage getImage(){
        return image;
    }
    public int getScore() {
        return score;
    }
    public boolean isTalking() {
        return false;
    }
    public void startTalking(String mensaje){
        talking = true;
        gp.ui.talk(mensaje);
    }
  public int getAtaque(){
    return 25;
  }
  public int getVelocidad(){
    return 5;
  }
  public int getCadencia(){
    return 10;
  }
}
*/
