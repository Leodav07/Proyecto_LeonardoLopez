/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lopez_leonardo_proyectotienda;

import java.util.Scanner;

/**
 *
 * @author hnleo
 */
public class Lopez_Leonardo_ProyectoTienda {

    // DECLARACIÓN DE VARIABLES
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");
        double efectivoCaja = 0;
        int opSeleccion = 0;
        String tipoCliente;
        int tipoProducto = 0;

        //MENÚ PRINCIPAL DE LA TIENDA
        do {
            System.out.println("***** TIENDA JAVA | MENÚ PRINCIPAL *****");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Salir de Sistema");
            System.out.print("Selecciona una opción: ");
            opSeleccion = leer.nextInt();
            System.out.println("\n==============================================");

            switch (opSeleccion) {
                
                   // SECCIÓN DE CAJA
                case 1:
                    System.out.println("==============================================\n");
                    System.out.println("*** ABRIR CAJA ***");
                    System.out.print("Ingrese monto en efectivo: ");
                    double monto = leer.nextDouble();
                    efectivoCaja += monto;
                    System.out.println("¡Monto agregado con éxito en caja!");
                    System.out.println("\n==============================================");
                    System.out.println("==============================================\n");

                    break;
             
                    // SECCIÓN DE VENTAS
                case 2:
                    System.out.println("==============================================\n");
                    System.out.println("*** VENTAS ***");
                    System.out.print("Ingrese tipo de cliente: ");
                    tipoCliente = leer.next();
                    
                    if(tipoCliente.equals("A")){
                        System.out.println("Producto: 1. Azúcar  |  2. Avena  |  3. Trigo  |  4. Maíz  ");
                        System.out.println("Precio:      30 Lps  |     25 Lps |     32 Lps |    20 Lps ");
                        System.out.print("Ingrese el código de producto: ");
                        
                        tipoProducto = leer.nextInt();
                        
                        System.out.println("\n==============================================");
                        System.out.println("==============================================\n");
                    }
                    else if(tipoCliente.equals("B")){
                        System.out.println("Puede comprar solo productos 1, 2, 3");
                        System.out.println("\n==============================================");
                        System.out.println("==============================================\n");
                        
                    }
                    else if (tipoCliente.equals("C")){
                        System.out.println("Puede comprar solo producto 4");
                        System.out.println("\n==============================================");
                        System.out.println("==============================================\n");
                    }
                    else{
                        System.out.println("Ingrese un número válido");
                        System.out.println("\n==============================================");
                        System.out.println("==============================================\n");
                    }
                   
                    break;
    
                    
                   // SECCIÓN DE COMPRAS
                case 3:
                    System.out.println("==============================================\n");
                    System.out.println("*** COMPRAS ***");

                    break;

                   // SECCIÓN DE REPORTES
                case 4:
                    System.out.println("==============================================\n");
                    System.out.println("*** REPORTES ***");
                    System.out.println("1. Cantidad Actual en Caja");
                    System.out.print("Seleccione una opción: ");
                    int reportSelec = leer.nextInt();

                    switch (reportSelec) {
                        case 1:
                            System.out.println("\n----------------------------------------");
                            System.out.println("Efectivo actual en caja: " + efectivoCaja + " Lps.");
                            System.out.println("\n==============================================");
                            System.out.println("==============================================\n");
                            break;

                        default:
                            System.out.println("Ingrese una opción válida...");
                            break;
                    }
                    break;

                  
                 // SALIDA DEL SISTEMA
                case 5:
                    System.out.println("==============================================\n");
                    System.out.println("===== SALIENDO DEL SISTEMA... =====");
                    break;

                // INGRESO INVÁLIDO DE OPCIONES
                default:
                    System.out.println("==============================================\n");
                    System.out.println("Selecciona un número válido...");
                    break;

            }
        } while (opSeleccion != 5);
    }

}
