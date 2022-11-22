package br.edu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int TAMANHO_CORRIDA = 1000;
    private static final int QTDE_SAPOS = 4;

    public static void main(String[] args) {

        Podio podio = new Podio();
        ExecutorService executor = Executors.newFixedThreadPool(QTDE_SAPOS);

        for (int i = 1; i <= QTDE_SAPOS; i++) {
            final int finalI = i;
            executor.execute(() -> new Sapo("Sapo " + finalI, TAMANHO_CORRIDA, podio).iniciarCorrida());
        }

        executor.shutdown();
        while (!executor.isTerminated());

        podio.printarPodio();
    }

}