import java.util.Scanner;

public class Caixa {
    private Scanner input;
    private Conta conta1;
    private Conta conta2;

    public Caixa(){
       input = new Scanner(System.in);
    }

    public void menu(){
        System.out.println("1. Criar Conta");
        System.out.println("2. Consultar Saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Rendimento");
        System.out.println("6. Transferencia");
        System.out.println("7. Sair ");
    }

    public void executar(){
        int opcao;
        do{
            menu();
            System.out.println("\nDigite uma opcao: ");
            opcao = Integer.parseInt(input.nextLine());
            executarMenu(opcao);
        }
        while(opcao != 7);
    }

    public void executarMenu(int opcao){
        switch(opcao){
            case 1:
                criarConta();
            break;
            case 2:
               consultarSaldo();
            break;
            case 3:
                System.out.println("Digite o numero da conta: ");
                int numConta = input.nextInt();
                System.out.println("Digite o valor a ser depositado: ");
                double valor = input.nextDouble();
                depositar(numConta , valor);
            break;
            case 4:
                System.out.println("Digite o numero da conta: ");
                int numConta1 = input.nextInt();
                System.out.println("Digite o valor a ser sacado: ");
                double valor1 = input.nextDouble();
                sacar(numConta1 , valor1);
            break;
            case 5:
                rendimento();
            break;
            case 6:
                System.out.println("Digite a conta de origem");
                int numContaO = input.nextInt();
                System.out.println("Digite a conta de destino");
                int numContaD = input.nextInt();
                System.out.println("Digite o valor a ser enviado");
                double valorEnv = input.nextDouble();
                transferir(numContaO, numContaD, valorEnv);
            break;
            case 7:
                System.out.println("Obrigado por utilizar nosso caixa");
            break;
            default:
                System.out.println("Nao existe essa opcao");
        }
        if(opcao != 7){
            System.out.println("\n"+ "Digite ENTER para continuar!");
            input.nextLine();
        }
    }

    public void criarConta(){
        System.out.println("Digite os dados da primeira conta:");
        
        String nome;
        String cpf;
        System.out.println("Digite seu nome: ");
        nome = input.nextLine();
        System.out.println("Digite seu cpf: ");
        cpf = input.nextLine();
        Cliente c1 = new Cliente(nome, cpf);

        System.out.println("\nDigite os dados da segunda conta:");

        System.out.println("Digite seu nome: ");
        nome = input.nextLine();
        System.out.println("Digite seu cpf: ");
        cpf = input.nextLine();
        Cliente c2 = new Cliente(nome, cpf);

        System.out.println("\nEscolha umas das opcoes: ");
        System.out.println("1. Criar conta normal: ");
        System.out.println("2. Criar conta com valor inicial");
        
        double opcao;
        opcao = input.nextInt();
        double valorInicial;
        
        

        if(opcao == 1){
            conta1 = new Conta(c1 ,658912 ,100.0, -100.0);
            conta2 = new Conta(c2,998811 ,3000, -4000);
        }
        else if(opcao == 2){
            System.out.println("Digite o valor inicial da primeira conta:\n");
            valorInicial = input.nextDouble();      
            conta1 = new Conta(c1 ,658912 , valorInicial);

            System.out.println("Digite o valor inicial da segunda conta:\n");
            valorInicial = input.nextDouble();      
            conta2 = new Conta(c2 ,998811, valorInicial);

        }
        else{
            System.out.println("Opcao invalida");
        }
    }

    public void consultarSaldo(){
        System.out.println(conta1);
        System.out.print(conta2);
    }

    public void depositar(int numConta , double valor){
      

        if(numConta == conta1.getNumconta()){
            conta1.deposito(valor);
        }
        else if(numConta == conta2.getNumconta()){
            conta2.deposito(valor);
        }else {
            System.out.println("Essa conta nao existe");
        }
        
    }

    public void sacar(int numConta , double valor){
        if(numConta == conta1.getNumconta()){
            conta1.saque(valor);
        }
        else if(numConta == conta2.getNumconta()){
            conta2.saque(valor);
        }else {
            System.out.println("Essa conta nao existe");
        }
    }

    public void transferir(int contaOri , int contaDest , double valor){
        if(conta1.getNumconta() == contaOri && conta2.getNumconta() == contaDest){
            conta1.saque(valor);
            conta2.deposito(valor);
        }
        else if(conta2.getNumconta() == contaOri && conta1.getNumconta() == contaDest){
            conta2.saque(valor);
            conta1.deposito(valor);
        }else {
            System.out.println("Nao existe alguma dessas contas");
        }
    }

    public void rendimento(){
        int tempo;
        System.out.println("Digite o total de meses da conta 1: ");
        tempo = input.nextInt();
        conta1.render(tempo);
        System.out.println("Digite o total de meses da conta 2:");
        tempo = input.nextInt();
        conta2.render(tempo);

        System.out.println("Rendimento da conta 1: "+ conta1.getSaldo() + "\nRendimento da conta 2: " + conta2.getSaldo());

    }
}
