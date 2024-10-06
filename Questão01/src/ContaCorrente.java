class ContaCorrente extends Conta {
    private final double chequeEspecial = 1000.00;

    public ContaCorrente(String titular) {
        super(titular);
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente! Saldo atual: " + saldo);
        }
    }

    @Override
    public void exibirDados() {
        System.out.println("Conta Corrente:");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
        System.out.println("Cheque Especial: " + chequeEspecial);
    }
}