package fabricaautomoveis.carros.Factory;

import fabricaautomoveis.carros.Carros.Carro;
import fabricaautomoveis.carros.Carros.Categoria;

public abstract class Factory_Carro {
    public abstract Carro criarCarro(Categoria categoria, String cor);
}
