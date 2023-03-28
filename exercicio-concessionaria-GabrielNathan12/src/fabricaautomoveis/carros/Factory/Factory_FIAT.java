package fabricaautomoveis.carros.Factory;

import fabricaautomoveis.carros.Carros.Argo;
import fabricaautomoveis.carros.Carros.Carro;
import fabricaautomoveis.carros.Carros.Categoria;
import fabricaautomoveis.carros.Carros.Strada;
import fabricaautomoveis.carros.Carros.Toro;

public class Factory_FIAT extends Factory_Carro{
    @Override
    public Carro criarCarro(Categoria categoria, String cor){
        Carro c = null;
        
        if(Categoria.POPULAR == categoria){
            c = new Argo(cor);
        }
        else if(Categoria.LUXO == categoria){
            c = new Toro(cor);
        }
        else if(Categoria.PICKUP == categoria){
            c = new Strada(cor);
        }
        return c;
    }
}
