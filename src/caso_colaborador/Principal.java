// Autor: Francisco Portocarrero Rios
// Curso: Técnicas de Programación
// Caso Práctico 5: Orquestador y Conductor del Flujo de Estudiantes

package caso_colaborador;

public class Principal {

    public static void main(String[] args) {
        
        // Instanciamos el motor del sistema de estudiantes
        SistemaEstudiantes sistema = new SistemaEstudiantes();
        
        // Ejecutamos el flujo controlado de captura de datos
        sistema.iniciarRegistro();
        
        // Desplegamos el reporte final una vez finalizados los ciclos
        sistema.mostrarListaCompleta();
        
        System.out.println("Fin del programa - Caso 5 completado con éxito.");
    }
}