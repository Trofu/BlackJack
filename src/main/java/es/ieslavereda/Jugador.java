package es.ieslavereda;

import java.util.Arrays;

public class Jugador {
    private String nombre;
    private Carta[] mano;
    public Jugador (String Nombre, Carta[] mano){
        this.nombre = Nombre;
        this.mano= mano;
    }
    public Carta[] getMano() {
        return mano;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre+": "+ Arrays.toString(mano)+"\n";
    }
}
