package br.ufla.gac106.s2022_2.sirios.manipulaDados;

import java.io.*;
import java.util.ArrayList;

import br.ufla.gac106.s2022_2.sirios.userFactory.User;
import br.ufla.gac106.s2022_2.sirios.times.Time;

public class Arquivo implements ManipulaDados,Serializable{
    /**Passa o array de times como parametro e o nome do arquivo para poder salvar modificacoes* */ 
    
    @Override
    public void salvar(ArrayList<Time> info, String arquivo) {
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("src/br/ufla/gac106/s2022_2/sirios/db/"+arquivo)))
        {    
                oss.writeObject(info);
        }
        catch(IOException e){
            System.err.println("Erro ao salvar o arquivo!!!"+ e.getMessage());
        }
    }
    /** Passa o array de user como parametro e o nome do arquivo para poder salvar modificacoes*/
    @Override
    public void salvarUser(ArrayList<User> info, String arquivo) {
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("src/br/ufla/gac106/s2022_2/sirios/db/"+arquivo)))
        {
            oss.writeObject(info);
        }
        catch(IOException e){
            System.err.println("Erro ao salvar o arquivo!!!"+ e.getMessage());
        }
    }
    /**Carrega os dados do arquivo para poder jogar no array de Time 
     * @return time
    */

    @Override
    public ArrayList<Time> carregarDados(String arquivo){
        ArrayList<Time> time = new ArrayList<>();
        try{
            File arq = new File("src/br/ufla/gac106/s2022_2/sirios/db/"+arquivo);
            if(arq.exists()){
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream(arq));
                time = (ArrayList<Time>)obj.readObject();
                obj.close();
            }    

        }catch(IOException e){
            System.err.println("Erro ao ler o arquivo!!!" + e.getMessage());

        }catch(ClassNotFoundException e){
            System.err.println("Erro !!!" + e.getMessage());
        }
        return time;
    }
    /**
    * Carrega os dados do arquivo para poder jogar no array de User
    @return user
    */
    @Override
    public ArrayList<User> carregarDadosUser(String arquivo){
        ArrayList<User> user = new ArrayList<>();
        try{
            File arq = new File("src/br/ufla/gac106/s2022_2/sirios/db/"+arquivo);
            if(arq.exists()){
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream(arq));
                user = (ArrayList<User>)obj.readObject();
                obj.close();
            }

        }catch(IOException e){
            System.err.println("Erro ao ler o arquivo!!!" + e.getMessage());

        }catch(ClassNotFoundException e){
            System.err.println("Erro !!!" + e.getMessage());
        }
        return user;
    }

}
