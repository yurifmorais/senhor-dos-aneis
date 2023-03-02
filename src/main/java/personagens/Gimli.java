package personagens;

import Mapa.Mapa;
import Racas.Anao;
import Racas.Guerreiro;

public class Gimli extends Personagem implements Guerreiro, Anao {
    private int bebeu;

    public Gimli() {
        super(9, 2, 4, 60, true);
        bebeu = 0;
    }

    @Override
    public void beber() {
        bebeu++;
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
            mapa.buscarCasa(y + 1).constituicao -= forca * 2;
            mapa.verificaSeMorreu(mapa, y + 1);
        } else if (mapa.buscarCasa(y - 1) != null && !mapa.buscarCasa(y - 1).sociedadeDoAnel) {
            mapa.buscarCasa(y - 1).constituicao -= forca * 2;
            mapa.verificaSeMorreu(mapa, y - 1);
        }
    }

    @Override
    public String falar() {
        if (bebeu >= 3) {
            return "What did I say? He can't hold his liquor!";
        }
        return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
    }

    @Override
    public void seMovimenta(Mapa mapa) {
        int y = 0;

        for (int i = 1; i <= 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).toString().equals(toString())) {
                y = mapa.buscarPosicao(mapa.buscarCasa(i));
            }
        }
        if (mapa.buscarCasa(y + 1) == null && y + 1 <= 10) {
            mapa.inserirDurenteJogo(y + 1, mapa.buscarCasa(y));
            mapa.inserirDurenteJogo(y, null);
        }
    }
    @Override
    public String toString() {
        return "I";
    }
}