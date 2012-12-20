package Principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class GameObject {
    protected int x;
    protected int y;

    
    public abstract void update(GameContainer gc, StateBasedGame game, int delta);
    public abstract void render(GameContainer gc, StateBasedGame game, Graphics g);

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
