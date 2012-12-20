/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Principal.Player;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor.SetterOnlyReflection;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas
 */
public class Fase1 extends BasicGameState {

    public static final int ID = 2;
    public Image img;
    public Player player;
    GameContainer gc;
    StateBasedGame game;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        this.player = new Player(100, 100, "teste");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int i) throws SlickException {
        this.processInput(gc);
        this.player.update(gc, game, i);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        this.player.render(gc, game, g);
    }

    public void processInput(GameContainer gc) {
        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
            this.player.setY(this.player.getY() - 5);
        }
        if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S)) {
            this.player.setY(this.player.getY() + 5);
        }
        if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
            this.player.setX(this.player.getX() - 5);
        }
        if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
            this.player.setX(this.player.getX() + 5);
        }
    }
}
