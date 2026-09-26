import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int HORAS = 10;
        int[] paquetes = new int[HORAS];
        
        for (int i = 0; i < HORAS; i++) {
            int valor = -1;
            boolean valido = false;

            while (!valido) {
                System.out.print("Ingrese la cantidad de paquetes procesados en la hora "
                        + (i + 1) + ": ");
                valor = sc.nextInt();

                if (valor < 0) {
                    System.out.println("Dato inválido. La cantidad no puede ser negativa. Intente de nuevo.");
                } else {
                    valido = true;
                }
            }
            paquetes[i] = valor;
        }

        int total = 0;
        for (int i = 0; i < HORAS; i++) {
            total += paquetes[i];
        }
        double promedio = (double) total / HORAS;

        // 3c. Hora con la menor cantidad procesada
        int indiceMenor = 0;
        for (int i = 1; i < HORAS; i++) {
            if (paquetes[i] < paquetes[indiceMenor]) {
                indiceMenor = i;
            }
        }
        int horaMenor = indiceMenor + 1; 

        
        int horasBajoPromedio = 0;
        for (int i = 0; i < HORAS; i++) {
            if (paquetes[i] < promedio) {
                horasBajoPromedio++;
            }
        }

        int rachaActual = 0;
        int rachaMasLarga = 0;
        for (int i = 0; i < HORAS; i++) {
            if (paquetes[i] < promedio) {
                rachaActual++;
                if (rachaActual > rachaMasLarga) {
                    rachaMasLarga = rachaActual;
                }
            } else {
                rachaActual = 0;
            }
        }

        System.out.println("RESULTADOS ");
        System.out.println("Total de paquetes procesados: " + total);
        System.out.printf("Promedio de paquetes por hora: %.2f%n", promedio);
        System.out.println("Hora con la menor cantidad procesada: Hora " + horaMenor
                + " (" + paquetes[indiceMenor] + " paquetes)");
        System.out.println("Horas con producción inferior al promedio: " + horasBajoPromedio);
        System.out.println("Racha más larga de horas consecutivas bajo el promedio: " + rachaMasLarga);

        System.out.println("\n--- LISTADO FINAL ---");
        for (int i = 0; i < HORAS; i++) {
            System.out.println("Hora " + (i + 1) + ": " + paquetes[i] + " paquetes");
        }

        sc.close();
    }
}