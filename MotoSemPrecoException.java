// MotoSemPrecoException.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Exceção personalizada – lançada quando tenta cadastrar uma moto com preço inválido (≤ 0).
 */
public class MotoSemPrecoException extends Exception {
    public MotoSemPrecoException(String msg) {
        super(msg);
    }
}
