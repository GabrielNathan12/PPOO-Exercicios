import Pet_Shoop.Controle;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {
    public void executar() {
        Controle c =  new Controle();
        VisualizadorSeries vs =  new VisualizadorSeries(c.getDadosArray());
        
        for(SerieDados s: c.getDadosArray()){
            System.out.println("Dados da Serie: " + s.obterIdentificacaoSerie());
            for(int i = s.obterDiaInicial(); i < s.obterDiaFinal(); i++){
                System.out.println("Dias: " + i + " = "+ s.obterDado(i) + " K(g)");
            }
        }

        vs.exibir();
    }
}
