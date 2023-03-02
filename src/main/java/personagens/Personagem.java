package personagens;

import Mapa.Mapa;

public abstract class Personagem {
    protected final int forca;
    protected final int agilidade;
    protected final int inteligencia;
    protected int constituicao;
    protected boolean sociedadeDoAnel;


    public int getConstituicao() {
        return constituicao;
    }

    public Personagem(int forca, int agilidade, int inteligencia, int constituicao, boolean sociedadeDoAnel) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
        this.sociedadeDoAnel = sociedadeDoAnel;
    }

    public void seMovimenta(Mapa mapa) {
    }

    public void ataque(Mapa mapa) {
    }
    public boolean isSociedadeDoAnel() {
        return sociedadeDoAnel;
    }
}