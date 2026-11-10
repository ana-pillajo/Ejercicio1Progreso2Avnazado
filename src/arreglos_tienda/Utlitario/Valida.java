package arreglos_tienda.Utlitario;
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
