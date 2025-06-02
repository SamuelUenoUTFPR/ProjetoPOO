// MotoJaCadastradaException.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Exceção personalizada – lançada quando tenta cadastrar uma moto cujo código já existe.
 */
public class MotoJaCadastradaException extends Exception {
    public MotoJaCadastradaException(String msg) {
        super(msg);
    }
}
