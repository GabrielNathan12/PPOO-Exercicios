package br.ufla.gac106.s2022_2.sirios.userFactory;
/**Subclasse de user */
public class UserComum extends User{
    
    public UserComum(String nome, int idade, String dataNasc, String userName, String email, String password){
        super(nome, idade, dataNasc, userName, email, password, TiposUser.Comum);
    }
}
