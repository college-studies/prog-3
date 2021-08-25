package trabalho;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Locacao cliente = new Locacao();

        ArrayList<Cliente> clientes = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        {

            // Leitura de Dados do Cliente

            Scanner entrada = new Scanner(new FileReader("src/trabalho/clientes.txt")).useDelimiter("\\|");


            int cliente_id;
            String nome, telefone, endereco, CPF, CNPJ, razaoSocial, tipoDoCliente;
            double divida;

            while(entrada.hasNext()) {
                cliente_id = Integer.parseInt(entrada.next().replace("\n", ""));
                tipoDoCliente = entrada.next().replace("\n", "");
                telefone = entrada.next().replace("\n", "");
                endereco = entrada.next().replace("\n", "");
                divida = Double.parseDouble(entrada.next().replace("\n", ""));

                if (tipoDoCliente.equals("1")) {
                    nome = entrada.next().replace("\n", "");
                    CPF = entrada.next().replace("\n","");

                    clientes.add(new PessoaFisica(nome, CPF,  telefone, endereco, cliente_id, divida));

                }

                else {
                    razaoSocial = entrada.next().replace("\n", "");
                    CNPJ = entrada.next().replace("\n", "");
                    nome = entrada.next().replace("\n", "");

                    clientes.add(new PessoaJuridica(razaoSocial, CNPJ, nome, telefone, endereco, cliente_id, divida));
                }
            }
            entrada.close();
        }


        // ----------------------- Fluxo de Menus / Crud -----------------------


        int escolha = -1;


        // Switch Inicial para verificar operaçaão que usuario deseja realizar
        String menuPrincipal = """
                                
                -- Menu principal --
                1.Cadastrar Cliente
                2.Selecionar Cliente
                3.Cadastrar Carro
                4.Mostrar Informaçoões do Carro
                5.Gerar Relatórios
                0.Sair\040\040\040\040\040
                                
                Selecionar Opção:""";

        while (escolha != 0)
        {

            System.out.println(menuPrincipal);
            escolha = scan.nextInt();

            switch (escolha) {

                // Caso o usuario selecione 1 Entramos no Fluxo de Criaçaão do cadastro de um novo cliente
                case 1 -> {
                    Cliente novoClient = cliente.adicionarCliente(clientes.size());
                    if (novoClient != null) {
                        clientes.add(novoClient);
                    }
                }

            }

        }

        {
            FileWriter clientesRegistro = new FileWriter("src/trabalho/clientes.txt");


            for(Cliente cl: clientes) {
                if(cl instanceof PessoaFisica pf){

                    clientesRegistro.write("Pessoa Física = [\n");
                    clientesRegistro.write("{ \n   id: " + cl.getClienteID());
                    clientesRegistro.write(" ,\n   Nome:'" + pf.getNome());
                    clientesRegistro.write(" ',\n   CPF:'" + pf.getCPF());
                    clientesRegistro.write(" ',\n   Telefone: " + cl.getTelefone());
                    clientesRegistro.write(" ,\n   Endereço:'" + cl.getEndereco());
                    clientesRegistro.write(" ',\n   Dividas:" + cl.getDivida());
                    clientesRegistro.write("  \n  }\n]\n");
                } else {
                    PessoaJuridica pj = (PessoaJuridica)cl;
                    clientesRegistro.write("|" + cl.getClienteID());
                    clientesRegistro.write("|" + pj.getNomeFantasia());
                    clientesRegistro.write("|" + pj.getRazaoSocial());
                    clientesRegistro.write("|" + pj.getCNPJ());
                    clientesRegistro.write("|" + cl.getTelefone());
                    clientesRegistro.write("|" + cl.getEndereco());
                    clientesRegistro.write("|" + cl.getDivida());
                }
            }

            clientesRegistro.close();
        }
    }
}
