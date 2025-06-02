// MotoEsportiva.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Classe filha de Motocicleta – representa motos esportivas.
 * - Terceira subclasse 
 * - Sobrescrita 
 */
public class MotoEsportiva extends Motocicleta {
    private int cilindradas;
    private double tempoAceleracao;

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        if (cilindradas <= 0) {
            throw new IllegalArgumentException("Cilindradas devem ser maiores que zero");
        }
        this.cilindradas = cilindradas;
    }

    public double getTempoAceleracao() {
        return tempoAceleracao;
    }

    public void setTempoAceleracao(double tempoAceleracao) {
        if (tempoAceleracao <= 0) {
            throw new IllegalArgumentException("Tempo de aceleração deve ser positivo");
        }
        this.tempoAceleracao = tempoAceleracao;
    }

    //Sobrescrita
    @Override
    public void exibirDetalhes() {
        System.out.println("Moto Esportiva - " + getMarca() + " " + getModelo()
            + " | Preço: R$" + getPreco()
            + " | Cilindradas: " + cilindradas + "cc"
            + " | 0-100 km/h em: " + tempoAceleracao + "s");
    }
}
