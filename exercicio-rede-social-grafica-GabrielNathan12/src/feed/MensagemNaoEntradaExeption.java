package feed;

import java.util.NoSuchElementException;

public class MensagemNaoEntradaExeption extends NoSuchElementException{
    private int ID;

    public MensagemNaoEntradaExeption(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }
}
