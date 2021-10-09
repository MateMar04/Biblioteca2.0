import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final ArrayList<Publicacion> listaDePublicaciones;
    private final ArrayList<Prestamo> listaDePrestamos;
    private final String nombreBiblioteca;


    public Biblioteca(String nombreBiblioteca) {

        this.nombreBiblioteca = nombreBiblioteca;
        listaDePublicaciones = new ArrayList<>();
        listaDePrestamos = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion publicacion) {
        listaDePublicaciones.add(publicacion);
    }

    public List<Libro> getLibros() {
        List<Libro> libros = new ArrayList<>();
        for (Publicacion publicacion : listaDePublicaciones) {
            if (publicacion instanceof Libro) {
                libros.add((Libro) publicacion);
            }
        }
        return libros;
    }

    public List<Revista> getRevistas() {
        List<Revista> revistas = new ArrayList<>();
        for (Publicacion publicacion : listaDePublicaciones) {
            if (publicacion instanceof Revista) {
                revistas.add((Revista) publicacion);
            }
        }
        return revistas;
    }

    public void prestarPublicacion(Prestamo prestamo) {
        listaDePrestamos.add(prestamo);
    }

    public int cantidadDePrestamos() {
        return listaDePrestamos.size();
    }

    public int cantidadDePublicaciones() {
        return listaDePublicaciones.size();
    }

    public int cantLibros() {
        return getLibros().size();
    }

    public int cantRevistas() {
        return getRevistas().size();
    }

    public List<Publicacion> listarPublicaciones() {
        return listaDePublicaciones;
    }

    public List<Prestamo> listarPrestamos() {
        return listaDePrestamos;
    }

    public List<Cliente> clientesConPrestamoDeLibro() {
        List<Cliente> clientes = new ArrayList<>();
        for (Prestamo prestamo : listaDePrestamos) {
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
        for (Prestamo prestamo : listaDePrestamos) {
            barrios.add(prestamo.getCliente().getDireccion().getBarrio());
        }
        return barrios;

    }


}
