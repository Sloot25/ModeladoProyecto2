package Game;

import java.awt.Dialog;
import java.awt.Graphics2D;
import java.util.ArrayList;


import Entity.NPC;

public class Conversation {
    ArrayList<Dialogue> dialogos;
    boolean available, finished;
    NPC npc;
    int dialogo;
    /*
     * Constructor de la conversacion
     * @param npc NPC con el que se tiene la conversacion
     * @param disponible 
     */
    public Conversation(NPC npc, boolean available){
        dialogos = new ArrayList<Dialogue>();
        this.npc = npc;
        this.available = available;
        finished = false;
        dialogo = -1;
    }
    public void setNPC(NPC npc){
        this.npc = npc;
    }
    public NPC getNPC(){
        return npc;
    }
    public void setAvailable(boolean avalailable){
        this.available = avalailable;
    }
    public boolean isAvailable(){
        return available;
    }
    public void setFinished(boolean finished){
        this.finished = finished;
    }
    public boolean isFinished(){
        return finished;
    }
    public void addDialogue(Dialogue dialogo){
        dialogos.add(dialogo);
    }
    public void removeDialogue(int d){
        dialogos.remove(d);
    }
    public Dialogue getDialogue(int d){
        return dialogos.get(d);
    }
    public void paint(Graphics2D g2){
        if(dialogos != null && !dialogos.isEmpty()){
            dialogos.get(dialogo).paint(g2);
        }
    }
    public void update(Graphics2D g2){
        if(dialogos != null && !dialogos.isEmpty()){
            getCurrentDialogue().update();
        }
    }
    public Dialogue getCurrentDialogue() {
        if(dialogo == -1){
            return null;
        }
        return dialogos.get(dialogo);
    }
}
