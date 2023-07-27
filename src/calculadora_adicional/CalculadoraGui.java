package calculadora_adicional;

import javax.swing.*;

import conversor_monedas_alura_gui.ConversorGui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGui {
    private JFrame frame;
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultadoLabel;

    public CalculadoraGui() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 250)); // Ajustar el tamaño de la ventana

        num1Field = new JTextField(6);
        num2Field = new JTextField(6);
        resultadoLabel = new JLabel("");

        // Botones para las operaciones matemáticas
        JButton btnSuma = new JButton("+");
        JButton btnResta = new JButton("-");
        JButton btnMultiplicacion = new JButton("*");
        JButton btnDivision = new JButton("/");
        JButton btnLimpiar = new JButton("C");
        JButton btnVolver = new JButton("Volver");

        // Agregar ActionListener al botón "C"
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Agregar ActionListener a los botones de las operaciones matemáticas y "="
        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonOperadorPresionado("+");
            }
        });

        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonOperadorPresionado("-");
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonOperadorPresionado("*");
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonOperadorPresionado("/");
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });

        JPanel panelNumeros = new JPanel(new GridLayout(2, 2, 5, 5));
        panelNumeros.add(new JLabel("Número 1:"));
        panelNumeros.add(num1Field);
        panelNumeros.add(new JLabel("Número 2:"));
        panelNumeros.add(num2Field);

        // Panel para los botones de las operaciones matemáticas
        JPanel panelOperaciones = new JPanel(new GridLayout(1, 4, 5, 5));
        panelOperaciones.add(btnSuma);
        panelOperaciones.add(btnResta);
        panelOperaciones.add(btnMultiplicacion);
        panelOperaciones.add(btnDivision);

        JPanel panelResultado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelResultado.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Margen superior de "Resultado"
        panelResultado.add(new JLabel("Resultado: "));
        resultadoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Encuadre del resultado
        panelResultado.add(resultadoLabel);

        // Panel para los botones "C" y "Volver"
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Espacio entre botones
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnVolver);

        // Panel principal para organizar todos los componentes
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen izquierdo y derecho
        panelPrincipal.add(panelNumeros);
        panelPrincipal.add(panelOperaciones);
        panelPrincipal.add(panelResultado);
        panelPrincipal.add(panelBotones);

        Container contenedor = frame.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(panelPrincipal, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    public void mostrarCalculadora() {
        frame.setVisible(true);
    }

    private void botonOperadorPresionado(String operador) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double resultado = calcularResultado(num1, num2, operador);
            if (Double.isNaN(resultado)) {
                resultadoLabel.setText("Resultado: Error (División por cero)");
            } else {
                resultadoLabel.setText("" + resultado);
            }
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Resultado: Error (Entrada inválida)");
        }
    }

    private double calcularResultado(double num1, double num2, String operador) {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.NaN; // Devolver un valor especial para indicar división por cero
                }
            case "=":
                return num1; // Si se presiona el botón "=", mostrar el primer número
            default:
                resultadoLabel.setText("Resultado: Error (Operador inválido)");
                return Double.NaN;
        }
    }
    
    private void limpiarCampos() {
        num1Field.setText("");
        num2Field.setText("");
        resultadoLabel.setText("");
    }

    private void volver() {
        frame.dispose(); // Cerrar la ventana de la calculadora
        // Llamar al menú de ConversorGui nuevamente
        ConversorGui.main(new String[0]);
    }
}
