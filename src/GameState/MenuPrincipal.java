/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 *
 * @author Lucas
 */
public class MenuPrincipal extends BasicGameState {
    
    public static final int ID = 1;
    GameContainer gc;
    StateBasedGame game;
    String[] options = {"Inicio de Jogo","Intruções","Opções","Sair"};
    private int selected;
    private Image img, img2;
    
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        this.gc = gc;
        this.game = game;
        
        this.img = new Image("resources/Fundo.png");
        this.img2 =  new Image ("resources/espada.png");
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        this.img.draw();
        
       for(int i = 0; i < this.options.length ; i++){
             g.drawString(options[i], gc.getWidth()/2- g.getFont().getWidth(this.options[i])/2 + 170,120+(60*i));
         if(i ==  this.selected){
             
        this.img2.draw(gc.getWidth()/2+10,120+(60*i));
         }
       }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int i) throws SlickException {
       
    }
    
    @Override
    public void keyPressed (int key , char c){
        
        if(key ==  Input.KEY_DOWN){
             this.selected++;
          if(this.selected >= this.options.length){
              this.selected = 0;
          }  
        }
        
        if(key == Input.KEY_UP){
             this.selected--;
           if(this.selected < 0 ){
               this.selected =  this.options.length -1;
           }
        }
       
        if(key == Input.KEY_ENTER){
            if(this.options[this.selected].equals("Inicio de Jogo")){
                  this.game.enterState(Fase1.ID, new FadeOutTransition(Color.yellow),new FadeInTransition(Color.red));
            }
            
            if(this.options[this.selected].equals("Sair")){
                this.gc.exit();
            }
        }
    }
    
}
