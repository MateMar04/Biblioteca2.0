import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Libros extends javax.swing.JFrame {
    private JPanel panel1;
    private JComboBox libros_combo;
    private JLabel title_info;
    private JLabel autor_info;
    private JLabel categoria_info;
    private JLabel editorial_info;


    public Libros(Biblioteca bib) {
        setTitle("Libros");
        setSize(new Dimension(600, 300));
        setResizable(false);
        add(panel1);

        Vector comboBox_items = new Vector();

        List<Libro> libros = bib.getLibros();

        for (Libro libro : libros) {
            comboBox_items.add(libro.getTitulo());
        }

        libros_combo.setModel(new DefaultComboBoxModel(comboBox_items));
        libros_combo.setSelectedIndex(-1);

        libros_combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Libro libro = libros.get(libros_combo.getSelectedIndex());
                title_info.setText(libro.getTitulo());
                autor_info.setText(libro.getAutor().toString());
                editorial_info.setText(libro.getEditorial().toString());
                categoria_info.setText(libro.getCategoria().toString());

            }
        });
    }
}
