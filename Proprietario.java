// Proprietario.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Classe Entidade – representa um proprietário real de motocicleta.
 * Validações extra:
 * - nome não pode ser vazio e não pode conter dígitos.
 * - cpf deve conter somente dígitos e ter exatamente 11 caracteres (ex.: "12345678901").
 * - telefone deve conter somente dígitos (mínimo 8 dígitos, máximo 14, por exemplo).
 * - ender (endereço) não pode ser nulo.
 */
public class Proprietario {
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco ender; // Reflexividade: Proprietario → Endereco

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        // Nome não pode conter dígitos
        if (nome.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Nome inválido: não deve conter números");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio!");
        }
        // CPF deve conter exatamente 11 dígitos (somente números)
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido: deve conter 11 dígitos numéricos");
        }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }
        // Telefone deve conter somente dígitos (8 a 14 dígitos)
        if (!telefone.matches("\\d{8,14}")) {
            throw new IllegalArgumentException("Telefone inválido: deve conter apenas dígitos (8 a 14 números)");
        }
        this.telefone = telefone;
    }

    public Endereco getEnder() {
        return ender;
    }

    public void setEnder(Endereco ender) {
        if (ender == null) {
            throw new IllegalArgumentException("Endereço não pode ser nulo");
        }
        this.ender = ender;
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf;
    }
}
