/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.carros.Carros.Categoria;
import fabricaautomoveis.carros.Carros.Marca;
import fabricaautomoveis.carros.Factory.Factory_Carro;
import fabricaautomoveis.carros.Factory.Factory_VW;

import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
        
    public void exibir() {
        
        ppooVeiculos = new Concessionaria("PPOO Veículos", Marca.FIAT);
        entrada = new Scanner(System.in);
        
        int opcao;        
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    escolherUmaFranquia();
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Escolha a Franquia");
        System.out.println("2 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }

    private void imprimirMarcas(){
        System.out.println("Você deseja qual franquia de carros?\n");
        System.out.println("1 - VW");
        System.out.println("2 - FIAT");
        System.out.println("3 - CHEVROLET");
    }

    public void escolherUmaFranquia(){
        imprimirMarcas();

        Factory_Carro cf = new Factory_VW();

        int opcao = Integer.parseInt(entrada.nextLine());

        if (opcao == 1){
            ppooVeiculos.trocarFranquia(Marca.VW, cf);
        }
        else if(opcao == 2){
            ppooVeiculos.trocarFranquia(Marca.FIAT, cf);
        }
        else if(opcao == 3){
            ppooVeiculos.trocarFranquia(Marca.CHEVROLET, cf);
        }
    }
    
    private void esperarTecla() {
        entrada.nextLine();
    }
}

