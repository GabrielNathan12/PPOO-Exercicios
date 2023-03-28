public class Teste {

    public static String exibirDescricaoCompleta(Animal a){
        String texto = "";
        texto += a.descricaoLonga();
        return texto;
    }
    public static void main(String[] args){
        Animal a = new Leao("Mufasa" , "Laranja");
        //System.out.println(a.getNome());

        //a = new Arara("Nigel" , "Bem");
        //System.out.println(a.getNome());
        
        a = new Ema("patolino", "Muito mal");
        System.out.println(exibirDescricaoCompleta(a));

    }
}
