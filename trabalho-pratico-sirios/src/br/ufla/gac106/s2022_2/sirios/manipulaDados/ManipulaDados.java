package br.ufla.gac106.s2022_2.sirios.manipulaDados;
import java.util.ArrayList;

import br.ufla.gac106.s2022_2.sirios.userFactory.User;
import br.ufla.gac106.s2022_2.sirios.times.Time;
/**Interface responsavio para que outras classes facam a implementacao */
public interface ManipulaDados {
    void salvar(ArrayList<Time> info, String arquivo);
    void salvarUser(ArrayList<User> info, String arquivo);
    ArrayList<Time> carregarDados(String arquivo);
    ArrayList<User> carregarDadosUser(String arquivo);
}
