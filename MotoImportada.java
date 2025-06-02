// MotoImportada.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Classe filha de Motocicleta – representa motos importadas.
 * - Herança 
 * - Sobrescrita 
 */
public class MotoImportada extends Motocicleta {
    private String paisDeOrigem;
    private double taxaImportacao;

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        if (paisDeOrigem == null || paisDeOrigem.trim().isEmpty()) {
            throw new IllegalArgumentException("País de origem não pode ser vazio");
        }
        this.paisDeOrigem = paisDeOrigem;
    }

    public double getTaxaImportacao() {
        return taxaImportacao;
    }

    public void setTaxaImportacao(double taxaImportacao) {
        if (taxaImportacao < 0) {
            throw new IllegalArgumentException("Taxa de importação não pode ser negativa");
        }
        this.taxaImportacao = taxaImportacao;
    }

    //Sobrescrita
    @Override
    public void exibirDetalhes() {
        System.out.println("Moto Importada - " + getMarca() + " " + getModelo()
            + " | Preço: R$" + getPreco()
            + " | País de Origem: " + paisDeOrigem
            + " | Taxa Importação: R$" + taxaImportacao);
    }
}
