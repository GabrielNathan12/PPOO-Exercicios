import java.util.ArrayList;

// Maculados e como os personagens humanos de elder ring sao chamados kkkk

public class Maculado {
    private String nome;
    private ArrayList<Item> mochila;

    public Maculado(String nome){
        this.nome = nome;
        mochila =  new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void addItem(Item i){
        mochila.add(i);
    }

    public void removeItem(String nome){
        for(int i = 0; i < mochila.size(); i++){
            if(mochila.get(i).getDescricaoItem().equals(nome)){
                mochila.remove(i);
            }
        }
    }

    public String listarItens(){
        String texto = "";

        for(Item d: mochila){
            texto = texto + d.getDescricaoItem() + " ";
        }
        return texto;
    }
}
