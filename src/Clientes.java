import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Clientes extends javax.swing.JFrame {
    private JPanel panel1;
    private JComboBox clientes_combo;
    private JComboBox prestamos_combo;
    private JLabel nombre_info;
    private JLabel direccion_info;
    private JLabel numTel_info;
    private JLabel email_info;
    private final Biblioteca bib;

    public Clientes(Biblioteca bib) {
        setTitle("Clientes");
        setSize(new Dimension(600, 300));
        setResizable(false);
        add(panel1);
        this.bib = bib;


        cargarClientes(bib);


        prestamos_combo.addActionListener(prestamo_action_listener);
    }

    ActionListener prestamo_action_listener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seleccionarPublicacion();
        }
    };

    private void cargarClientes(Biblioteca bib) {
        Vector comboBox_items = new Vector();
        List<Cliente> clientes = bib.getClientes();

        for (Cliente cliente : clientes) {
            comboBox_items.add(cliente.getNombre());
        }

        clientes_combo.setModel(new DefaultComboBoxModel(comboBox_items));
        clientes_combo.setSelectedIndex(-1);

        clientes_combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = clientes.get(clientes_combo.getSelectedIndex());
                nombre_info.setText(cliente.getNombre());
                direccion_info.setText(cliente.getDireccion().toString());
                email_info.setText(cliente.getMail());
                numTel_info.setText(cliente.getNumeroDeTelefono());

                prestamos_combo.removeActionListener(prestamo_action_listener);

                Vector comboBox_items_prestamos = new Vector();

                for (Prestamo prestamo : bib.getPrestamos()) {
                    List<Publicacion> publicaciones = prestamo.getPublicaciones();
                    if (prestamo.getCliente() == cliente) {
                        for (Publicacion publicacion : publicaciones) {
                            comboBox_items_prestamos.add(new ComboBoxItem(publicacion.getTitulo(), publicacion));
                        }
                    }
                }
                prestamos_combo.setModel(new DefaultComboBoxModel(comboBox_items_prestamos));
                prestamos_combo.setSelectedIndex(-1);
                prestamos_combo.addActionListener(prestamo_action_listener);
            }
        });
    }

    private void seleccionarPublicacion() {
        Publicacion publicacion = ComboBoxItem.getSelectedContent(prestamos_combo)
                .map(o -> (Publicacion) o).orElse(null);

        if (publicacion instanceof Libro) {
            new Libros(bib, (Libro) publicacion).setVisible(true);
        } else if (publicacion instanceof Revista) {
            new Revistas(bib, (Revista) publicacion).setVisible(true);
        }
    }
}
