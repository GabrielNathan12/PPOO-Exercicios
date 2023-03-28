package br.ufla.gac106.s2022_2;
import java.util.Scanner;

import br.ufla.gac106.s2022_2.sirios.views.*;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------\n" 
                            +"Qual Interface deseja executar ?\n" 
                            + "1 - Grafica\n"
                            + "2 - Terminal\n"
                            + "-----------------------------------\n"
                            + "Digite uma opcao: ");
        int opcao = input.nextInt();
        if(opcao == 1) {
            Gui g = new Gui();
            g.executar();
        } else {
            InterfaceUsuario iu = new InterfaceUsuario();
            iu.executar();
        }
        input.close();
    }
}
