package personagens;

import Mapa.Mapa;
import Racas.Guerreiro;
import Racas.Humano;

public class Boromir extends Personagem implements Guerreiro, Humano {
    public Boromir() {
        super(7, 6, 3, 40, true);
    }

    @Override
    public void seMovimenta(Mapa mapa) {
        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y + 1) == null && y + 1 <= 10) {
            mapa.inserirDurenteJogo(y + 1, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        }
    }

    public int buscaPosicao(Mapa mapa) {
        int y = 0;
        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).toString().equals(toString())) {
                y = mapa.buscarPosicao(mapa.buscarCasa(i));
            }
        }
        return y;
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public void envelhecer() {
        constituicao -= 2;
    }

    @Override
    public void ataque(Mapa mapa) {
        int y = 0;

        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).toString().equals(toString())) {
                y = mapa.buscarPosicao(mapa.buscarCasa(i));
            }
        }
        if (mapa.buscarCasa(y + 1) != null && !mapa.buscarCasa(y + 1).sociedadeDoAnel) {
            mapa.buscarCasa(y + 1).constituicao -= 14;
            mapa.verificaSeMorreu(mapa, y + 1);
        } else if (mapa.buscarCasa(y - 1) != null && !mapa.buscarCasa(y - 1).sociedadeDoAnel) {
            mapa.buscarCasa(y - 1).constituicao -= 14;
            mapa.verificaSeMorreu(mapa, y - 1);
        }
    }
}
