public class Item {
    private String descricao;
    private int peso;

    public Item(String umaDescricao, int umPeso){
        this.descricao = umaDescricao;
        this.peso = umPeso;
    }

    public String getDescricaoItem(){
        return descricao;
    }
    
    public int getPeso(){
        return peso;
    }
}
