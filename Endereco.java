// Endereco.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Classe Entidade – representa um endereço físico com rua e número.
 * Validações:
 * - rua não pode ser vazia e não pode conter apenas dígitos (deve ter alguma letra).
 * - numero deve conter apenas dígitos.
 */
public class Endereco {
    private String rua;
    private String numero;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua == null || rua.trim().isEmpty()) {
            throw new IllegalArgumentException("Rua não pode ser vazia");
        }
        // Não permitir rua puramente numérica: deve conter ao menos uma letra
        if (!rua.matches(".*[A-Za-zÀ-ÿ].*")) {
            throw new IllegalArgumentException("Rua inválida: deve conter pelo menos uma letra");
        }
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Número não pode ser vazio");
        }
        // Número deve ser composto apenas por dígitos (é o número da casa/prédio)
        if (!numero.matches("\\d+")) {
            throw new IllegalArgumentException("Número inválido: deve conter apenas dígitos");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return rua + ", " + numero;
    }
}
