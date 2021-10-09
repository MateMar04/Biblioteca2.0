import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Clientes extends javax.swing.JFrame {
    private JPanel panel1;
    private JComboBox clientes_combo;
    private JComboBox libros_combo;
    private JLabel nombre_info;
    private JLabel direccion_info;
    private JLabel numTel_info;
    private JLabel email_info;

    public Clientes(Biblioteca bib) {
        setTitle("Clientes");
        setSize(new Dimension(600, 300));
        setResizable(false);
        add(panel1);

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
            }
        });
    }
}
