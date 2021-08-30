package trabalho;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // ----------------- INICIA INSTANCIAS DAS CLASSES PARA LOCACAO, CLIENTES, CARROS E ALUGUEIS ------------------- //

        // Nova Instancia de Locacao para criar conta Cliente
        Locacao contaCliente = new Locacao();

        // Cria uma instancia de arraylist para os clientes
        ArrayList<Cliente> clientes = new ArrayList<>();

        // Cria uma instancia de arraylist para os clientes
        ArrayList<Carro> carros = new ArrayList<>();

        // Cria uma instancia de arraylist para os alugueis
        ArrayList<Aluguel> alugueis = new ArrayList<>();

        // -------------------------------------------------------------------------------------------------------------- //


        Scanner scanner = new Scanner(System.in);


        // ---------------------------- FLUXO DE LEITURA DOS ARQUIVOS TXT ---------------------------------------------- //
        {
            //Fluxo de Leitura do arquivo Clientes
            Scanner entrada = new Scanner(new FileReader("src/trabalho/database/clientes.txt")).useDelimiter("\\|");

            String tel, end, nome, cpf, cnpj, razao, tipoCliente;
            double divida;
            int idCliente;

            while(entrada.hasNext()) {
                tipoCliente = entrada.next().replace("\n", "");
                idCliente = Integer.parseInt(entrada.next().replace("\n", ""));
                tel = entrada.next().replace("\n", "");
                end = entrada.next().replace("\n", "");
                divida = Double.parseDouble(entrada.next().replace("\n", ""));


                if (tipoCliente.equals("1")){
                    nome = entrada.next().replace("\n", "");
                    cpf = entrada.next().replace("\n", "");
                    clientes.add(new PessoaFisica(nome, cpf, tel, end, idCliente, divida));
                }else{
                    nome = entrada.next().replace("\n", "");
                    razao = entrada.next().replace("\n", "");
                    cnpj = entrada.next().replace("\n", "");
                    clientes.add(new PessoaJuridica(nome, razao, cnpj, tel, end, idCliente, divida));
                }
            }
            entrada.close();


            // ---------------------------------------------------------------------------------------------------------//


            //Fluxo de Leitura do arquivo Carros
            entrada = new Scanner(new FileReader("src/trabalho/database/carros.txt")).useDelimiter("\\|");

            String placa, modelo, descricao, observacoes;
            int ano, carro_id;
            double quilometragem, taxaDiaria, taxaPorKm;
            boolean situacao;

            while(entrada.hasNext()) {
                carro_id = Integer.parseInt(entrada.next().replace("\n", ""));
                situacao = entrada.next().replace("\n", "").equals("1");
                quilometragem = Double.parseDouble(entrada.next().replace("\n", ""));
                taxaPorKm = Double.parseDouble(entrada.next().replace("\n", ""));
                taxaDiaria = Double.parseDouble(entrada.next().replace("\n", ""));
                placa = entrada.next().replace("\n", "");
                modelo = entrada.next().replace("\n", "");
                descricao = entrada.next().replace("\n", "");
                observacoes = entrada.next().replace("\n", "");
                ano = Integer.parseInt(entrada.next().replace("\n", ""));
                carros.add(new Carro(placa, modelo, descricao, observacoes, carro_id, ano, situacao, quilometragem, taxaDiaria, taxaPorKm));
            }
            entrada.close();

            // ---------------------------------------------------------------------------------------------------------//

            //Fluxo de Leitura do arquivo Aluguel
            entrada = new Scanner(new FileReader("src/trabalho/database/alugueis.txt")).useDelimiter("\\|");
            boolean ativo;
            int aluguel_id, tipoLocacao, diaInicio, mesInicio, anoInicio;
            int diaFinal, mesFinal, anoFinal;
            double valor;
            LocalDate dIni, dFi;

            while(entrada.hasNext()){
                ativo = entrada.next().replace("\n", "").equals("1");
                idCliente = Integer.parseInt(entrada.next().replace("\n", ""));
                carro_id = Integer.parseInt(entrada.next().replace("\n", ""));
                aluguel_id = Integer.parseInt(entrada.next().replace("\n", ""));
                valor = Double.parseDouble(entrada.next().replace("\n", ""));
                tipoLocacao = Integer.parseInt(entrada.next().replace("\n", ""));
                diaInicio = Integer.parseInt(entrada.next().replace("\n", ""));
                mesInicio = Integer.parseInt(entrada.next().replace("\n", ""));
                anoInicio = Integer.parseInt(entrada.next().replace("\n", ""));
                dIni = LocalDate.of(anoInicio, mesInicio, diaInicio);
                dFi = null;

                if(!ativo){
                    diaFinal = Integer.parseInt(entrada.next().replace("\n", ""));
                    mesFinal = Integer.parseInt(entrada.next().replace("\n", ""));
                    anoFinal = Integer.parseInt(entrada.next().replace("\n", ""));
                    dFi = LocalDate.of(anoFinal, mesFinal, diaFinal);
                }
                alugueis.add(new Aluguel(dIni, dFi, idCliente, carro_id,  aluguel_id, valor, tipoLocacao));
            }
        }


        // Loop inf menu
        int opcao = -1;

        // ---------------------------------------- MENUS DO SISTEMA -------------------------------------------- //

        String menuPrincipal = """
                 ---- Menu Principal ---\040
                1. Cadastrar Cliente
                2. Selecionar Cliente
                3. Cadastrar Carro
                4. Mostrar Carros
                5. Relatórios
                0. Sair
                                
                Selecione uma opcão:
                                
                """;

        String menuCliente = """
                 ---- Menu Cliente ---\040
                1. Alugar Carro\040
                2. Quitar Dividas
                3. Devolver um Carro
                0. Voltar
                                
                Selecione uma opcão:
                                
                """;

        String menuRelatorios = """
                 ---- Menu Relatorios ---\040
                1. Clientes\040
                2. Veiculos
                3. Alugueis
                4. CLientes com Dividas
                5. Alugados por Periodo
                0. Sair
                                
                Selecione uma opcão:
                                
                """;


        // Menu se mantem ativo em loop ate que o usuario passe o valor 0 para encerrar programa
        while(opcao != 0) {
            System.out.print(menuPrincipal);

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {

                    // Chamada do metodo para criar um novo cliente
                    Cliente cliente = contaCliente.adicionarCliente(clientes.size());
                    if (cliente != null) {
                        clientes.add(cliente);
                    }
                }
                case 2 -> {

                    String clienteX = "";
                    System.out.println("1.Pessoa Física\n2.Pessoa Jurídica\n\nSeleciona uma opçaão:");
                    int x = scanner.nextInt();

                    System.out.println(" ---- Clientes Cadastrados: ----");

                    if (x == 1) {
                        PessoaFisica pf;
                        for (Cliente c : clientes) {
                            if (c instanceof PessoaFisica) {
                                pf = (PessoaFisica) c;
                                System.out.println("ID: " + pf.getClienteID() + " Nome: " + pf.getNome() + " - CPF: " + pf.getCPF() + " - Telefone: " + pf.getTelefone() + " - Endereco: " + pf.getEndereco() + " - Divida: " + pf.getDivida());
                            }
                        }
                    } else if (x == 2) {
                        PessoaJuridica pj;
                        for (Cliente c : clientes) {
                            if (c instanceof PessoaJuridica) {
                                pj = (PessoaJuridica) c;
                                System.out.println("ID: " + pj.getClienteID() + " - Nome Fantasia: " + pj.getNomeFantasia() + " - CNPJ: " + pj.getCNPJ() + " - Telefone: " + pj.getTelefone() + " - Endereco" + pj.getEndereco() + " - Divida: " + pj.getDivida());
                            }
                        }
                    }

                    int y = -1;

                    while (y < 0 || y >= clientes.size()) {
                        System.out.println("\nDigite um ID para escolher o cliente:");
                        y = scanner.nextInt();
                    }
                    Cliente cliente;

                    cliente = clientes.get(y);
                    if (cliente instanceof PessoaFisica pf) {
                        clienteX = pf.getNome();
                    } else {
                        PessoaJuridica pj = (PessoaJuridica) cliente;
                        clienteX = pj.getNomeFantasia();
                    }


                    opcao = -1;
                    while (opcao != 0) {
                        System.out.println(" -- Cliente " + clienteX + " selecionado\n");
                        System.out.println(menuCliente);
                        opcao = scanner.nextInt();

                        switch (opcao) {
                            case 1 -> {
                                ArrayList<Carro> disponiveis = new ArrayList<>();

                                for (Carro carro : carros) {
                                    if (carro.getSituacao()) {
                                        disponiveis.add(carro);
                                    }
                                }

                                alugueis.add(contaCliente.cadastrarAluguel(alugueis.size(), cliente, disponiveis));
                            }
                            case 2 -> {
                                if (cliente.getDivida() > 0) {
                                    contaCliente.pagarDividas(cliente);
                                } else {
                                    System.out.println("Nenhuma divida encontrada");
                                }

                                scanner.nextLine();
                                scanner.nextLine();
                            }
                            case 3 -> {
                                Aluguel aluguel = null;
                                Carro carro = null;
                                boolean flag = false;

                                for (Aluguel al : alugueis) {
                                    if (al.getFimLocacao() == null) {
                                        if (al.getClienteID() == cliente.getClienteID()) {
                                            flag = true;
                                            aluguel = al;
                                            carro = carros.get(al.getCarroID());
                                            break;

                                        }
                                    }
                                }

                                if (flag) {
                                    System.out.println("KM antes" + carro.getQuilometragem());
                                    System.out.println("KM atual");

                                    double currentKm = scanner.nextDouble();

                                    contaCliente.devolucaoAluguel(cliente, carro, aluguel, currentKm);
                                } else {
                                    System.out.println("Cliente naão tem nenhum carro alugado");
                                }

                                scanner.nextLine();
                            }
                            case 4 -> {
                                contaCliente.mostrarDados(cliente);
                                scanner.nextLine();
                            }
                        }
                    }

                }
                case 3 -> {
                    Carro carro = contaCliente.cadastrarCarro(carros.size());
                    if (carro != null) {
                        carros.add(carro);
                    }
                }
                case 4 -> {
                    int i = 0;
                    int vl;

                    for (Carro carro : carros) {
                        System.out.println(i++ + ". " + carro.getModelo() + " " + carro.getDescricao());
                    }

                    System.out.print("\n\nSelecione uma opcao: ");

                    vl = scanner.nextInt();

                    if (vl >= 0 && vl < carros.size()) {
                        contaCliente.mostrarDados(carros.get(vl));
                        ;
                    } else {
                        System.out.println("Valor invalido");
                    }

                    scanner.nextLine();
                }
                case 5 -> {
                    opcao = -1;
                    while (opcao != 0) {

                        System.out.println(menuRelatorios);
                        opcao = scanner.nextInt();
                        switch (opcao) {
                            case 1 -> {

                                for (Cliente c : clientes) {
                                    contaCliente.mostrarDados(c);
                                }
                                scanner.nextLine();
                            }
                            case 2 -> {

                                for (Carro c : carros) {
                                    contaCliente.mostrarDados(c);
                                }
                                scanner.nextLine();

                            }
                            case 3 -> {

                                for (Aluguel a : alugueis) {
                                    contaCliente.mostrarDados(a);
                                }
                                scanner.nextLine();

                            }
                            case 4 -> {

                                int cont = 0;
                                for (Cliente c : clientes) {
                                    if (c.getDivida() > 0) {
                                        cont++;
                                        contaCliente.mostrarDados(c);
                                    }
                                }
                                if (cont == 0) {
                                    System.out.println("Todos os clientes efetuaram pagamento");
                                }
                                scanner.nextLine();

                            }
                            case 5 -> {

                                int dI, mI, aI, dF, mF, aF, cont = 0;
                                System.out.print("Dia Inicial: ");
                                dI = scanner.nextInt();
                                System.out.print("Mes Inicial: ");
                                mI = scanner.nextInt();
                                System.out.print("Ano Inicial: ");
                                aI = scanner.nextInt();
                                System.out.print("Dia Final: ");
                                dF = scanner.nextInt();
                                System.out.print("Mes Final: ");
                                mF = scanner.nextInt();
                                System.out.print("Ano Final: ");
                                aF = scanner.nextInt();

                                LocalDate dataInicial = LocalDate.of(aI, mI, dI);
                                LocalDate dataFinal = LocalDate.of(aF, mF, dF);


                                for (Aluguel a : alugueis) {
                                    if (a.calculaTempoAluguel(dataInicial, dataFinal)) {
                                        cont++;
                                        contaCliente.mostrarDados(a);
                                    }
                                }
                                if (cont == 0) {
                                    System.out.println("\nNenhum aluguel no periodo");
                                }
                                scanner.nextLine();

                            }
                        }
                    }

                }
            }

        }


        // ---------------------------- FLUXO DE ESCRITA DOS ARQUIVOS TXT ---------------------------------------------- //
        {
            // Escrita no arquivo txt de clientes
            FileWriter arquivoClientes = new FileWriter("src/trabalho/database/clientes.txt");

            // Escrita no arquivo txt de clientes
            FileWriter arquivoCarros = new FileWriter("src/trabalho/database/carros.txt");

            // Escrita no arquivo txt de clientes
            FileWriter arquivoAlugueis = new FileWriter("src/trabalho/database/alugueis.txt");


            for(Cliente cliente: clientes){

                // Escrita para Pessoa Fisica
                if (cliente instanceof PessoaFisica pf){
                    arquivoClientes.write("|1|" + cliente.getClienteID());
                    arquivoClientes.write("|" + cliente.getTelefone());
                    arquivoClientes.write("|" + cliente.getEndereco());
                    arquivoClientes.write("|" + cliente.getDivida());
                    arquivoClientes.write("|" + pf.getNome());
                    arquivoClientes.write("|" + pf.getCPF() + "\n");

                }else{

                    // Escrita para Pessoa Juridica
                    PessoaJuridica pj = (PessoaJuridica) cliente;
                    arquivoClientes.write("|2|" + cliente.getClienteID());
                    arquivoClientes.write("|" + cliente.getTelefone());
                    arquivoClientes.write("|" + cliente.getEndereco());
                    arquivoClientes.write("|" + cliente.getDivida());
                    arquivoClientes.write("|" + pj.getNomeFantasia());
                    arquivoClientes.write("|" + pj.getRazaoSocial());
                    arquivoClientes.write("|" + pj.getCNPJ()  + "\n");

                }
            }

            for (Carro carro: carros){
                arquivoCarros.write("|" + carro.getID());
                arquivoCarros.write("|" + (carro.getSituacao()?1:0));
                arquivoCarros.write("|" + carro.getQuilometragem());
                arquivoCarros.write("|" + carro.getTaxaPorKm());
                arquivoCarros.write("|" + carro.getTaxaDiaria());
                arquivoCarros.write("|" + carro.getPlaca());
                arquivoCarros.write("|" + carro.getModelo());
                arquivoCarros.write("|" + carro.getDescricao());
                arquivoCarros.write("|" + carro.getObservacoes());
                arquivoCarros.write("|" + carro.getAno() + "\n");
            }

            for (Aluguel aluguel: alugueis){
                if (aluguel.getFimLocacao() == null){
                    arquivoAlugueis.write("|1|" + aluguel.getClienteID());
                    arquivoAlugueis.write("|" + aluguel.getCarroID());
                    arquivoAlugueis.write("|" + aluguel.getAluguelID());
                    arquivoAlugueis.write("|" + aluguel.getValorAluguel());
                    arquivoAlugueis.write("|" + aluguel.getTipoAluguel());
                    arquivoAlugueis.write("|" + aluguel.getInicioLocacao().getDayOfMonth());
                    arquivoAlugueis.write("|" + aluguel.getFimLocacao().getMonthValue());
                    arquivoAlugueis.write("|" + aluguel.getInicioLocacao().getYear() + "\n");
                }else{
                    arquivoAlugueis.write("|0|" + aluguel.getClienteID());
                    arquivoAlugueis.write("|" + aluguel.getCarroID());
                    arquivoAlugueis.write("|" + aluguel.getAluguelID());
                    arquivoAlugueis.write("|" + aluguel.getValorAluguel());
                    arquivoAlugueis.write("|" + aluguel.getTipoAluguel());
                    arquivoAlugueis.write("|" + aluguel.getInicioLocacao().getDayOfMonth());
                    arquivoAlugueis.write("|" + aluguel.getInicioLocacao().getMonthValue());
                    arquivoAlugueis.write("|" + aluguel.getInicioLocacao().getYear());
                    arquivoAlugueis.write("|" + aluguel.getFimLocacao().getDayOfMonth());
                    arquivoAlugueis.write("|" + aluguel.getFimLocacao().getMonthValue());
                    arquivoAlugueis.write("|" + aluguel.getFimLocacao().getYear() + "\n");
                }
            }

            // Finaliza escrita e salva alteracoes apos fim da execucao do programa
            arquivoAlugueis.close();

            // Finaliza escrita e salva alteracoes apos fim da execucao do programa
            arquivoCarros.close();

            // Finaliza escrita e salva alteracoes apos fim da execucao do programa
            arquivoClientes.close();
        }
    }
}
