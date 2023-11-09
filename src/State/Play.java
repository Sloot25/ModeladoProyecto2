package State;

import res.Constantes;
public class Play implements State {
  private InterfazUsuario interfaz; 
  private boolean enFuncionamiento;
  private SuperficieDibujo sd; 
  private Ventana ventana; 

  private int aps = 0; 

  public Play(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  public void inicializarEstado(){
    System.setProperty("sun.java2d.openg1", "True");

    this.iniciarJuego();
  }
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
  }
  public void jugar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPlay());
  }
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
  }

  private void iniciarJuego(){
    enFuncionamiento = true;
    inicializar();
    // Deberiamos inicializar la musica de igual forma aqui 
  }

  private void inicializar(){
    sd = new SuperficieDibujo(Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA);
    ventana = new Ventana(titulo, sd);
    interfaz.cambiar(sd);
  }

  private void iniciarBuclePrincipal(){
    int actualizacionesAcumuladas = 0; 
    int frameAcumulados = 0;

    final int NS_POR_SEGUNDO = 1000000000;
    final int APS_OBJETIVO = 60; 
    final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

    long referenciaActualizacion = System.nanoTime();
    long referenciaContador = System.nanoTime();

    double tiempoTranscurrido;
    double delta = 0; 

    while(enFuncionamiento){
      final long inicioBucle = System.nanoTime();
      
      tiempoTranscurrido = inicioBucle - referenciaActualizacion; 
      referenciaActualizacion = inicioBucle; 

      delta += tiempoTranscurrido / NS_POR_ACTUALIZACION; 

      while(delta >= 1){
        actualizar();
        actualizacionesAcumuladas++; 
        delta--; 
      }
      dibujar();
      frameAcumulados++; 

      if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
        aps = actualizacionesAcumuladas; 
        actualizacionesAcumuladas = 0; 
        frameAcumulados = 0;
        referenciaContador = System.nanoTime();
      }
    }
  }

  private void actualizar(){
    //if(Gestor.teclado.inventarioActivo)

    interfaz.actualizar();
    sd.actualizar();

  }

  private void dibujar(){
    sd.dibujar(interfaz);
  }
    
}
