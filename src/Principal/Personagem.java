/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas
 */
public class Personagem extends GameObject{
    
    int velocidade;
    public Image sprite;
    
    
    protected String nome;
   
    public Personagem (String nome) {
       this.nome = nome; 
       
       try {
            this.sprite = new Image("resources/espada.png");
        } catch (SlickException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) {
         this.sprite.draw(this.x,this.y); 
    }
     
    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) {
        
    }
    
    
    public void resetPosicao (int x,int y){
        this.x = x;
        this.y = y;
    }
//    
//    public void setDirecao(Direcao direcao){
//        this.direcao = direcao;
//    }
//    
//    public Direcao getDirecao(){
//        return this.direcao;
//    }

   

     
}
