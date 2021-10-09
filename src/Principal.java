import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends javax.swing.JFrame {
    private JPanel panel1;
    private JButton librosButton;
    private JButton revistasButton;
    private JLabel cant_publicaciones_num;
    private JLabel cant_libros_num;
    private JLabel cant_revistas_num;
    private JButton clientesButton;

    public Principal(Biblioteca bib) {
        setTitle("Biblioteca");
        setSize(new Dimension(600, 300));
        setResizable(false);
        add(panel1);

        cant_publicaciones_num.setText(String.valueOf(bib.cantidadDePublicaciones()));
        cant_libros_num.setText(String.valueOf(bib.cantLibros()));
        cant_revistas_num.setText(String.valueOf(bib.cantRevistas()));
        librosButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                new Libros(bib).setVisible(true);
            }
        });
        revistasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                new Revistas(bib).setVisible(true);
            }
        });

        clientesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                new Clientes(bib).setVisible(true);
            }
        });
    }

}
