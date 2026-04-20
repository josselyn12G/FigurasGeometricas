import figuras.*;
import java.util.Scanner;

// Clase principal que permite interactuar con el usuario
// para calcular área y perímetro de diferentes figuras geométricas
public class Main {

    // Scanner global para capturar datos desde consola
    static Scanner sc = new Scanner(System.in);

    // Variable para guardar la última figura creada
    static Figura figuraActual;

    public static void main(String[] args) {
        int opcion;

        // Ciclo principal del programa (se repite hasta que el usuario decida salir)
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // IMPORTANTE: limpiar buffer SIEMPRE después de nextInt
            procesarOpcion(opcion);
        } while (opcion != 4);

        // Cierre del scanner para liberar recursos
        sc.close();
    }

    // Muestra el menú principal con las opciones disponibles
    static void mostrarMenu() {
        System.out.println("\n=== MENÚ FIGURAS GEOMÉTRICAS ===");
        System.out.println("1. Mostrar valores por defecto");
        System.out.println("2. Crear una figura personalizada");
        System.out.println("3. Cambiar color de la última figura creada");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Procesa la opción seleccionada por el usuario
    static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> mostrarValoresPorDefecto();     // Demostración de polimorfismo
            case 2 -> calcularFiguraPersonalizada(); // Entrada de datos del usuario
            case 3 -> cambiarColorFigura();          // Uso de interfaz
            case 4 -> System.out.println("Saliendo del programa...");
            default -> System.out.println("Opción inválida");
        }
    }

    // Se crean objetos con valores predefinidos para demostrar polimorfismo
    static void mostrarValoresPorDefecto() {

        // Todas las variables son de tipo Figura, pero contienen objetos distintos
        Figura f1 = new Circulo(5, "Rojo");
        Figura f2 = new Rectangulo(4, 6, "Azul");
        Figura f3 = new Triangulo(3, 4, 5, "Verde");

        System.out.println("\n--- RESULTADOS POR DEFECTO ---");

        // Método heredado desde la clase abstracta Figura
        // Cada objeto ejecuta su propia implementación (polimorfismo)
        f1.mostrarInfo();
        f2.mostrarInfo();
        f3.mostrarInfo();
    }

    // Permite al usuario ingresar valores y crear una figura dinámica
    static void calcularFiguraPersonalizada() {
        mostrarMenuFiguras();
        int tipo = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // Creación de la figura según la opción seleccionada
        figuraActual = crearFigura(tipo);

        // Se muestra la información completa de la figura
        if (figuraActual != null) {
            figuraActual.mostrarInfo();
        }
    }

    // Método para cambiar el color de la figura actual utilizando la interfaz Coloreable
    static void cambiarColorFigura() {

        if (figuraActual == null) {
            System.out.println("Primero debe crear una figura.");
            return;
        }

        System.out.print("Ingrese nuevo color: ");
        String nuevoColor = sc.nextLine();

        figuraActual.aplicarColor(nuevoColor);

        System.out.println("\nColor actualizado:");
        figuraActual.mostrarInfo();
    }

    // Muestra las opciones de figuras disponibles
    static void mostrarMenuFiguras() {
        System.out.println("\nSeleccione figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Rectángulo");
        System.out.println("3. Triángulo");
        System.out.print("Opción: ");
    }

    // Método que decide qué figura crear
    // Retorna tipo Figura - aplicación de polimorfismo
    static Figura crearFigura(int tipo) {
        return switch (tipo) {
            case 1 -> crearCirculo();
            case 2 -> crearRectangulo();
            case 3 -> crearTriangulo();
            default -> {
                System.out.println("Opción inválida");
                yield null;
            }
        };
    }

    // Solicita datos y crea un objeto Circulo
    static Figura crearCirculo() {
        System.out.print("Ingrese radio: ");
        double radio = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese color: ");
        String color = sc.nextLine();

        return new Circulo(radio, color);
    }

    // Solicita datos y crea un objeto Rectangulo
    static Figura crearRectangulo() {
        System.out.print("Ingrese base: ");
        double base = sc.nextDouble();

        System.out.print("Ingrese altura: ");
        double altura = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese color: ");
        String color = sc.nextLine();

        return new Rectangulo(base, altura, color);
    }

    // Solicita datos y crea un objeto Triangulo
    static Figura crearTriangulo() {
        System.out.print("Ingrese lado 1: ");
        double l1 = sc.nextDouble();

        System.out.print("Ingrese lado 2: ");
        double l2 = sc.nextDouble();

        System.out.print("Ingrese lado 3: ");
        double l3 = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        System.out.print("Ingrese color: ");
        String color = sc.nextLine();

        return new Triangulo(l1, l2, l3, color);
    }
}