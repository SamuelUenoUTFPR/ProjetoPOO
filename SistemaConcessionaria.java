// SistemaConcessionaria.java
// Samuel Ueno Fernandes - RA: 2678314

import java.util.List;
import java.util.ArrayList;

/**
 * Classe de Controle – gerencia motos e acessórios cadastrados.
 * - Reflexividade: mantém listas de Motocicleta e Acessorio.
 * - Tratamento de Exceções: lança exceções personalizadas.
 */
public class SistemaConcessionaria {
    private List<Motocicleta> motos = new ArrayList<>();        // Reflexividade
    private List<Acessorio> acessoriosDisponiveis = new ArrayList<>(); // Reflexividade

    /**
     * Cadastra uma moto (pode ser Nacional, Importada ou Esportiva).
     * Lança exceções de negócio se violar regras.
     */
    public void cadastrarMoto(Motocicleta moto)
            throws MotoJaCadastradaException,
                   MotoSemProprietarioException,
                   MotoSemPrecoException {
        if (moto == null) {
            throw new IllegalArgumentException("Moto não pode ser nula");
        }
        // Verifica código duplicado
        if (buscarMoto(moto.getCodigo()) != null) {
            throw new MotoJaCadastradaException("Moto com código " + moto.getCodigo() + " já está cadastrada");
        }
        // Verifica se há proprietário
        if (moto.getProprietario() == null) {
            throw new MotoSemProprietarioException("Moto deve ter um proprietário associado");
        }
        // Verifica preço válido
        if (moto.getPreco() <= 0) {
            throw new MotoSemPrecoException("Preço da moto deve ser maior que zero");
        }
        motos.add(moto);
        System.out.println("Moto cadastrada com sucesso!");
    }

    /**
     * Cadastra um acessório. Se preco ≤ 0, lança AcessorioInvalidoException.
     */
    public void cadastrarAcessorio(Acessorio acessorio) throws AcessorioInvalidoException {
        if (acessorio == null) {
            throw new IllegalArgumentException("Acessório não pode ser nulo");
        }
        if (acessorio.getPreco() <= 0) {
            throw new AcessorioInvalidoException("Preço do acessório deve ser maior que zero");
        }
        acessoriosDisponiveis.add(acessorio);
        System.out.println("Acessório cadastrado com sucesso!");
    }

    /**
     * Lista todos os acessórios cadastrados.
     */
    public void listarAcessoriosDisponiveis() {
        System.out.println("\nAcessórios Disponíveis:");
        if (acessoriosDisponiveis.isEmpty()) {
            System.out.println("Nenhum acessório disponível.");
            return;
        }
        acessoriosDisponiveis.forEach(System.out::println);
    }

    /**
     * Busca um acessório pelo código; retorna null se não encontrar.
     */
    public Acessorio buscarAcessorio(String codigo) {
        for (Acessorio a : acessoriosDisponiveis) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Lista todas as motos cadastradas, exibindo detalhes e proprietário.
     */
    public void listarMotos() {
        if (motos.isEmpty()) {
            System.out.println("Nenhuma moto cadastrada no sistema.");
            return;
        }
        System.out.println("\n--- Motos Cadastradas ---");
        for (Motocicleta moto : motos) {
            moto.exibirDetalhes();     // Polimorfismo (Sobrescrita)
            moto.exibirProprietario(); // Reflexividade em ação
            System.out.println("-----------");
        }
    }

    /**
     * Busca uma moto pelo código; retorna null se não encontrar.
     */
    public Motocicleta buscarMoto(String codigo) {
        for (Motocicleta moto : motos) {
            if (moto.getCodigo().equals(codigo)) {
                return moto;
            }
        }
        return null;
    }
}
