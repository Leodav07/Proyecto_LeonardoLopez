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
        double efectivoCaja = 0, cantidadKg = 0, totalCompraProveedor = 0;
        double azucarKg = 0, avenaKg = 0, trigoKg = 0, maizKg = 0;
        int opSeleccion = 0;
        String tipoCliente, tipoProveedor;
        int tipoProducto = 0;

        //MENÚ PRINCIPAL DE LA TIENDA
        do {
            System.out.println("=============** TIENDA JAVA | MENÚ PRINCIPAL **===========");
            System.out.println("==========================================================\n");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Salir de Sistema");
            System.out.print("Selecciona una opción: ");
            opSeleccion = leer.nextInt();
            System.out.println("\n==========================================================");

            switch (opSeleccion) {

                // SECCIÓN DE CAJA
                case 1:
                    System.out.println("========================** CAJA **========================");
                    System.out.println("==========================================================\n");

                    System.out.print("Ingrese monto en efectivo: ");
                    double monto = leer.nextDouble();
                    efectivoCaja += monto;
                    System.out.println("\n===========**¡Monto agregado con éxito en caja!**=========");
                    System.out.println("\n==========================================================");

                    break;

                // SECCIÓN DE VENTAS
                case 2:
                    System.out.println("========================** VENTAS **========================");
                    System.out.println("==========================================================\n");
                    System.out.print("Ingrese tipo de cliente: ");
                    tipoCliente = leer.next();
                    System.out.println("Producto: 1. Azúcar  |  2. Avena  |  3. Trigo  |  4. Maíz  ");
                    System.out.print("Ingrese el código de producto deseado: ");
                    tipoProducto = leer.nextInt();

                    // RESTRINGIR PRODUCTOS
                    if (tipoCliente.equals("B")) {
                        if (tipoProducto == 4) {
                            System.out.println("======** NO PUEDE COMPRAR DICHO PRODUCTO **======\n");
                        }
                        break;
                    } else if (tipoCliente.equals("C")) {
                        if (tipoProducto == 1 || tipoProducto == 2 || tipoProducto == 3) {
                            System.out.println("======** NO PUEDE COMPRAR DICHO PRODUCTO **======\n");
                            break;
                        }
                    }
                    // FIN RESTRINGIR PRODUCTOS

                    System.out.println("Producto: Azúcar | Precio: 30 Lps.");

                    System.out.println("\n==========================================================");

                    break;

                // SECCIÓN DE COMPRAS
                case 3:
                    System.out.println("========================** COMPRAS **======================");
                    System.out.println("==========================================================\n");
                    System.out.print("Ingrese tipo de Proveedor: ");
                    tipoProveedor = leer.next();
                    System.out.println("Producto: 1. Azúcar  |  2. Avena  |  3. Trigo  |  4. Maíz  ");
                    System.out.print("Ingrese el código de producto deseado a comprar: ");
                    tipoProducto = leer.nextInt();

                    // RESTRINGIR PRODUCTOS
                    if (tipoProveedor.equals("A")) {
                        if (tipoProducto == 2 || tipoProducto == 3) {
                            System.out.println("======** NO PUEDE PROVEER DICHO PRODUCTO **======\n");
                            break;
                        }
                        
                    } else if (tipoProveedor.equals("B")) {
                        if (tipoProducto == 1 || tipoProducto == 4) {
                            System.out.println("======** NO PUEDE PROVEER DICHO PRODUCTO **======\n");
                            break;
                        } else if (tipoProveedor.equals("C")) {
                            if (tipoProducto == 1 || tipoProducto == 3 || tipoProducto == 4) {
                                System.out.println("======** NO PUEDE PROVEER DICHO PRODUCTO **======\n");
                                break;
                            }
                        }
                    }
                    // FIN RESTRINGIR PRODUCTOS

                    System.out.print("Ingrese cantidad de kilogramos(kg) a comprar: ");
                    cantidadKg = leer.nextDouble();
                    switch (tipoProducto) {
                        case 1:

                            totalCompraProveedor = cantidadKg * 25;
                            System.out.println("Precio por kilogramo: " + 25 + " Lps.");
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.");
                            System.out.print("¿Desea realizar la compra?: ");
                            String respuestaSiNo = leer.next().toLowerCase();

                            if (respuestaSiNo.equals("si")) {
                                if (efectivoCaja >= totalCompraProveedor) {
                                    azucarKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                } else {
                                    System.out.println("No se puede pagar compra...");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("Finalizando proceso de compra...");
                                System.out.println("\n==========================================================");
                                break;
                            }

                            break;

                        case 2:
                            if (tipoProveedor.equals("B")) {
                                totalCompraProveedor = cantidadKg * 20;
                                System.out.println("Precio por kilogramo: " + 20 + " Lps.");
                            } else if (tipoProveedor.equals("C")) {
                                totalCompraProveedor = cantidadKg * 22;
                                System.out.println("Precio por kilogramo: " + 22 + " Lps.");
                            }
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.");
                            break;
                        case 3:
                            totalCompraProveedor = cantidadKg * 30;
                            System.out.println("Precio por kilogramo: " + 30 + " Lps.");
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.");
                            System.out.println("\n==========================================================");
                            break;
                    }

                    break;

                // SECCIÓN DE REPORTES
                case 4:
                    System.out.println("========================** REPORTES **========================");
                    System.out.println("==========================================================\n");
                    System.out.println("1. Cantidad Actual en Caja");
                    System.out.print("Seleccione una opción: ");
                    int reportSelec = leer.nextInt();

                    switch (reportSelec) {
                        case 1:
                            System.out.println("\n----------------------------------------");
                            System.out.println("Efectivo actual en caja: " + efectivoCaja + " Lps.");
                            System.out.println("\n==========================================================");

                            break;

                        default:
                            System.out.println("Ingrese una opción válida...");
                            break;
                    }
                    break;

                // SALIDA DEL SISTEMA
                case 5:
                    System.out.println("========================** SALIENDO DEL SISTEMA... **========================");
                    System.out.println("==========================================================\n");
                    break;

                // INGRESO INVÁLIDO DE OPCIONES
                default:
                    System.out.println("==========================================================\n");
                    System.out.println("Selecciona un número válido...");
                    break;

            }

        } while (opSeleccion != 5);
    }

}
