/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador.tda.grafo;

import controlador.tda.grafo.GrafoED;
import controlador.tda.lista.ListaEnlazada;
import java.util.Objects;

/**
 *
 * @author Stalin Adrián Jiménez Molina
 */
public class Dijkstra {

    private Double[][] Pesos;
    private int[] ultimo;
    private double[] D;
    private boolean[] F;
    private Integer s, n; //Vertice origen y numero de vertices

    public void caminoMinimo(GrafoED e, int origen) {
        n = e.numVertices();
        s = origen;
        Pesos = e.pesoArista(origen, s);
        ultimo = new int[n]; // nodo de paso
        D = new double[n]; // caminos min
        F = new boolean[n]; // Nodo escogido
    }

    public void DijkstraCam() {
        for (int i = 0; i < n; i++) {
            F[i] = false;
            D[i] = Pesos[s][i];
            ultimo[i] = s;
        }
        D[s] = 0;
        F[s] = true;
        for (int i = 0; i < n; i++) {
            int v = minimos();
            /* selecciona vértice no marcado 
de menor distancia */
            F[v] = true;
            // actualiza distancia de vértices no marcados 
            for (int w = 0; w < n; w++) {
                if (!F[w]) {
                    if ((D[v] + Pesos[v][w]) < D[w]) {
                        D[w] = D[v] + Pesos[v][w];
                        ultimo[w] = v;
                    }
                }
            }
        }
    }

    public int minimos() {
        double mx = 1000000.0;
        int v = 1;
        for (int i = 0; i < n; i++) {
            if (!F[i] && D[i] <= mx) {
                mx = D[i];
                v = i;
            }
        }
        return v;
    }

    public int minimo(double dist[], boolean b[]) {
        double min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < 5; i++) {
            if (b[i] == false && dist[i] <= min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    public Lista<Integer> ruta(Integer destino, Lista<Integer> caminos) {
        destino = destino;
        Integer anterior = ultimo[destino];
        if (!Objects.equals(destino, s)) {
            ruta(anterior, caminos);
            caminos.insertarNodo(destino);
        } else {
            caminos.insertarNodo(s);
        }
        return caminos;
    }

}
