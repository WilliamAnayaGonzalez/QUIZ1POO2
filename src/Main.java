import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private ArrayList<Propietario> propietarios = new ArrayList<>();

    private JButton btnRegistrar;
    private JButton btnListar;
    private JButton btnBuscar;

    public Main() {
        setTitle("Gestión de Propietarios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 120));
        setLayout(new GridLayout(1, 3));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
        setLocationRelativeTo(null);

        btnRegistrar = new JButton("Registrar");
        btnListar = new JButton("Listar");
        btnBuscar = new JButton("Buscar");

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegistroPropietarioGUI();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPropietarios();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPropietario();
            }
        });

        add(btnRegistrar);
        add(btnListar);
        add(btnBuscar);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    class Propietario {
        String id_Propietario;
        Persona persona;
    }

    class Persona {
        String documento;
        String nombres;
        String apellidos;
        int edad;
    }

    class RegistroPropietarioGUI extends JFrame {
        private JTextField txtIdPropietario;
        private JTextField txtNombres;
        private JTextField txtApellidos;
        private JTextField txtEdad;
        private JButton btnRegistrar;
        private JButton btnRegresar;

        public RegistroPropietarioGUI() {
            setTitle("Registro de Propietario");
            setSize(300, 200);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
            panel.setBorder(new EmptyBorder(10, 10, 10, 10));

            txtIdPropietario = new JTextField(20);
            txtNombres = new JTextField(20);
            txtApellidos = new JTextField(20);
            txtEdad = new JTextField(20);
            btnRegistrar = new JButton("Registrar");
            btnRegresar = new JButton("Regresar");

            btnRegistrar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    registrarPropietario();
                }
            });

            btnRegresar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            panel.add(new JLabel("ID Propietario:"));
            panel.add(txtIdPropietario);
            panel.add(new JLabel("Nombres:"));
            panel.add(txtNombres);
            panel.add(new JLabel("Apellidos:"));
            panel.add(txtApellidos);
            panel.add(new JLabel("Edad:"));
            panel.add(txtEdad);
            panel.add(btnRegistrar);
            panel.add(btnRegresar);

            add(panel);
            setVisible(true);
        }

        private void registrarPropietario() {
            String idPropietario = txtIdPropietario.getText();
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Propietario propietario = new Propietario();
            propietario.id_Propietario = idPropietario;

            Persona persona = new Persona();
            persona.documento = idPropietario;
            persona.nombres = nombres;
            persona.apellidos = apellidos;
            persona.edad = edad;

            propietario.persona = persona;

            propietarios.add(propietario);

            JOptionPane.showMessageDialog(this, "Propietario registrado:\nID: " + idPropietario + "\nNombres: " + nombres + "\nApellidos: " + apellidos + "\nEdad: " + edad);
            dispose();
        }
    }

    private void mostrarPropietarios() {
        JFrame frame = new JFrame("Listado de Propietarios");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        for (Propietario propietario : propietarios) {
            textArea.append("ID: " + propietario.id_Propietario + "\nNombres: " + propietario.persona.nombres + "\nApellidos: " + propietario.persona.apellidos + "\nEdad: " + propietario.persona.edad + "\n\n");
        }

        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    private void buscarPropietario() {
        JFrame frame = new JFrame("Buscar Propietario");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField txtIdPropietario = new JTextField(20);
        JButton btnBuscarPropietario = new JButton("Buscar");

        btnBuscarPropietario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBuscar = txtIdPropietario.getText();
                Propietario encontrado = null;
                for (Propietario propietario : propietarios) {
                    if (propietario.id_Propietario.equals(idBuscar)) {
                        encontrado = propietario;
                        break;
                    }
                }
                if (encontrado != null) {
                    JOptionPane.showMessageDialog(frame, "Propietario encontrado:\nID: " + encontrado.id_Propietario + "\nNombres: " + encontrado.persona.nombres + "\nApellidos: " + encontrado.persona.apellidos + "\nEdad: " + encontrado.persona.edad);
                } else {
                    JOptionPane.showMessageDialog(frame, "Propietario no encontrado.");
                }
            }
        });

        panel.add(new JLabel("ID Propietario:"));
        panel.add(txtIdPropietario);
        panel.add(btnBuscarPropietario);

        frame.add(panel);
        frame.setVisible(true);
    }
}

