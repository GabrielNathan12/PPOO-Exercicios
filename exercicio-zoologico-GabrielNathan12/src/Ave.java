public class Ave extends Animal{
    private String infoVoo;

    public Ave(String nome ,String especie ,String infoVoo, String som){
        super(nome, 2,especie, som);
        this.infoVoo = infoVoo;
    }

    public String getInfo(){
        return infoVoo;
    }

    @Override
        public String descricaoLonga(){
            String texto = "";
            texto += super.descricaoLonga() + " e voa " + getInfo() + "\n";
            return texto; 
        }
   
}
