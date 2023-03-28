public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }
}
