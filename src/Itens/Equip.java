/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Itens;

/**
 *
 * @author Maike
 */
public abstract class Equip extends Item {

    int levelMinimo;
    int itemLevel;
    int bonusForca;
    int bonusDefesa;
    int bonusDestreza;
    int bonusVida;

    public int getLevelMinimo() {
        return levelMinimo;
    }

    public void setLevelMinimo(int levelMinimo) {
        this.levelMinimo = levelMinimo;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public int getBonusForca() {
        return bonusForca;
    }

    public void setBonusForca(int bonusForca) {
        this.bonusForca = bonusForca;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }

    public void setBonusDefesa(int bonusDefesa) {
        this.bonusDefesa = bonusDefesa;
    }

    public int getBonusDestreza() {
        return bonusDestreza;
    }

    public void setBonusDestreza(int bonusDestreza) {
        this.bonusDestreza = bonusDestreza;
    }

    public int getBonusVida() {
        return bonusVida;
    }

    public void setBonusVida(int bonusVida) {
        this.bonusVida = bonusVida;
    }
}
