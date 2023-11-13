package Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import Aliados.Telefono;
import Entity.Enemy;
import Entity.Entity;
import Entity.NPC;
import Entity.Player;
import Item.Item;
import State.State;
import State.Pause;
import State.Play;
import res.Rutas.Rutas;

public class GamePanel extends JPanel implements Runnable{
    int screenWidth = 1000;
    int screenHeight = 500;
    int scale = 6;
    int worldWidth = 1000*scale;
    int worldHeight = 200*scale;
    int fps = 60;
    int camx;
    int camy;
    Rutas rutas;
    public CollisionChecker cc ;
    public Keyboard kb;
    public AssetSetter as;
    public SoundPlayer sp ;
    public LevelCreator lc;
    public UserInterface ui ;
    public Player player;
    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<NPC> npcs = new ArrayList<NPC>();
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public Telefono telefono;
    State estadoActual;
    Thread gameThread;


    public GamePanel(Rutas rutas, State estadoActual) throws CloneNotSupportedException{
        this.estadoActual = estadoActual;
        this.rutas = rutas;
        cc = new CollisionChecker(this);
        kb = new Keyboard(this);
        as = new AssetSetter(this);
        sp = new SoundPlayer(this);
        ui = new UserInterface(this);
        player = new Player(this, kb);
        lc = new LevelCreator(this);
        telefono = new Telefono(this, player, kb);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kb);
        this.setFocusable(true);
    }
    /*
     * Coloca las entidades y objetos en el mapa, así como preparar lo que sea necesario
     */
    public void setGame(){;
        as.setItems();
        sp.agregarAudio("Pista2.wav");
        sp.play(0);
    }
    /*
     * Inicia el hilo de ejecución
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    /*
     * Mientras se este ejecutando el juego, este metodo debera actualizar y repintar el juego
     */
    @Override
    public void run() {
        double interval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
            if(timer >= 1000000000){
                timer = 0;
            }
        }
    }
    /*
     * Actualiza la posición y sprites de las entidades y objetos del juego
     */
    public void update(){   
      if(kb.pressEsc()){
        if(getEstado() instanceof Play)
          lanzarPausa();
        else if(getEstado() instanceof Pause){
          System.out.println("Despausate sesamo");
          lanzarPlay();
        }
      }
      if(player.getLife() <= 0){
        System.out.println("te moriste bro");
      }
      else if(estadoActual instanceof Pause){
        System.out.println("le pausaste bro");
      }
      else if(estadoActual instanceof Play){
        //System.out.println("Le despausaste bro");
        player.update();
        lc.update();
        telefono.update();
        camx = -player.getX()+getWidth()/2;
        camy = -player.getY()+getHeight()/2;
       // checkVidaEnemys();
        checkVida();
      }
    }
    public void lanzarPausa(){
      estadoActual.pausar();
      estadoActual.inicializar();
    }
    public void lanzarPlay(){
      estadoActual.jugar();
    }
    /*
     * Pinta el mapa, así como todos los objetos y entidades en el rango de la pantalla
     */
  
    public void paintComponent(Graphics g){
      if(player.getLife() <= 0){
        g.drawImage(getRutas().getImagen("youdied.png"), camx-getScreenWidth()/2,camy-getScreenHeight(), null);
      }
      if(estadoActual instanceof Pause){
        g.setColor(Color.black);
        g.fillRect(0,0,getWorldWidth(), getWorldHeight());
        g.setColor(Color.RED);
        g.setFont(new Font("Papyrus", Font.PLAIN, 100));
        sp.stop(0);
        g.drawString("PAUSA",camx-50, camy-50);
      }else{
        g.translate(camx, camy);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        lc.paint(g2);
        for(Entity npc: npcs){
            npc.paint(g2);
        }
        for(int i = 0; i < enemies.size(); i ++){
            enemies.get(i).paint(g2);
        }
        for(Item item: items){
            item.paint(g2);
        }
        player.paint(g2);
        ui.paint(g2);
        telefono.paint(g2);
        g2.dispose();
      }
    }

    
    private void checkVida(){
      if(player.getLife() <= 0)
        estadoActual.morir();
    }
    /*
     * Regresa el estado actual
     * @return State estadoActual
     */
    public State getEstado() {
        return estadoActual;
    }
    public void setEstado(State estadoActual){
      this.estadoActual = estadoActual;
    }
    /*
     * Regresa la altura del mundo
     * @return int 
     */
    public int getWorldHeight() {
        return worldHeight;
    }
    /*
     * Regresa la altura de la pantalla, lo que puede ver el jugador
     * @return int 
     */
    public int getScreenHeight() {
        return screenHeight;
    }
    /*
     * Regresa el ancho del mundo
     * @return int
     */
    public int getWorldWidth() {
        return worldWidth;
    }
    /*
     * Regresa el ancho de la pantalla, lo que puede ver el jugador
     * @return int
     */
    public int getScreenWidth() {
        return screenWidth;
    }
    public int getScale(){
        return scale;
    }
  public Rutas getRutas(){
    return this.rutas;
  }
    
}
