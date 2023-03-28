package br.ufla.gac106.s2022_2.sirios.avaliacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.ufla.gac106.s2022_2.base.Avaliacao;
import br.ufla.gac106.s2022_2.base.Avaliacoes;

    /**
    * Classe que implementa a  interface Avaliacoes
    */
public class AvaliacoesTema implements Avaliacoes {

    private List<Avaliacao> avaliacoes;
    private String tema;

    public AvaliacoesTema(String tema){
        avaliacoes = new ArrayList<>();
        this.tema = tema;
    }
    
    /**
    * Sobrescreve o metodo temaAvaliacao da interface
        @return tema
    */
    @Override
    public String temaAvaliacao() {
        return tema;
    }
    
    /**
    * Sobrescreve o metodo colecaoAvaliacoes da interface
        @return avaliacoes
    */
    @Override
    public Collection<Avaliacao> colecaoAvaliacoes() {
        return avaliacoes;
    }
    
}
