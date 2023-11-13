package Game.Menu;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import res.Rutas.Rutas;
import State.State;
public class MenuInicio extends JPanel implements Runnable{
  private int screenWidth = 1000;
  private int screenHeight = 500;
  private State estadoActual;
  private Rutas rutas;
  private final int FPS = 60;
  private Thread gameThread;
  public MenuInicio(Rutas rutas, State estadoActual){
    this.estadoActual = estadoActual;
    this.rutas = rutas;
    this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    //this.addKeyListener(new KeyBoard());
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
    
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.black);
    g2.drawImage(rutas.getImagen("MenuImagen.png"), 0, 0, screenWidth, screenHeight, null); 
    g2.dispose();
  }
}
