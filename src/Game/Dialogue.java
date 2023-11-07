package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Entity.NPC;

public class Dialogue {
    GamePanel gp;
    String dialogo, dialogoTemp;
    Conversation conversation;
    ArrayList<String> lines;
    NPC npc;
    boolean talking;
    int delay, line, length, numLines, size;

    public Dialogue(GamePanel gp, NPC npc, Conversation conversation, String dialogo){
        this.gp = gp;
        this.npc = npc;
        this.conversation = conversation;
        this.dialogo = dialogo;
        dialogoTemp = "";
        lines = new ArrayList<String>();
        lines.add("");
        line = 1;
        delay = 0;
        if(dialogo.length() < size){
            length = dialogo.length();
        }
        else{
            length = size;
        }
        numLines = dialogo.length()/size + 1;
    }

    public void update() {
        if(!isFinished()){
            if(delay == 5){
                int i = 0;
                String temp = dialogo.substring(i, i+1);
                dialogoTemp += temp;
                i++; 
                delay = 0;
                if(i%size == 0){
                    setCurrentLine(getCurrentLine() + temp);
                    lines.add("");
                    numLines++;
                }
                else{
                    setCurrentLine(getCurrentLine() + temp );
                }
            }
            else{
                delay++;
            }
            talking = true;
        }
        else{
            delay = 0;
            talking = false;
        }
    }
    public void finish(){
        int i = 0; line = 1;
        while(i<dialogo.length()){
            if(i+size>=dialogo.length()){
                dialogoTemp = dialogo.substring(i, dialogo.length());
                setCurrentLine(dialogoTemp);
            }
            else{
                dialogoTemp = dialogo.substring(i, i+size);
                setCurrentLine(dialogoTemp);
                lines.add("");
                numLines++;
            }
            i+=size;
        }
        dialogoTemp = dialogo;
        talking = false;
        delay = 0; i = 0;
    }

    public void paint(Graphics2D g2) {        
        g2.setColor(Color.GRAY);
        g2.fillRoundRect(gp.getScreenWidth()/2-size*8,120 , size*16, 45*numLines, 50, 50);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(gp.getScreenWidth()/2-size*8,120 , size*16, 45*numLines, 50, 50);
        g2.setFont(new Font("Arial", Font.PLAIN, 35));
        for(int i = 0; i < line; i++){
            g2.drawString(lines.get(i), gp.getScreenWidth()/2 - (length*4-40), 150+i*35 );
        }
    }
    public boolean isFinished(){
        return dialogoTemp.length()==dialogo.length();
    }
    public boolean isTalking(){
        return talking;
    }
    public String getCurrentLine(){
        return lines.get(line-1);
    }
    public void setCurrentLine(String temp){
        lines.set(line-1, temp);
    }
    
}
