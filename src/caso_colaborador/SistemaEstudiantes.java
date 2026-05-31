// Autor: Francisco Portocarrero Rios
// Curso: Técnicas de Programación
// Caso Práctico 5: Gestión Dinámica de ArrayList y Control de Excepciones.

package caso_colaborador;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEstudiantes {

    // Lista dinámica para almacenar los nombres de los estudiantes
    private ArrayList<String> listaNombres;

    // Constructor: Inicializa el ArrayList en memoria
    public SistemaEstudiantes() {
        this.listaNombres = new ArrayList<>();
    }

    // Método operativo que maneja el registro con control de errores (try-catch)
    public void iniciarRegistro() {
        Scanner sc = new Scanner(System.in);
        String opcion;

        System.out.println("=== INTERFAZ DE REGISTRO DE ESTUDIANTES ===");

        do {
            // Estructura defensiva try-catch para capturar fallos de entrada
            try {
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = sc.nextLine();

                // Validación manual: Evitar que pongan nombres vacíos o puros números
                if (nombre.trim().isEmpty() || nombre.matches(".*\\d.*")) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío ni contener números.");
                }

                // Inserción exitosa en la colección dinámica
                listaNombres.add(nombre);
                System.out.println("[OK] Estudiante registrado correctamente.");

            } catch (Exception e) {
                // Bloque catch: Captura el error, lo muestra amigablemente y no rompe el bucle
                System.out.println("[ERROR DATO INVÁLIDO] " + e.getMessage());
                System.out.println("Por favor, intente ingresar el nombre nuevamente.");
            }

            System.out.print("¿Desea agregar otro estudiante? (s/n): ");
            opcion = sc.nextLine();
            System.out.println();

        } while (opcion.equalsIgnoreCase("s"));

        // ==========================================================
        // SOLUCIÓN: Cerramos el Scanner aquí para limpiar el Resource Leak
        // ==========================================================
        sc.close();
    }

    // Método para imprimir el reporte masivo de la colección
 // >>> REPORTE DE CONTROL DE EXCEPCIONES: HISTORIAL DE ESTUDIANTES <<<
    public void mostrarListaCompleta() {
        System.out.println("=========================================");
        System.out.println("     REPORTE FINAL: LISTA DE ESTUDIANTES ");
        System.out.println("=========================================");
        
        if (listaNombres.isEmpty()) {
            System.out.println("No se registraron estudiantes en el sistema.");
        } else {
            // Bucle for-each para recorrer el ArrayList indexado
            for (int i = 0; i < listaNombres.size(); i++) {
                System.out.println((i + 1) + ". " + listaNombres.get(i));
            }
        }
        System.out.println("=========================================");
    }
}