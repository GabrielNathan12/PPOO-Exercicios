package br.ufla.gac106.s2022_2.sirios.avaliacao;

import java.io.Serializable;

    /**
    * Classe que responsavel por guardas os comentarios do usuario
    */

public class Comentario implements Serializable {
    private String autor;
    private String texto;
    private String data;

    public Comentario(String nomeTime ,String autor, String texto, String data) {
        this.autor = autor;
        this.texto = texto;
        this.data = data;
    }
    
    /**
    * retorna o nome do autor que fez o cometario
    @return autor
    */
    public String getAutor() {
        return autor;
    }
    
    /**
    * retorna o texto da mensagem
    @return texto
    */
    public String getTexto() {
        return texto;
    }
    
    /**
    * retorna a data da mensagem
        @return data
    */
    public String getData() {
        return data;
    }
    
    /**
    * Sobrescreve o metodo nomeItemAvalidado da interface
        @return string
    */

    @Override
    public String toString() {
        return " " + getTexto() + "\n" + "   Autor: " + getAutor() + "\n" + "    Data: " + getData() + "\n";
    }
}
