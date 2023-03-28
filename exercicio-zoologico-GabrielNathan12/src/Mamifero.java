public class Mamifero extends Animal{
    private String corPelo;
   

    public Mamifero(String nome,String especie ,String corPelo, String som){
        super(nome, 4,especie ,som);
        this.corPelo = corPelo;       
    }

    public String getCor(){
        return corPelo;
    }

    @Override
    public String descricaoLonga(){
        String texto = "";
        texto += super.descricaoLonga() + " e tem pelo " + getCor() + "\n";
        return texto; 
    }
}
