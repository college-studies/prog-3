package trabalho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Tarefas disponiveis no sistema de locação
public class Locacao {

    // construtor default
    public Locacao() {}


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

    public Carro cadastrarCarro(int carro_id) {
        String placa, modelo, descricao, observacoes;
        int ano;
        double quilometragem, taxaDiaria, taxaPorKm;
        boolean situacao = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println(" --- Cadastrar Carro --- ");

        System.out.println("Placa: "); placa = scanner.nextLine();
        System.out.println("Modelo: "); modelo = scanner.nextLine();
        System.out.println("Descricao: "); descricao = scanner.nextLine();
        System.out.println("Ano: "); ano = scanner.nextInt();
        System.out.println("Quilometragem: "); quilometragem = scanner.nextDouble();
        System.out.println("Taxa por Km: "); taxaPorKm = scanner.nextDouble();
        System.out.println("Taxa Diaria: "); taxaDiaria = scanner.nextDouble();
        System.out.println("Observação: "); observacoes = scanner.nextLine();

        return new Carro(placa, modelo, descricao, observacoes, carro_id, ano, situacao, quilometragem, taxaDiaria, taxaPorKm);

    }

    public Aluguel cadastrarAluguel(int aluguel_id, Cliente cliente, ArrayList<Carro> disponiveis) {
        Scanner scanner = new Scanner(System.in);

        LocalDate diaInicio = LocalDate.now();

        if (cliente.getDivida() > 0) {
            System.out.println("ERRO - O Cliente tem Dividas a serem pagas");
            scanner.nextLine();

            return null;
        }

        System.out.println(" -- Carros Disponiveis --");
        int i = 0;

        for(Carro carro: disponiveis) {
            System.out.println(i++ + ". " + carro.getModelo() + " "+ carro.getDescricao() + " "+ carro.getAno());
        }
        System.out.println("\nInsira o ID do carro a ser alugado: ");
        Carro carro = disponiveis.get(scanner.nextInt());

        System.out.println("Tipo de locação:\n0. Por Km Rodado (R$" + carro.getTaxaPorKm() + ")\n1. Por Dia (R$ " + carro.getTaxaDiaria() + ")");

        System.out.println("Selecione uma opcao: ");

        Aluguel aluguel = new Aluguel(diaInicio, null, cliente.getClienteID(), carro.getID(), 0, scanner.nextInt(), aluguel_id);

        carro.setSituacao(false);
        return aluguel;
    }


}
