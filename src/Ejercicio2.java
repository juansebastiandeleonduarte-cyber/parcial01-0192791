import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int SUCURSALES = 4;
        final int PRODUCTOS = 5;
        int[][] ventas = new int[SUCURSALES][PRODUCTOS];

        // 1 y 2. Lectura y validación de la matriz
        for (int i = 0; i < SUCURSALES; i++) {
            for (int j = 0; j < PRODUCTOS; j++) {
                int valor = -1;
                boolean valido = false;

                while (!valido) {
                    System.out.print("Unidades vendidas - Sucursal " + (i + 1)
                            + ", Producto " + (j + 1) + ": ");
                    valor = sc.nextInt();

                    if (valor < 0) {
                        System.out.println("Dato inválido. No puede ser negativo. Intente de nuevo.");
                    } else {
                        valido = true;
                    }
                }
                ventas[i][j] = valor;
            }
        }

        
        int[] totalPorSucursal = new int[SUCURSALES];
        for (int i = 0; i < SUCURSALES; i++) {
            int suma = 0;
            for (int j = 0; j < PRODUCTOS; j++) {
                suma += ventas[i][j];
            }
            totalPorSucursal[i] = suma;
        }

        int[] totalPorProducto = new int[PRODUCTOS];
        for (int j = 0; j < PRODUCTOS; j++) {
            int suma = 0;
            for (int i = 0; i < SUCURSALES; i++) {
                suma += ventas[i][j];
            }
            totalPorProducto[j] = suma;
        }

  
        int indiceSucursalMenor = 0;
        for (int i = 1; i < SUCURSALES; i++) {
            if (totalPorSucursal[i] < totalPorSucursal[indiceSucursalMenor]) {
                indiceSucursalMenor = i;
            }
        }

  
        int indiceProductoMayor = 0;
        for (int j = 1; j < PRODUCTOS; j++) {
            if (totalPorProducto[j] > totalPorProducto[indiceProductoMayor]) {
                indiceProductoMayor = j;
            }
        }


        int registrosMayores30 = 0;
        for (int i = 0; i < SUCURSALES; i++) {
            for (int j = 0; j < PRODUCTOS; j++) {
                if (ventas[i][j] > 30) {
                    registrosMayores30++;
                }
            }
        }

        System.out.println("\n RESULTADOS ");

        System.out.println("Total de unidades vendidas por sucursal:");
        for (int i = 0; i < SUCURSALES; i++) {
            System.out.println("  Sucursal " + (i + 1) + ": " + totalPorSucursal[i]);
        }

        System.out.println("\nTotal vendido por producto (todas las sucursales):");
        for (int j = 0; j < PRODUCTOS; j++) {
            System.out.println("  Producto " + (j + 1) + ": " + totalPorProducto[j]);
        }

        System.out.println("\nSucursal con menor cantidad total de ventas: Sucursal "
                + (indiceSucursalMenor + 1) + " (" + totalPorSucursal[indiceSucursalMenor] + " unidades)");

        System.out.println("Producto con mayor cantidad total de unidades vendidas: Producto "
                + (indiceProductoMayor + 1) + " (" + totalPorProducto[indiceProductoMayor] + " unidades)");

        System.out.println("Registros de la matriz superiores a 30 unidades: " + registrosMayores30);

        System.out.println("\nMATRIZ COMPLETA (Sucursal y Producto)");
        for (int i = 0; i < SUCURSALES; i++) {
            System.out.print("Sucursal " + (i + 1) + ": ");
            for (int j = 0; j < PRODUCTOS; j++) {
                System.out.print("P" + (j + 1) + "=" + ventas[i][j] + "  ");
            }
            System.out.println();
        }

        sc.close();
    }
}