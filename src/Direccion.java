public class Direccion {

    private final String calle;
    private final Barrio barrio;
    private final String numero;

    public Direccion(String calle, String numero, Barrio barrio) {
        this.calle = calle;
        this.numero = numero;
        this.barrio = barrio;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    @Override
    public String toString() {
        return barrio + ", " + calle + " " + numero;
    }
}
