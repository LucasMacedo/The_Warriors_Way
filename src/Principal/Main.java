/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas
 */
public class Main extends StateBasedGame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main("The Warrior's Way"));
        app.setDisplayMode(800, 600, false);
        app.setTargetFrameRate(60);
        
        app.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Main(String title){
        super(title);
    }
}
