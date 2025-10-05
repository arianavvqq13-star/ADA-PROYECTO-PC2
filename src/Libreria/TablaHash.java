
package Libreria;
import java.util.Scanner;
import java.util.LinkedList;

public class TablaHash {
    private LinkedList<Articulo>[] tabla;
    private int tamaño;
    //tamaño tabla hash
    public TablaHash(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
              }
    }
    // Función hash: obtiene un índice a partir del código
    private int funcionHash(String codigo) {
        return Math.abs(codigo.hashCode() % tamaño);
    }

    // Insertar artículo
    public void insertar(Articulo articulo) {
        int indice = funcionHash(articulo.getCodigo());
        tabla[indice].add(articulo);
    }

    // Buscar artículo por código
    public Articulo buscar(String codigo) {
        int indice = funcionHash(codigo);
        for (Articulo art : tabla[indice]) {
            if (art.getCodigo().equals(codigo)) {
                return art;
            }
        }
        return null; // no encontrado
    }

    // Eliminar artículo por código
    public boolean eliminar(String codigo) {
        int indice = funcionHash(codigo);
        for (Articulo art : tabla[indice]) {
            if (art.getCodigo().equals(codigo)) {
                tabla[indice].remove(art);
                return true;
            }
        }
        return false;
    }

    // Mostrar todos los artículos
    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            if (!tabla[i].isEmpty()) {
                System.out.println("Índice " + i + ": " + tabla[i]);
        
// ======== MÉTODOS PARA GUARDAR Y CARGAR DESDE ARCHIVO ========

public void guardarEnArchivo(String nombreArchivo) {
    try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(nombreArchivo))) {
        for (ListaEnlazada lista : tabla) { // tabla es tu arreglo de listas enlazadas
            if (lista != null) {
                for (Articulo a : lista.obtenerArticulos()) { // necesitas un método que devuelva los artículos
                    pw.println(a.getCodigo() + ";" + a.getNombre() + ";" + a.getPrecio() + ";" + a.getStock());
                }
            }
        }
        System.out.println("Datos guardados en " + nombreArchivo);
    } catch (Exception e) {
        System.out.println("Error al guardar en archivo: " + e.getMessage());
    }
}

public void cargarDesdeArchivo(String nombreArchivo) {
    try (java.util.Scanner sc = new java.util.Scanner(new java.io.File(nombreArchivo))) {
        while (sc.hasNextLine()) {
            String[] partes = sc.nextLine().split(";");
            if (partes.length == 4) {
                String codigo = partes[0];
                String nombre = partes[1];
                double precio = Double.parseDouble(partes[2]);
                int stock = Integer.parseInt(partes[3]);
                insertar(new Articulo(codigo, nombre, precio, stock));
            }
        }
        System.out.println("Datos cargados desde " + nombreArchivo);
    } catch (Exception e) {
        System.out.println("No se pudo cargar el archivo: " + e.getMessage());
    }
}

    }
        }
    }
} 