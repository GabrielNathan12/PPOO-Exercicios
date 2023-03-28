public class Conta {
    private double limite;
    private double saldo;
    private Cliente c;
    private double valorInicial;
    private int numConta;
    private static int ultimaConta;
    private static double percentual;

    public Conta(Cliente c ,int numConta ,double saldo , double limite){
        this.c = c;
        this.saldo = saldo;
        this.limite = limite;
        this.numConta = numConta;
        percentual = 0.09;
        ultimaConta++;
    }

    public Conta(Cliente c,int numConta ,double valorInicial){
        this.c = c ;
        this.saldo = 0;
        this.valorInicial = valorInicial;
        this.numConta = numConta;
        limite = 0;
        percentual = 0.07;  
        ultimaConta++;  
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
        saldo *= percentual + tempo;
    }

    public String toString(){
        return "Nome: " + c.getNome() + "\n" + "Saldo: " + getSaldo() + "\n" + "Numero da Conta: " + getNumconta() +"\n";
    }
}
