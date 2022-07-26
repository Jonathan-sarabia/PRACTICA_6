/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.tda.grafo;


import controlador.tda.grafo.exception.GrafoConnectionException;
import controlador.tda.grafo.exception.VerticeException;
import controlador.tda.lista.ListaEnlazada;
import java.util.HashMap;

/**
 *
 * @author javisarango
 */
public abstract class Grafo {

    public abstract Integer numVertices();

    public abstract Integer numAristas();

    public abstract Object[] existeArista(Integer i, Integer f) throws VerticeException;

    public abstract Double pesoArista(Integer i, Integer f) throws VerticeException;

    public abstract void insertarArista(Integer i, Integer f) throws VerticeException;

    public abstract void insertarArista(Integer i, Integer f, Double peso) throws VerticeException;

    public abstract ListaEnlazada<Adyacencia> adyacentes(Integer i) throws VerticeException;

    @Override
    public String toString() {
        StringBuilder grafo = new StringBuilder();
        for (int i = 1; i < numVertices(); i++) {
            grafo.append("VERTICE " + i);
            try {
                ListaEnlazada<Adyacencia> lista = adyacentes(i);
                for (int j = 0; j < lista.getSize(); j++) {
                    Adyacencia aux = lista.obtenerDato(j);
                    if (aux.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("---VERTICE DESTINO----- " + aux.getDestino());
                    } else {
                        grafo.append("---VERTICE DESTINO----- " + aux.getDestino() + "--peso-- " + aux.getPeso());

                    }
                }
                grafo.append("\n");
            } catch (Exception e) {
                System.out.println("Error en to String " + e);
            }
        }
        return grafo.toString();
    }

    private Boolean estaConectado() {
        Boolean bad = true;
        for (int i = 1; i <= numVertices(); i++) {

            try {
                ListaEnlazada<Adyacencia> lista = adyacentes(i);
                if (lista.getSize() == 0) {
                    bad = false;
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error en esta Conectado " + e);
                bad = false;
            }
        }
        return bad;
    }

    private Boolean estaPintado(ListaEnlazada<Integer> lista, Integer vertice) {
        Boolean band = false;
        try {
            for (int i = 0; i < lista.getSize(); i++) {
                if (lista.obtenerDato(i).intValue() == vertice.intValue()) {
                    band = true;
                    break;
                }
            }
        } catch (Exception e) {
        }
        return band;
    }

    public ListaEnlazada caminoMinimo(Integer verticeInicial, Integer verticeFinal) throws Exception {

        ListaEnlazada<Integer> camino = new ListaEnlazada<>();
        if (estaConectado()) {
            ListaEnlazada pesos = new ListaEnlazada();
            Boolean finalizar = false;
            Integer inicial = verticeInicial;
            camino.insertarCabecera(inicial);
            while (!finalizar) {
                ListaEnlazada<Adyacencia> adyacencias = adyacentes(inicial);
                Integer T = -1;
                Double peso = 1000000000.0;
                for (int i = 0; i < adyacencias.getSize(); i++) {
                    Adyacencia ad = adyacencias.obtenerDato(i);
                    if (!estaPintado(camino, ad.getDestino())) {
                        Double pesoArista = ad.getPeso();
                        if (verticeFinal.intValue() == ad.getDestino()) {
                            T = ad.getDestino();
                            peso = ad.getPeso();
                            break;
                        } else if (pesoArista < peso) {
                            T = ad.getDestino();
                            peso = pesoArista;
                        }
                    }

                }
                if (T > -1) {
                    pesos.insertarCabecera(peso);
                    camino.insertarCabecera(T);
                    inicial = T;
                } else {
                    throw new GrafoConnectionException("No se encuentra el camino");
                }
                if (verticeFinal.intValue() == inicial.intValue()) {
                    finalizar = true;
                }

            }
        } else {
            throw new GrafoConnectionException("El grafo no esta conectado");
        }
        return camino;
    }

}
