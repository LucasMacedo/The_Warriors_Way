package Principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends GameObject {

    String nome;
    Image imagem;
    int velocidade = 3;
    double anguloRotate;
    Arma arma;

    public Player(int xSpawn, int ySpawn, String nome, String arma) {
        try {
            this.imagem = new Image("resources/personagens/player.png");
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
        this.x = xSpawn;
        this.y = ySpawn;

        this.nome = nome;
        this.arma = new Arma(arma, this);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        this.arma.update(gc, game, delta);
        if (this.arma.atacou == false) {
            this.rotacionaImagem(gc);
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        this.arma.render(gc, game, g);
        this.imagem.draw(this.x, this.y);
        //  g.draw(this.getShape());
    }

    @Override
    public Shape getShape() {
        Shape s = new Rectangle(this.x, this.y, this.imagem.getWidth(), this.imagem.getHeight());
        s = s.transform(Transform.createRotateTransform((float) -this.anguloRotate, x + this.imagem.getCenterOfRotationX(), y + this.imagem.getCenterOfRotationY()));
        return s;
    }

    public void rotacionaImagem(GameContainer gc) {
        int xMouse = gc.getInput().getMouseX();
        int yMouse = gc.getInput().getMouseY();
        this.anguloRotate = Util.calculaAngulo(xMouse, x + this.imagem.getWidth() / 2, yMouse, y + this.imagem.getHeight() / 2);
        this.imagem.setRotation((float) -this.anguloRotate);
    }

    public String getNome() {
        return nome;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double getAnguloRotate() {
        return anguloRotate;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
}
