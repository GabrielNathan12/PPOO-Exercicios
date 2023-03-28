package fabricaautomoveis.carros.Factory;

import fabricaautomoveis.carros.Carros.Camaro;
import fabricaautomoveis.carros.Carros.Carro;
import fabricaautomoveis.carros.Carros.Categoria;
import fabricaautomoveis.carros.Carros.Onix;
import fabricaautomoveis.carros.Carros.Montana;

public class Factory_Chevrolet extends Factory_Carro{
    @Override
    public Carro criarCarro(Categoria cartegoria, String cor){
        Carro c = null;
        if(Categoria.POPULAR == cartegoria){
            c = new Onix(cor);
        }
        else if(Categoria.PICKUP == cartegoria){
            c = new Montana(cor);
        }
        else if (Categoria.LUXO == cartegoria){
            c = new Camaro(cor);
        }
        return c;
    }
}
