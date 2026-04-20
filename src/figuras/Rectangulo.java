package figuras;

// Clase Rectangulo que hereda de Figura
public class Rectangulo extends Figura {

    // Atributos propios
    private double base;
    private double altura;

    // Constructor
    public Rectangulo(double base, double altura, String color) {
        super(color, "Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    // Cálculo del área
    @Override
    public double calcularArea() {
        return base * altura;
    }

    // Cálculo del perímetro
    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }

    // Getters y Setters
    public double getBase() { return base; }
    public double getAltura() { return altura; }

    public void setBase(double base) { this.base = base; }
    public void setAltura(double altura) { this.altura = altura; }
}