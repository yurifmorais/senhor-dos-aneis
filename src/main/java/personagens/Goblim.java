package personagens;

import Mapa.Mapa;
import Racas.Arqueiro;
import Racas.Monstro;

public class Goblim extends Personagem implements Arqueiro, Monstro {
    public Goblim() {
        super(3, 6, 1, 20, false);
    }

    @Override
    public void ataque(Mapa mapa) {
        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y - 3) != null && mapa.buscarCasa(y - 3).sociedadeDoAnel) {
            mapa.buscarCasa(y - 3).constituicao -= 3 * agilidade;
            mapa.verificaSeMorreu(mapa, y - 3);
        } else if (mapa.buscarCasa(y - 2) != null && mapa.buscarCasa(y - 2).sociedadeDoAnel) {
            mapa.buscarCasa(y - 2).constituicao -= 2 * agilidade;
            mapa.verificaSeMorreu(mapa, y - 2);
        } else if (mapa.buscarCasa(y - 1) != null && mapa.buscarCasa(y - 1).sociedadeDoAnel) {
            mapa.buscarCasa(y - 1).constituicao -= agilidade;
            mapa.verificaSeMorreu(mapa, y - 1);
        }
    }

    @Override
    public String grunir() {
        return "Iiisshhhh";
    }

    @Override
    public void seMovimenta(Mapa mapa) {
        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y - 1) == null && mapa.buscarCasa(y - 2) == null && y - 2 >= 1) {
            mapa.inserirDurenteJogo(y - 2, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        } else if (mapa.buscarCasa(y - 1) == null && y - 1 >= 1) {
            mapa.inserirDurenteJogo(y - 1, mapa.buscarCasa(y));
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
    public String toString() {
        return "M";
    }
}
