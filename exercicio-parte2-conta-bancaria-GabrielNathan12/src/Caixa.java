import java.util.ArrayList;
import java.util.Scanner;

public class Caixa {
    private Scanner input;
    private ArrayList<Conta> contas;

    public Caixa(){
       input = new Scanner(System.in);
       contas = new ArrayList<>();
    }

    public void menu(){
        System.out.println("1. Criar Conta");
        System.out.println("2. Consultar Saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Rendimento");
        System.out.println("6. Transferencia");
        System.out.println("7. Listar Contas");
        System.out.println("8. Remover conta");
        System.out.println("9. Sair ");
    }

    public void executar(){
        int opcao;
        do{
            menu();
            System.out.println("\nDigite uma opcao: ");
            opcao = Integer.parseInt(input.nextLine());
            executarMenu(opcao);
        }
        while(opcao != 9);
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
                Integer numConta = Integer.parseInt(input.nextLine());
                System.out.println("Digite o valor a ser depositado: ");
                double valor = input.nextDouble();
                depositar(numConta , valor);
            break;
            case 4:
                System.out.println("Digite o numero da conta: ");
                Integer numConta1 = Integer.parseInt(input.nextLine());
                System.out.println("Digite o valor a ser sacado: ");
                double valor1 = input.nextDouble();
                sacar(numConta1 , valor1);
            break;
            case 5:
                System.out.println("Digite o numero da conta: ");
                int numConta3 = input.nextInt();
                rendimento(numConta3);
            break;
            case 6:
                System.out.println("Digite a conta de origem");
                Integer numContaO = Integer.parseInt(input.nextLine());
                System.out.println("Digite a conta de destino");
                Integer numContaD = Integer.parseInt(input.nextLine());
                System.out.println("Digite o valor a ser enviado");
                double valorEnv = input.nextDouble();
                transferir(numContaO, numContaD, valorEnv);
            break;
            case 7:
                consultasListasContas();
            break;
            case 8:
                System.out.println("Digite o numero da conta: ");
                int numContaR = input.nextInt();
                removerConta(numContaR);
            break;
            case 9:
                System.out.println("Obrigado por utilizar nosso caixa");
            break;
            default:
                System.out.println("Nao existe essa opcao");
        }
        if(opcao != 9){
            System.out.println("\n"+ "Digite ENTER para continuar!");
            input.nextLine();
        }
    }

    public void criarConta(){
        
        System.out.println("Digite uma opcao:");
        System.out.println("1. Conta com Saldo e limite dados pelo usuario");
        System.out.println("2. Conta com Saldo 0 e valor inicial");
        
        Integer opcao = Integer.parseInt(input.nextLine());
        
        
        
        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();
        
        System.out.println("Digite seu cpf: ");
        String cpf = input.nextLine();
        
        Cliente c = new Cliente(nome, cpf);
        

        if(opcao == 1){
            System.out.println("Digite o saldo: ");
            double saldo;
            saldo = input.nextDouble();
            
            System.out.println("Digite o limite da conta:");
            double limite;
            limite = input.nextDouble();
            contas.add(new Conta(c, saldo, limite));
        }
        else if(opcao == 2){
            System.out.println("Digite o valor inicial: ");
            double valorIni;
            valorIni = input.nextDouble();
            
            contas.add(new Conta(c, valorIni));
        }
        else{
            System.out.println("Opcao Invalida, conta nao criado");
        }
    }

    public void consultarSaldo(){
        for(Conta c: contas){
            System.out.println("Saldo das contas : " + c.getSaldo());
        }
    }

    public void depositar(int numConta , double valor){
        for(Conta c: contas){
            if(c.getNumconta() == numConta){
                c.deposito(valor);
            }
        }
    }

    public void sacar(int numConta , double valor){
        for(Conta c: contas){
            if(c.getNumconta() == numConta){
                c.saque(valor);
            }
        }
    }

    public void transferir(int contaOri , int contaDest , double valor){
        for(Conta c: contas){
            if(c.getNumconta() == contaOri){
                c.saque(valor);
            }
        }
        for(Conta c: contas){
            if(c.getNumconta() == contaDest){
                c.deposito(valor);
            }
        }
    }

    public void removerConta(int numConta){
        for(int i = 0; i < contas.size(); i++){
            if(contas.get(i).getNumconta() == numConta){
                if(contas.get(i).getSaldo() > 0){
                    System.out.println("Nao e possivel remover existe saldo ainda na conta");
                   
                }
                else if(contas.get(i).getSaldo() < 0){
                    System.out.println("Nao e possivel remover sua conta esta negativada" );
                }
                else{
                    contas.remove(i);
                }
            }
        }
    }

    public void consultasListasContas(){
       for (Conta c : contas){
            System.out.println(c);
       }
    }

    public void rendimento(int numConta){
        int tempo;
        System.out.println("Digite o total de meses da conta: ");
        tempo = input.nextInt();
        
        for(Conta c: contas){
            if(c.getNumconta() == numConta){
                c.render(tempo);
                System.out.println("Rendimento da conta : "+ c.getSaldo());
        
            }
        }
    }
}
