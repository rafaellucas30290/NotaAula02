abstract class Conta {
    String titular;
    double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    public abstract void exibirDados();
}