package es.ieslavereda;

import java.util.Arrays;

public class Jugador {
    private String nombre;
    private Carta[] mano;
    public Jugador (String Nombre){
        this.nombre = Nombre;
    }

    public void cartaNueva (Carta carta){
        mano= Arrays.copyOf(mano,mano.length+1);
        mano[mano.length-1]=carta;
    }
    private int getPuntuacion(){
        int punt=0;
        int as1 =0;
        for (Carta carta:mano) {
            if (punt>21){
                punt = 0;
                for (Carta carta2:mano) {
                    if (carta2.getNumero().getTypeOf()=="A"){
                        punt += (carta2.getNumero().getValor()[0]);
                    }else {
                        punt += (carta2.getNumero().getValor()[0]);
                    }
                }
            }else {
                if (carta.getNumero().getTypeOf()=="A"){
                    if (as1>=1){
                        punt += (carta.getNumero().getValor()[0]);
                    }else {
                        punt += (carta.getNumero().getValor()[1]);
                    }
                    as1++;
                }else {
                    punt += (carta.getNumero().getValor()[0]);
                }
            }
        }
        return punt;
    }
    public Carta[] getMano() {
        return mano;
    }

    @Override
    public String toString(){
        return nombre+": "+ Arrays.toString(mano)+ " puntuacion "+ getPuntuacion() + "\n";
    }
}
