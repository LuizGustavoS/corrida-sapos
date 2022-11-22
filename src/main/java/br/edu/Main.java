package br.edu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int TAMANHO_CORRIDA = 100;
    private static final int QTDE_THREADS = 4;
    private static final int QTDE_SAPOS = 4;

    public static void main(String[] args) {

        Podio podio = new Podio();

        ExecutorService executor = Executors.newFixedThreadPool(QTDE_THREADS);
        for (int i = 0; i < QTDE_SAPOS; i++) {
            int finalI = i;
            executor.execute(() -> new Sapo("Sapo " + finalI, TAMANHO_CORRIDA, podio).iniciarCorrida());
        }

        executor.shutdown();
        while (!executor.isTerminated());

        podio.printarPodio();
    }

}