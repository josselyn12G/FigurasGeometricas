package figuras;

// Clase Circulo que hereda de Figura
// Implementa su propia lógica de área y perímetro (POLIMORFISMO)
public class Circulo extends Figura {

    // Atributo propio
    private double radio;

    // Constructor
    public Circulo(double radio, String color) {
        super(color, "Círculo");
        this.radio = radio;
    }

    // Cálculo del área
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    // Cálculo del perímetro
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // Getters y Setters
    public double getRadio() { return radio; }
    public void setRadio(double radio) { this.radio = radio; }
}