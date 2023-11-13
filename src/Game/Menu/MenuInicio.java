package Game.Menu;

import javax.swing.JPanel;

import Game.Keyboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;

import res.Rutas.Rutas;
import State.Menu;
import State.InterfazUsuario;
import res.Gestor;
public class MenuInicio extends JPanel implements Runnable{
  private int screenWidth = 1000;
  private int screenHeight = 500;
  private int commandNum = 0;
  private InterfazUsuario interfaz;
  private Rutas rutas;
  private Keyboard kb;
  private final int FPS = 60;
  private Thread gameThread;
  private long ultimaPulsacion;
  private long cooldown = 200;
  boolean a = false;
  public MenuInicio(Rutas rutas, InterfazUsuario interfaz){
    kb = Gertor.kb;
    this.interfaz = interfaz;
    this.rutas = rutas;
    this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(kb);
    this.setFocusable(true);
  }

  public void startGameThread(){
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override 
  public void run(){
    double interval = 1000000000/FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime; 
    long timer = 0; 
    
    while(gameThread != null){
      currentTime = System.nanoTime();
      delta += (currentTime -lastTime)/interval; 
      timer += (currentTime - lastTime);
      lastTime = currentTime; 
      if(delta >= 1){
        update();
        repaint();
        delta--;
      }
      if(timer >= 1000000000){
          timer = 0;
      }
    }
  }

  public void update(){
    long time = System.currentTimeMillis();
      if(time > ultimaPulsacion + cooldown){
        if(kb.pressUp()){
          commandNum--;
          if(commandNum < 0){
            commandNum = 3;
          }
        }
        if(kb.pressDown()){
          commandNum++;
          if(commandNum > 3){
            commandNum = 0;
          }
        }
        if(kb.pressEnter()){
          switch (commandNum) {
            case 0:
              interfaz.jugar();
              gameThread.interrupt();
              break;
            case 1:
              ((Menu)interfaz.getEstado()).reglas();
              gameThread.interrupt();
              break;
            case 2: 
              ((Menu)interfaz.getEstado()).creditos();
              gameThread.interrupt();
              break;
            case 3: 
              System.exit(0);
              break;
            default:
              break;
          }
        }
    ultimaPulsacion = time;
    }
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.black);
    g2.drawImage(rutas.getImagen("MenuImagen.png"), 0, 0, screenWidth, screenHeight, null);
    g2.setFont(new Font("Impact", Font.BOLD, 30 ));    
    g2.setColor(Color.WHITE);
    int x = 100;
    int y = 100;
    g2.drawString("JUGAR",x,y);
    if(commandNum == 0){
      g2.drawString(">", x-20, y);
    }
    y += 50;
    g2.drawString("REGLAS", x, y);
    if(commandNum == 1){
      g2.drawString(">", x-20, y);
    }
    y += 50;
    g2.drawString("CREDITOS", x, y);
    if(commandNum == 2){
      g2.drawString(">", x-20, y);
    }
    y += 50;
    g2.drawString("SALIR", x, y);
    if(commandNum == 3){
      g2.drawString(">", x-20, y);
    }
    g2.dispose();
  }
}
