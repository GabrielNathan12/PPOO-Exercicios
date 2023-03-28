package br.ufla.gac106.s2022_2.sirios.controller;

import java.util.ArrayList;
import java.util.List;

import br.ufla.gac106.s2022_2.sirios.manipulaDados.Arquivo;
import br.ufla.gac106.s2022_2.sirios.manipulaDados.ManipulaDados;
import br.ufla.gac106.s2022_2.sirios.times.*;
import br.ufla.gac106.s2022_2.sirios.avaliacao.*;

    /**
    * Classe responsavel por criar e cuidar dos Array de Times e guardalos no arquivo
    */
public class TimesController {

    private ArrayList<Time> times;
    private ManipulaDados arq;

    public TimesController(){
        arq =  new Arquivo();
        times = new ArrayList<>();
        times.addAll(arq.carregarDados("tableTime"));
    }
        
    /**
    * adiciona uma selecao no array e atualiza o arquivo
    */
    public void addSelecao(String name, String anoFunda, int qtdTitulos, String tecnico, String cont , String tipo) {
        Time s = new Selecao(name, qtdTitulos, anoFunda, tecnico, cont, tipo);
        times.add(s);
        atualizarArquivo();
    }

    
    /**
    * adiciona um clube no array e atualiza o arquivo
    */
    public void addClube(String name, String anoFunda, int qtdTitulos, String tecnico, String pais, String campe) {
        Time c = new Clube(name, qtdTitulos, anoFunda, tecnico, pais, campe);
        times.add(c);
        atualizarArquivo();
    }
    
    /**
    * retorna o array de times 
    @return times;
    */
    public ArrayList<Time> getTimes(){
        return times;
    }
    
    /**
    * busca o nome de um time
        @param nomeTime 
        @return nome
    */
    public String getTime(String nomeTime){
        String texto = "";
        for(Time t: times){
            if(nomeTime.equals(t.getNome())){
                texto += t;
            }
        }
        return texto;
    }
    /**
    * busca o nome de um time
        @param nomeTime 
        @return nome
    */
    public String buscarTime(String nome){
        String texto = "";

        for(Time t : times){
            if(t.getNome().equals(nome)){
                texto += t.toString() + "\n";
            }
        }
        return texto;
    }

      /**
        * Atualiza o arquivo de times
        */
    private void atualizarArquivo(){
        arq.salvar(times, "tableTime");
    }

    /**
    * Exclui o time do arquivo pelo seu nome
        @param nomeTime 
    */
    public void removeTime(String name){
        for(int i = 0; i < times.size(); i++){
            if(times.get(i).getNome().equals(name)){
                times.remove(i);
                atualizarArquivo();
            }
        }
    }

    /**
    * Imprime todo o array de times
        @return nome
    */

    public String descricaoTime(){
        String texto = "";
        //time.addAll(arq.carregarDados("tableTime"));
        for (Time t : times) {
           texto += t;
        }
        return texto;
    }
     /**
    * adicona uma classificao ao time
        @param nomeTime 
        @param classificacao
    */
    public void adicionarClassificacao(String nomeTime, int classificacao) {
        for(Time t : times) {
            boolean temClassificacao = t.getTemAvaliacao();
            if (!temClassificacao) {
                temClassificacao = true;
            }
            t.setAvaliacao(nomeTime,classificacao);
            atualizarArquivo();
        }
    }
     /**
    * adiciona um comentario ao time
        @param nomeTime
        @param autor
        @param texto
        @param data 
      
    */
    public void adicionarComentario(String nomeTime, String autor, String texto, String data) {
        for(Time t : times) {
            if(t.getNome().equals(nomeTime)) {
                t.getComentarios().add(new Comentario(nomeTime, autor, texto, data));
                atualizarArquivo();
            }
        }
    }
    
     /**
    * busca filtra sem classificacao nenhuma
        @return semClassificacao
    */
    public String ordenarSemClassificacao() {
        String resultado = "";
        for(Time t : getTimes()) {
            boolean temClassificacao = t.getTemAvaliacao();
            if(!temClassificacao){
                resultado += t;
            }
        }
        return resultado;
    }
     /**
    * retorna a lista ordenada por nome
        @param List<Time> times 
        @return times
    */
    public List<Time> ordenarPorNome(List<Time> times) {
        times.sort((time1, time2) -> time1.getNome().compareToIgnoreCase(time2.getNome()));
        return times;
    }
     /**
    * retorna a lista ordenada por classificacao
        @param List<Time> time 
        @return times
    */
    public List<Time> ordenarPorClassificacao(List<Time> times) {
        times.sort((time1, time2) -> Double.compare(time2.getClassificacaoMedia(), time1.getClassificacaoMedia()));
        return times;
    }

}
