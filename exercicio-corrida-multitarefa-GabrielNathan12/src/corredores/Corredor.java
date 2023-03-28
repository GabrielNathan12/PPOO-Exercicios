package corredores;

public class Corredor implements Competidor{
    private String nome;
    private int Velocidade;
    private int distanciaDaCorrida;
    private boolean correndo;
    private int distanciaPercorrida;

    public Corredor(String nome, int Velocidade){
       
        this.nome = nome;
        this.Velocidade = Velocidade;
    }

    @Override
    public void run() {
        

        while(distanciaPercorrida < distanciaDaCorrida){
            try{
                correndo = true;
                distanciaPercorrida += 1;
                Thread.sleep(1000/Velocidade);
               
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        correndo = false;
    }

    public int getDistanciaDaCorrida(){
        return distanciaDaCorrida;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getVelocidade() {
        return Velocidade;
    }

    @Override
    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    @Override
    public boolean estaCorrendo() {
        return correndo;
    }

    @Override
    public void prepararParaNovaCorrida(int distanciaDaCorrida) {
        correndo = false;
        this.distanciaDaCorrida = distanciaDaCorrida;
        this.distanciaPercorrida = 0;
    }
    
}
