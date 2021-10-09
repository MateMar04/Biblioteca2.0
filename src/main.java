public class main {
    public static void main(String[] args) {


        Provincia prov = new Provincia("Cordoba");

        Localidad loc1 = new Localidad("Capital", prov);
        Localidad loc2 = new Localidad("Carlos Paz", prov);

        Barrio b1 = new Barrio("Valle Escondido", loc1);
        Barrio b2 = new Barrio("Cerro de las Rosas", loc1);

        Direccion d1 = new Direccion("Loncoche", "8136", b1);
        Direccion d2 = new Direccion("Loncoche", "8136", b2);

        Cliente c1 = new Cliente("Mateo Marchisone", "12312123123", "dasddas@gmail.com", d1);
        Cliente c2 = new Cliente("Mateo Marchisone", "12312123123", "dasddas@gmail.com", d2);

        Autor a1 = new Autor("J.K Rowling");
        Autor a2 = new Autor("Steve Forbes");

        Editorial ed1 = new Editorial("La Salamandra");
        Editorial ed2 = new Editorial("Forbes");

        Categoria cat1 = new Categoria("Fantasia");
        Categoria cat2 = new Categoria("Informativa");

        Publicacion lib1 = new Libro("Harry Potter", a1, ed1, cat1);
        Publicacion rev1 = new Revista("Forbes", a2, ed2, cat2);

        Prestamo pres1 = new Prestamo("22/22/22", "13/13/13", c1);
        Prestamo pres2 = new Prestamo("22/22/22", "13/13/13", c2);

        pres1.agregar(lib1);
        pres2.agregar(rev1);

        Biblioteca bib = new Biblioteca("Quade");
        bib.agregarPublicacion(lib1);
        bib.agregarPublicacion(rev1);

        bib.prestarPublicacion(pres1);

        System.out.println("Cantidad de Prestamos: " + bib.cantidadDePrestamos());
        System.out.println("Cantidad de Libros: " + bib.cantLibros());
        System.out.println("Cantidad de Revistas: " + bib.cantRevistas());
        System.out.println("Cantidad de Publicaciones: " + bib.cantidadDePublicaciones());
        System.out.println("Listado de publicaciones: " + bib.listarPublicaciones());
        System.out.println("Listado de prestamos: " + bib.listarPrestamos());
        System.out.println("Listado de clientes con prestamos de libros: " + bib.clientesConPrestamoDeLibro());
        System.out.println("Listado de barrios con prestamos: " + bib.listarBarriosConPrestamos());

        new Principal(bib).setVisible(true);
    }
}
