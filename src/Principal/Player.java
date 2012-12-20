package Principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends GameObject{

    String nome;
    Image imagem;
    
    public Player(int x, int y){
        try {
            this.imagem = new Image("resources/player.png");
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
        this.imagem.draw(this.x, this.y);
    }
    
}
