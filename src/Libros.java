import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Libros extends javax.swing.JFrame {
    private JPanel panel1;
    private JComboBox libros_combo;


    public Libros(Biblioteca bib) {
        setTitle("Libros");
        setSize(new Dimension(300, 300));
        setResizable(false);
        add(panel1);

        Vector comboBox_items = new Vector();


        for (Libro libro : bib.getLibros()) {
            comboBox_items.add(libro.getTitulo());
        }

        libros_combo.setModel(new DefaultComboBoxModel(comboBox_items));
        libros_combo.setSelectedIndex(-1);
    }
}
