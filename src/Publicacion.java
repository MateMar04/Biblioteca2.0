public abstract class Publicacion {

    private int cantidadDePrestamos;
    private final String titulo;
    private final Autor autor;
    private final Editorial editorial;
    private final Categoria categoria;

    public Publicacion(String nombre, Autor autor, Editorial editorial, Categoria categoria) {
        this.titulo = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.categoria = categoria;
    }

    public void incrementarCantPrestamos() {
        cantidadDePrestamos++;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
