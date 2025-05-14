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
        double compraCliente = 0, cantidadKg = 0, subtotalVenta = 0, totalVenta = 0, descuento = 0, isv = 0, pctDesc = 0, ventaMax = 0;
        double compraKgAzucar = 0, compraKgAzucarU = 0;
        double compraKgAvena = 0, compraKgAvenaU = 0;
        double compraKgTrigo = 0, compraKgTrigoU = 0;
        double compraKgMaiz = 0, compraKgMaizU = 0;
        String tipoCliente, respContinuar = "", respuestaSiNo;
        int contadorVentas = 0;
        double volumenVentas = 0, promedioVentas = 0;
        boolean abrirVentas = false;
        // VARIABLES SECCIÓN COMPRAS
        String tipoProveedor;
        double totalCompraProveedor = 0, compraMax = 0;
        double azucarKg = 00, avenaKg = 00, trigoKg = 00, maizKg = 00;
        int tipoProducto = 0, contadorCompras = 0;
        double volumenCompras = 0, promedioCompras = 0;
        boolean abrirCompras = false;
        // VARIABLES SECCION REPORTES
        double margenGanancia = 0, productoEstrella = 0;
        // VARIABLES SECCIÓN MENÚ
        int opSeleccion = 0;

        //VARIABLES SECCION CIERRE DE CAJA
        boolean cierreCaja = false;

        //MENÚ PRINCIPAL DE LA TIENDA
        System.out.println("==========================================================");
        do {
            System.out.println("=============** TIENDA JAVA | MENÚ PRINCIPAL **===========");
            System.out.println("==========================================================\n");
            System.out.println("================* 1.     Abrir Caja     *=================");
            System.out.println("================* 2.      Ventas        *=================");
            System.out.println("================* 3.      Compras       *=================");
            System.out.println("================* 4.      Reportes      *=================");
            System.out.println("================* 5.   Cierre de Caja   *=================");
            System.out.println("================* 6.  Salir del Sistema *=================\n");
            System.out.print("Selecciona una opción: ");
            opSeleccion = leer.nextInt();
            System.out.println("\n==========================================================");

            switch (opSeleccion) {

                /* 
                SECCIÓN DE CAJA
                Actividad: Aquí el cajero puede abrir la cajera e ingresar monto en efectivo.
                 */
                case 1:
                    if (cierreCaja == true) {
                        System.out.println("====================** CAJA ABIERTA **====================");
                        System.out.println("==========================================================\n");

                        //Reinicio de contadores
                        compraCliente = 0;
                        cantidadKg = 0;
                        subtotalVenta = 0;
                        totalVenta = 0;
                        descuento = 0;
                        isv = 0;
                        pctDesc = 0;
                        ventaMax = 0;
                        compraKgAzucar = 0;
                        compraKgAzucarU = 0;
                        compraKgAvena = 0;
                        compraKgAvenaU = 0;
                        compraKgTrigo = 0;
                        compraKgTrigoU = 0;
                        compraKgMaiz = 0;
                        compraKgMaizU = 0;
                        contadorVentas = 0;
                        volumenVentas = 0;
                        promedioVentas = 0;
                        totalCompraProveedor = 0;
                        compraMax = 0;
                        azucarKg = 0;
                        avenaKg = 0;
                        trigoKg = 0;
                        maizKg = 0;
                        contadorCompras = 0;
                        volumenCompras = 0;
                        promedioCompras = 0;
                        margenGanancia = 0;
                        productoEstrella = 0;
                        abrirVentas = true;
                        abrirCompras = true;
                        cierreCaja = false;
                        System.out.println("\n==========================================================");
                        break;
                    }
                    System.out.println("========================** CAJA **========================");
                    System.out.println("==========================================================\n");

                    System.out.print("Ingrese monto en efectivo: ");
                    double monto = leer.nextDouble();
                    efectivoCaja += monto;
                    System.out.println("\n===========**¡Monto agregado con éxito en caja!**=========");
                    System.out.println("\n==========================================================");
                    abrirVentas = true;
                    abrirCompras = true;
                    break;

                /* SECCIÓN DE VENTAS
                    Actividad: Aquí el cliente puede seleccionar producto, añadirlo a la canasta y comprar.
                 */
                case 2:
                    // Si esta cerrada la caja...
                    if (abrirVentas == false) {
                        System.out.println("\n==** CAJA CERRADA; NO PUEDES INGRESAR A VENTAS **==\n");
                        break;
                    }
                    if (azucarKg > 0 || avenaKg > 0 || avenaKg > 0 || trigoKg > 0) {
                        double totalAzucar = 0,
                                totalAvena = 0,
                                totalTrigo = 0,
                                totalMaiz = 0;
                        compraKgAzucarU = 0;
                        compraKgAvenaU = 0;
                        compraKgTrigoU = 0;
                        compraKgMaizU = 0;
                        int contadorProductos = 0;
                        System.out.println("=======================** VENTAS **=======================");
                        System.out.println("==========================================================\n");
                        do {
                            boolean seguir = true;
                            cantidadKg = 0;
                            compraCliente = 0;

                            System.out.print("Ingrese tipo de cliente (A/B/C): ");
                            tipoCliente = leer.next().toLowerCase();
                            System.out.println("\nProducto: 1. Azúcar  |  2. Avena  |  3. Trigo  |  4. Maíz  ");
                            System.out.printf("Stock:    %-10s | %-10s | %-10s | %-10s%n",
                                    azucarKg + "kg.", avenaKg + "kg.", trigoKg + "kg.", maizKg + "kg.");
                            System.out.print("\nIngrese el código de producto deseado: ");
                            tipoProducto = leer.nextInt();

                            // RESTRINGIR PRODUCTOS
                            if (tipoCliente.equals("b")) {
                                if (tipoProducto == 4) {
                                    System.out.println("\n======** NO PUEDE COMPRAR DICHO PRODUCTO **======\n");
                                    seguir = false;
                                }

                            } else if (tipoCliente.equals("c")) {
                                if (tipoProducto == 1 || tipoProducto == 2 || tipoProducto == 3) {
                                    System.out.println("\n======** NO PUEDE COMPRAR DICHO PRODUCTO **======\n");
                                    seguir = false;
                                }
                            }
                            // FIN RESTRINGIR PRODUCTOS
                            if (seguir == true) {
                                System.out.print("Ingrese cantidad de kilogramos(kg) a comprar: ");
                                cantidadKg = leer.nextDouble();

                                switch (tipoProducto) {
                                    case 1:
                                        if (azucarKg >= cantidadKg) {
                                            compraCliente = cantidadKg * 30;
                                            System.out.println("\nPrecio por kilogramo: " + 30 + " Lps.");
                                            System.out.println("Precio total: " + compraCliente + " Lps.\n");
                                            System.out.print("¿Desea añadir producto a la compra?(Si/No): ");
                                            respuestaSiNo = leer.next().toLowerCase();

                                            if (respuestaSiNo.equals("si")) {

                                                azucarKg -= cantidadKg;
                                                compraKgAzucar += cantidadKg;
                                                compraKgAzucarU += cantidadKg;
                                                totalAzucar += compraCliente;
                                                contadorProductos++;
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
                                            System.out.print("¿Desea añadir producto a la compra?(Si/No): ");
                                            respuestaSiNo = leer.next().toLowerCase();

                                            if (respuestaSiNo.equals("si")) {
                                                avenaKg -= cantidadKg;
                                                compraKgAvena += cantidadKg;
                                                compraKgAvenaU += cantidadKg;
                                                totalAvena += compraCliente;
                                                contadorProductos++;
                                                System.out.println("\n====** PRODUCTO AÑADIDO EXITOSAMENTE **=====\n");

                                            } else {
                                                System.out.println("\n=========** PRODUCTO NO AÑADIDO **==========\n");
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
                                            System.out.print("¿Desea añadir producto a la compra?(Si/No): ");
                                            respuestaSiNo = leer.next().toLowerCase();

                                            if (respuestaSiNo.equals("si")) {

                                                trigoKg -= cantidadKg;
                                                compraKgTrigo += cantidadKg;
                                                compraKgTrigoU += cantidadKg;
                                                totalTrigo += compraCliente;
                                                contadorProductos++;
                                                System.out.println("\n====** PRODUCTO AÑADIDO EXITOSAMENTE **=====\n");

                                            } else {
                                                System.out.println("\n=========** PRODUCTO NO AÑADIDO **==========\n");
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
                                            System.out.print("¿Desea añadir producto a la compra?(Si/No): ");
                                            respuestaSiNo = leer.next().toLowerCase();

                                            if (respuestaSiNo.equals("si")) {

                                                maizKg -= cantidadKg;
                                                compraKgMaiz += cantidadKg;
                                                compraKgMaizU += cantidadKg;
                                                totalMaiz += compraCliente;
                                                contadorProductos++;
                                                System.out.println("\n====** PRODUCTO AÑADIDO EXITOSAMENTE **=====\n");

                                            } else {
                                                System.out.println("\n=========** PRODUCTO NO AÑADIDO **==========\n");
                                            }

                                        } else {
                                            System.out.println("\n======** NO HAY SUFICIENTE PRODUCTO **======\n");
                                        }
                                }
                            }

                            System.out.print("¿Desea comprar otro producto?(Si/No): ");
                            respContinuar = leer.next().toLowerCase();
                            System.out.println("\n==========================================================\n");
                        } while (respContinuar.equals("si"));

                        if (contadorProductos > 0) {
                            //APARTADO DE FACTURA DEL CLIENTE
                            String totalAzucarU = String.format("%.2f", totalAzucar);
                            String totalAvenaU = String.format("%.2f", totalAvena);
                            String totalTrigoU = String.format("%.2f", totalTrigo);
                            String totalMaizU = String.format("%.2f", totalMaiz);

                            subtotalVenta = 0;
                            totalVenta = 0;
                            System.out.println("\n================** FACTURA **==================\n");
                            if (compraKgAzucarU > 0) {

                                System.out.println("Producto: Azúcar | Cantidad(kg): " + compraKgAzucarU + "kg. | Precio: " + totalAzucarU + " Lps.");
                                subtotalVenta += totalAzucar;
                            }
                            if (compraKgAvenaU > 0) {
                                System.out.println("Producto: Avena  | Cantidad(kg): " + compraKgAvenaU + "kg.  | Precio: " + totalAvenaU + " Lps.");
                                subtotalVenta += totalAvena;
                            }
                            if (compraKgTrigoU > 0) {
                                System.out.println("Producto: Trigo  | Cantidad(kg): " + compraKgTrigoU + "kg.  | Precio: " + totalTrigoU + " Lps.");
                                subtotalVenta += totalTrigo;
                            }
                            if (compraKgMaizU > 0) {
                                System.out.println("Producto: Maíz   | Cantidad(kg): " + compraKgMaizU + "kg.   | Precio: " + totalMaizU + " Lps.");
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
                            volumenVentas += totalVenta;
                            if (totalVenta > ventaMax) {
                                ventaMax = totalVenta;
                            }
                        } else {
                            System.out.println("\n==** FIN DE VENTA | NO PRODUCTOS AÑADIDOS EN CANASTA **===\n");
                            System.out.println("\n==========================================================");
                        }
                    } else {
                        System.out.println("\n=============** NO HAY PRODUCTOS EN STOCK **==============\n");
                        System.out.println("\n==========================================================");
                    }
                    break;

                //Fin de sección de ventas.    
                /*
                SECCIÓN DE COMPRAS
                    Actividad: Aquí el vendedor compra producto para la tienda.
                 */
                case 3:

                    //Si esta cerrada la caja...
                    if (abrirCompras == false) {
                        System.out.println("\n==** CAJA CERRADA; NO PUEDES INGRESAR A COMPRAS **==\n");
                        break;
                    }

                    System.out.println("=======================** COMPRAS **======================");
                    System.out.println("==========================================================\n");
                    do {
                        System.out.print("Ingrese tipo de Proveedor(A/B/C): ");
                        tipoProveedor = leer.next().toLowerCase();
                    } while (tipoProveedor.equals("a") || tipoProveedor.equals("b") || tipoProveedor.equals("c"));
                    System.out.println("\nProducto: 1. Azúcar  |  2. Avena  |  3. Trigo  |  4. Maíz  ");
                    System.out.printf("Stock:    %-10s | %-10s | %-10s | %-10s%n",
                            azucarKg + "kg.", avenaKg + "kg.", trigoKg + "kg.", maizKg + "kg.");
                    do {
                        System.out.print("\nIngrese el código de producto deseado a comprar: ");
                        tipoProducto = leer.nextInt();
                    } while (tipoProducto <= 0 || tipoProducto > 4);

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
                    do {
                        System.out.print("Ingrese cantidad de kilogramos(kg) a comprar: ");
                        cantidadKg = leer.nextDouble();
                    } while (cantidadKg <= 0);
                    System.out.println("\n");
                    switch (tipoProducto) {
                        case 1:
                            totalCompraProveedor = cantidadKg * 25;
                            if (efectivoCaja >= totalCompraProveedor) {
                                System.out.println("Precio por kilogramo: " + 25 + " Lps.");
                                System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                                System.out.print("¿Desea realizar la compra?(Si/No): ");
                                respuestaSiNo = leer.next().toLowerCase();

                                if (respuestaSiNo.equals("si")) {

                                    azucarKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                    volumenCompras += totalCompraProveedor;
                                    System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                    System.out.println("\n==========================================================");
                                    if (totalCompraProveedor > compraMax) {
                                        compraMax = totalCompraProveedor;
                                    }
                                    contadorCompras++;
                                    break;

                                } else {
                                    System.out.println("\n============** FINALIZANDO PROCESO DE COMPRA **===========\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("\n====** DINERO INSUFICIENTE, NO SE PUEDE PAGAR COMPRA *====\n");
                                System.out.println("\n==========================================================");
                                break;
                            }

                        case 2:
                            if (tipoProveedor.equals("b")) {
                                totalCompraProveedor = cantidadKg * 20;
                                if (efectivoCaja >= totalCompraProveedor) {
                                    System.out.println("Precio por kilogramo: " + 20 + " Lps.");
                                } else {
                                    System.out.println("\n====** DINERO INSUFICIENTE, NO SE PUEDE PAGAR COMPRA *====\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else if (tipoProveedor.equals("c")) {
                                totalCompraProveedor = cantidadKg * 22;
                                if (efectivoCaja >= totalCompraProveedor) {
                                    System.out.println("Precio por kilogramo: " + 22 + " Lps.\n");
                                } else {
                                    System.out.println("\n====** DINERO INSUFICIENTE, NO SE PUEDE PAGAR COMPRA *====\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            }
                            System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                            System.out.print("¿Desea realizar la compra?(Si/No): ");
                            respuestaSiNo = leer.next().toLowerCase();

                            if (respuestaSiNo.equals("si")) {

                                avenaKg += cantidadKg;
                                efectivoCaja -= totalCompraProveedor;
                                volumenCompras += totalCompraProveedor;
                                System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                System.out.println("\n==========================================================");
                                if (totalCompraProveedor > compraMax) {
                                    compraMax = totalCompraProveedor;
                                }
                                contadorCompras++;
                                break;

                            } else {
                                System.out.println("\n============** FINALIZANDO PROCESO DE COMPRA **===========\n");
                                System.out.println("\n==========================================================");
                                break;
                            }
                        case 3:
                            totalCompraProveedor = cantidadKg * 30;
                            if (efectivoCaja >= totalCompraProveedor) {
                                System.out.println("Precio por kilogramo: " + 30 + " Lps.");
                                System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                                System.out.print("¿Desea realizar la compra?(Si/No): ");
                                respuestaSiNo = leer.next().toLowerCase();

                                if (respuestaSiNo.equals("si")) {
                                    trigoKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                    volumenCompras += totalCompraProveedor;
                                    System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                    System.out.println("\n==========================================================");
                                    if (totalCompraProveedor > compraMax) {
                                        compraMax = totalCompraProveedor;
                                    }
                                    contadorCompras++;
                                    break;

                                } else {
                                    System.out.println("\n============** FINALIZANDO PROCESO DE COMPRA **===========\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("\n====** DINERO INSUFICIENTE, NO SE PUEDE PAGAR COMPRA *====\n");
                                System.out.println("\n==========================================================");
                                break;
                            }
                        case 4:
                            totalCompraProveedor = cantidadKg * 18;
                            if (efectivoCaja >= totalCompraProveedor) {
                                System.out.println("Precio por kilogramo: " + 18 + " Lps.");
                                System.out.println("Precio total: " + totalCompraProveedor + " Lps.\n");
                                System.out.print("¿Desea realizar la compra?(Si/No): ");
                                respuestaSiNo = leer.next().toLowerCase();

                                if (respuestaSiNo.equals("si")) {

                                    maizKg += cantidadKg;
                                    efectivoCaja -= totalCompraProveedor;
                                    volumenCompras += totalCompraProveedor;
                                    System.out.println("\n============** COMPRA REALIZADA EXITOSAMENTE **===========\n");
                                    System.out.println("\n==========================================================");
                                    if (totalCompraProveedor > compraMax) {
                                        compraMax = totalCompraProveedor;
                                    }
                                    contadorCompras++;
                                    break;

                                } else {
                                    System.out.println("\n============** FINALIZANDO PROCESO DE COMPRA **===========\n");
                                    System.out.println("\n==========================================================");
                                    break;
                                }
                            } else {
                                System.out.println("\n====** DINERO INSUFICIENTE, NO SE PUEDE PAGAR COMPRA *====\n");
                                System.out.println("\n==========================================================");
                                break;
                            }

                        default:
                            System.out.println("\n=============** SELECCIONE UNA OPCION VALIDA *============\n");
                            System.out.println("\n==========================================================");
                            break;

                    }

                    break;
                /*
                    SECCIÓN DE REPORTES
                    Actividad: Aqui el cajero puede observar estadísticas de las ventas, compras realizadas, etc..
                 */
                case 4:

                    String efectivoCajaU = String.format("%.2f", efectivoCaja);
                    margenGanancia = 0;

                    System.out.println("======================** REPORTES **======================");
                    System.out.println("==========================================================\n");

                    //Cantidad de efectivo en caja
                    System.out.println("\nCantidad en efectivo Actual en Caja: " + efectivoCajaU + " Lps.");
                    System.out.println("\n--------------------------------------------------------\n");

                    //Cantidad de Ventas y Compras Realizadas
                    System.out.println("Cantidad de Ventas Realizadas: " + contadorVentas + " ventas.");
                    System.out.println("Cantidad de Compras Realizadas: " + contadorCompras + " compras.");
                    System.out.println("\n--------------------------------------------------------\n");

                    // Volumen de Ventas y Compras junto con Margen de Ganancia
                    String volumenVentasU = String.format("%.2f", volumenVentas);
                    String volumenComprasU = String.format("%.2f", volumenCompras);
                    System.out.println("Volumen de Ventas: " + volumenVentasU + " Lps.");
                    System.out.println("Volumen de Compras: " + volumenComprasU + " Lps.");
                    //Cálculo de Margen de Ganancia
                    if (volumenVentas > volumenCompras) {
                        margenGanancia = volumenVentas - volumenCompras;
                        String margenGananciaU = String.format("%.2f", margenGanancia);
                        System.out.println("Margen de Ganancia: " + margenGananciaU + " Lps.");
                    } else if (volumenVentas < volumenCompras) {
                        margenGanancia = volumenCompras - volumenVentas;
                        String margenGananciaU = String.format("%.2f", margenGanancia);
                        System.out.println("Margen de Pérdida: " + margenGananciaU + " Lps.");
                    } else {
                        System.out.println("Sin Ganancias ni Pérdidas.");
                    }
                    System.out.println("\n--------------------------------------------------------\n");

                    //Cálculo de promedios
                    promedioVentas = 0;
                    promedioCompras = 0;

                    promedioVentas = volumenVentas / contadorVentas;
                    promedioCompras = volumenCompras / contadorCompras;
                    String promedioVentasU = String.format("%.2f", promedioVentas);
                    String promedioComprasU = String.format("%.2f", promedioCompras);
                    System.out.println("Total Promedio de Ventas: " + promedioVentasU + " Lps.");
                    System.out.println("Total Promedio de Compras: " + promedioComprasU + " Lps.");
                    System.out.println("\n--------------------------------------------------------\n");

                    // Mayor Venta y Mayor Compra
                    String ventaMaxU = String.format("%.2f", ventaMax);
                    String compraMaxU = String.format("%.2f", compraMax);
                    System.out.println("La Venta con Mayor Ganancia Realizada es de: " + ventaMaxU + " Lps.");
                    System.out.println("La Compra con Mayor Gasto Efectuada es de: " + compraMaxU + " Lps.");
                    System.out.println("\n--------------------------------------------------------\n");

                    //Cálculo Producto Estrella
                    productoEstrella = 0;
                    if (compraKgAzucar > productoEstrella) {
                        productoEstrella = compraKgAzucar;

                    }
                    if (compraKgAvena > productoEstrella) {
                        productoEstrella = compraKgAvena;

                    }
                    if (compraKgTrigo > productoEstrella) {
                        productoEstrella = compraKgTrigo;

                    }
                    if (compraKgMaiz > productoEstrella) {
                        productoEstrella = compraKgMaiz;

                    }

                    //Impresión de producto Estrella o Productos Estrellas.
                    System.out.print("El Producto Estrella es:");

                    if (compraKgAzucar == productoEstrella) {
                        System.out.print(" Azucar con " + compraKgAzucar + "kg vendidos.");
                    }
                    if (compraKgAvena == productoEstrella) {
                        System.out.print(" Avena con " + compraKgAvena + "kg vendidos.");
                    }
                    if (compraKgTrigo == productoEstrella) {
                        System.out.print(" Trigo con " + compraKgTrigo + "kg vendidos.");
                    }
                    if (compraKgMaiz == productoEstrella) {
                        System.out.print(" Maiz con " + compraKgMaiz + "kg vendidos.");
                    }
                    System.out.println("\n\n==========================================================");

                    break;
                // CIERRE DE CAJA
                case 5:
                    double depositar = 0;
                    boolean continuar = true;
                    System.out.println("==================** CIERRE DE CAJA **====================");
                    System.out.println("==========================================================\n");
                    String gananciaCajaU = String.format("%.2f", gananciaCaja);
                    System.out.println("Ganancia en Caja: " + gananciaCajaU + " Lps.");
                    while (continuar) {
                        System.out.print("Efectivo a Depositar en el Banco(Max. 60%): ");
                        depositar = leer.nextDouble();

                        if (depositar <= (gananciaCaja * 60) / 100) {
                            gananciaCaja -= depositar;
                            efectivoCaja = gananciaCaja;
                            System.out.println("\n==================** CERRANDO CAJA **====================\n");
                            cierreCaja = true;
                            abrirVentas = false;
                            abrirCompras = false;
                            continuar = false;
                        } else {
                            System.out.println("\n============** CANTIDAD SUPERA 60% **===========\n");
                        }
                        if (depositar > gananciaCaja) {
                            System.out.println("\n============** CANTIDAD SUPERA 100% **===========\n");
                        }

                    }
                    break;

                // SALIDA DEL SISTEMA   
                case 6:

                    System.out.println("===============** SALIENDO DEL SISTEMA.. **===============");
                    System.out.println("==========================================================\n");
                    break;
                // INGRESO INVÁLIDO DE OPCIONES
                default:

                    System.out.println("\n=============** SELECCIONE UNA OPCION VALIDA *============\n");
                    System.out.println("\n==========================================================");
                    break;

            }

        } while (opSeleccion != 6);
    }

}
