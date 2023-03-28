package br.ufla.gac106.s2022_2.sirios.controller;
import java.util.ArrayList;

import br.ufla.gac106.s2022_2.base.relatorios.Grafico;
import br.ufla.gac106.s2022_2.sirios.avaliacao.AvaliacoesTema;
import br.ufla.gac106.s2022_2.sirios.manipulaDados.Arquivo;
import br.ufla.gac106.s2022_2.sirios.manipulaDados.ManipulaDados;
import br.ufla.gac106.s2022_2.sirios.userFactory.Factory;
import br.ufla.gac106.s2022_2.sirios.userFactory.TiposUser;
import br.ufla.gac106.s2022_2.sirios.userFactory.User;
    /**
    * Classe responsavel por criar e cuidar dos Array de Times e guardalos no arquivo
    */
public class UserController {
    
    private ArrayList<User> users;
    private ManipulaDados arq;
    private AvaliacoesTema avaliacoes;
    private Grafico grafico;

    public UserController(){
        arq =  new Arquivo();
        users = new ArrayList<>();
        users.addAll(arq.carregarDadosUser("tableUser"));
        avaliacoes = new AvaliacoesTema("Times");
        grafico = new Grafico();
        
    }
    /**
    * adiciona um novo usuario no arquivo
    @param nome
    @param username
    @param idade
    @param dataNascimento
    @param email
    @param passord
    @param TipoUser
    */

    public void addUser(String name, String username, int idade, String dataNas, String email, String password, TiposUser t) {
        Factory f = new Factory();  
        users.add(f.criarUsuario(name, idade, dataNas, username, email, password, t));
        atualizarArquivoUser();
    }
    /**
    * Plota o grafico na tela
    */
    public void plotarGrafico(){
        grafico.exibir("Avaliacoes dos Times", avaliacoes);
    }

    /**
    * remove o usuario atravez de seu username
    @param username
    */
    public void removeUsuario(String username) {
        for (int i=0; i < users.size(); i++){
            if(users.get(i).getUserName().equals(username)){
                users.remove(i);
                atualizarArquivoUser();
            }
        }
    }
    /**
    * retorna o array de usuarios
    */
    public ArrayList<User> getUser(){
        return users;
    }
    /**
    * verifica a senha do usuario
    @param passoword
    @param userName
    @return bollean
    */
    public boolean verificaSenha(String passaword, String userName){

        for (User u:users){
            if(userName.equals(u.getUserName())){
                if(passaword.equals(u.getPassword()) ){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * verifica se o usuario se encontra no arquivo 
    @return boolean
    */
    public boolean verificaUsername(String userName){
        for(User u: users){
            if(userName.equals(u.getUserName())){
                return true;
            }
        }
        return false;
    }
   /**
    * retorna o usuario de acordo com o seu nome
    @param nome
    @return texto
    */
    public String getUser(String nome){
        String texto = "";

        for(User u: users){
            if(nome.equals(u.getNome())){
                texto += u;
            }
        }
        return texto;
    }

    /**
    * atualiza o arquivo de usuarios 
    */
    private void atualizarArquivoUser(){
        arq.salvarUser(users, "tableUser");
    }
    /**
    * retorna toda a descricao de usuarios 
    */
    public String descricaoUser(){
        String texto = "";
        
        for (User u : users) {
            texto += u + "\n";
        }
        return texto;
    }

}