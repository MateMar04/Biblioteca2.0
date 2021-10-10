import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class Libros extends javax.swing.JFrame {
    private JPanel panel1;
    private JComboBox libros_combo;
    private JLabel title_info;
    private JLabel autor_info;
    private JLabel categoria_info;
    private JLabel editorial_info;


    public Libros(Biblioteca bib, Libro selected_libro) {
        setTitle("Libros");
        setSize(new Dimension(600, 300));
        setResizable(false);
        add(panel1);

        List<Libro> libros = bib.getLibros();
        int selected_index = -1;
        Vector comboBox_items = new Vector();
        for (Libro libro : libros) {
            if (libro == selected_libro) {
                selected_index = comboBox_items.size();
            }
            comboBox_items.add(new ComboBoxItem(libro.getTitulo(), libro));
        }

        libros_combo.setModel(new DefaultComboBoxModel(comboBox_items));

        libros_combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<Libro> optionalLibro = ComboBoxItem.getSelectedContent(libros_combo).map(o -> (Libro) o);
                optionalLibro.ifPresent(libro -> {
                    title_info.setText(libro.getTitulo());
                    autor_info.setText(libro.getAutor().toString());
                    editorial_info.setText(libro.getEditorial().toString());
                    categoria_info.setText(libro.getCategoria().toString());
                });
            }
        });
        libros_combo.setSelectedIndex(selected_index);
    }
}
