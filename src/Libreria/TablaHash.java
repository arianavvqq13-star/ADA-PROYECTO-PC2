
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
            }
        }
    }
} 
