package es.ieslavereda;
import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Juego {

    private Baraja baraja;

    private Jugador[] jugadores;
    private Jugador banca;

    public Juego(Jugador[] jugadores){
        this.jugadores=jugadores;
        baraja= new Baraja();
        banca = new Jugador("Banca");
    }

    public void start(){
        for (Jugador jugador:jugadores) {
            for (int i = 0; i < 2; i++) {
                jugador.cartaNueva(baraja.repartitEncima());
            }
        }
        for (int i = 0; i < 2; i++) {
            banca.cartaNueva(baraja.repartitEncima());
        }
    }

    public void juegaPC (){
        System.out.println(colorize("\nLe toca al jugador " + banca.getNombre(), Attribute.GREEN_TEXT()));
        System.out.println(banca);
        int maxPuntuacion = maxPuntuacion();

        while(banca.getPuntuacion()>=0 && banca.getPuntuacion()<maxPuntuacion){
            esperar(2000);
            banca.cartaNueva(baraja.repartitEncima());
            System.out.println(banca);
            if(banca.getPuntuacion()<0)
                System.out.println(colorize("Se ha pasado la BANCA",Attribute.MAGENTA_TEXT()));
        }
    }

    private void esperar(int tiempoMili){
        try{
            Thread.sleep(tiempoMili);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private int maxPuntuacion(){
        int maxPuntuacion = Integer.MIN_VALUE;
        for(Jugador jugador:jugadores){
            if(jugador.getPuntuacion()>maxPuntuacion)
                maxPuntuacion=jugador.getPuntuacion();
        }
        return maxPuntuacion;
    }

    public void juegaJugador(Jugador jugador ){
        System.out.println(colorize("Le toca al jugador: "+jugador.getNombre(),Attribute.BRIGHT_BLUE_TEXT())+"\n");
        System.out.println(jugador);
        if (jugador.getPuntuacion()==21){
            System.out.println("Has Ganado");
        }else {
            String opcion = Input.getString("Otra carta? (Y/N)");
            boolean y21=false;
            while (opcion.equalsIgnoreCase("Y")&& jugador.getPuntuacion()>=0&&y21!=true){
                jugador.cartaNueva(baraja.repartitEncima());
                System.out.println("\n"+jugador);
                if(jugador.getPuntuacion()>=0)
                    if (jugador.getPuntuacion()==21){
                        System.out.println("Has ganado\n");
                        y21=true;
                    }else {
                        opcion = Input.getOption("Otra carta? (Y/N) ");
                    }
                else
                    System.out.println(colorize("Te has pasado !!\n",Attribute.MAGENTA_TEXT()));
            }
        }
    }

    public void mostrarGanador(){
        int maxPuntuacion = maxPuntuacion();
        if(maxPuntuacion<=banca.getPuntuacion())
            System.out.println("GANA LA BANCA PRINGAOS !!");
        else{
            int numGanadores=0;
            String[] ganadores = new String[jugadores.length];
            for(Jugador jugador:jugadores){
                if(jugador.getPuntuacion()==maxPuntuacion){
                    ganadores[numGanadores++] = jugador.getNombre();
                }
            }
            for(String ganador:ganadores){
                if(ganador!=null)
                    System.out.println("GANADOR: " + ganador);
            }
        }
    }

}
