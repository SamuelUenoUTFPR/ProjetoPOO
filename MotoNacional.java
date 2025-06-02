// MotoNacional.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Classe filha de Motocicleta – representa motos produzidas no Brasil.
 * - Herança 
 * - Sobrescrita 
 */
public class MotoNacional extends Motocicleta {
    private String estadoDeOrigem;
    private boolean temIncentivoFiscal;

    public String getEstadoDeOrigem() {
        return estadoDeOrigem;
    }

    public void setEstadoDeOrigem(String estadoDeOrigem) {
        if (estadoDeOrigem == null || estadoDeOrigem.trim().isEmpty()) {
            throw new IllegalArgumentException("Estado de origem não pode ser vazio");
        }
        this.estadoDeOrigem = estadoDeOrigem;
    }

    public boolean isTemIncentivoFiscal() {
        return temIncentivoFiscal;
    }

    public void setTemIncentivoFiscal(boolean temIncentivoFiscal) {
        this.temIncentivoFiscal = temIncentivoFiscal;
    }

    //Sobrescrita
    @Override
    public void exibirDetalhes() {
        System.out.println("Moto Nacional - " + getMarca() + " " + getModelo()
            + " | Preço: R$" + getPreco()
            + " | Estado: " + estadoDeOrigem
            + " | Incentivo Fiscal: " + (temIncentivoFiscal ? "SIM" : "NÃO"));
    }
}
