package conversor_monedas_alura_gui;

import javax.swing.JOptionPane;
import conversor_monedas_alura.Menu;
import calculadora_adicional.CalculadoraGui;
import javax.swing.*;

public class ConversorGui {
    public static void main(String[] args) {
        Menu monedas = new Menu();
        JFrame frame = new JFrame("Conversor de Moneda y Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usamos un diálogo de opciones para seleccionar la operación
        String opciones = (String) JOptionPane.showInputDialog(frame, "Seleccione una opción:", "Menu",
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Conversor de Moneda", "Calculadora"},
                "Seleccion");

        if (opciones == null) {
            // Si se cierra el diálogo, terminar el programa.
            System.exit(0);
        }

        switch (opciones) {
            case "Conversor de Moneda":
                String input = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir: ");
                if (ValidarNumero(input)) {
                    double Minput = Double.parseDouble(input);
                    monedas.PesoADivisas(Minput);

                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?");
                    if (JOptionPane.OK_OPTION == respuesta) {
                        System.out.println("Opcion Afirmativa");
                    } else {
                        // Si el usuario elige "Cancelar", terminamos el programa.
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
                break;

            case "Calculadora":
                frame.dispose(); // Cerramos la ventana del menú principal
                CalculadoraGui calculadoraGui = new CalculadoraGui();
                calculadoraGui.mostrarCalculadora();
                break;

            default:
                JOptionPane.showMessageDialog(frame, "Opción inválida");
                break;
        }
    }

    
    public static boolean ValidarNumero(String input) {
        try {
            double x = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
