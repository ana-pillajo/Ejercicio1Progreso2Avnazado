/*package arreglos_tienda.interfaz;

import arreglos_tienda.Utlitario.Valida;
import arreglos_tienda.modelo.AppStore;
import arreglos_tienda.modelo.Juego;

import java.sql.SQLOutput;
import java.util.Scanner;
import javax.swing.*;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        tienda.cargarDatos();
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch(opc){
                case 1:{
                    ingresarJuegos();
                }break;
                case 2:{
                    mostrarJuegos();
                }break;
                case 3:{

                }break;
                case 4:{

                }break;
                case 5:{

                }break;
                case 6:{

                }break;
                case 7:{
                    System.out.println("Gracias por usar nuestros servicios!");
                }break;

                default:
                    System.out.println("Opción no válida");
            }
        }while(opc != 7);

    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }
    public static void ingresarJuegos(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Valida.leerString("Ingrese el nombre");
        String categoria = Valida.leerString("Ingrese la categoria");
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        if(tienda.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null,"El juego se ha agregado con éxito!!");
        }else{
            JOptionPane.showMessageDialog(null,"El juego no puedo ser agregado");
        }
    }

    public static void mostrarJuegos(){
        Juego juegos[] = tienda.getJuegos();
        if(tienda.getIndice() >= 0){
            for(int i = 0; i <= tienda.getIndice(); i++){
                System.out.println(juegos[i]);
            }
        }else{
            System.out.println("No existe juegos a mostrar");
        }

    }
}
*/

package arreglos_tienda.interfaz;
import arreglos_tienda.modelo.AppStore;
import arreglos_tienda.modelo.Juego;
import arreglos_tienda.Utlitario.Valida;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc= new Scanner(System.in);
    private static AppStore tienda = new AppStore();
    static void main() {
        int opc;
        do{
            menu();
            //validación: si ingresa letras va al default
            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opc = 0;
            }
            switch(opc){
                case 1:{
                    ingresarJuegos();
                }
                break;
                case 2:{
                    mostrarJuegos();
                }
                break;
                case 3:{
                    buscarJuego();
                }
                break;
                case 4:{
                    comprar();
                }
                break;
                case 5:{
                    vender();
                }
                break;
                case 6:{
                    masVendido();
                }
                break;
                case 7:{
                    System.out.println("Gracias por usar nuestros servicios!");
                }
                break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opc !=7);
    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }
    public static void ingresarJuegos(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Valida.leerString("Ingrese el nombre");
        //validación: no permitir juegos repetidos
        if(tienda.buscarJuego(nombre) != null){
            JOptionPane.showMessageDialog(null, "El juego ya existe");
            return;
        }
        String categoria = Valida.leerString("Ingrese la categoria");
        int tamanio = Valida.leerEnteroPositivo("Ingrese el tamanio");
        double precio = Valida.leerDoublePositivo("Ingrese el precio");
        int licenciasDisponibles = Valida.leerEnteroNoNegativo("Ingrese el stock inicial");
        if (tienda. agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "Juego agregado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Juego no agregado correctamente");
        }
    }
    public static void mostrarJuegos(){
        Juego juegos[]= tienda.getJuegos();
        if(tienda.getIndice()>=0) {
            for (int i = 0; i <= tienda.getIndice(); i++) {
                System.out.println(juegos[i]);
            }
        }else {
            System.out.println("No existe juegos a mostrar");
        }
    }
    public static void buscarJuego(){
        //validación: debe haber juegos registrados
        if(tienda.getIndice()>=0) {
            String nombre = Valida.leerString("Ingrese el nombre del juego a buscar");
            Juego j = tienda.buscarJuego(nombre);
            if (j != null) {
                System.out.println(j);
            } else {
                System.out.println("El juego no existe");
            }
        }else {
            System.out.println("No existe juegos registrados");
        }
    }
    public static void comprar(){
        //validación: debe haber juegos registrados
        if(tienda.getIndice()>=0) {
            String nombre = Valida.leerString("Ingrese el nombre del juego a comprar");
            //validación: el juego debe existir
            if (tienda.buscarJuego(nombre) == null) {
                System.out.println("El juego no existe");
                return;
            }
            int cantidad = Valida.leerEnteroPositivo("Ingrese la cantidad de licencias a comprar");
            if (tienda.comprar(nombre, cantidad)) {
                JOptionPane.showMessageDialog(null, "Compra realizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la compra");
            }
        }else {
            System.out.println("No existe juegos registrados");
        }
    }
    public static void vender(){
        //validación: debe haber juegos registrados
        if(tienda.getIndice()>=0) {
            String nombre = Valida.leerString("Ingrese el nombre del juego a vender");
            Juego j = tienda.buscarJuego(nombre);
            //validación: el juego debe existir
            if (j == null) {
                System.out.println("El juego no existe");
                return;
            }
            //validación: debe haber licencias disponibles
            if (j.getLicenciasDisponibles() == 0) {
                System.out.println("No hay licencias disponibles de este juego");
                return;
            }
            int cantidad = Valida.leerEnteroPositivo("Ingrese la cantidad a vender (disponibles: "
                    + j.getLicenciasDisponibles() + ")");
            //validación: no vender más licencias de las disponibles
            if (cantidad > j.getLicenciasDisponibles()) {
                JOptionPane.showMessageDialog(null, "No hay suficientes licencias. Disponibles: "
                        + j.getLicenciasDisponibles());
                return;
            }
            double total = tienda.vender(nombre, cantidad);
            if (total > 0) {
                JOptionPane.showMessageDialog(null, "Venta realizada. Total a pagar: $" + total);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la venta");
            }
        }else {
            System.out.println("No existe juegos registrados");
        }
    }
    public static void masVendido(){
        //validación: debe haber juegos registrados
        if(tienda.getIndice()>=0) {
            String nombre = tienda.masVendido();
            //validación: si el juego encontrado no tiene ventas, no se ha vendido nada
            if (tienda.buscarJuego(nombre).getLicenciasVendidas() == 0) {
                System.out.println("Todavia no se ha vendido ningun juego");
            } else {
                System.out.println("El juego más vendido es: " + nombre);
            }
        }else {
            System.out.println("No existe juegos registrados");
        }
    }
}
