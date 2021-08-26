package trabalho;

import java.util.Scanner;

// Tarefas disponiveis no sistema de locação
public class Locacao {

    // construtor default
    public Locacao() {};


    // Criar um Novo Cliente
    public Cliente adicionarCliente(int client_id) {

        Scanner scanner = new Scanner(System.in);
        String nome, CPF, CNPJ, telefone, endereco, razaoSocial, nomeFantasia;

        // Menu Criação de Cliente
        System.out.println(" --- Cadastrar Cliente --- ");
        System.out.println("""
                1. Cadastro Pessoa Física
                2. Cadastro Pessoa Jurídica

                Selecione uma opção:\s""");


        // Condicional para verificar qual o tipo do cliente (1 - PF, 2 - PJ) e pegar os inputs do usuario;
        if ((scanner.nextInt() == 1)) {

            scanner.nextLine();
            System.out.println("Nome: "); nome = scanner.nextLine();
            System.out.println("CPF: "); CPF = scanner.nextLine();
            System.out.println("Telefone: "); telefone = scanner.nextLine();
            System.out.println("Endereço: "); endereco = scanner.nextLine();


            return new PessoaFisica(nome, CPF, telefone, endereco, client_id, 0);

        } else {

            scanner.nextLine();
            System.out.println("Nome Fantasia: "); nomeFantasia = scanner.nextLine();
            System.out.println("Razão Social: "); razaoSocial = scanner.nextLine();
            System.out.println("CNPJ: "); CNPJ = scanner.nextLine();
            System.out.println("Telefone: "); telefone = scanner.nextLine();
            System.out.println("Endereço: "); endereco = scanner.nextLine();

            return new PessoaJuridica(nomeFantasia, razaoSocial, CNPJ, telefone, endereco, client_id, 0);
        }
    }
}
