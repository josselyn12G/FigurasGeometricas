package figuras;

// Clase Triangulo que hereda de Figura
public class Triangulo extends Figura {

    // Atributos propios
    private double lado1, lado2, lado3;

    // Constructor
    public Triangulo(double l1, double l2, double l3, String color) {
        super(color, "Triángulo");
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    // Cálculo del área usando la fórmula de Herón
    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    // Cálculo del perímetro
    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    // Getters y Setters
    public double getLado1() { return lado1; }
    public double getLado2() { return lado2; }
    public double getLado3() { return lado3; }

    public void setLado1(double l1) { this.lado1 = l1; }
    public void setLado2(double l2) { this.lado2 = l2; }
    public void setLado3(double l3) { this.lado3 = l3; }
}