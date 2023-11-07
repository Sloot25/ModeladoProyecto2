package Game;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Entity.NPC;

public class Dialogue {
    String dialogo, dialogoTemp;
    Conversation conversation;
    ArrayList<String> lines;
    NPC npc;
    boolean talking;
    int delay, line, length, numLines, size;

    public Dialogue(NPC npc, Conversation conversation, String dialogo){
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
    public int finish(){
        int i = 0; line = 1;
        while(i)
    }
    public void paint(Graphics2D g2) {

    }
    public boolean isFinished(){
        return dialogoTemp.length()==dialogo.length();
    }
    public String getCurrentLine(){
        return lines.get(line-1);
    }
    public void setCurrentLine(String temp){
        lines.set(line-1, temp);
    }
    
}
