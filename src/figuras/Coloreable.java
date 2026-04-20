package figuras;

// Interfaz que define el comportamiento relacionado con el color
// Permite modificar y consultar el color de una figura
public interface Coloreable {

    // Método para cambiar el color de la figura
    void aplicarColor(String color);

    // Método para obtener el color actual
    String obtenerColor();
}