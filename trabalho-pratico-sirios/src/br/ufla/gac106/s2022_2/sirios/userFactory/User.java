package br.ufla.gac106.s2022_2.sirios.userFactory;

import java.io.Serializable;
/**SuperClasse User */
public abstract class User implements Serializable {
    private String nome;
    private int idade;
    private String dataNasc;
    private String userName;
    private TiposUser tipoUser;
    private String email;
    private String password;

    public User(String nome, int idade, String dataNasc, String userName, String email, String password, TiposUser tipoUser){
        this.nome = nome;
        this.idade = idade;
        this.dataNasc = dataNasc;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.tipoUser = tipoUser;
    }
    /**retorna o nome
     * @return nome
    */
    public String getNome(){
        return nome;
    }
    
    /**retorna a idade
     * @return idade
    */
    public int getIdade(){
        return idade;
    }
    
    /**retorna a data de nascimento
     * @return dataNasc
    */
    public String getDataNasc(){
        return dataNasc;
    }
    
    /**retorna o userName
     * @return userName
    */
    public String getUserName(){
        return userName;
    }
    
    /**retorna o tipo de usuario
     * @return tipoUser
    */
    public TiposUser getTipoUser(){
        return tipoUser;
    }
    
    /**retorna o email
     * @return email
    */
    public String getEmail(){
        return email;
    }
    
    /**retorna a senha
     * @return senha
    */
    public String getPassword(){
        return password;
    }
    
    /**toString da classe
     * @return String
    */
    @Override
    public String toString(){
        return "Nome: " + getNome() +"\nIdade:"+ getIdade() + "\nUser Name: "+ getUserName() +
                "\nTipo de usuario: "+ getTipoUser() + "\nEmail: " + getEmail() + "\n";
    }
}
