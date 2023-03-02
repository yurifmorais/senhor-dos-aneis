package Simulador;

import Exceptions.SauronDominaOMundoException;
import Mapa.Mapa;

public class Simulador {
    private Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() {
        int i = 1, aux = 0;
        boolean emJogo = true;
        String ultimoAJogar = mapa.getMapa().get(i).toString();

        while (emJogo) {

            if (mapa.getMapa().get(i) != null) {
                mapa.getMapa().get(i).ataque(mapa);
                ultimoAJogar = mapa.getMapa().get(i).toString();
                mapa.getMapa().get(i).seMovimenta(mapa);

                if (mapa.getMapa().get(10) != null && mapa.buscarCasa(10).isSociedadeDoAnel()) {
                    emJogo = false;
                } else {
                    aux =0;
                    for (int x = 1; x <= 10; x++) {
                        if (mapa.getMapa().get(x) != null && mapa.buscarCasa(x).isSociedadeDoAnel()) aux++;
                    }
                    if (aux == 0) throw new SauronDominaOMundoException();
                }
            }
            i++;
            if (i > 10) i = 1;
            else if (mapa.getMapa().get(i) != null && mapa.getMapa().get(i).toString().equals(ultimoAJogar)) {
                i++;
            }
        }
    }
}