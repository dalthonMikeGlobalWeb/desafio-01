public class Main {
    public static void main(String[] args) {

        Cliente Dalthon = new Cliente();
        Dalthon.setNome("Dalthon");
        Conta cc = new ContaCorrente(Dalthon);
        Conta contaPoupnca = new ContaPoupanca(Dalthon);

        cc.depositar(100);
        cc.transferir(50, contaPoupnca);

        cc.imprimirInforcomuns();
        contaPoupnca.imprimirInforcomuns();
    }
}
