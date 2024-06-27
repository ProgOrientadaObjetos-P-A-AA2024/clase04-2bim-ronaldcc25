/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class EjecutorDos {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        String nombre;
        double cuotaB;
        int iva;
        double valAgua;
        double valLuz;
        double valFijo;
        double valSillas;
        double valAmplificacion;
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        System.out.print("Ingrese el numero de Locales de Comida va a ingresar: ");
        int localComida = leer.nextInt();
        leer.nextLine();

        for (int i = 0; i < localComida; i++) {

            System.out.print("\nIngrese el nombre del Local de Comida: ");
            nombre = leer.nextLine();

            System.out.print("Ingrese la cuota base: ");
            cuotaB = leer.nextDouble();

            System.out.print("Ingrese el IVA: ");
            iva = leer.nextInt();

            System.out.print("Ingrese el valor del agua: ");
            valAgua = leer.nextDouble();

            System.out.print("Ingrese el valor de la luz: ");
            valLuz = leer.nextDouble();
            leer.nextLine();

            ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                    nombre, cuotaB);

            arriendoComida.establecerIva(iva); // en porcentaje
            arriendoComida.establecerValorAgua(valAgua); // en $
            arriendoComida.establecerValorLuz(valLuz); // en $
            listaArriendos.add(arriendoComida);
        }

        System.out.print("\nIngrese el numero de Locales de Comida va a ingresar: ");
        int localComercial = leer.nextInt();
        leer.nextLine();

        for (int i = 0; i < localComercial; i++) {

            System.out.print("\nIngrese el nombre del Local Comercial: ");
            nombre = leer.nextLine();

            System.out.print("Ingrese la cuota base: ");
            cuotaB = leer.nextDouble();

            System.out.print("Ingrese el valor adicional Fijo: ");
            valFijo = leer.nextDouble();
            leer.nextLine();

            ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                    nombre, cuotaB);

            arriendoComercial.establecerValorAdicionalFijo(valFijo); // en $
            listaArriendos.add(arriendoComercial);
        }

        System.out.print("\nIngrese el numero de Locales de Sesiones va a ingresar: ");
        int localSesiones = leer.nextInt();
        leer.nextLine();

        for (int i = 0; i < localSesiones; i++) {
            
            System.out.print("\nIngrese el nombre del Local de Sesiones: ");
            nombre = leer.nextLine();

            System.out.print("Ingrese la cuota base: ");
            cuotaB = leer.nextDouble();

            System.out.print("Ingrese el valor sillas: ");
            valSillas = leer.nextDouble();

            System.out.print("Ingrese el valor amplificacion: ");
            valAmplificacion = leer.nextDouble();
            leer.nextLine();

            ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                    nombre, cuotaB);
            arriendoSesiones.establecerValorSillas(valSillas); // en $
            arriendoSesiones.establecerValorAmplificacion(valAmplificacion); // en $

            listaArriendos.add(arriendoSesiones);
        }

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera",
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }

}
