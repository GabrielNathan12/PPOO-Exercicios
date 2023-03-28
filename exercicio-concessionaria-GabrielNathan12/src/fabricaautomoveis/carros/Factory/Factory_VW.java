package fabricaautomoveis.carros.Factory;

import fabricaautomoveis.carros.Carros.Carro;
import fabricaautomoveis.carros.Carros.Categoria;
import fabricaautomoveis.carros.Carros.Gol;
import fabricaautomoveis.carros.Carros.Amarock;
import fabricaautomoveis.carros.Carros.XLSport;

public class Factory_VW extends Factory_Carro{
    @Override
    public Carro criarCarro(Categoria categoria, String cor){
        Carro c = null;
        if(Categoria.POPULAR == categoria){
            c = new Gol(cor);
        }else if(Categoria.PICKUP == categoria){
            c = new Amarock(cor);
        }else if(Categoria.LUXO == categoria){
            return c = new XLSport(cor);
        }
        return c;
    }
}
