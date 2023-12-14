package es.ieslavereda;
public class Main {
    public static void main(String[] args) {
        Baraja MAIN = new Baraja();
        System.out.println(MAIN);
        Jugador Joker = new Jugador("Joker",new Carta[]{MAIN.repartitEncima(),MAIN.repartitEncima()});
        Jugador BlackJack = new Jugador("BlackJack",new Carta[]{MAIN.repartitEncima(),MAIN.repartitEncima()});
        Jugador Xavi = new Jugador("Xavi",new Carta[]{MAIN.repartitEncima(),MAIN.repartitEncima()});
        Jugador Consola = new Jugador("Consola",new Carta[]{MAIN.repartitEncima(),MAIN.repartitEncima()});
        System.out.println("\n"+MAIN);
        System.out.print(Joker+""+BlackJack+Xavi+Consola);

    }
}