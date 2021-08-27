package trabalho;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // Nova Instancia de Locacao para criar conta Cliente
        Locacao contaCliente = new Locacao();

        // Cria uma instancia de arraylist para os clientes
        ArrayList<Cliente> clientes = new ArrayList<>();

        // Cria uma instancia de arraylist para os clientes
        ArrayList<Carro> carros = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        {
            //Fluxo de Leitura do arquivo Clientes
            Scanner entrada = new Scanner(new FileReader("src/trabalho/clientes.txt")).useDelimiter("\\|");

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


            //Fluxo de Leitura do arquivo Carros
            entrada = new Scanner(new FileReader("src/trabalho/carros.txt")).useDelimiter("\\|");

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
            }
            entrada.close();

        }


        // Loop inf menu
        int opcao = -1;

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

        // Menu se mantem ativo em loop ate que o usuario passe o valor 0 para encerrar programa
        while(opcao != 0) {
            System.out.print(menuPrincipal);

            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                {

                    // Chamada do metodo para criar um novo cliente
                    Cliente cliente = contaCliente.adicionarCliente(clientes.size());
                    if(cliente != null){
                        clientes.add(cliente);
                    }
                    break;
                }

                case 2: {
                    System.out.println("Ainda nao implementado");
                }

                case 3: {
                    Carro carro = contaCliente.cadastrarCarro(carros.size());
                    if( carro != null) {
                        carros.add(carro);
                    }
                }

            }

        }





        {
            // Escrita no arquivo txt de clientes
            FileWriter arquivoClientes = new FileWriter("src/trabalho/clientes.txt");

            // Escrita no arquivo txt de clientes
            FileWriter arquivoCarros = new FileWriter("src/trabalho/carros.txt");


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

            // Finaliza escrita e salva alteracoes apos fim da execucao do programa
            arquivoClientes.close();

            // Finaliza escrita e salva alteracoes apos fim da execucao do programa
            arquivoCarros.close();
        }
    }
}
