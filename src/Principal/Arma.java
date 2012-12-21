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
    public boolean atacou;
    int contAtaque = 500;

    public Arma(String nome) {
        this.nome = nome;
        try {
            this.imagem = new Image("resources/weapons/2h sword.png");
        } catch (SlickException ex) {
            Logger.getLogger(Arma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        if (this.atacou) {
            this.rotacionaImagem(gc);
            this.contAtaque --;
            if(this.contAtaque <= 0){
                this.atacou = false;
            }
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        this.imagem.draw(10, 10);
    }

    @Override
    public Shape getShape() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void rotacionaImagem(GameContainer gc) {
        this.anguloRotate ++;
        this.imagem.setRotation((float) -this.anguloRotate);
    }
}
