package es.ieslavereda;

public class Juego {

    private Baraja baraja;

    private Jugador[] jugadores;
    private Jugador Banca;

    public Juego(Jugador[] jugadores){
        this.jugadores=jugadores;
        baraja= new Baraja();
        Banca = new Jugador("Banca");
    }

    public void start(){
        for (Jugador jugador:jugadores) {
            for (int i = 0; i < 2; i++) {
                jugador.cartaNueva(baraja.repartitEncima());
            }
        }

    }

    public void juegaPC (){

    }

}
