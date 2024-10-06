class ContaPoupanca extends Conta {
    private double taxaSelic;

    public ContaPoupanca(String titular, double taxaSelic) {
        super(titular);
        this.taxaSelic = taxaSelic;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente! Saldo atual: " + saldo);
        }
    }

    public void calcularRendimento() {
        double rendimento;
        if (taxaSelic > 8.5) {
            rendimento = saldo * 0.005; // 0,5% ao mês
        } else {
            rendimento = saldo * (0.7 * taxaSelic / 100); // 70% da Selic
        }
        saldo += rendimento;
        System.out.println("Rendimento de " + rendimento + " calculado e adicionado ao saldo.");
    }

    @Override
    public void exibirDados() {
        System.out.println("Conta Poupança:");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
        System.out.println("Taxa Selic: " + taxaSelic + "%");
    }
}