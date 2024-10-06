import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        Conta conta = null;

        if (tipoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (tipoConta == 2) {
            System.out.print("Digite a taxa Selic atual (%): ");
            double taxaSelic = scanner.nextDouble();
            conta = new ContaPoupanca(titular, taxaSelic);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        while (true) {
            System.out.println("\nMenu de opções:");
            if (conta instanceof ContaCorrente) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Exibir Dados da Conta");
            } else if (conta instanceof ContaPoupanca) {
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Calcular Rendimento");
                System.out.println("4. Exibir Dados da Conta");
            }
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    if (conta instanceof ContaCorrente) {
                        ((ContaCorrente) conta).sacar(valorSaque);
                    } else {
                        ((ContaPoupanca) conta).sacar(valorSaque);
                    }
                    break;
                case 3:
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).calcularRendimento();
                    } else {
                        System.out.println("Operação não disponível para Conta Corrente.");
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}