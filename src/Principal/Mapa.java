/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Maike
 */
public class Mapa extends GameObject{

    TiledMap mapa;
    
    public Mapa(String nome){
        try {
            this.mapa = new TiledMap("resources/mapas/"+nome+".tmx");
        } catch (SlickException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
       this.mapa.render(x, y);
    }

    @Override
    public Shape getShape() {
        throw new UnsupportedOperationException("Mapa nao precisa de shape :)");
    }
    
}
