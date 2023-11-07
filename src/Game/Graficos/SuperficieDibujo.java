package Game.Graficos;

import java.awt.Canvas; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy; 

import Teclas.Teclado;
public class SuperficieDibujo extends Canvas {
  private int ancho; 
  private int alto; 
  public SuperficieDibujo(final int ancho, final int alto){
    this.ancho = ancho; 
    this.alto = alto; 
    setIgnoreRepaint(true);
    setPreferredSize(new Dimension(ancho, alto));
    addKeyListener(new Teclado());
    setFocusable(true);
    requestFocus();
  }
  public void dibujar(final GestorEstados ge){
    final BufferStrategy buffer = getBufferStrategy();
    if(buffer == null){
      createBufferStrategy(4);
      return; 
    }
    final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
    DibujoDebug.reiniciarContadorObjetos();
    DibujoDebug.dibujarRectanguloRelleno(g,0,0,ancho, alto);
    Toolkit.getDefaultToolkit().sync();
    g.dispose();
    buffer.show();
  }
  public int obtenerAncho(){
    return ancho;
  }
  public int obtenerAlto(){
    return alto;
  }
}
