package Item; 

public interface Armas {
  /* Interface encargada de la generacion de armas, esta sera implementada 
   * En las clases abstractas que posteriormente nos generaran a nuestro personaje 
   * */
  // @return int Correspondiente al daño de ataque del arma equipada
  public int getAtaque();
  // @return int Correspondiente a la velocidad del arma equipada
  public int getVelocidad();
  // @return int Correspondiente a la cadencia del arma equipada
  public int getCadencia();
  // @return int Correspondiente a la vida del arma equipada
  public int getVida();
}
