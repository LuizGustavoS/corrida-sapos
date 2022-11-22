package br.edu;

import java.util.ArrayList;
import java.util.List;

public class Podio {

    private final List<Sapo> listSapos = new ArrayList<>();

    public synchronized void adicionarPodio(Sapo sapo){
        this.listSapos.add(sapo);
    }

    public void printarPodio(){

        System.out.println("---------------------------");
        System.out.println("Lista de colocados");

        for (int i = 0; i < listSapos.size(); i++) {
            final Sapo sapo = this.listSapos.get(i);
            System.out.println(":nome ficou em :posicao lugar com :pulos pulos"
                    .replace(":nome", sapo.getNomeSapo())
                    .replace(":posicao", String.valueOf(i+1))
                    .replace(":pulos", sapo.getQtdePulos().toString()));
        }
    }
}
