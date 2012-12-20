/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Maike
 */

public abstract class GameObject {
    protected Direcao direcao;
    
    protected int x;
    protected int y;
    
    public abstract void update(GameContainer gc, StateBasedGame game, int delta);

    public abstract void render(GameContainer gc, StateBasedGame game, Graphics g);
    
    // Movimentação no eixo Y -  Cima e Baixo
    public void moveCima(int valor){
        direcao = Direcao.CIMA;
        this.y += valor;
    }
    
    public void moveBaixo(int valor){
        direcao = Direcao.BAIXO;
        this.y -= valor;
    }

    // Movimentações no eixo X - Direita e Esquerda
    public void moveDireita(int valor){
        direcao =  Direcao.DIREITA;
        this.x += valor;
    }
    
    public void moveEsquerda (int valor){
        direcao =  Direcao.ESQUERDA;
        this.x -= valor;
    }
    
    // Pega X e Y
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
