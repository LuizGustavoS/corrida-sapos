package br.edu;

public class Sapo {

    private final String nomeSapo;

    private final Integer puloMaximo;

    private final Integer descansoMaximo;

    private final Integer distanciaTotal;

    private final Podio podio;

    private Integer distanciaPercorrida;

    private Integer tamanhoPuloAtual;

    private Integer qtdePulos;

    public Sapo(String nomeSapo, Integer puloMaximo, Integer descansoMaximo, Integer distanciaTotal, Podio podio) {
        this.nomeSapo = nomeSapo;
        this.puloMaximo = puloMaximo;
        this.descansoMaximo = descansoMaximo;
        this.distanciaTotal = distanciaTotal;
        this.podio = podio;
        this.distanciaPercorrida = 0;
        this.tamanhoPuloAtual = 0;
        this.qtdePulos = 0;
    }

    public String getNomeSapo() {
        return nomeSapo;
    }

    public Integer getQtdePulos() {
        return qtdePulos;
    }

    public void iniciarCorrida() {

        do {
            pular();
            printarSituacao();
            descansar();
        }while (this.distanciaPercorrida < this.distanciaTotal);

        podio.adicionarPodio(this);
    }

    private void pular() {
        this.qtdePulos++;
        this.tamanhoPuloAtual = (int) (Math.random() * puloMaximo);

        this.distanciaPercorrida += this.tamanhoPuloAtual;
        if (this.distanciaPercorrida >= this.distanciaTotal){
            this.distanciaPercorrida = this.distanciaTotal;
        }
    }

    private void printarSituacao() {
        System.out.println("O :sapo pulou :pulo cm e já percorreu uma distancia de :total"
                .replace(":sapo", this.nomeSapo)
                .replace(":pulo", this.tamanhoPuloAtual.toString())
                .replace(":total", this.distanciaPercorrida.toString()));
    }

    private void descansar() {
        try {
            Thread.sleep((int) (Math.random() * descansoMaximo));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
