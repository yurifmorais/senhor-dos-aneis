package personagens;

import Mapa.Mapa;
import Racas.Arqueiro;
import Racas.Elfo;

public class Legolas extends Personagem implements Arqueiro, Elfo {
    public Legolas() {
        super(5, 10, 6, 80, true);
    }

    @Override
    public String falarElfilico() {
        return "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";
    }

    @Override
    public String falar() {
        return "They're taking the Hobbits to Isengard!";
    }

    @Override
    public String toString() {
        return "L";
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
    public void seMovimenta(Mapa mapa) {
        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y + 1) == null && mapa.buscarCasa(y + 2) == null && y + 2 <= 10) {
            mapa.inserirDurenteJogo(y + 2, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        } else if (mapa.buscarCasa(y + 1) == null && y + 1 <= 10) {
            mapa.inserirDurenteJogo(y + 1, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        }
    }

    @Override
    public void ataque(Mapa mapa) {
        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y + 3) != null && !mapa.buscarCasa(y + 3).sociedadeDoAnel) {
            mapa.buscarCasa(y + 3).constituicao -= 3 * agilidade;
            verificaSeMorreu(mapa, y + 3);
        } else if (mapa.buscarCasa(y + 2) != null && !mapa.buscarCasa(y + 2).sociedadeDoAnel) {
            mapa.buscarCasa(y + 2).constituicao -= 2 * agilidade;
            verificaSeMorreu(mapa, y + 2);
        } else if (mapa.buscarCasa(y + 1) != null && !mapa.buscarCasa(y + 1).sociedadeDoAnel) {
            mapa.buscarCasa(y + 1).constituicao -= agilidade;
            verificaSeMorreu(mapa, y + 1);
        }
    }

    public void verificaSeMorreu(Mapa mapa, int y) {
        if (mapa.buscarCasa(y).constituicao <= 0) {
            mapa.inserirDurenteJogo(y, null);
        }
    }
}
