public class Animal {
    private String nome;
    private int qtdPatas;
    private String som;
    private String especie;

    public Animal(String nome, int qtdPatas,String especie ,String som){
        this.nome = nome;
        this.qtdPatas = qtdPatas;
        this.especie = especie;
        this.som = som;
    }

    public String getNome(){
        return nome;
    }
    
    public int getPatas(){
        return qtdPatas;
    }

    public String getSom(){
        return som;
    }
    
    public String getEspecie(){
        return especie;
    }

    public String descricaoCurta(){
        String texto = "";
        texto += getNome() + " é um(a) " + getEspecie() + "\n";

        return texto;
    }
    public String descricaoLonga(){
        String texto = "";
        texto += getNome() + " é um(a) " + getEspecie() + " que faz " + getSom();
        return texto;
    }
}
