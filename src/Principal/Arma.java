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
    double anguloRotate;
    double anguloPadrao;
    public boolean atacou;
    public int contAtaque = 115;
    public int contAtaquePadrao = 115;
    Player portador;
    int xRotate;
    int yRotate;

    public Arma(String nome, Player portador) {
        this.nome = nome;
        this.portador = portador;
        try {
            this.imagem = new Image("resources/weapons/2h sword.png");
        } catch (SlickException ex) {
            Logger.getLogger(Arma.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.anguloRotate = this.anguloPadrao;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        this.anguloPadrao = this.portador.getAnguloRotate() - 45;
        this.x = this.portador.getX();
        this.y = this.portador.getY();
        this.xRotate = (int) this.portador.imagem.getCenterOfRotationX();
        this.yRotate = (int) this.portador.imagem.getCenterOfRotationY();

        if (this.atacou) {
            this.rotacionaImagem(gc);
            if (this.contAtaque <= 0) {
                this.atacou = false;
                this.anguloRotate = this.anguloPadrao;
            }
        } else {
            this.anguloRotate = this.anguloPadrao;
        }
        System.out.println(contAtaque);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        g.rotate(x + xRotate, y + yRotate, (float) -this.anguloRotate);
        //fazer a arma sempre ficar na mao direita
        this.imagem.draw(x + this.portador.imagem.getWidth() / 2, y + imagem.getHeight() / 2);
        g.rotate(x + xRotate, y + yRotate, (float) this.anguloRotate);
    }

    @Override
    public Shape getShape() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void rotacionaImagem(GameContainer gc) {
        this.anguloRotate += 5;
        this.contAtaque-=5;
    }
    
    public void resetContAtaque(){
        this.contAtaque = this.contAtaquePadrao;
    }
}
