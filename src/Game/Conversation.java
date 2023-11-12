package Game;

import java.awt.Graphics;
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
    public void setDialogue(int d){
        dialogo = d;
    }
    public void paint(Graphics g){
        if(dialogos != null && !dialogos.isEmpty()){
            dialogos.get(dialogo).paint(g);
        }
    }
    public void update(){
        if(dialogos != null && !dialogos.isEmpty()){
            getCurrentDialogue().update();
        }
    }
    public boolean nextDialogue(){
        Dialogue d = getCurrentDialogue();
        if(!d.isTalking()){
            dialogo++;
            if(dialogo>dialogos.size()){
                dialogo = -1;
                return false;
            }
        }
        return true;
    }
    public Dialogue getCurrentDialogue() {
        if(dialogo == -1){
            return null;
        }
        return dialogos.get(dialogo);
    }
}
