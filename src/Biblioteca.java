import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final ArrayList<Publicacion> publicaciones;
    private final ArrayList<Prestamo> prestamos;
    private final String nombreBiblioteca;
    private final ArrayList<Cliente> clientes = new ArrayList<>();


    public Biblioteca(String nombreBiblioteca) {

        this.nombreBiblioteca = nombreBiblioteca;
        publicaciones = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public List<Libro> getLibros() {
        List<Libro> libros = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            if (publicacion instanceof Libro) {
                libros.add((Libro) publicacion);
            }
        }
        return libros;
    }

    public List<Revista> getRevistas() {
        List<Revista> revistas = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            if (publicacion instanceof Revista) {
                revistas.add((Revista) publicacion);
            }
        }
        return revistas;
    }

    public void prestarPublicacion(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public int cantidadDePrestamos() {
        return prestamos.size();
    }

    public int cantidadDePublicaciones() {
        return publicaciones.size();
    }

    public int cantLibros() {
        return getLibros().size();
    }

    public int cantRevistas() {
        return getRevistas().size();
    }

    public List<Publicacion> listarPublicaciones() {
        return publicaciones;
    }

    public List<Prestamo> listarPrestamos() {
        return prestamos;
    }

    public List<Cliente> clientesConPrestamoDeLibro() {
        List<Cliente> clientes = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            for (Publicacion publicacion : prestamo.getPublicaciones()) {
                if (publicacion instanceof Libro) {
                    clientes.add(prestamo.getCliente());
                    break;
                }
            }
        }
        return clientes;
    }

    public List<Barrio> listarBarriosConPrestamos() {
        List<Barrio> barrios = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            barrios.add(prestamo.getCliente().getDireccion().getBarrio());
        }
        return barrios;

    }


}
