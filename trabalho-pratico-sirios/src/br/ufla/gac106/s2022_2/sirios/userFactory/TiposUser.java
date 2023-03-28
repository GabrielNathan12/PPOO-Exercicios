package br.ufla.gac106.s2022_2.sirios.userFactory;
/**Enum da classe User, para definir o tipo de usuario*/
public enum TiposUser {
    Comum(1),
    Moderador(2), 
    Administrador(3);

    private int id;
    
    private TiposUser(int id){
        this.id = id;
    }

    public static TiposUser peloID(int id){
        for (TiposUser tu: TiposUser.values()){
            if(tu.id == id){
                return tu;
            }
        }
        throw new RuntimeException("Nao existe esse id: " + id);
    }
}
