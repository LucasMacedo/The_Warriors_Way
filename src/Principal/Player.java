/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.InputTest;

/**
 *
 * @author Maike
 */
public class Player extends GameObject {
    
    public Personagem personagem;
    int velocidade = 5;

   public Player (Personagem personagem){
     
       this.personagem = personagem; 
       this.personagem.setDirecao(Direcao.DIREITA);
   }
  
   
    @Override
   public void update(GameContainer gc, StateBasedGame game, int delta){
       this.personagem.update(gc,game,delta);
       
       Input input = gc.getInput();
       
       // Direção Cima e Baixo
       if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)){
           this.personagem.direcao = Direcao.CIMA;
           this.moveCima(velocidade);
       }
       if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)){
           this.personagem.direcao = Direcao.BAIXO;
           this.moveBaixo(velocidade);
       }
       
       // Direção Direita e Esquerda
       
       if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)){
           this.personagem.direcao = Direcao.DIREITA;
           this.moveDireita(velocidade);
       }
       
       if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)){
           this.personagem.direcao = Direcao.DIREITA;
           this.moveEsquerda(velocidade);
       }
   }
   
   @Override
    public void render(GameContainer gc, StateBasedGame game,Graphics g) {
         this.personagem.render(gc, game, g);
    }
   
   
   
   
   
   
   // Velocidade do Jogador 
   public int getVelocidade() {
        return velocidade;
    }

   public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

  

    

   
   
   
        
}
