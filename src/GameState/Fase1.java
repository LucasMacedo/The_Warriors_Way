/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Principal.Arma;
import Principal.Inimigo;
import Principal.Mapa;
import Principal.Player;
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

    public static final int ID = 3;
    Mapa mapa;
    public Image img;
    public Player player;
    GameContainer gc;
    StateBasedGame game;
    int offsetx;
    int offsety;
    Inimigo inimigo;
    
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        int xSpawn = gc.getWidth() / 2;
        int ySpawn = gc.getHeight() / 2;
        this.player = new Player(xSpawn, ySpawn, "teste", "2h sword");
        this.inimigo = new Inimigo(100, 100, "goblin", "1h sword", this.player);
        this.mapa = new Mapa("mapa teste");
        this.offsetx = xSpawn;
        this.offsety = ySpawn;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int i) throws SlickException {
        this.processInput(gc);
        this.player.update(gc, game, i);
        this.inimigo.update(gc, game, i);        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        this.mapa.render(gc, game, g);
        this.player.render(gc, game, g);
        this.inimigo.render(gc, game, g);
    }

    public void processInput(GameContainer gc) {
        Input input = gc.getInput();
        if (this.player.getArma().atacou == false) {
            if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
                this.mapa.setY(this.mapa.getY() + this.player.getVelocidade());
                this.inimigo.setY(this.inimigo.getY() + this.player.getVelocidade());
                this.offsety -= this.player.getVelocidade();
                //this.player.setY(this.player.getY() - 5);
            }
            if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S)) {
                this.mapa.setY(this.mapa.getY() - this.player.getVelocidade());
                this.inimigo.setY(this.inimigo.getY() - this.player.getVelocidade());
                this.offsety += this.player.getVelocidade();
                //this.player.setY(this.player.getY() + 5);
            }
            if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
                this.mapa.setX(this.mapa.getX() + this.player.getVelocidade());
                this.inimigo.setX(this.inimigo.getX() + this.player.getVelocidade());
                this.offsetx -= this.player.getVelocidade();
                //this.player.setX(this.player.getX() - 5);
            }
            if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
                this.mapa.setX(this.mapa.getX() - this.player.getVelocidade());
                this.inimigo.setX(this.inimigo.getX() - this.player.getVelocidade());
                this.offsetx += this.player.getVelocidade();
                //this.player.setX(this.player.getX() + 5);
            }

            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                this.player.getArma().atacou = true;
                this.player.getArma().resetContAtaque();
            }
        }
    }
}
