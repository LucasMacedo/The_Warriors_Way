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
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
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
    Personagem portador;
    int xRotate;
    int yRotate;
    float peso;
    float velocidadeDeAtaque;
    int alcance;

    public Arma(String nome, Personagem portador) {
        this.nome = nome;
        this.portador = portador;
        try {
            this.imagem = new Image("resources/weapons/"+nome+".png");
        } catch (SlickException ex) {
            Logger.getLogger(Arma.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.anguloRotate = this.anguloPadrao;
        this.peso = imagem.getHeight()*imagem.getWidth()/100f;
      //  this.velocidadeDeAtaque = portador.getForca()/this.peso;
        this.velocidadeDeAtaque = ( (float) portador.getForca() ) / this.peso;
        this.alcance = this.imagem.getWidth();
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
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        g.rotate(x + xRotate, y + yRotate, (float) -this.anguloRotate);
        //fazer a arma sempre ficar na mao direita
        this.imagem.draw(x + this.portador.imagem.getWidth() / 2, y + imagem.getHeight() / 2);
        g.rotate(x + xRotate, y + yRotate, (float) this.anguloRotate);
        g.draw(this.getShape());
    }

    @Override
    public Shape getShape() {
        Shape s = new Rectangle(x + this.portador.imagem.getWidth() / 2, y + imagem.getHeight() / 2, this.imagem.getWidth(), this.imagem.getHeight());
        float angulo = (float) Math.toRadians(this.anguloRotate);
        s = s.transform(Transform.createRotateTransform(-angulo, x + xRotate, y + yRotate));
        return s;
    }

    public void rotacionaImagem(GameContainer gc) {
        this.anguloRotate += velocidadeDeAtaque;
        this.contAtaque-=velocidadeDeAtaque;
    }
    
    public void resetContAtaque(){
        this.contAtaque = this.contAtaquePadrao;
    }
}
