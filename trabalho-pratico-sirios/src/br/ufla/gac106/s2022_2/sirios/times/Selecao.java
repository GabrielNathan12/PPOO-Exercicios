package br.ufla.gac106.s2022_2.sirios.times;

/**
 * Subclasse de Time
 */
public class Selecao extends Time {

    private String continente;
    private String categoria;

    public Selecao(String nome, int qtdTitulos, String anoFundacao ,String tecnico , String continente, String categoria) {
        super(nome, qtdTitulos, anoFundacao, tecnico);
        this.continente = continente;
        this.categoria = categoria;
    }
    /**
     * retorna o continente da selecao
     * @return continente
     */
    public String getContinente() {
        return continente;
    }
    /**
     * categoria da selecao (masculino ou feminino)
     * @return categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /** toString da classe
     * @return string
     */
    @Override
        public String toString(){
            String texto = "";
            texto +=  super.toString() + "Seu continente: " + getContinente() + "\n"+
                        "A categoria da seleção(Masculino/Fenimino): " + getCategoria() + "\n";
            return texto;
        }

}