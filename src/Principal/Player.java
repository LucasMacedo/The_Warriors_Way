/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Maike
 */
public class Player {
    
    String nome;
    
    public Player(String nome){
        this.nome = nome;
    }

    public Player(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
}
