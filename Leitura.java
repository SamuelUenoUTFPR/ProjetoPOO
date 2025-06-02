// Leitura.java
// Samuel Ueno Fernandes - RA: 2678314

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Classe de leitura única (Singleton) para entradas via teclado usando BufferedReader.
 */
public class Leitura {
    private static Leitura leitUnic; // 1º passo: instância única

    private Leitura() {
        // construtor privado
    }

    /**
     * Retorna a instância única de Leitura, criando-a se ainda não existir.
     */
    public static Leitura geraLeitura() {
        if (leitUnic == null) {
            leitUnic = new Leitura();
        }
        return leitUnic;
    }

    /**
     * Exibe o rótulo no console e retorna a linha digitada pelo usuário.
     * Se ocorrer IOException, exibe mensagem e retorna string vazia.
     *
     * @param rotulo texto a ser exibido antes da leitura
     * @return a linha digitada (sem o \n)
     */
    public static String entDados(String rotulo) {
        System.out.print(rotulo);
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader bufTec = new BufferedReader(teclado);
        String ret = "";
        try {
            ret = bufTec.readLine();
        } catch (IOException ioe) {
            System.out.println("ERRO de JVM ou RAM durante a leitura");
        }
        return ret;
    }
}
