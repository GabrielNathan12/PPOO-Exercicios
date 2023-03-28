package br.ufla.gac106.s2022_2.sirios.userFactory;

/**Padrao de projeto Factory
 * @return User
*/
public class Factory{
    public User criarUsuario(String nome, int idade, String dataNasc ,String userName, String email, String password, TiposUser t){
        
        if (TiposUser.Comum == t){
            return new UserComum(nome, idade, dataNasc, userName, email, password);
        }
        else if(TiposUser.Moderador == t){
            return new Moderador(nome, idade, dataNasc, userName, email, password);
        }
        else if(TiposUser.Administrador == t){
            return new Administrador(nome, idade, dataNasc, userName, email, password);
        }
    
        return null;

    }

}
