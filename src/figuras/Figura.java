package figuras;

// Clase abstracta que representa una figura geométrica general
// Aplica ABSTRACCIÓN y centraliza el comportamiento del color
public abstract class Figura implements Coloreable {

    // Atributos comunes a todas las figuras
    protected String color;
    protected String nombre;

    // Constructor
    public Figura(String color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    // Métodos abstractos (cada figura define su implementación)
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    // Método común reutilizable (HERENCIA)
    public void mostrarInfo() {
        System.out.println("=============================");
        System.out.println("Figura    : " + nombre);
        System.out.println("Color     : " + color);
        System.out.printf ("Área      : %.2f%n", calcularArea());
        System.out.printf ("Perímetro : %.2f%n", calcularPerimetro());
        System.out.println("=============================");
    }

    // Implementación de la interfaz Coloreable (centralizada)

    @Override
    public void aplicarColor(String color) {
        this.color = color;
    }

    @Override
    public String obtenerColor() {
        return this.color;
    }

    // Getters y Setters
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}