public class Barrio {

    private final String nombreBarrio;
    private final Localidad localidad;

    public Barrio(String nombreBarrio, Localidad localidad) {

        this.nombreBarrio = nombreBarrio;
        this.localidad = localidad;
    }


    @Override
    public String toString() {
        return "Barrio{" +
                "nombreBarrio='" + nombreBarrio + '\'' +
                ", localidad=" + localidad +
                '}';
    }
}
