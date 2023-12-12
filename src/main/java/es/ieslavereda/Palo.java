package es.ieslavereda;
import static com.diogonunes.jcolor.Ansi.colorize;
public enum Palo {
    CORAZONES("♥",Color.ROJO),
    PICAS("♠",Color.NEGRO),
    DIAMANTES("♦",Color.ROJO),
    TREBOLES("♣",Color.NEGRO);
    private String typeOf;
    private Color color;
    Palo(String typeOf, Color color){
        this.typeOf=typeOf;
        this.color=color;
    }
    @Override
    public String toString() {
        return colorize(typeOf,color.getColor());
    }
}
