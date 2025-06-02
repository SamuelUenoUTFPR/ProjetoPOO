// Principal.java
// Samuel Ueno Fernandes - RA: 2678314

public class Principal {
    public static void main(String[] args) {
        SistemaConcessionaria sistema = new SistemaConcessionaria();
        int opcao = 0;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Moto Nacional");
            System.out.println("2 - Cadastrar Moto Importada");
            System.out.println("3 - Cadastrar Moto Esportiva");
            System.out.println("4 - Listar Motos");
            System.out.println("5 - Cadastrar Acessório");
            System.out.println("6 - Listar Acessórios");
            System.out.println("7 - Sair");

            String entrada = Leitura.entDados("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
                System.out.println("Por favor, digite um número inteiro de 1 a 7.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarMotoNacional(sistema);
                    break;
                case 2:
                    cadastrarMotoImportada(sistema);
                    break;
                case 3:
                    cadastrarMotoEsportiva(sistema);
                    break;
                case 4:
                    sistema.listarMotos();
                    break;
                case 5:
                    cadastrarAcessorio(sistema);
                    break;
                case 6:
                    sistema.listarAcessoriosDisponiveis();
                    break;
                case 7:
                    System.out.println("Encerrando aplicação...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarMotoNacional(SistemaConcessionaria sistema) {
        while (true) {
            try {
                MotoNacional moto = new MotoNacional();

                // 1) Código
                String codigo = Leitura.entDados("Código da Moto: ");
                moto.setCodigo(codigo);

                // 2) Marca
                String marca = Leitura.entDados("Marca: ");
                moto.setMarca(marca);

                // 3) Modelo
                String modelo = Leitura.entDados("Modelo: ");
                moto.setModelo(modelo);

                // 4) Preço (double)
                while (true) {
                    String sPreco = Leitura.entDados("Preço (ex: 15000.50): ");
                    try {
                        double precoLido = Double.parseDouble(sPreco);
                        moto.setPreco(precoLido);
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorreto. Digite um número válido para o preço.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Valor inválido: " + iae.getMessage());
                    }
                }

                // 5) Proprietário
                Proprietario prop = new Proprietario();
                String nomeProp = Leitura.entDados("Nome do Proprietário: ");
                prop.setNome(nomeProp);

                String cpfProp = Leitura.entDados("CPF do Proprietário (11 dígitos): ");
                prop.setCpf(cpfProp);

                String telProp = Leitura.entDados("Telefone do Proprietário (8 a 14 dígitos): ");
                prop.setTelefone(telProp);

                // 5.1) Endereço
                Endereco end = new Endereco();
                String rua = Leitura.entDados("Rua do Proprietário: ");
                end.setRua(rua);

                String num = Leitura.entDados("Número do Proprietário: ");
                end.setNumero(num);

                prop.setEnder(end);
                moto.setProprietario(prop);

                // 6) Estado de Origem
                String estadoOrigem = Leitura.entDados("Estado de Origem: ");
                moto.setEstadoDeOrigem(estadoOrigem);

                // 7) Incentivo Fiscal (boolean)
                while (true) {
                    String sIncentivo = Leitura.entDados("Tem incentivo fiscal? (true/false): ");
                    if (sIncentivo.equalsIgnoreCase("true") || sIncentivo.equalsIgnoreCase("false")) {
                        moto.setTemIncentivoFiscal(Boolean.parseBoolean(sIncentivo));
                        break;
                    } else {
                        System.out.println("Digite apenas 'true' ou 'false'. Tente novamente.");
                    }
                }

                // 8) Cadastrar no sistema
                sistema.cadastrarMoto(moto);
                System.out.println("Moto Nacional cadastrada com sucesso!");
                return;

            } catch (MotoJaCadastradaException | MotoSemProprietarioException | MotoSemPrecoException e) {
                System.out.println("Erro ao cadastrar Moto Nacional: " + e.getMessage());
                System.out.println("Reiniciando cadastro da Moto Nacional.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Dados inválidos: " + e.getMessage());
                System.out.println("Reiniciando cadastro da Moto Nacional.\n");
            }
        }
    }

    private static void cadastrarMotoImportada(SistemaConcessionaria sistema) {
        while (true) {
            try {
                MotoImportada moto = new MotoImportada();

                // 1) Código
                String codigo = Leitura.entDados("Código da Moto: ");
                moto.setCodigo(codigo);

                // 2) Marca
                String marca = Leitura.entDados("Marca: ");
                moto.setMarca(marca);

                // 3) Modelo
                String modelo = Leitura.entDados("Modelo: ");
                moto.setModelo(modelo);

                // 4) Preço (double)
                while (true) {
                    String sPreco = Leitura.entDados("Preço (ex: 20000.75): ");
                    try {
                        double precoLido = Double.parseDouble(sPreco);
                        moto.setPreco(precoLido);
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorreto. Digite um número válido para o preço.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Valor inválido: " + iae.getMessage());
                    }
                }

                // 5) Proprietário
                Proprietario prop = new Proprietario();
                String nomeProp = Leitura.entDados("Nome do Proprietário: ");
                prop.setNome(nomeProp);

                String cpfProp = Leitura.entDados("CPF do Proprietário (11 dígitos): ");
                prop.setCpf(cpfProp);

                String telProp = Leitura.entDados("Telefone do Proprietário (8 a 14 dígitos): ");
                prop.setTelefone(telProp);

                // 5.1) Endereço
                Endereco end = new Endereco();
                String rua = Leitura.entDados("Rua do Proprietário: ");
                end.setRua(rua);

                String num = Leitura.entDados("Número do Proprietário: ");
                end.setNumero(num);

                prop.setEnder(end);
                moto.setProprietario(prop);

                // 6) País de Origem
                String paisOrigem = Leitura.entDados("País de Origem: ");
                moto.setPaisDeOrigem(paisOrigem);

                // 7) Taxa de Importação (double)
                while (true) {
                    String sTaxa = Leitura.entDados("Taxa de Importação (ex: 5000.00): ");
                    try {
                        double taxaLida = Double.parseDouble(sTaxa);
                        moto.setTaxaImportacao(taxaLida);
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorreto. Digite um número válido para a taxa.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Valor inválido: " + iae.getMessage());
                    }
                }

                // 8) Cadastrar no sistema
                sistema.cadastrarMoto(moto);
                System.out.println("Moto Importada cadastrada com sucesso!");
                return;
            } catch (MotoJaCadastradaException | MotoSemProprietarioException | MotoSemPrecoException e) {
                System.out.println("Erro ao cadastrar Moto Importada: " + e.getMessage());
                System.out.println("Reiniciando cadastro da Moto Importada.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Dados inválidos: " + e.getMessage());
                System.out.println("Reiniciando cadastro da Moto Importada.\n");
            }
        }
    }

    private static void cadastrarMotoEsportiva(SistemaConcessionaria sistema) {
        while (true) {
            try {
                MotoEsportiva moto = new MotoEsportiva();

                // 1) Código
                String codigo = Leitura.entDados("Código da Moto: ");
                moto.setCodigo(codigo);

                // 2) Marca
                String marca = Leitura.entDados("Marca: ");
                moto.setMarca(marca);

                // 3) Modelo
                String modelo = Leitura.entDados("Modelo: ");
                moto.setModelo(modelo);

                // 4) Preço (double)
                while (true) {
                    String sPreco = Leitura.entDados("Preço (ex: 18000.00): ");
                    try {
                        double precoLido = Double.parseDouble(sPreco);
                        moto.setPreco(precoLido);
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorreto. Digite um número válido para o preço.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Valor inválido: " + iae.getMessage());
                    }
                }

                // 5) Proprietário
                Proprietario prop = new Proprietario();
                String nomeProp = Leitura.entDados("Nome do Proprietário: ");
                prop.setNome(nomeProp);

                String cpfProp = Leitura.entDados("CPF do Proprietário (11 dígitos): ");
                prop.setCpf(cpfProp);

                String telProp = Leitura.entDados("Telefone do Proprietário (8 a 14 dígitos): ");
                prop.setTelefone(telProp);

                // 5.1) Endereço
                Endereco end = new Endereco();
                String rua = Leitura.entDados("Rua do Proprietário: ");
                end.setRua(rua);

                String num = Leitura.entDados("Número do Proprietário: ");
                end.setNumero(num);

                prop.setEnder(end);
                moto.setProprietario(prop);

                // 6) Cilindradas (int)
                while (true) {
                    String sCil = Leitura.entDados("Cilindradas (ex: 600): ");
                    try {
                        int cilLido = Integer.parseInt(sCil);
                        moto.setCilindradas(cilLido);
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorreto. Digite um número inteiro para cilindradas.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Valor inválido: " + iae.getMessage());
                    }
                }

                // 7) Tempo de aceleração (double)
                while (true) {
                    String sTempo = Leitura.entDados("Tempo 0-100 km/h (segundos; ex: 3.5): ");
                    try {
                        double tempoLido = Double.parseDouble(sTempo);
                        moto.setTempoAceleracao(tempoLido);
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorreto. Digite um número válido para o tempo.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Valor inválido: " + iae.getMessage());
                    }
                }

                // 8) Cadastrar no sistema
                sistema.cadastrarMoto(moto);
                System.out.println("Moto Esportiva cadastrada com sucesso!");
                return;
            } catch (MotoJaCadastradaException | MotoSemProprietarioException | MotoSemPrecoException e) {
                System.out.println("Erro ao cadastrar Moto Esportiva: " + e.getMessage());
                System.out.println("Reiniciando cadastro da Moto Esportiva.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Dados inválidos: " + e.getMessage());
                System.out.println("Reiniciando cadastro da Moto Esportiva.\n");
            }
        }
    }

    private static void cadastrarAcessorio(SistemaConcessionaria sistema) {
        while (true) {
            try {
                Acessorio acessorio = new Acessorio();

                // 1) Código
                String codigo = Leitura.entDados("Código do Acessório: ");
                acessorio.setCodigo(codigo);

                // 2) Nome
                String nome = Leitura.entDados("Nome do Acessório: ");
                acessorio.setNome(nome);

                // 3) Preço (double)
                while (true) {
                    String sPreco = Leitura.entDados("Preço do Acessório (ex: 250.0): ");
                    try {
                        double precoAcess = Double.parseDouble(sPreco);
                        acessorio.setPreco(precoAcess);
                        break;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Formato incorreto. Digite um número válido para o preço.");
                    } catch (IllegalArgumentException iae) {
                        System.out.println("Valor inválido: " + iae.getMessage());
                    }
                }

                // 4) Cadastrar no sistema
                sistema.cadastrarAcessorio(acessorio);
                System.out.println("Acessório cadastrado com sucesso!");
                return;
            } catch (AcessorioInvalidoException e) {
                System.out.println("Erro ao cadastrar acessório: " + e.getMessage());
                System.out.println("Reiniciando cadastro do acessório.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Dados inválidos: " + e.getMessage());
                System.out.println("Reiniciando cadastro do acessório.\n");
            }
        }
    }
}
