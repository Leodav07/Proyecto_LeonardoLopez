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

    public static void main(String[] args) {

        // DECLARACIÓN DE VARIABLES
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");

        // VARIABLES SECCIÓN DE CAJA
        double efectivoCaja = 0, gananciaCaja = 0;
        // VARIABLES SECCIÓN DE VENTAS
        double compraCliente = 0, cantidadKg = 0, subtotalVenta = 0, totalVenta = 0, descuento = 0, isv = 0, pctDesc = 0;
        double compraKgAzucar = 0, totalAzucar = 0;
        double compraKgAvena = 0, totalAvena = 0;
        double compraKgTrigo = 0, totalTrigo = 0;
        double compraKgMaiz = 0, totalMaiz = 0;
        String tipoCliente, respContinuar, respuestaSiNo;
        int contadorVentas = 0, volumenVentas=0, promedioVentas=0;
        // VARIABLES SECCIÓN COMPRAS
        String tipoProveedor;
        double totalCompraProveedor = 0;
        double azucarKg = 0, avenaKg = 0, trigoKg = 0, maizKg = 0;
        int tipoProducto = 0, contadorCompras = 0, volumenCompras=0, promedioCompras=0;
        
        // VARIABLES SECCION REPORTES
        double margenGanancia = 0;
        // VARIABLES SECCIÓN MENÚ
        int opSeleccion = 0;

        //MENÚ PRINCIPAL DE LA TIENDA
        System.out.println("==========================================================");
        do {
            System.out.println("=============** TIENDA JAVA | MENÚ PRINCIPAL **===========");
            System.out.println("==========================================================\n");
            System.out.println("================* 1.     Abrir Caja     *=================");
            System.out.println("================* 2.      Ventas        *=================");
            System.out.println("================* 3.      Compras       *=================");
            System.out.println("================* 4.      Reportes      *=================");
            System.out.println("================* 5.  Salir del Sistema *=================\n");
            System.out.print("Selecciona una opción: ");
            opSeleccion = leer.nextInt();
            System.out.println("\n==========================================================");

            switch (opSeleccion) {

                /* 
                SECCIÓN DE CAJA
                Actividad: Aquí el cajero puede abrir la cajera e ingresar monto en efectivo.
                 */
                case 1:
                    System.out.println("========================** CAJA **========================");
                    System.out.println("==========================================================\n");

                    System.out.print("Ingrese monto en efectivo: ");
                    double monto = leer.nextDouble();
                    efectivoCaja += monto;
                    System.out.println("\n===========**¡Monto agregado con éxito en caja!**=========");
                    System.out.println("\n==========================================================");

                    break;

                /* SECCIÓN DE VENTAS
                    Actividad: Aquí el cliente puede seleccionar producto, añadirlo a la canasta y comprar.
                 */
                case 2:
                    do {
                        cantidadKg = 0;
                        compraCliente = 0;
                        System.out.println("=======================** VENTAS **========================");
                        System.out.println("==========================================================\n");
                        System.out.print("Ingrese tipo de cliente: ");
                        tipoCliente = leer.next().toLowerCase();
                        System.out.println("Producto: 1. Azúcar  |  2. Avena  |  3. Trigo  |  4. Maíz  ");
                        System.out.print("Ingrese el código de producto deseado: ");
                        tipoProducto = leer.nextInt();

                        // RESTRINGIR PRODUCTOS
                        if (tipoCliente.equals("b")) {
                            if (tipoProducto == 4) {
                                System.out.println("======** NO PUEDE COMPRAR DICHO PRODUCTO **======\n");
                            }

                        } else if (tipoCliente.equals("c")) {
                            if (tipoProducto == 1 || tipoProducto == 2 || tipoProducto == 3) {
                                System.out.println("======** NO PUEDE COMPRAR DICHO PRODUCTO **======\n");

                            }
                        }
                        // FIN RESTRINGIR PRODUCTOS

                        System.out.print("Ingrese cantidad de kilogramos(kg) a comprar: ");
                        cantidadKg = leer.nextDouble();

                        switch (tipoProducto) {
                            case 1:
                                if (azucarKg >= cantidadKg) {
                                    compraCliente = cantidadKg * 30;
                                    System.out.println("\nPrecio por kilogramo: " + 30 + " Lps.");
                                    System.out.println("Precio total: " + compraCliente + " Lps.\n");
                                    System.out.print("¿Desea añadir producto a la compra?: ");
                                    respuestaSiNo = leer.next().toLowerCase();

                                    if (respuestaSiNo.equals("si")) {

                                        azucarKg -= cantidadKg;
                                        compraKgAzucar += cantidadKg;
                                        totalAzucar += compraCliente;
                                        System.out.println("\n====** PRODUCTO AÑADIDO EXITOSAMENTE **=====\n");
                                    } else {
                                        System.out.println("\n=========** PRODUCTO NO AÑADIDO **==========\n");
                                    }
                                } else {
                                    System.out.println("\n======** NO HAY SUFICIENTE PRODUCTO **======\n");
                                    break;
                                }

                                break;
                            case 2:
                                if (avenaKg >= cantidadKg) {
                                    compraCliente = cantidadKg * 25;
                                    System.out.println("\nPrecio por kilogramo: " + 25 + " Lps.");
                                    System.out.println("Precio total: " + compraCliente + " Lps.\n");
                                    System.out.print("¿Desea añadir producto a la compra?: ");
                                    respuestaSiNo = leer.next().toLowerCase();

                                    if (respuestaSiNo.equals("si")) {
                                        if (avenaKg > cantidadKg) {
                                            avenaKg -= cantidadKg;
                                            compraKgAvena += cantidadKg;
                                            totalAvena += compraCliente;
                                            System.out.println("\n====** PRODUCTO AÑADIDO EXITOSAMENTE **=====\n");

                                        } else {
                                            System.out.println("\n=========** PRODUCTO NO AÑADIDO **==========\n");
                                        }
                                    }
                                } else {
                                    System.out.println("\n======** NO HAY SUFICIENTE PRODUCTO **======\n");
                                }

                                break;
                            case 3:
                                if (trigoKg >= cantidadKg) {
                                    compraCliente = cantidadKg * 32;
                                    System.out.println("\nPrecio por kilogramo: " + 32 + " Lps.");
                                    System.out.println("Precio total: " + compraCliente + " Lps.\n");
                                    System.out.print("¿Desea añadir producto a la compra?: ");
                                    respuestaSiNo = leer.next().toLowerCase();

                                    if (respuestaSiNo.equals("si")) {
                                        if (trigoKg > cantidadKg) {
                                            trigoKg -= cantidadKg;
                                            compraKgTrigo += cantidadKg;
                                            totalTrigo += compraCliente;
                                            System.out.println("\n====** PRODUCTO AÑADIDO EXITOSAMENTE **=====\n");

                                        } else {
                                            System.out.println("\n=========** PRODUCTO NO AÑADIDO **==========\n");
                                        }

                                    }
                                } else {
                                    System.out.println("\n======** NO HAY SUFICIENTE PRODUCTO **======\n");
                                }
                                break;
                            case 4:
                                if (maizKg >= cantidadKg) {
                                    compraCliente = cantidadKg * 20;
                                    System.out.println("\nPrecio por kilogramo: " + 20 + " Lps.");
                                    System.out.println("Precio total: " + compraCliente + " Lps.\n");
                                    System.out.print("¿Desea añadir producto a la compra?: ");
                                    respuestaSiNo = leer.next().toLowerCase();

                                    if (respuestaSiNo.equals("si")) {
                                        if (maizKg > cantidadKg) {
                                            maizKg -= cantidadKg;
                                            compraKgMaiz += cantidadKg;
                                            totalMaiz += compraCliente;
                                            System.out.println("\n====** PRODUCTO AÑADIDO EXITOSAMENTE **=====\n");

                                        } else {
                                            System.out.println("\n=========** PRODUCTO NO AÑADIDO **==========\n");
                                        }

                                    }
                                } else {
                                    System.out.println("\n======** NO HAY SUFICIENTE PRODUCTO **======\n");
                                }
                        }

                        System.out.print("¿Desea comprar otro producto?: ");
                        respContinuar = leer.next().toLowerCase();

                    } while (respContinuar.equals("si"));

                    //APARTADO DE FACTURA DEL CLIENTE
                    String totalAzucarU = String.format("%.2f", totalAzucar);
                    String totalAvenaU = String.format("%.2f", totalAvena);
                    String totalTrigoU = String.format("%.2f", totalTrigo);
                    String totalMaizU = String.format("%.2f", totalMaiz);

                    subtotalVenta = 0;
                    System.out.println("\n================** FACTURA **==================\n");
                    if (compraKgAzucar > 0) {

                        System.out.println("Producto: Azúcar | Cantidad(kg): " + compraKgAzucar + "kg. | Precio: " + totalAzucarU + " Lps.");
                        subtotalVenta += totalAzucar;
                    }
                    if (compraKgAvena > 0) {
                        System.out.println("Producto: Avena  | Cantidad(kg): " + compraKgAvena + "kg.  | Precio: " + totalAvenaU + " Lps.");
                        subtotalVenta += totalAvena;
                    }
                    if (compraKgTrigo > 0) {
                        System.out.println("Producto: Trigo  | Cantidad(kg): " + compraKgTrigo + "kg.  | Precio: " + totalTrigoU + " Lps.");
                        subtotalVenta += totalTrigo;
                    }
                    if (compraKgMaiz > 0) {
                        System.out.println("Producto: Maíz   | Cantidad(kg): " + compraKgMaiz + "kg.   | Precio: " + totalMaizU + " Lps.");
                        subtotalVenta += totalMaiz;
                    }

                    if (subtotalVenta >= 1000 && subtotalVenta <= 5000) {
                        descuento = subtotalVenta * 0.05;
                        pctDesc = 5;
                    } else if (subtotalVenta > 5000) {
                        descuento = subtotalVenta * 0.10;
                        pctDesc = 10;
                    } else {
                        descuento = 0;
                        pctDesc = 0;
                    }

                    //CALCULO PARA LA FACTURA
                    isv = subtotalVenta * 0.07;
                    totalVenta = (subtotalVenta - descuento) + isv;

                    efectivoCaja += totalVenta;
                    gananciaCaja += totalVenta;

                    String pctDescU = String.format("%.2f", pctDesc);
                    String isvU = String.format("%.2f", isv);
                    String descuentoU = String.format("%.2f", descuento);
                    String subtotalVentaU = String.format("%.2f", subtotalVenta);
                    String totalVentaU = String.format("%.2f", totalVenta);

                    System.out.println("\nSubtotal: " + subtotalVentaU + " Lps.\n" + "\nDescuento del " + pctDescU + "%: " + descuentoU + " Lps.\n"
                            + "\nImpuestos 7%: " + isvU + " Lps.\n\nTotal a Pagar: " + totalVentaU + " Lps.");
                    System.out.println("\n==========================================================");
                    contadorVentas++;
                    volumenVentas+=totalVenta;
                    break;

                //Fin de sección de ventas.    
                /*
                SECCIÓN DE COMPRAS
                    Actividad: Aquí el vendedor compra producto para la tienda.
                 */
                case 3:
                    System.out.println("=======================** COMPRAS **======================");
                    System.out.println("==========================================================\n");
                    System.out.print("Ingrese tipo de Proveedor: ");
                    tipoProveedor = leer.next().toLowerCase();
                    System.out.println("Producto: 1. Azúcar  |  2. Avena  |  3. Trigo  |  4. Maíz  ");
                    System.out.print("Ingrese el código de producto deseado a comprar: ");
                    tipoProducto = leer.nextInt();

                    // RESTRINGIR PRODUCTOS
                    if (tipoProveedor.equals("a")) {
                        if (tipoProducto == 2 || tipoProducto == 3) {
                            System.out.println("\n===========* NO PUEDE PROVEER DICHO PRODUCTO *============\n");
                            System.out.println("\n==========================================================");
                            break;
                        }

                    } else if (tipoProveedor.equals("b")) {
                        if (tipoProducto == 1 || tipoProducto == 4) {
                            System.out.println("\n===========* NO PUEDE PROVEER DICHO PRODUCTO *============\n");
                            System.out.println("\n==========================================================");
                            break;
                        } else if (tipoProveedor.equals("c")) {
                            if (tipoProducto == 1 || tipoProducto == 3 || tipoProducto == 4) {
                                System.out.println("\n===========* NO PUEDE PROVEER DICHO PRODUCTO *============\n");
                                System.out.println("\n==========================================================");
                                break;
                            }
                        }
                    }
                    // FIN RESTRINGIR PRODUCTOS

                    System.out.print("Ingrese cantidad de kilogramos(kg) a comprar: ");
                    cantidadKg = leer.nextDouble();
                    System.out.println("\n");
                    switch (tipoProducto) {
                        case 1:

                            totalCompraProveedor = cantidadKg * 25;
                            System.out.println("Precio por kilogramo: " + 25 + " Lps.");
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                            System.out.print("¿Desea realizar la compra?: ");
                            respuestaSiNo = leer.next().toLowerCase();

                            if (respuestaSiNo.equals("si")) {
                                if (efectivoCaja >= totalCompraProveedor) {
                                    azucarKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                    volumenCompras+=totalCompraProveedor;
                                    System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                    System.out.println("\n==========================================================");
                                    contadorCompras++;
                                    break;

                                } else {
                                    System.out.println("\nDinero insuficiente, no se puede pagar compra...\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("\nFinalizando proceso de compra...\n");
                                System.out.println("\n==========================================================");
                                break;
                            }

                        case 2:
                            if (tipoProveedor.equals("b")) {
                                totalCompraProveedor = cantidadKg * 20;
                                System.out.println("Precio por kilogramo: " + 20 + " Lps.");
                            } else if (tipoProveedor.equals("c")) {
                                totalCompraProveedor = cantidadKg * 22;
                                System.out.println("Precio por kilogramo: " + 22 + " Lps.\n");
                            }
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                            System.out.print("¿Desea realizar la compra?: ");
                            respuestaSiNo = leer.next().toLowerCase();

                            if (respuestaSiNo.equals("si")) {
                                if (efectivoCaja >= totalCompraProveedor) {
                                    avenaKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                    volumenCompras+=totalCompraProveedor;
                                    System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                    break;

                                } else {
                                    System.out.println("\nDinero insuficiente, no se puede pagar compra...\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("\nFinalizando proceso de compra...\n");
                                System.out.println("\n==========================================================");
                                break;
                            }
                        case 3:
                            totalCompraProveedor = cantidadKg * 30;
                            System.out.println("Precio por kilogramo: " + 30 + " Lps.");
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                            System.out.print("¿Desea realizar la compra?: ");
                            respuestaSiNo = leer.next().toLowerCase();

                            if (respuestaSiNo.equals("si")) {
                                if (efectivoCaja >= totalCompraProveedor) {
                                    trigoKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                    volumenCompras+=totalCompraProveedor;
                                    System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                    break;

                                } else {
                                    System.out.println("\nDinero insuficiente, no se puede pagar compra...\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("\nFinalizando proceso de compra...\n");
                                System.out.println("\n==========================================================");
                                break;
                            }

                        case 4:
                            totalCompraProveedor = cantidadKg * 18;
                            System.out.println("Precio por kilogramo: " + 18 + " Lps.");
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                            System.out.print("¿Desea realizar la compra?: ");
                            respuestaSiNo = leer.next().toLowerCase();

                            if (respuestaSiNo.equals("si")) {
                                if (efectivoCaja >= totalCompraProveedor) {
                                    maizKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                    volumenCompras+=totalCompraProveedor;
                                    System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                    break;
                                } else {
                                    System.out.println("\nDinero insuficiente, no se puede pagar compra...\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("\nFinalizando proceso de compra...\n");
                                System.out.println("\n==========================================================");
                                break;
                            }
                    }

                    break;

                /*
                    SECCIÓN DE REPORTES
                    Actividad: Aqui el cajero puede observar estadísticas de las ventas, compras realizadas, etc..
                 */
                case 4:
                    String efectivoCajaU = String.format("%.2f", efectivoCaja);

                    System.out.println("======================** REPORTES **======================");
                    System.out.println("==========================================================\n");
                    System.out.println("\nCantidad en efectivo Actual en Caja: " + efectivoCajaU+" Lps.");
                    System.out.println("\n--------------------------------------------------------\n");
                    System.out.println("Cantidad de Ventas Realizadas: "+contadorVentas+" ventas.");
                    System.out.println("Cantidad de Compras Realizadas: "+contadorCompras+" compras.");
                     System.out.println("\n--------------------------------------------------------\n");
                     System.out.println("Volumen de Ventas: "+volumenVentas+" Lps.");
                     System.out.println("Volumen de Compras: "+volumenCompras+" Lps.");
                    //Cálculo de Margen de Ganancia
                    if(volumenVentas>volumenCompras){
                        margenGanancia = volumenVentas - volumenCompras;
                        System.out.println("Margen de Ganancia: "+margenGanancia+" Lps.");
                    }else if(volumenVentas<volumenCompras){
                        margenGanancia = volumenCompras - volumenVentas;
                        System.out.println("Margen de Pérdida: "+margenGanancia+" Lps.");
                    }else{
                        System.out.println("Sin Ganancias ni Pérdidas.");
                    }
                    System.out.println("\n--------------------------------------------------------\n");
                    // Fin del cálculo
                    //Cálculo de promedios
                    promedioVentas = volumenVentas / contadorVentas;
                    promedioCompras = volumenCompras / contadorCompras;
                    System.out.println("Total Promedio de Ventas: "+promedioVentas);
                    
                            
                   
                  

                    break;

                // SALIDA DEL SISTEMA
                case 5:
                    System.out.println("===============** SALIENDO DEL SISTEMA.. **===============");
                    System.out.println("==========================================================\n");
                    break;

                // INGRESO INVÁLIDO DE OPCIONES
                default:
                  
                    System.out.println("\nSelecciona una opción válida...\n");
                    System.out.println("==========================================================\n");
                    break;

            }

        } while (opSeleccion != 5);
    }

}
