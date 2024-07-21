/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrizordenada;
import java.util.*;
/**
 *
 * @author Carol
 */
public class MatrizOrdenada {

    public static void main(String[] args) {
//
//        // Ejemplo de matriz de productos: [código del despacho, nombre del producto, dosis, precio unitario]
//        String[][] productos = {
//            {"001", "tixapil", "5", "500000"},
//            {"001", "aspirina", "20", "150000"},
//            {"002", "paracetamol", "15", "70000"},
//            {"002", "tixapil", "8", "650000"},
//            {"003", "ibuprofeno", "25", "800000"},
//            {"003", "tixapil", "9", "300000"}
//        };
//
//
//        // Paso 1: Descartar productos con valor unitario mayor a 700.000
//        List<String[]> listaProductos = new ArrayList<>(Arrays.asList(productos));
//        listaProductos.removeIf(producto -> Integer.parseInt(producto[3]) > 700000);
//
//        // Paso 2: Modificar dosis y precio de productos "tixapil" con dosis menor a 10
//        for (String[] producto : listaProductos) {
//            if (producto[1].toLowerCase().contains("tixapil") && Integer.parseInt(producto[2]) < 10) {
//                producto[2] = String.valueOf(Integer.parseInt(producto[2]) * 7);
//                producto[3] = String.valueOf(Integer.parseInt(producto[3]) * 10);
//            }
//        }
//
//        // Paso 3: Agrupar productos repetidos dentro del mismo despacho
//        Map<String, Map<String, int[]>> despachoMap = new HashMap<>();
//        for (String[] producto : listaProductos) {
//            String codigoDespacho = producto[0];
//            String nombreProducto = producto[1];
//            int dosis = Integer.parseInt(producto[2]);
//            int precio = Integer.parseInt(producto[3]);
//
//            despachoMap.putIfAbsent(codigoDespacho, new HashMap<>());
//            Map<String, int[]> productosDespacho = despachoMap.get(codigoDespacho);
//
//            if (productosDespacho.containsKey(nombreProducto)) {
//                productosDespacho.get(nombreProducto)[0] += dosis;
//                productosDespacho.get(nombreProducto)[1] += precio;
//            } else {
//                productosDespacho.put(nombreProducto, new int[]{dosis, precio});
//            }
//        }
//
//        // Convertir el mapa a una lista de productos agrupados
//        List<String[]> productosAgrupados = new ArrayList<>();
//        for (String codigoDespacho : despachoMap.keySet()) {
//            Map<String, int[]> productosDespacho = despachoMap.get(codigoDespacho);
//            for (String nombreProducto : productosDespacho.keySet()) {
//                int[] valores = productosDespacho.get(nombreProducto);
//                productosAgrupados.add(new String[]{codigoDespacho, nombreProducto, String.valueOf(valores[0]), String.valueOf(valores[1])});
//            }
//        }
//
//        // Paso 4: Ordenar los despachos por su código consecutivo
//        productosAgrupados.sort(Comparator.comparing(producto -> producto[0]));
//
//        // Imprimir la matriz resultante
//        for (String[] producto : productosAgrupados) {
//            System.out.println(Arrays.toString(producto));
//        }



        // Ejemplo de matriz de productos: [código del despacho, nombre del producto, dosis, precio unitario]
        String[][] productos = {
            {"1","100", "tixapil", "10000", "10","19"},
            {"1","100", "Azitromicina", "10000", "10","1"},
            {"2","205", "Ezetimiba", "205000", "20","4"},
            {"1","150", "closaoina", "15000", "15","1"},
            {"2","290", "Ezetimiba", "290000", "29","2"},
            {"3","344", "Roxes nonatixapil generique", "34000", "3","50"},
            {"3","380", "Ibuprofeno", "3800000", "38","70"},
            {"33","380", "acetaminofem", "3800000", "70","70"},
        };
        

        // Paso 1: Descartar productos con valor unitario mayor a 700000
        int numProductosValidos = 0;
        for (int i = 0; i < productos.length; i++) {
            if (Integer.parseInt(productos[i][3]) <= 700000) {
                productos[numProductosValidos++] = productos[i];
            }
        }
        productos = Arrays.copyOf(productos, numProductosValidos);

        // Paso 2: Modificar dosis y precio de productos "tixapil" con dosis menor a 10
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][2].toLowerCase().contains("tixapil") && Integer.parseInt(productos[i][4]) < 10) {
                productos[i][4] = String.valueOf(Integer.parseInt(productos[i][4]) * 7);
                productos[i][3] = String.valueOf(Integer.parseInt(productos[i][3]) * 10);
            }
        }

        // Paso 3: Agrupar productos repetidos dentro del mismo despacho
        for (int i = 0; i < productos.length; i++) {
            for (int j = i + 1; j < productos.length; j++) {
                if (productos[i][0].equals(productos[j][0]) && productos[i][2].equals(productos[j][2])) {
                    productos[i][4] = String.valueOf(Integer.parseInt(productos[i][4]) + Integer.parseInt(productos[j][4]));
                    productos[i][3] = String.valueOf(Integer.parseInt(productos[i][3]) + Integer.parseInt(productos[j][3]));
                    productos[j][0] = "000"; // Marcar para eliminar
                }
            }
        }

        // Remover productos marcados para eliminar
        numProductosValidos = 0;
        for (int i = 0; i < productos.length; i++) {
            if (!productos[i][0].equals("000")) {
                productos[numProductosValidos++] = productos[i];
            }
        }
        productos = Arrays.copyOf(productos, numProductosValidos);
//añado algo 
    System.out.println("Hola ");
        // Paso 4: Ordenar los despachos por su código consecutivo
        Arrays.sort(productos, (a, b) -> a[0].compareTo(b[0]));

        // Imprimir la matriz resultante
        for (String[] producto : productos) {
            System.out.println(Arrays.toString(producto));
        }
    }
}

   