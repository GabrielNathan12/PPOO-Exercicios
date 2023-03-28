import java.util.ArrayList;

public class Zoologico {
    private ArrayList<Animal> animais;
 
    public Zoologico(){
        animais = new ArrayList<>();
    }

    public void addLeao(String nome, String corPelo){
        Leao le = new Leao(nome, corPelo);
        animais.add(le);
    }

    public void addGorila(String nome , String corPelo){
        Gorila go = new Gorila(nome, corPelo);
        animais.add(go);
    }

    public void addEma(String nome, String info){
        Ema ema = new Ema(nome, info);
        animais.add(ema);
    }

    public void addArara(String nome , String info){
        Arara ara = new Arara(nome, info);
        animais.add(ara);
    }

    public String descricaoCompleta(){
        String texto = "";

        for(Animal a: animais){
            texto += a.descricaoLonga();
        }

        return texto;
    }

    public String descricaoResumida(){
        String texto = "";

        for(Animal a: animais){
            texto += a.descricaoCurta();
        }

        return texto;
    }

    public String buscar(String nome){
        for(Animal i: animais){
            if(i.getNome().equals(nome)){
                return i.descricaoLonga();
            }
        }
        return "Animal não encontrado\n ";
    }

}
