
package GameState;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class TelaHistoria extends BasicGameState {

     public static final int ID = 2;
     GameContainer gc;
     StateBasedGame game;
     Image img;
     
    
    
     
    @Override
    public int getID() {
       return ID; 
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        this.gc =  gc;
        this.game = game;
        
        this.img = new Image("resources/pergaminho.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        this.img.drawCentered(gc.getWidth()/2, gc.getHeight()/2);
        
        g.setColor(Color.red);
        g.drawString("The Warrior's Way",gc.getWidth()/2-90,50);
        g.drawString("Historia se passa em um reino,uma ",gc.getWidth()/2-160,100);
        g.drawString("terra medieval, governada por um rei,",gc.getWidth()/2-190,120);
        g.drawString("governada por um rei,sendo reino mt prospero",gc.getWidth()/2-190,140);
               
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
       
    }
    
    public void keyPressed (int key , char c){
        
        if(key == Input.KEY_ENTER){
            this.game.enterState(Fase1.ID,new FadeOutTransition(Color.black),new FadeInTransition(Color.white));
        }
    }
    
}
