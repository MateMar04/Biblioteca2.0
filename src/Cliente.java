public class Cliente {

    private final String nombreCliente;
    private final String numeroDeTelefono;
    private final String mail;
    private final Direccion direccion;

    public Cliente(String nombreCliente, String numeroDeTelefono, String mail, Direccion direccion) {
        this.nombreCliente = nombreCliente;
        this.numeroDeTelefono = numeroDeTelefono;
        this.mail = mail;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombreCliente;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", numeroDeTelefono='" + numeroDeTelefono + '\'' +
                ", mail='" + mail + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
