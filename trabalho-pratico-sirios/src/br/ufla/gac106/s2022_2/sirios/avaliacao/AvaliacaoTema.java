package br.ufla.gac106.s2022_2.sirios.avaliacao;

import java.io.Serializable;

import br.ufla.gac106.s2022_2.base.Avaliacao;
/**
 * Classe que implementa a interface Avaliacao e a interface Serializable
 */

public class AvaliacaoTema implements Avaliacao, Serializable {
    
    private String nome;
    private double nota;

    public AvaliacaoTema(String nome , double nota) {
        this.nome = nome;
        this.nota = nota;
    }
    /**
    * Sobrescreve o metodo nomeItemAvalidado da interface
        @return nome
    */
    @Override
    public String nomeItemAvaliado() {
        return nome;
    }
    
    /**
    * Sobrescreve o metodo nomeItemAvalidado da interface
        @return nota
    */
    @Override
    public double classificacaoMedia() {
        return nota;
    }
    
    /**
    * Metodo ToString da classe Avaliacao
        @return String
    */

    @Override
    public String toString() {
        return "\n    Avaliacao: " + classificacaoMedia(); 
    }
    
}
