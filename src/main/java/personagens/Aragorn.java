package personagens;

import Mapa.Mapa;
import Racas.Guerreiro;
import Racas.Humano;

public class Aragorn extends Personagem implements Guerreiro, Humano {
    public Aragorn() {
        super(10, 7, 6, 60, true);
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
    public void ataque(Mapa mapa) {
        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y + 1) != null && !mapa.buscarCasa(y + 1).sociedadeDoAnel) {
            mapa.buscarCasa(y + 1).constituicao -= 20;
            mapa.verificaSeMorreu(mapa, y + 1);
        }
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public void envelhecer() {
        constituicao -= 1;
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

    @Override
    public void seMovimenta(Mapa mapa) {
        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y + 1) == null && y + 1 <= 10) {
            mapa.inserirDurenteJogo(y + 1, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        }
    }
}
