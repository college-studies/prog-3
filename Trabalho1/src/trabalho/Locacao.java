package trabalho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
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

    // Cria um novo carro no sistema
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

    // Cadastro Aluguel de um carro para um cliente
    public Aluguel cadastrarAluguel(int aluguel_id, Cliente cliente, ArrayList<Carro> disponiveis) {
        Scanner scanner = new Scanner(System.in);

        //Pega data atual do pc
        LocalDate diaInicio = LocalDate.now();

        // Verifica se o cliente tem dividas, caso tenha o sistema nao permite que o mesmo alugue um carro
        if (cliente.getDivida() > 0) {
            System.out.println("ERRO - O Cliente tem Dividas a serem pagas");
            scanner.nextLine();

            return null;
        }


        // Caso o cliente nao tenha dividas, sistema percorre pelos carros disponiveis e mostra as opcoes de locacao
        System.out.println(" -- Carros Disponiveis --");
        int i = 0;
        for (Carro carro: disponiveis){
            System.out.println(i++ + ". " + carro.getModelo());
        }

        System.out.println("\nInsira o ID do carro a ser alugado: ");
        Carro carro = disponiveis.get(scanner.nextInt());

        // Determina qual o tipo de locacao que o cliente deseja
        System.out.println("Tipo de locação:\n0. Por Km Rodado (R$" + carro.getTaxaPorKm() + ")\n1. Por Dia (R$ " + carro.getTaxaDiaria() + ")");

        System.out.println("Selecione uma opcao: ");

        // Passa os parametros para realizacao do aluguel
        Aluguel aluguel = new Aluguel(diaInicio, null, cliente.getClienteID(), carro.getID(), 0, scanner.nextInt(), aluguel_id);

        // Determina a situacao como false para q o carro se torne indisponivel para aluguel
        carro.setSituacao(false);
        return aluguel;
    }

    // Pagamento de dividas
    public void pagarDividas(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);

        String entrada, saida = "";

        // Recupera a divida do cliente
        System.out.println("Divida de R$ " + cliente.getDivida());

        entrada = scanner.nextLine();

        if (entrada.toLowerCase().equals("s")) {
            // Setta a divida como quitada
            cliente.setDivida(0);

            System.out.println("\n -- Divida Quitada -- ");

            // Retorna o status da divida de acordo com o tipo do cliente
            if (cliente instanceof PessoaFisica pf) {
                saida += pf.getNome() +" "+ pf.getCPF() + " Divida quitada - Valor R$" + pf.getDivida();

            } else {
                PessoaJuridica pj = (PessoaJuridica) cliente;
                saida += pj.getNomeFantasia() +" "+ pj.getCNPJ() + " Divida quitada - Valor R$" + pj.getDivida();
            }

            System.out.println(saida);
            System.out.println(LocalDate.now());
        }
    }

    // Devolve o veiculo alugado
    public void devolucaoAluguel(Cliente cliente, Carro carro, Aluguel aluguel, double quilometragemNova) {
        Scanner scanner = new Scanner(System.in);

        double total, pagamento;
        LocalDate entrega = LocalDate.now();
        long qtdTempoAlugado = (entrega.toEpochDay() - aluguel.getInicioLocacao().toEpochDay());

        // Verifica o tipo de locacao (Por dia ou km rodados)
        String tipoLocacao = "Locacao Feita por " + (aluguel.getTipoAluguel() == 1 ? " dia" : " Km/rodados");

        String saidaCliente, saidaFinal, sComeco, sFinal;

        String saidaCarro = "Carro: " + carro.getModelo() + " " + carro.getDescricao();

        // Imprime os dados de saida de acordo com o tipo do cliente
        if (cliente instanceof PessoaFisica pf) {
            saidaCliente = "Cliente: " + pf.getNome() + " CPF: " + pf.getCPF();
        }else {
            PessoaJuridica pj = (PessoaJuridica) cliente;
            saidaCliente = "Cliente: " + pj.getNomeFantasia() + " CNPJ: " + pj.getCNPJ();
        }

        // Verifica o inicio da locacao
        System.out.println(saidaCliente);
        System.out.println("\n" + saidaCarro);
        System.out.println("Inicio do Aluguel: " + aluguel.getInicioLocacao());

        // Verifica o tempo total em que o veiculo ficou alugado com o cliente e recebe pagamento
        total = (aluguel.getTipoAluguel() == 1 ? carro.getTaxaDiaria() * (qtdTempoAlugado + 1) : carro.getTaxaPorKm() * (quilometragemNova - carro.getQuilometragem()));
        System.out.println("Valor total a se pagar: R$" + total);
        System.out.print("Dinheiro: ");
        pagamento = scanner.nextDouble();


        // Cria recibo de devolucao e faz a verificacao se o pagamento foi completo ou se restou divida para pagar
        sComeco = "\n -- Recibo de Devolucao -- \n";
        sComeco +=  "O " + saidaCliente + " devolveu o " + saidaCarro;
        if (pagamento < total){
            sFinal = "\nDivida do cliente: " + (total - pagamento);
            cliente.setDivida(total - pagamento);
        }else{
            sComeco += " pagamento efeituado !!";
            sFinal = "\nTroco: " + (pagamento - total);
        }

        sFinal = sComeco +  "\nData Inicio: " + aluguel.getInicioLocacao();
        sFinal += "\nData da entrega: " + entrega;
        sFinal += "\n" + tipoLocacao;
        sFinal += "\nValor total: " + total + "\nTotal pago: " + pagamento;
        sFinal += sFinal + "\n";

        System.out.println(sFinal);
        carro.setQuilometragem(quilometragemNova);
        carro.setSituacao(true);
        aluguel.setFimLocacao(entrega);
        aluguel.setValorAluguel(total);
    }

    // Funcao para mostrar os dados do relatorio
    public void mostrarDados(Object out) {
        String saida = "";

        //Dados dos clientes (PessoFisica ou Juridica)
        if (out instanceof PessoaFisica cliente){
            saida += "\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCPF();
            saida += "\nTelefone: " + cliente.getTelefone() + "\nEndereco: " + cliente.getEndereco();
            saida += "\nDivida: " + cliente.getDivida();
        }else if (out instanceof PessoaJuridica cliente){
            saida += "\nNome Fantasia: " + cliente.getNomeFantasia() + "\nCNPJ: " + cliente.getCNPJ();
            saida += "\nRazao Social: " + cliente.getRazaoSocial() + "\nTelefone: " + cliente.getTelefone();
            saida += "\nEndereco: " + cliente.getEndereco() + "\nDivida: " + cliente.getDivida();

        //Dados dos carros
        }else if (out instanceof Carro carro){
            saida += "\nModelo: " + carro.getModelo() + "\nDescricao: " + carro.getDescricao();
            saida += "\nAno: " + carro.getAno() + "\nPlaca: " + carro.getPlaca() + "\nKilometragem: " + carro.getQuilometragem();
            saida += "\nTaxa KM: " + carro.getTaxaPorKm() + "\nTaxa por dia: " + carro.getTaxaDiaria();
            saida += "\nDisponivel: " + (carro.getSituacao() ? "Sim" : "Nao");
            saida += "\nObservacao: " + carro.getObservacoes();

        //Dados dos alugueis
        }else if (out instanceof Aluguel aluguel){
            saida += "\nData Inicio: " + aluguel.getInicioLocacao();
            saida += "\nData Final: " + (aluguel.getFimLocacao() == null ? "Aluguel ativo" : aluguel.getFimLocacao());
            saida += "\nCliente: " + aluguel.getClienteID() + "\nCarro: " + aluguel.getCarroID();
            saida += "\nTipo de Alocacao: " + (aluguel.getTipoAluguel() == 1 ? "Por dia" : "Por KM");
            saida += "\nValor: " + aluguel.getValorAluguel();
        }
        System.out.println(saida);
    }

}
