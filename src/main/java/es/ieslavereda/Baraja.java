package es.ieslavereda;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private Carta[] baraja;
    public Baraja(){
        baraja= new Carta[Palo.values().length*Numero.values().length];
        int a=0;
        for (Numero num:Numero.values()) {
            for (Palo palo:Palo.values() ) {
                baraja[a++] = new Carta(num,palo);
            }
        }
        barajar();
    }
    private void barajar(){
        List<Carta> listaCartas = Arrays.asList(baraja);
        Collections.shuffle(listaCartas);
        listaCartas.toArray(baraja);
    }

    public Carta repartitEncima(){
        //devuelve 0
        Carta carta = null;
        if (baraja.length>0){
            carta = baraja[0];
            this.baraja=Arrays.copyOfRange(this.baraja,1,baraja.length);
        }
        return carta;
    }

    public Carta repartitDebajo(){
        //devuelve length-1
        Carta carta = null;
        if (baraja.length>0){
            carta = baraja[baraja.length-1];
            this.baraja=Arrays.copyOfRange(this.baraja,0,baraja.length-1);
        }
        return carta;
    }

    public Carta[] getBaraja() {
        return baraja;
    }

    @Override
    public String toString() {
        return Arrays.toString(baraja);
    }
}
