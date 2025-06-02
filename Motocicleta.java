// Motocicleta.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Classe abstrata Motocicleta – classe-mãe para todas as motos.
 * - Herança 
 * - Interface Anunciavel
 * - Encapsulamento
 * - Reflexividade: Proprietario dentro de Motocicleta
 */
public abstract class Motocicleta implements Anunciavel {
    private String codigo;           // Identificador exclusivo
    private String modelo;
    private String marca;
    private double preco;
    private Proprietario proprietario;

    // Getter e Setter “codigo”
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código não pode ser vazio");
        }
        this.codigo = codigo;
    }

    // Getter e Setter “modelo”
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser vazio");
        }
        this.modelo = modelo;
    }

    // Getter e Setter “marca”
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca não pode ser vazia");
        }
        this.marca = marca;
    }

    // Getter e Setter “preco”
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço da moto deve ser maior que zero");
        }
        this.preco = preco;
    }

    // Getter e Setter “proprietario” (Reflexividade)
    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        if (proprietario == null) {
            throw new IllegalArgumentException("Proprietário não pode ser nulo");
        }
        this.proprietario = proprietario;
    }

    /**
     * Exibe o proprietário da moto, incluindo rua e número via reflexividade:
     * proprietario.getEnder().getRua() e getNumero().
     */
    public void exibirProprietario() {
        System.out.println("Proprietário: " + proprietario.getNome() 
            + " (CPF: " + proprietario.getCpf() + ")");
        System.out.println("Endereço: " 
            + proprietario.getEnder().getRua() 
            + ", " 
            + proprietario.getEnder().getNumero());
    }

    //Sobrecarga : método com mesmo nome, parâmetros diferentes.
    //Sobrecarga
    public void exibirDetalhes(String prefixo) {
        System.out.println(prefixo + "Moto: " + marca + " " + modelo + " (código: " + codigo + ")");
    }

    // Polimorfismo de sobrescrita: as subclasses devem implementar este método.
    @Override
    public abstract void exibirDetalhes();
}
