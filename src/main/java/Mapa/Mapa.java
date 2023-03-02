package Mapa;

import Exceptions.PersonagemJaEstaNoMapaException;
import Exceptions.PersonagemNaoEncontradoNoMapaException;
import Exceptions.PosicaoOcupadaException;
import personagens.Personagem;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
    private Map<Integer, Personagem> mapa = new HashMap<Integer, Personagem>();
    private StringBuilder strRetorno = new StringBuilder();

    public Mapa() {
        preencheMapa();
    }

    public void preencheMapa() {
        for (int i = 1; i <= 10; i++) {
            mapa.put(i, null);
        }
    }

    public String exibir() {
        for (int i = 1; i <= 10; i++) {
            strRetorno.append("|");
            if (mapa.get(i) == null) {
                strRetorno.append(" ");
            } else {
                strRetorno.append(mapa.get(i).toString());
            }
        }
        strRetorno.append("|");
        return strRetorno.toString();
    }

    public void inserir(int posicao, Personagem personagem) {
        for (int i = 1; i <= 10; i++) {
            if (mapa.get(i) != null && mapa.get(i).toString().equals(personagem.toString())) {
                throw new PersonagemJaEstaNoMapaException();
            }
        }
        if (mapa.get(posicao) != null) {
            throw new PosicaoOcupadaException();
        }
        mapa.put(posicao, personagem);
    }

    public int buscarPosicao(Personagem personagem) {
        for (int i = 1; i <= 10; i++) {
            if (mapa.get(i) != null && mapa.get(i).toString().equals(personagem.toString())) {
                return i;
            }
        }
        throw new PersonagemNaoEncontradoNoMapaException();
    }

    public Personagem buscarCasa(int posicao) {
        if (mapa.get(posicao) != null) {
            return mapa.get(posicao);
        } else return null;
    }

    public void inserirDurenteJogo(int posicao, Personagem personagem) {
        mapa.put(posicao, personagem);
    }

    public void verificaSeMorreu(Mapa mapa, int y) {
        if (mapa.buscarCasa(y).getConstituicao() <= 0) {
            mapa.inserirDurenteJogo(y, null);
        }
    }

    public Map<Integer, Personagem> getMapa() {
        return mapa;
    }
}
