package Principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.state.StateBasedGame;

public class Inimigo extends Personagem {

    Player player;
    int xPlayer;
    int yPlayer;

    public Inimigo(int xSpawn, int ySpawn, String nome, String arma, Player player) {
        this.player = player;
        try {
            this.imagem = new Image("resources/personagens/" + nome + ".png");
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
        this.x = xSpawn;
        this.y = ySpawn;

        this.nome = nome;

        ///testes
        this.forca = 50;
        this.velocidade = 2;
        //

        this.arma = new Arma(arma, this);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        this.arma.update(gc, game, delta);
        if (this.arma.atacou == false) {
            this.rotacionaImagem(gc);
        }

        this.xPlayer = (int)(this.player.getX()+this.player.imagem.getCenterOfRotationX());
        this.yPlayer = (int)(this.player.getY()+this.player.imagem.getCenterOfRotationY());

        double distanciaAtePlayer = Util.calculaDistancia(x, y, this.player.getX(), this.player.getY());
        if (distanciaAtePlayer < this.arma.alcance*3/4) {
            if (this.arma.atacou == false) {
                this.ataca();
            }
        } else {
            this.aproxima();
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        this.arma.render(gc, game, g);
        this.imagem.draw(x, y);
        g.draw(this.getShape());
    }

    @Override
    public Shape getShape() {
        Shape s = new Rectangle(this.x, this.y, this.imagem.getWidth(), this.imagem.getHeight());
        float angulo = (float) Math.toRadians(this.anguloRotate);
        s = s.transform(Transform.createRotateTransform(-angulo, x + this.imagem.getCenterOfRotationX(), y + this.imagem.getCenterOfRotationY()));
        return s;
    }

    public void rotacionaImagem(GameContainer gc) {
        this.anguloRotate = Util.calculaAngulo(xPlayer, x + this.imagem.getWidth() / 2, yPlayer, y + this.imagem.getHeight() / 2);
        this.imagem.setRotation((float) -this.anguloRotate);
    }

    private void ataca() {
        this.arma.atacou = true;
        this.arma.resetContAtaque();
    }

    private void aproxima() {
        if (this.player.getX() < this.x) {
            this.x -= this.velocidade;
        }
        if (this.player.getX() > this.x) {
            this.x += this.velocidade;
        }
        if (this.player.getY() < this.y) {
            this.y -= this.velocidade;
        }
        if (this.player.getY() > this.y) {
            this.y += this.velocidade;
        }
    }
}
