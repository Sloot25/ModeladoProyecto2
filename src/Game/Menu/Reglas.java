package Game.Menu;

import javax.swing.JPanel;

import Game.Keyboard;
import res.Gestor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;

import res.Rutas.Rutas;
import State.Menu;
public class Reglas extends JPanel implements Runnable{
  private int screenWidth = 1000;
  private int screenHeight = 500;
  private Menu menu;
  private Rutas rutas;
  private Keyboard kb;
  private final int FPS = 60;
  private Thread gameThread;
  public Reglas(Rutas rutas, Menu menu){
    kb = Gestor.kb;
    this.menu = menu;
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
    if(kb.pressEnter()){
        menu.menuInicio();
        gameThread.interrupt();
    }
    
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.black);
    g2.drawImage(rutas.getImagen("Reglas.png"), 0, 0, screenWidth, screenHeight, null);
    g2.setFont(new Font("Impact", Font.BOLD, 20 ));    
    g2.setColor(Color.WHITE);
    int x = 100;
    int y = 100;
    g2.drawString("Ciudad Universitaria ha sido invadida por las chinches",x,y);
    y += 30;
    g2.drawString("Es tu deber acabar con las chinches para restaurar la paz en CU", x, y);
    y += 30;
    g2.drawString("Para moverte utiliza las teclas", x, y);
    y += 30;
    g2.drawString("Para disparar utiliza A y D", x, y);
    y += 30;
    g2.drawString("Para subir y bajar escaleras utiliza W y S respectivamente", x, y);
    y += 30;
    g2.drawString("Para mejorar tus habilidades busca a los profesores y ayudantes y presiona Q al interactuar", x, y);
    y += 30;
    g2.drawString("Para llamar a un aliado por ayuda presiona 1", x, y);
    y += 30;
    g2.drawString("Puedes poner pausa usando Esc", x, y);
    y += 30;
    g2.drawString("> Regresar", 800, y);
    g2.dispose();
  }
}
