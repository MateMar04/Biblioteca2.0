import javax.swing.*;
import java.awt.*;

public class Clientes extends javax.swing.JFrame{
    private JPanel panel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public Clientes(Biblioteca bib) {
        setTitle("Clientes");
        setSize(new Dimension(300, 300));
        setResizable(false);
        add(panel1);
    }
}
