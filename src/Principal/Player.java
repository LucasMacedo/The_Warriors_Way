package Principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends GameObject{

    String nome;
    Image imagem;
    
    public Player(int x, int y, String nome){
        try {
            this.imagem = new Image("resources/player.png");
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
        this.x = x;
        this.y = y;
        
        this.nome = nome;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        this.imagem.draw(this.x, this.y);
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
}
