// AcessorioInvalidoException.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Exceção personalizada – lançada ao cadastrar um acessório inválido (por exemplo, preço ≤ 0).
 */
public class AcessorioInvalidoException extends Exception {
    public AcessorioInvalidoException(String msg) {
        super(msg);
    }
}
