/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

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
    ///   int offsetx;
    ///  int offsety;
    Inimigo inimigo;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        int xSpawn = gc.getWidth() / 2;
        int ySpawn = gc.getHeight() / 2;
        this.player = new Player("teste", "1h axe");
        this.inimigo = new Inimigo(100, 100, "orc", "2h axe", this.player);
        this.mapa = new Mapa("mapa teste");
                
        this.player.setX(xSpawn);
        this.player.setY(ySpawn);
        
        this.player.offsetx = -xSpawn;
        this.player.offsety = -ySpawn;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int i) throws SlickException {
        this.processInput(gc);
        this.moveMapa();
        this.player.update(gc, game, i);
        this.inimigo.update(gc, game, i);

        if (this.player.contCaiParaTras > 0) {
            this.inimigo.setX(this.inimigo.getX()-(int)this.player.distanciaQuedaParaTrasX);
            this.inimigo.setY(this.inimigo.getY()-(int)this.player.distanciaQuedaParaTrasY);
        }
        
        this.verificaColisao();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        this.mapa.render(gc, game, g);
        this.inimigo.render(gc, game, g);
        this.player.render(gc, game, g);        
    }

    public void processInput(GameContainer gc) {
        Input input = gc.getInput();
        if (this.player.atacou == false && this.player.parado == false) {
            if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
                //this.mapa.setY(this.mapa.getY() + this.player.getVelocidade());
                this.inimigo.setY(this.inimigo.getY() + this.player.getVelocidade());
                this.player.offsety += this.player.getVelocidade();
                //this.player.setY(this.player.getY() - 5);
            }
            if (input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S)) {
                //  this.mapa.setY(this.mapa.getY() - this.player.getVelocidade());
                this.inimigo.setY(this.inimigo.getY() - this.player.getVelocidade());
                this.player.offsety -= this.player.getVelocidade();
                //this.player.setY(this.player.getY() + 5);
            }
            if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
                //     this.mapa.setX(this.mapa.getX() + this.player.getVelocidade());
                this.inimigo.setX(this.inimigo.getX() + this.player.getVelocidade());
                this.player.offsetx += this.player.getVelocidade();
                //this.player.setX(this.player.getX() - 5);
            }
            if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
                //       this.mapa.setX(this.mapa.getX() - this.player.getVelocidade());
                this.inimigo.setX(this.inimigo.getX() - this.player.getVelocidade());
                this.player.offsetx -= this.player.getVelocidade();
                //this.player.setX(this.player.getX() + 5);
            }

            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                this.player.atacou = true;
                this.player.getArma().resetContAtaque();
            }
        }
    }

    public void verificaColisao() {
        if (this.player.atacou) {
            if (this.player.getArma().getShape().intersects(this.inimigo.getShape()) || this.player.getArma().getShape().contains(this.inimigo.getShape())) {
                if (!this.player.getArma().getInimigosAcertados().contains(this.inimigo)) {
                    this.player.getArma().acerta(this.inimigo);
                    this.inimigo.levaDano(10, this.player.getAnguloRotate());
                }
            }
        }
        if (this.inimigo.atacou) {
            if (this.inimigo.getArma().getShape().intersects(this.player.getShape()) || this.inimigo.getArma().getShape().contains(this.player.getShape())) {
                if (!this.inimigo.getArma().getInimigosAcertados().contains(this.player)) {
                    this.inimigo.getArma().acerta(player);
                    this.player.levaDano(10, this.inimigo.getAnguloRotate());
                }
            }
        }
    }

    private void moveMapa() {
        this.mapa.setX(this.player.offsetx);
        this.mapa.setY(this.player.offsety);        
    }
}