/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import org.newdawn.slick.Image;

/**
 *
 * @author Lucas
 */
public abstract class Personagem extends GameObject {

    String nome;
    int vida;
    int forca;
    int defesa;
    int velocidade;
    
    Arma arma;
    
    Image imagem;
    double anguloRotate;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public double getAnguloRotate() {
        return anguloRotate;
    }

    public void setAnguloRotate(double anguloRotate) {
        this.anguloRotate = anguloRotate;
    }
    
    
}
