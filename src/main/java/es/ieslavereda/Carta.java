package es.ieslavereda;
public class Carta {
    private Numero numero;
    private Palo palo;
    public Carta(Numero numero,Palo palo){
        this.numero=numero;
        this.palo=palo;
    }
    public Palo getPalo() {
        return palo;
    }
    public Numero getNumero() {
        return numero;
    }
    @Override
    public String toString(){
        return numero+""+palo;
    }
}
