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
    dibujarPuntos(g);
    dibujarRanuraObjetos(g);
  }

  private void dibujarBarraVitalidad(final Graphics g){
    final int medidaVertical = 4; 
    final int anchoTotal = 100;

    DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical, anchoTotal, rojoClaro);
    DibujoDebug.dibujarRectanguloRelleno(g, areaInventario.x + 35, areaInventario.y + medidaVertical * 2, anchoTotal, medidaVertical, rojoOscuro);
    
    g.setColor(Color.white);
    
    DibujoDebug.dibujarString(g, "Health", areaInventario.x + 10, areaInventario.y + medidaVertical*3,);
    DibujoDebug.dibujarString(g, "1000",anchoTotal + 45, areaInventario.y + medidaVertical*3);
  }
  private void dibujarPuntos(final Graphics g){
    final int medidaVertical = 4; 
    //DibujoDebug.dibujarString(g, "Puntos: " + AquiDebemosReferenciarAljugador, areaInventario.x + 10,areaInventario.y +medidaVertical * 15, Color.white);
  }
  // Sera ocupadoncomo ranura del ayudante 
  private void dibujarRanuraObjetos(final Graphics g){
    final int anchoRanura = 32; 
    final int numeroRanuras = 1;
    final int espaciadoRanuras = 10; 
    final int anchoTotal = anchoRanura*numeroRanuras + espaciadoRanuras*numeroRanuras; 
    final int xInicial = Constantes.ANCHO_PANTALLA - anchoTotal;
    final int anchoRanuraYEspacio = anchoRanura + espaciadoRanuras; 
    g.setColor(Color.white);
    for(int i = 0; i < numeroRanuras; i++){
      int xActual = xInicial + anchoRanuraYEspacio*i; 
      Rectangle ranura = new Rectangle(xActual, areaInventario.y + 4, anchoRanura, anchoRanura);
      DibujoDebug.dibujarRectanguloRelleno(g,ranura);
      DibujoDebug.dibujarString(g, "" + i, xActual + 13, areaInventario.y + 54);
    }
  }
}
