/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Maike
 */
public class Arma extends GameObject {

    String nome;
    Image imagem;
    double anguloRotate = 90;
    double anguloPadrao;
    public boolean atacou;
    public int contAtaque = 50;
    Player portador;

    public Arma(String nome, Player portador) {
        this.nome = nome;
        this.portador = portador;
        try {
            this.imagem = new Image("resources/weapons/2h sword.png");
        } catch (SlickException ex) {
            Logger.getLogger(Arma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        this.anguloPadrao = this.portador.getAnguloRotate();
        this.x = this.portador.getX();
        this.y = this.portador.getY();

        if (this.atacou) {
            this.rotacionaImagem(gc);
            this.contAtaque--;
            if (this.contAtaque <= 0) {
                this.atacou = false;
                this.anguloRotate = this.anguloPadrao;
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        g.rotate(x, y + this.imagem.getHeight() / 2, (float) -this.anguloPadrao);
        //fazer a arma sempre ficar na mao direita
        this.imagem.draw(x, y);
        g.rotate(x, y + this.imagem.getHeight() / 2, (float) this.anguloPadrao);
    }

    @Override
    public Shape getShape() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void rotacionaImagem(GameContainer gc) {
        this.anguloRotate++;
    }
}
