package br.ufla.gac106.s2022_2.sirios.times;
/**Subclasse de Time */
public class Clube extends Time{
    private String pais;
    private String campeonato;

    public Clube(String nome, int qtdTitulos, String anoFundacao,String tecnico, String pais, String campeonato) {
        super(nome, qtdTitulos, anoFundacao, tecnico);
        this.pais = pais;
        this.campeonato = campeonato;
    }
    /**retorna seu pais de origem 
     * @return pais
    */
    public String getPais() {
        return pais;
    }
    /**
     * 
     * @return campeonato
     */
    public String getCampeonato() {
        return campeonato;
    }
    /**
     * @return toString da classe
     */
    @Override
    public String toString(){
        String texto = "";
        texto +=  super.toString() + "Seu pais de origem: " + getPais() + 
                    "\nO campeonato que esta disputando no momento: " + getCampeonato() + "\n";
        return texto;
    }
}
