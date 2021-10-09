import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Revistas extends javax.swing.JFrame {
    private JComboBox revistas_combo;
    private JPanel panel1;


    public Revistas(Biblioteca bib) {
        setTitle("Libros");
        setSize(new Dimension(300, 300));
        setResizable(false);
        add(panel1);

        Vector comboBox_items = new Vector();


        for (Revista revista : bib.getRevistas()) {
            comboBox_items.add(revista.getTitulo());
        }

        revistas_combo.setModel(new DefaultComboBoxModel(comboBox_items));
        revistas_combo.setSelectedIndex(-1);
    }
}

