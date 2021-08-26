package trabalho;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Locacao contaCliente = new Locacao();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        Scanner leitor = new Scanner(System.in);

        {
            Scanner input = new Scanner(new FileReader("src/trabalho/clientes.txt")).useDelimiter("\\|");

            String tel, end, nome, cpf, cnpj, razao, tipoCliente;
            double divida;
            int idCliente;

            while(input.hasNext()) {
                tipoCliente = input.next().replace("\n", "");
                idCliente = Integer.parseInt(input.next().replace("\n", ""));
                tel = input.next().replace("\n", "");
                end = input.next().replace("\n", "");
                divida = Double.parseDouble(input.next().replace("\n", ""));
                if (tipoCliente.equals("0")){
                    nome = input.next().replace("\n", "");
                    cpf = input.next().replace("\n", "");
                    clientes.add(new PessoaFisica(nome, cpf, tel, end, idCliente, divida));
                }else{
                    nome = input.next().replace("\n", "");
                    razao = input.next().replace("\n", "");
                    cnpj = input.next().replace("\n", "");
                    clientes.add(new PessoaJuridica(nome, razao, cnpj, tel, end, idCliente, divida));
                }
            }
            input.close();
        }

        int opcao = -1;

        String menuPrincipalOutput = "============= Menu principal ===============\n\n";
        menuPrincipalOutput += "1. Cadastrar Novo Cliente\n2. Selecionar Cliente\n3. Cadastrar Novo Carro";
        menuPrincipalOutput += "\n4. Mostrar Dados de um Carro\n5. Relatorios\n6. Sair";
        menuPrincipalOutput += "\n\nSua Opcao: ";


        while(opcao != 6) {
            System.out.print(menuPrincipalOutput);

            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:
                {

                    Cliente c = contaCliente.adicionarCliente(clientes.size());
                    if(c != null){
                        clientes.add(c);
                    }
                    break;
                }

            }

        }


        {
            FileWriter arquivoClientes = new FileWriter("src/trabalho/clientes.txt");

            for(Cliente cliente: clientes){
                if (cliente instanceof PessoaFisica){
                    PessoaFisica c = (PessoaFisica) cliente;
                    arquivoClientes.write("|0|" + cliente.getClienteID());
                    arquivoClientes.write("|" + cliente.getTelefone());
                    arquivoClientes.write("|" + cliente.getEndereco());
                    arquivoClientes.write("|" + cliente.getDivida());
                    arquivoClientes.write("|" + c.getNome());
                    arquivoClientes.write("|" + c.getCPF() + "\n");
                }else{
                    PessoaJuridica c = (PessoaJuridica) cliente;
                    arquivoClientes.write("|1|" + cliente.getClienteID());
                    arquivoClientes.write("|" + cliente.getTelefone());
                    arquivoClientes.write("|" + cliente.getEndereco());
                    arquivoClientes.write("|" + cliente.getDivida());
                    arquivoClientes.write("|" + c.getNomeFantasia());
                    arquivoClientes.write("|" + c.getRazaoSocial());
                    arquivoClientes.write("|" + c.getCNPJ() + "\n");
                }
            }

            arquivoClientes.close();

        }
    }
}
