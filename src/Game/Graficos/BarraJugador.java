package Game.Graficos; 

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Rectangle; 

import res.Constantes;
public class BarraJugador {
  private Rectangle areaInventario;
  private Rectangle borderAreaInventario; 
  
  // Los colores que llevara la barra de vida;
  private Color negroDesaturado;
  private Color verdeOscuro;
  private Color rojoOscuro;
  private Color rojoClaro; 
  private Color azulClaro; 
  private Color azulOscuro; 
  private Color rosaClaro; 
  private Color rosaOscuro;
  public BarraJugador(){
    int altoMenu = 64; 
    areaInventario = new Rectangle(0, Constantes.ALTO_PANTALLA - altoMenu, Constantes.ANCHO_PANTALLA, altoMenu);
    borderAreaInventario = new Rectangle(areaInventario.x, areaInventario.y-1, areaInventario.width, 1);

    negroDesaturado = new Color(23,23,23);
    rojoOscuro = new Color(150,0,0);
    verdeOscuro = new Color(0,150,0);


  }

  public void dibujar(final Graphics g){
    dibujarBarraVitalidad(g);
  }

  private void dibujarBarraVitalidad(final Graphics g){
    final int medidaVertical = 4; 
    final int anchoTotal = 100;

    DibujoDebug.dibujarRectanguloRelleno(g. areaInventario.x + 35, areaInventario.y + medidaVertical, anchoTotal, rojoOscuro);
  }
}
