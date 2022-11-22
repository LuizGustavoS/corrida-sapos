package br.edu;

public class Sapo {

    private static final int DESCANSO_MAXIMO = 1000;
    private static final int PULO_MAXIMO = 50;

    private final Podio podio;

    private final String nomeSapo;

    private final Integer distanciaTotal;

    private Integer distanciaPercorrida;

    private Integer tamanhoPuloAtual;

    private Integer qtdePulos;

    public Sapo(String nomeSapo, Integer distanciaTotal, Podio podio) {
        this.nomeSapo = nomeSapo;
        this.distanciaTotal = distanciaTotal;
        this.distanciaPercorrida = 0;
        this.tamanhoPuloAtual = 0;
        this.qtdePulos = 0;
        this.podio = podio;
    }

    public String getNomeSapo() {
        return nomeSapo;
    }

    public Integer getQtdePulos() {
        return qtdePulos;
    }

    public void iniciarCorrida(){

        try {
            do {
                pular();
                printarSituacao();
                descansar();
            }while (this.distanciaPercorrida < this.distanciaTotal);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        podio.adicionarPodio(this);
    }

    private void pular(){
        this.qtdePulos++;
        this.tamanhoPuloAtual = (int) (Math.random() * PULO_MAXIMO);

        this.distanciaPercorrida += this.tamanhoPuloAtual;
        if (this.distanciaPercorrida >= this.distanciaTotal){
            this.distanciaPercorrida = this.distanciaTotal;
        }
    }

    private void printarSituacao(){
        System.out.println("O :sapo pulou :pulo cm e já percorreu uma distancia de :total"
                .replace(":sapo", this.nomeSapo)
                .replace(":pulo", this.tamanhoPuloAtual.toString())
                .replace(":total", this.distanciaPercorrida.toString()));
    }

    private void descansar(){
        try {
            Thread.sleep((int) (Math.random() * DESCANSO_MAXIMO));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
