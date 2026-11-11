/*package arreglos_tienda.Utlitario;
import java.util.Scanner;


public class Valida {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String valor;
        do{
            System.out.print(mensaje + ": ");
            valor = sc.nextLine();
            if(valor == null || valor.trim().isEmpty())
                System.out.println("El dato no puede ser nulo ni estar vacio");
        }while(valor == null || valor.trim().isEmpty());
        return valor;
    }
}
*/


package arreglos_tienda.Utlitario;

import java.util.Scanner;

public class Valida {
    private static Scanner sc = new Scanner(System.in);
    public static String leerString(String mensaje) {
        String valor;
        do {
            System.out.println(mensaje+": ");
            valor = sc.nextLine();
            if(valor==null || valor.trim().isEmpty())
                System.out.println("El dato no pùede ser nulo ni estar vacio");
        }while(valor==null || valor.trim().isEmpty());
        return valor;
    }
    //lee un número entero mayor a 0 (tamaño, cantidad)
    public static int leerEnteroPositivo(String mensaje) {
        int valor = 0;
        do {
            System.out.println(mensaje+": ");
            try {
                valor = Integer.parseInt(sc.nextLine());
                if(valor <= 0)
                    System.out.println("El dato debe ser mayor a 0");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero");
                valor = 0;
            }
        }while(valor <= 0);
        return valor;
    }
    //lee un número entero mayor o igual a 0 (stock inicial)
    public static int leerEnteroNoNegativo(String mensaje) {
        int valor = -1;
        do {
            System.out.println(mensaje+": ");
            try {
                valor = Integer.parseInt(sc.nextLine());
                if(valor < 0)
                    System.out.println("El dato no puede ser negativo");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero");
                valor = -1;
            }
        }while(valor < 0);
        return valor;
    }
    //lee un número decimal mayor a 0 (precio)
    public static double leerDoublePositivo(String mensaje) {
        double valor = 0;
        do {
            System.out.println(mensaje+": ");
            try {
                valor = Double.parseDouble(sc.nextLine());
                if(valor <= 0)
                    System.out.println("El dato debe ser mayor a 0");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero");
                valor = 0;
            }
        }while(valor <= 0);
        return valor;
    }
}