package Principal;

import Itens.Arma;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Personagem extends GameObject {

    String nome;
    int level;
    int exp;
    int vida;
    int forca;
    int defesa;
    int destreza;
    double velocidade;
    double peso;
    
    Mochila mochila;
    Arma arma;
    
    Image imagem;
    double anguloRotate;
    public boolean atacou;
    int contParado;
    public int contCaiParaTras;
    public boolean parado;
    public double distanciaQuedaParaTrasX;
    public double distanciaQuedaParaTrasY;
    int danoLevado;
    int contDanoLevado;
    int contDanoLevadoPadrao = 30;

    public void levaDano(int dano, double anguloAtacante) {
        this.distanciaQuedaParaTrasX = Math.cos(Math.toRadians(anguloAtacante)) * dano / (this.peso / 10);
        this.distanciaQuedaParaTrasY = -Math.sin(Math.toRadians(anguloAtacante)) * dano / (this.peso / 10);
        this.danoLevado = dano;
        this.contDanoLevado = this.contDanoLevadoPadrao;
        this.vida -= dano;
        this.contParado = dano;
        this.contCaiParaTras = dano * 2 / 3;
        this.parado = true;
    }
    
    public void desenhaDano(Graphics g) {
        int ySubida = this.contDanoLevado - this.contDanoLevadoPadrao;
        String dano = "" + this.danoLevado;
        float xDraw = this.x + this.imagem.getCenterOfRotationX() - g.getFont().getWidth(dano) / 2;
        float yDraw = this.y - g.getFont().getHeight(dano)+ySubida;
        g.drawString(dano, xDraw, yDraw);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
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

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getVelocidade() {
        return (int)velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
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
