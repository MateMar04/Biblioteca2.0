public class Autor {

    private final String nombre;

    public Autor(String nombreAutor) {
        this.nombre = nombreAutor;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
