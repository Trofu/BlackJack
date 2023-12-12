package es.ieslavereda;
import java.util.Arrays;
public class Baraja {
    private Carta[] baraja;
    public Baraja(){
        baraja= new Carta[12*4];
        int a=0;
        for (Numero num:Numero.values()) {
            for (Palo palo:Palo.values() ) {
                baraja[a++] = new Carta(num,palo);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(baraja);
    }
}
