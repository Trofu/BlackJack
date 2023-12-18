package es.ieslavereda;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // CANT JUGADOR
        int numJugadores = 0;
        while (numJugadores<1 || numJugadores>5){
            numJugadores = Input.getInteger("Por favor, introduzca el número de jugadores: ");
        }

        // ARRAY JUGADORES
        Jugador[] jugadores = new Jugador[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = new Jugador(Input.getString("Nombre jugador " + i+" : "));
        }

        // CREA JUEGO
        Juego j1 = new Juego(jugadores);
        j1.start();
        for (Jugador jugador:jugadores) {
            j1.juegaJugador(jugador);
        }
        j1.juegaPC();
        j1.mostrarGanador();



//        Jugador[] jugadores = new Jugador[]{new Jugador("Joker"),new Jugador("Xavi"),new Jugador("Marcos")};
//        Juego MATCH = new Juego(jugadores);
//        MATCH.start();


    }
}