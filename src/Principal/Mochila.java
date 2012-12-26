package Principal;

import Itens.Item;
import java.util.ArrayList;

public class Mochila {

    ArrayList<Item> mochila;
    int tamanho;
    int dinheiro;

    public Mochila(int tamanho) {
        this.tamanho = tamanho;
        this.mochila = new ArrayList<Item>();
    }

    public void adicionaItem(Item item) {
        if (this.mochila.size() < this.tamanho) {
            this.mochila.add(item);
        }
    }

    public void retiraItem(Item item) {
        if (this.mochila.contains(item)) {
            this.mochila.remove(item);
        }
    }

    public void esvaziaMochila() {
        this.mochila.clear();
    }
}
