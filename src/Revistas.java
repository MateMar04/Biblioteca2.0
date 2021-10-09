import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Revistas extends javax.swing.JFrame {
    private JComboBox revistas_combo;
    private JPanel panel1;
    private JLabel title_info;
    private JLabel autor_info;
    private JLabel editorial_info;
    private JLabel categoria_info;


    public Revistas(Biblioteca bib) {
        setTitle("Libros");
        setSize(new Dimension(300, 300));
        setResizable(false);
        add(panel1);

        Vector comboBox_items = new Vector();

        List<Revista> revistas = bib.getRevistas();


        for (Revista revista : bib.getRevistas()) {
            comboBox_items.add(revista.getTitulo());
        }

        revistas_combo.setModel(new DefaultComboBoxModel(comboBox_items));
        revistas_combo.setSelectedIndex(-1);

        revistas_combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Revista revista = revistas.get(revistas_combo.getSelectedIndex());
                title_info.setText(revista.getTitulo());
                autor_info.setText(revista.getAutor().toString());
                editorial_info.setText(revista.getEditorial().toString());
                categoria_info.setText(revista.getCategoria().toString());

            }
        });
    }
}

