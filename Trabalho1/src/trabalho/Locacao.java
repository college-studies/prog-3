package trabalho;

import java.util.Scanner;

public class Locacao {

    // construtor default
    public Locacao() {};


    public Cliente adicionarCliente(int client_id) {

        Scanner scanner = new Scanner(System.in);
        String nome, CPF, CNPJ, telefone, endereco, razaoSocial, nomeFantasia;

        System.out.println(" --- Cadastrar Cliente --- ");

        System.out.println("""
                1. Cadastro Pessoa Física
                2. Cadastro Pessoa Jurídica

                Selecione uma opção:\s""");

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
