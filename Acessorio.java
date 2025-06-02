// Acessorio.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Classe Entidade – representa um acessório vendável na concessionária.
 * - Encapsulamento 
 */
public class Acessorio {
    private String codigo;
    private String nome;
    private double preco;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código do acessório não pode ser vazio");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do acessório não pode ser vazio");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço do acessório deve ser maior que zero");
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " (R$" + preco + ")";
    }
}
