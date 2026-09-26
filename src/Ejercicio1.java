import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new java.util.Scanner(System.in);

        int[] paquetes = new int[10];
        int total = 0;

        System.out.println("=== Registro de paquetes procesados por hora ===");
        for (int i = 0; i < 10; i++) {
            int valor;
            do {
                System.out.print("Ingrese la cantidad de paquetes de la hora " + (i + 1) + ": ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Entrada inválida. Ingrese un número entero para la hora " + (i + 1) + ": ");
                    scanner.next();
                }
                valor = scanner.nextInt();

                if (valor < 0) {
                    System.out.println("La cantidad no puede ser negativa. Intente nuevamente.");
                }
            } while (valor < 0);

            paquetes[i] = valor;
            total += valor;
        }

        double promedio = total / 10.0;

        int horaMenor = 1;
        int menorCantidad = paquetes[0];
        for (int i = 1; i < 10; i++) {
            if (paquetes[i] < menorCantidad) {
                menorCantidad = paquetes[i];
                horaMenor = i + 1;
            }
        }

        int horasBajoPromedio = 0;
        int rachaActual = 0;
        int rachaMasLarga = 0;

        for (int i = 0; i < 10; i++) {
            if (paquetes[i] < promedio) {
                horasBajoPromedio++;
                rachaActual++;
                if (rachaActual > rachaMasLarga) {
                    rachaMasLarga = rachaActual;
                }
            } else {
                rachaActual = 0;
            }
        }

        System.out.println();
        System.out.println("=== Resultados ===");
        System.out.println("Total de paquetes procesados: " + total);
        System.out.println("Promedio de paquetes por hora: " + promedio);
        System.out.println("Hora con la menor cantidad procesada: Hora " + horaMenor + " con " + menorCantidad + " paquetes.");
        System.out.println("Horas con producción inferior al promedio: " + horasBajoPromedio);
        System.out.println("Racha más larga de horas consecutivas por debajo del promedio: " + rachaMasLarga);

        System.out.println();
        System.out.println("=== Listado final ===");
        for (int i = 0; i < 10; i++) {
            System.out.println("Hora " + (i + 1) + ": " + paquetes[i] + " paquetes");
        }

        scanner.close();
    }
}
