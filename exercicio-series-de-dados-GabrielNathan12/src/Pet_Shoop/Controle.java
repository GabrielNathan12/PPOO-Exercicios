package Pet_Shoop;
import java.util.ArrayList;

import series.SerieDados;

public class Controle {
    private ArrayList<SerieDados> sd;

    public Controle(){
        sd = new ArrayList<>();
        SerieDadosPetShoop petShoop =  new SerieDadosPetShoop("Cao", 1, 5);
        petShoop.addDados(1, 20);
        petShoop.addDados(2, 10);
        petShoop.addDados(3, 11);
        petShoop.addDados(4, 80);
        petShoop.addDados(5, 0);
        
        SerieDadosPetShoop petShoop2 = new SerieDadosPetShoop("Gato", 1, 4);
        petShoop2.addDados(1, 5);
        petShoop2.addDados(2, 8);
        petShoop2.addDados(3, 3);
        petShoop2.addDados(4, 3);
        sd.add(petShoop);
        sd.add(petShoop2);
    }
    
    public ArrayList<SerieDados> getDadosArray(){
        return sd;
    }
}
