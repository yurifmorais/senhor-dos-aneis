package personagens;

import Mapa.Mapa;
import Racas.Guerreiro;
import Racas.Humano;
import Racas.Monstro;

public class Urukhai extends Personagem implements Guerreiro, Monstro, Humano {
    public Urukhai() {
        super(8, 6, 3, 45, false);
    }

    @Override
    public void seMovimenta(Mapa mapa) {
        int y = 0;

        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).toString().equals(toString())) {
                y = mapa.buscarPosicao(mapa.buscarCasa(i));
            }
        }
        if (mapa.buscarCasa(y - 1) == null && y - 1 >= 1) {
            mapa.inserirDurenteJogo(y - 1, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        }
    }

    @Override
    public void envelhecer() {
        constituicao -= 2;
    }

    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }

    @Override
    public String toString() {
        return "U";
    }

    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public void ataque(Mapa mapa) {
        int y = 0;

        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).toString().equals(toString())) {
                y = mapa.buscarPosicao(mapa.buscarCasa(i));
            }
        }
        if (mapa.buscarCasa(y + 1) != null && mapa.buscarCasa(y + 1).sociedadeDoAnel) {
            mapa.buscarCasa(y + 1).constituicao -= forca * 2;
            mapa.verificaSeMorreu(mapa, y + 1);
        } else if (mapa.buscarCasa(y - 1) != null && mapa.buscarCasa(y - 1).sociedadeDoAnel) {
            mapa.buscarCasa(y - 1).constituicao -= forca * 2;
            mapa.verificaSeMorreu(mapa, y - 1);
        }
    }
}
