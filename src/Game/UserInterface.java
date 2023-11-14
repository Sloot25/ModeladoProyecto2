package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UserInterface {
    GamePanel gp;
    int messageCounter;
    Boolean messageOn;
    String message;
    public UserInterface(GamePanel gp){
        this.gp = gp;
        messageCounter = 0;
        messageOn = false;
        message = "";
    }
    public void talk(String message){
        messageOn = true;
        this.message = message;
    }
    /*
     * Constantemente muestra tu vida, puntuación, etc
     * @param Graphics2D g2
     */
    public void paint(Graphics2D g2) {
        showLife(g2);
        showScore(g2);
        if(messageOn == true)
            showMessage(g2, message);
    }
    /*
     * Muestra la vida actual del jugador 
     * @param Graphics2D g2
     */
    public void showLife(Graphics2D g2){
        int vida = gp.player.getLife();
        BufferedImage image = gp.player.getImage();
        g2.setColor(Color.BLUE);
        g2.drawOval(-gp.camx+50, -gp.camy+50, 50, 50);
        g2.drawImage(image, -gp.camx+55, -gp.camy+55, 40, 40, null);
        g2.setColor(Color.RED);
        g2.fillRoundRect(-gp.camx+100, -gp.camy+65, 400, 20, 20, 20);
        g2.setColor(Color.BLUE);
        g2.fillRoundRect(-gp.camx+100, -gp.camy+65, vida * 400 / 1000 ,20 , 20, 20);
        g2.drawRoundRect(-gp.camx+100, -gp.camy+65, 400, 20, 20, 20);
    }
    /*
     * Muestra la puntuación actual del jugador
     * @param Graphics2d g2
     */
    public void showScore(Graphics2D g2){
        int score = gp.player.getScore();
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 30));
        g2.drawString("SCORE: "+score, -gp.camx+gp.getScreenWidth() - 200, -gp.camy+85);
    }
    /*
     * Muestra los mensajes que los npcs le comentan al jugador
     */
    public void showMessage(Graphics2D g2, String mensaje){
        g2.setColor(Color.GRAY);
        g2.fillRoundRect(-gp.camx+100,-gp.camy+gp.getScreenHeight() - 200 , gp.getScreenWidth()-200, 150, 50, 50);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(-gp.camx+100,-gp.camy+gp.getScreenHeight() - 200 , gp.getScreenWidth()-200, 150, 50, 50);
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.drawString(mensaje, -gp.camx+150, -gp.camy+gp.getScreenHeight() - 150 );
        messageCounter++;
        if(messageCounter > 120){
            messageCounter = 0;
            messageOn = false;
        }
    }
}
