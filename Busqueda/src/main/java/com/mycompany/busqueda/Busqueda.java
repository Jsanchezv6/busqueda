/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 *//*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.busqueda;

/**
 *
 * @author User
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Busqueda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Leer la cantidad de números y generarlos aleatoriamente
        System.out.print("Ingrese la cantidad de números: ");
        int cantidadNumeros = scanner.nextInt();
        int[] arreglo = new int[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            arreglo[i] = random.nextInt(100);
        }

        // Ordenar el arreglo
        Arrays.sort(arreglo);

        // Mostrar los números generados y ordenados
        System.out.print("Números generados y ordenados: ");
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();

        // Leer los números a buscar
        System.out.print("Ingrese los números a buscar separados por comas: ");
        String numeros = scanner.next();

        // Convertir la cadena de números a un arreglo de enteros
        String[] numerosSeparados = numeros.split(",");
        int[] numerosBuscar = new int[numerosSeparados.length];
        for (int i = 0; i < numerosSeparados.length; i++) {
            numerosBuscar[i] = Integer.parseInt(numerosSeparados[i]);
        }

        // Elegir el método de búsqueda
        System.out.println("Elija el método de búsqueda: ");
        System.out.println("1. Búsqueda secuencial");
        System.out.println("2. Búsqueda binaria");
        int opcion = scanner.nextInt();

        // Realizar la búsqueda para cada número
        for (int i = 0; i < numerosBuscar.length; i++) {
            int numero = numerosBuscar[i];
            int indice = -1;
            if (opcion == 1) {
                // Busqueda secuencial
                indice = busquedaSecuencial(arreglo, numero);
            } else if (opcion == 2) {
                // Búsqueda binaria
                indice = busquedaBinaria(arreglo, numero);
            } else {
                System.out.println("Opción no válida.");
            }

            // Mostrar el resultado de la búsqueda
            if (indice == -1) {
                System.out.println("No se encontró el número " + numero + ".");
            } else {
                System.out.println("El número " + numero + " se encontró en el índice " + indice + ".");
            }
        }
    }

    public static int busquedaSecuencial(int[] arreglo, int numero) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public static int busquedaBinaria(int[] arreglo, int numero) {
        int inicio = 0;
        int fin = arreglo.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (arreglo[medio] == numero) {
                return medio;
            } else if (arreglo[medio] < numero) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }
}