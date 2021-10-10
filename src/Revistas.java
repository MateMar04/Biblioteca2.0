import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class Revistas extends javax.swing.JFrame {
    private JComboBox revistas_combo;
    private JPanel panel1;
    private JLabel title_info;
    private JLabel autor_info;
    private JLabel editorial_info;
    private JLabel categoria_info;


    public Revistas(Biblioteca bib, Revista selected_revista) {
        setTitle("Revistas");
        setSize(new Dimension(600, 300));
        setResizable(false);
        add(panel1);

        List<Revista> revistas = bib.getRevistas();

        int selected_index = -1;

        Vector comboBox_items = new Vector();
        for (Revista revista : revistas) {
            if (revista == selected_revista) {
                selected_index = comboBox_items.size();
            }
            comboBox_items.add(new ComboBoxItem(revista.getTitulo(), revista));
        }

        revistas_combo.setModel(new DefaultComboBoxModel(comboBox_items));

        revistas_combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<Revista> optionalRevista = ComboBoxItem.getSelectedContent(revistas_combo).map(o -> (Revista) o);
                optionalRevista.ifPresent(revista -> {
                    title_info.setText(revista.getTitulo());
                    autor_info.setText(revista.getAutor().toString());
                    editorial_info.setText(revista.getEditorial().toString());
                    categoria_info.setText(revista.getCategoria().toString());
                });
            }
        });

        revistas_combo.setSelectedIndex(selected_index);
    }
}

