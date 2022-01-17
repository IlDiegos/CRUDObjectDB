/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.crudobjectdb;

import java.util.InputMismatchException;
import java.util.Scanner;
import models.Carta;
import models.Pedido;

/**
 *
 * @author diegu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var des = new Desayuno();
        Pedido p = new Pedido();
        boolean salir = false;
        int num;

        Carta carta = new Carta();
        /*
        carta.setId(2L);
        carta.setNombre("Bocadillo de queso manchego");
        carta.setPrecio(1.2);
        des.guardaCarta(carta);

        carta.setId(3L);
        carta.setNombre("Bocadillo mixto");
        carta.setPrecio(1.4);
        des.guardaCarta(carta);

        carta.setId(4L);
        carta.setNombre("Bocadillo catalana");
        carta.setPrecio(1.8);
        des.guardaCarta(carta);

        carta.setId(5L);
        carta.setNombre("Bocadillo de aceite");
        carta.setPrecio(1.0);
        des.guardaCarta(carta);

        carta.setId(6L);
        carta.setNombre("Bocadillo de sobrasada");
        carta.setPrecio(1.7);
        des.guardaCarta(carta);

        carta.setId(7L);
        carta.setNombre("Coca cola");
        carta.setPrecio(0.8);
        des.guardaCarta(carta);

        carta.setId(8L);
        carta.setNombre("Fanta de naranja");
        carta.setPrecio(0.8);
        des.guardaCarta(carta);

        carta.setId(9L);
        carta.setNombre("Fanta de limón");
        carta.setPrecio(0.8);
        des.guardaCarta(carta);

        carta.setId(10L);
        carta.setNombre("Agua");
        carta.setPrecio(0.6);
        des.guardaCarta(carta);
        */

        while (!salir) {
            System.out.println("\n \n");
            System.out.println("1. Crear pedido.");
            System.out.println("2. Eliminar pedido.");
            System.out.println("3. Marcar pedido.");
            System.out.println("4. Listar pendientes.");
            System.out.println("5. Listar carta.");
            System.out.println("6. Salir.");

            System.out.println("\n");
            num = sc.nextInt();
            try {
                switch (num) {
                    case 1:
                        des.imprimeCarta();
                        des.creaPedido();
                        break;

                    case 2:
                        des.borrarPedido();
                        break;

                    case 3:
                        des.marcarPedido();
                        break;
                    case 4:
                        des.mostrarHoy();
                        break;
                    case 5:
                        des.mostrarCarta();
                        break;
                    case 6:
                        System.out.println("Saliendo.");
                        System.exit(0);

                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce una opción correcta.");
                sc.next();
            }

        }

    }
}
