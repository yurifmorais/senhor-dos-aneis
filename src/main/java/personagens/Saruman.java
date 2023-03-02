package personagens;

import Mapa.Mapa;
import Racas.Mago;
import Racas.Maia;

public class Saruman extends Personagem implements Mago, Maia {
    public Saruman() {
        super(2, 2, 9, 70, false);
    }

    @Override
    public Gandalf ressucitar() {
        return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }

    @Override
    public String toString() {
        return "S";
    }

    @Override
    public void seMovimenta(Mapa mapa) {
        int aux = 0;
        int y = 0;


        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) == null) {
                aux++;
            }
        }
        if (aux == 9) {
            for (int i = 1; i <= 10; i++) {
                if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).toString().equals(toString())) {
                    y = mapa.buscarPosicao(mapa.buscarCasa(i));
                }
            }
            if (y - 1 >= 1) {
                mapa.inserirDurenteJogo(y - 1, mapa.buscarCasa(y));
                mapa.inserirDurenteJogo(y, null);
            }
        }
    }

    @Override
    public void ataque(Mapa mapa) {
        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).sociedadeDoAnel) {
                mapa.buscarCasa(i).constituicao -= inteligencia;
                mapa.verificaSeMorreu(mapa, i);
            }
        }
    }
}
