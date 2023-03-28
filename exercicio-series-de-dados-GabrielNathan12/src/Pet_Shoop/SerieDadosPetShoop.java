package Pet_Shoop;

import java.util.HashMap;

import series.SerieDados;

public class SerieDadosPetShoop implements SerieDados {
    private String ID;
    private int diaInicial;
    private int diaFinal;
    private HashMap<Integer, Integer> dados;

    public SerieDadosPetShoop(String ID, int diaInicial, int diaFinal){
        this.ID = ID;
        this.diaInicial = diaInicial;
        this.diaFinal = diaFinal;
        dados = new HashMap<>();
    }

    public boolean addDados(int dia, int peso){
        if(dia >= obterDiaInicial() && dia <= obterDiaFinal()){        
            if(dados.put(dia,peso) != null);
            return true;
        }
        return false;
    }

    @Override
    public String obterIdentificacaoSerie() {
        return ID;
    }

    @Override
    public int obterDiaInicial() {
        return diaInicial;
    }

    @Override
    public int obterDiaFinal() {
        return diaFinal;
    }

    @Override
    public int obterDado(int dia) {
       if( dia >= obterDiaInicial() && dia <= obterDiaFinal()){
            for(Integer s: dados.keySet()){
                if(s == dia){
                    return dados.get(s);
                }
            }
       }
        return 0;
    }


}
