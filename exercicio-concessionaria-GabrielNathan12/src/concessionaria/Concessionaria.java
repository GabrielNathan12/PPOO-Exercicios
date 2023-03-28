package concessionaria;

import fabricaautomoveis.carros.Carros.Carro;
import fabricaautomoveis.carros.Carros.Categoria;
import fabricaautomoveis.carros.Carros.Marca;
import fabricaautomoveis.carros.Factory.Factory_Carro;
import java.util.ArrayList;
import java.util.List;
import detran.GeradorDePlaca;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private List<Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;
    private Factory_Carro fatCarro;
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, Marca marca) {
        this.nome = nome;        
        this.marcaFranquia = marca;
        carros = new ArrayList<>();
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }
    
    public void trocarFranquia(Marca marca, Factory_Carro modelo){
        this.marcaFranquia = marca;
        this.fatCarro = modelo;
    }
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro;
        
        carro = fatCarro.criarCarro(categoria, cor);

        if (carro != null) {
            carro.emplacar(GeradorDePlaca.gerarPlaca());
            carro.prepararParaEntrega();
            carro.liberarDocumentacao();
            carros.add(carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
