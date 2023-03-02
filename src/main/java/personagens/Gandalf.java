package personagens;

import Mapa.Mapa;
import Racas.Mago;
import Racas.Maia;

public class Gandalf extends Personagem implements Mago, Maia {
    public Gandalf() {
        super(2, 3, 10, 80, true);
    }

    @Override
    public String toString() {
        return "G";
    }

    @Override
    public Gandalf ressucitar() {
        if (constituicao == 0) {
            return new Gandalf();
        } else return null;
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }

    public void trocaPosicao(Mapa mapa, int aux) {
        int y = 0;
        if (aux == 9) {
            for (int i = 1; i <= 10; i++) {
                if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).toString().equals(toString())) {
                    y = mapa.buscarPosicao(mapa.buscarCasa(i));
                }
            }
            mapa.inserirDurenteJogo(10, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        }
    }

    @Override
    public void seMovimenta(Mapa mapa) {
        int aux = 0;

        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) == null) {
                aux++;
            }
        }
        trocaPosicao(mapa, aux);
    }

    @Override
    public void ataque(Mapa mapa) {
        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) != null && !mapa.buscarCasa(i).sociedadeDoAnel) {
                mapa.buscarCasa(i).constituicao -= inteligencia;
                mapa.verificaSeMorreu(mapa, i);
            }
        }
    }
}
