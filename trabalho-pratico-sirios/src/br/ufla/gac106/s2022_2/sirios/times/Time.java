package br.ufla.gac106.s2022_2.sirios.times;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufla.gac106.s2022_2.base.Avaliacao;
import br.ufla.gac106.s2022_2.sirios.avaliacao.AvaliacaoTema;
import br.ufla.gac106.s2022_2.sirios.avaliacao.Comentario;

/**
 * Super classe time, ela implementa a interface Serializable para guardar no arquivo e a interface avaliacao para que o usuario consiga fazer avaliacao de um time
 */
public class Time implements Serializable, Avaliacao{
    
    private String nome;
    private int qtdTitulos;
    private String anoFundacao;
    private String tecnico;
    private double classificacaoMedia;
    private boolean temAvaliacao;
    private List<Comentario> comentarios;
    private List<AvaliacaoTema> avaliacoes;
    
    public Time(String nome, int qtdTitulos, String anoFundacao, String tecnico) {
        this.nome = nome;
        this.qtdTitulos = qtdTitulos;
        this.anoFundacao = anoFundacao;
        this.tecnico = tecnico;
        this.avaliacoes = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.temAvaliacao = false;
    }
    /**retorna o nome do time
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * retorna a quantidade de titulos do time
     * @return qtdTitulos
     */
    public int getQtdTitulos() {
        return qtdTitulos;
    }

    /**
     * retorna o ano de fundacao do time
     * @return anoFundacao
     */
    public String getAnoFundacao() {
        return anoFundacao;
    }
    /**
     * retorna o tecnico do time
     * @return tecnico
     */
    public String getTecnico() {
        return tecnico;
    }
    /**
     * retorna a lista de avaliacoes
     * @return avaliacoes
     */
    public List<AvaliacaoTema> getAvaliacoes() {
        return avaliacoes;
    }
    /**adiciona uma nova avaliacao ao time
     * @param nome
     * @param avaliacao
     */
    public void setAvaliacao(String nome, int avaliacao) {
        AvaliacaoTema avalia = new AvaliacaoTema(nome, avaliacao);
        avaliacoes.add(avalia);
    }
    /**retorna a classificacao media de cada time 
     * @return classificacaoMedia
    */
    public double getClassificacaoMedia() {
        return classificacaoMedia;
    }
    /**
     * retorna a lista de comentarios 
     * @return comentarios
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }
    /**
     * retorna os comentarios concatenados em uma string
     * @return comentarios
     */
    public String getStringComentarios() {
        String comentarios = "";
        for(Comentario c : getComentarios()) {
            comentarios += "Comentario:" + c;
        }
        return comentarios;
    }
    /**
     * retorna as avaliacoes concatenados em uma string
     * @return avaliacoes
     */
    public String getStringAvaliacoes() {
        String avaliacoesString = "";
        for(AvaliacaoTema a : avaliacoes) {
            avaliacoesString += a;
        }
        return avaliacoesString;
    }
    /**
     * verifica se tem avaliacao
     * @return temAvaliacao
     */
    public boolean getTemAvaliacao() {
        return temAvaliacao;
    }
    /**
     * calcula a media de cada time
     */

    public double getMediaAvaliacoes() {
        double soma = 0.0;
        double media = 0.0;
        for(AvaliacaoTema a : avaliacoes) {
            if (avaliacoes.isEmpty()) {
                media = 0.0;
                return media;
            }
            double avaliacao = a.classificacaoMedia();
            soma += avaliacao;
        }
        media = soma / getAvaliacoes().size();
        return media; 
    }
    /**
     * toString da classe
     * @return string
     */
    public String toString(){
        String texto = "";

        texto += "\nNome da Equipe: " + getNome() + "\nSua quantidade de titulos: " + getQtdTitulos() 
                +"\nO ano de fudacao do equipe: " + getAnoFundacao() + "\nTecnico no comando agora da equipe: " + getTecnico() 
                +"\n" + "Comentarios: \n" + getStringComentarios() + "Avaliacoes: " + getStringAvaliacoes()
                + "\nAvaliacao media: " + getMediaAvaliacoes() + "\n";
        return texto;
    }
    /**
     * sobrescreve o metetodo da interface Avaliacoes
     * @return nome
     */
    @Override
    public String nomeItemAvaliado() {
        return nome;
    }
    /**
     * sobrescreve o metetodo da interface Avaliacoes
     * @return classificacaoMedia
     */
    @Override
    public double classificacaoMedia() {
        return classificacaoMedia;
    }
}
