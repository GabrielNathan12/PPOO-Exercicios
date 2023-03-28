package br.ufla.gac106.s2022_2.sirios.userFactory;
/**Subclasse de User */
public class Moderador extends User {
    public Moderador(String nome, int idade, String dataNasc, String userName, String email, String password){
        super(nome, idade, dataNasc, userName, email, password, TiposUser.Moderador);
    }
}
