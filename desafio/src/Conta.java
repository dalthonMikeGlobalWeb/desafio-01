public abstract class Conta implements  IConta{

    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saldo atual " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente");
        }

    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito no valor de " + valor + " efetuado com sucesso");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= this.saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Translação efetuada com sucesso para a conta com o número " + contaDestino.getNumero());
        } else {
            System.out.println("Saldo insuficiente para essa operação");
        }
    }

    protected void imprimirInforcomuns() {
        System.out.println(String.format("*** INFORMAÇÕES ***"));
        System.out.println(String.format("Titular: " +  this.cliente.getNome()));
        System.out.println(String.format("Agência: " + this.agencia));
        System.out.println(String.format("Número: " + this.numero));
        System.out.println(String.format("Saldo: " +  this.saldo));
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
