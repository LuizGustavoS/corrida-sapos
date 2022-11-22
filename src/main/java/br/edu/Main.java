package br.edu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int DESCANSO_MAXIMO = 1000; //tempo maximo de descanso em ms
    private static final int TAMANHO_CORRIDA = 1000; //tamanho total da corrida em cm
    private static final int PULO_MAXIMO = 50; //tamanho maximo do pulo do sapo em cm

    private static final int QTDE_SAPOS = 4; //qtde de sapos participando da corrida

    public static void main(String[] args) {

        Podio podio = new Podio();
        ExecutorService executor = Executors.newFixedThreadPool(QTDE_SAPOS);

        for (int i = 1; i <= QTDE_SAPOS; i++) {
            final String nome = "Sapo " + i;
            executor.execute(() -> new Sapo(nome, PULO_MAXIMO, DESCANSO_MAXIMO, TAMANHO_CORRIDA, podio).iniciarCorrida());
        }

        executor.shutdown();
        while (!executor.isTerminated());

        podio.printarPodio();
    }

}