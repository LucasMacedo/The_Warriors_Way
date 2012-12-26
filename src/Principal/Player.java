package Principal;

import Itens.Arma;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Personagem {

    public int offsetx;
    public int offsety;

    public Player(String nome, String arma) {
        try {
            this.imagem = new Image("resources/personagens/player.png");
        } catch (SlickException ex) {
            ex.printStackTrace();
        }

        this.nome = nome;
        this.mochila = new Mochila(10);


        ///testes
        this.vida = 100;
        this.forca = 50;
        this.destreza = 75;
        this.peso = this.imagem.getWidth() * this.imagem.getHeight() / 5;

        this.arma = new Arma(arma, this);

        this.velocidade = this.destreza / ((this.peso / 3) + (this.arma.getPeso() / 2));
        if (this.velocidade < 1) {
            this.velocidade = 1;
        }
        //75/(62/3)+(8/5) = 75/20.6+1.6 = 75/22.2 = 3.3
        //75/(62/3)*(8/5) = 75/20.6*1.6 = 75/33 = 2.2
        //por ser player, velocidade aumenta
        this.velocidade += 1;
        //
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        this.arma.update(gc, game, delta);
        if (this.atacou == false && this.parado == false) {
            this.rotacionaImagem(gc);
        }
        if (this.contParado > 0) {
            this.contParado--;
            if (this.contCaiParaTras > 0) {
                this.contCaiParaTras--;
                this.caiParaTras();
            }
        } else {
            this.parado = false;
        }

        if (this.contDanoLevado > 0) {
            this.contDanoLevado--;
        } else {
            this.danoLevado = 0;
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        this.arma.render(gc, game, g);
        this.imagem.draw(this.x, this.y);
        if (this.danoLevado > 0) {
            this.desenhaDano(g);
        }
    }

    private void caiParaTras() {
        this.offsetx -= this.distanciaQuedaParaTrasX;
        this.offsety -= this.distanciaQuedaParaTrasY;
    }

    @Override
    public Shape getShape() {
        Shape s = new Rectangle(this.x, this.y, this.imagem.getWidth(), this.imagem.getHeight());
        float angulo = (float) Math.toRadians(this.anguloRotate);
        s = s.transform(Transform.createRotateTransform(-angulo, x + this.imagem.getCenterOfRotationX(), y + this.imagem.getCenterOfRotationY()));
        return s;
    }

    public void rotacionaImagem(GameContainer gc) {
        int xMouse = gc.getInput().getMouseX();
        int yMouse = gc.getInput().getMouseY();
        this.anguloRotate = Util.calculaAngulo(xMouse, x + this.imagem.getWidth() / 2, yMouse, y + this.imagem.getHeight() / 2);
        this.imagem.setRotation((float) -this.anguloRotate);
    }

    public double getAnguloRotate() {
        return anguloRotate;
    }
}
