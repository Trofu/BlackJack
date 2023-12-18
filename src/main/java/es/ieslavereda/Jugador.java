package es.ieslavereda;

import java.util.Arrays;

public class Jugador {
    private String nombre;
    private Carta[] mano;
    public Jugador (String Nombre){
        this.nombre = Nombre;
        this.mano=new Carta[0];
    }

    public void cartaNueva (Carta carta){
        mano= Arrays.copyOf(mano,mano.length+1);
        mano[mano.length-1]=carta;
    }
    public int getPuntuacion(){
        int punt=0;
        int as1 =0;
        for (Carta carta:mano) {
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
        if (punt>21 && as1>=1){
            punt=0;
            for (Carta carta:mano) {
                punt += (carta.getNumero().getValor()[0]);
            }
        }
        return (punt>21?-1:punt);
    }
    public Carta[] getMano() {
        return mano;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return nombre+": "+ Arrays.toString(mano)+ " puntuacion "+ getPuntuacion() + "\n";
    }
}
