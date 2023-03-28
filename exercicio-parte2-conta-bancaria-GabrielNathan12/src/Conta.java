public class Conta {
    private double limite;
    private double saldo;
    private Cliente c;
    private double valorInicial;
    private int numConta;
    private static int ultimaConta = 100;
    private static double percentual;

    public Conta(Cliente c ,double saldo , double limite){
        this.c = c;
        this.saldo = saldo;
        this.limite = limite;
        percentual = 0.09;
        ultimaConta++;
        numConta = ultimaConta;
    }

    public Conta(Cliente c, double valorInicial){
        this.c = c;
        percentual = 0.6;
        ultimaConta++;
        numConta = ultimaConta;
        saldo = 0;
    }

    public int getNumconta(){
        return numConta;
    }

    public int getUltimaConta(){
        return ultimaConta;
    }

    public double getValorInicial(){
        return valorInicial;
    }

    public double getLimite(){
        return limite;
    }

    public double getSaldo(){
        return saldo;
    }

    public void saque(double valor){
        
        if(getSaldo() <= getLimite()){
            System.out.println("Saldo insuficiente:");
        }else{
            saldo -= valor;
        }
    }
    
    public void deposito(double valor){
        saldo += valor;
    }

    public void render(int tempo){
        saldo += percentual * tempo;
    }

    public String toString(){
        return "Nome: " + c.getNome() + "\n" + "Numero da Conta: " + getNumconta() +"\n";
    }
}
