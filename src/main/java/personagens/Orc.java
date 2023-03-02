package personagens;

import Mapa.Mapa;
import Racas.Guerreiro;
import Racas.Monstro;

public class Orc extends Personagem implements Guerreiro, Monstro {
    public Orc() {
        super(7, 4, 1, 30, false);
    }

    @Override
    public void ataque(Mapa mapa) {

        int y = buscaPosicao(mapa);

        if (mapa.buscarCasa(y + 1) != null && mapa.buscarCasa(y + 1).sociedadeDoAnel) {
            mapa.buscarCasa(y + 1).constituicao -= forca * 2;
            mapa.verificaSeMorreu(mapa, y + 1);
        } else if (mapa.buscarCasa(y - 1) != null && mapa.buscarCasa(y - 1).sociedadeDoAnel) {
            mapa.buscarCasa(y - 1).constituicao -= forca * 2;
            mapa.verificaSeMorreu(mapa, y - 1);
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
        return "O";
    }

    @Override
    public String grunir() {
        return "Arrrggghhh";
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
}
