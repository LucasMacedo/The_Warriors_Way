/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas
 */
public class Fase1 extends BasicGameState{
    
    public static final int ID = 3;
    public Image img;
    GameContainer gc;
    StateBasedGame game;
    
    
    

    @Override
    public int getID() {
       return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
     
        this.img = new Image("");  
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
       
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int i) throws SlickException {
       
    }  
}
