// MotoSemProprietarioException.java
// Samuel Ueno Fernandes - RA: 2678314

/**
 * Exceção personalizada – lançada quando tenta cadastrar uma moto sem proprietário.
 */
public class MotoSemProprietarioException extends Exception {
    public MotoSemProprietarioException(String msg) {
        super(msg);
    }
}
