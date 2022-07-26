/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.tda.grafo;

import controlador.tda.grafo.exception.VerticeException;
import controlador.tda.lista.ListaEnlazada;
import java.util.HashMap;

/**
 *
 * @author javisarango
 */
public class GrafoED<E> extends GrafoD {

    protected Class<E> clazz;
    protected E etiquetas[];
    protected HashMap<E, Integer> dirVertices;

    public GrafoED(Integer numV, Class clazz) {
        super(numV);
        this.clazz = clazz;
        etiquetas = (E[]) java.lang.reflect.Array.newInstance(this.clazz, numV + 1);
        dirVertices = new HashMap<>(numV);

    }

    public Boolean modificar(E anterior, E nuevo) throws Exception {
        Integer pos = obtenerCodigo(anterior);
        etiquetas[pos] = nuevo;
        dirVertices.remove(anterior);
        dirVertices.put(nuevo, pos);
        return true;
    }

    public Object[] existeArista(E i, E j) throws Exception {
        return this.existeArista(obtenerCodigo(i), obtenerCodigo(j));
    }

    public void insertarArista(E i, E j, Double peso) throws Exception {
        this.insertarArista(obtenerCodigo(i), obtenerCodigo(j), Double.NaN);

    }

    public Integer obtenerCodigo(E etiqueta) throws Exception {
        Integer key = dirVertices.get(etiqueta);
        if (key != null) {
            return key;
        } else {
            throw new VerticeException("No se encuentra la etiqueta Correspondiente");
        }

    }

    public E obtenerEtiqueta(Integer codigo) throws Exception {
        return etiquetas[codigo];

    }

    public ListaEnlazada<Adyacencia> adyacentesDEE(E i) throws Exception {
        return adyacentes(obtenerCodigo(i));

    }

    public void etiquetarVertice(Integer codigo, E etiqueta) {
        etiquetas[codigo] = etiqueta;
        dirVertices.put(etiqueta, codigo);

    }

    @Override
    public String toString() {
        StringBuilder grafo = new StringBuilder();
        try {
            for (int i = 1; i < numVertices(); i++) {
                grafo.append("VERTICE " + i + "- E - " + obtenerEtiqueta(i).toString());
                try {
                    ListaEnlazada<Adyacencia> lista = adyacentes(i);
                    for (int j = 0; j < lista.getSize(); j++) {
                        Adyacencia aux = lista.obtenerDato(j);
                        if (aux.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                            grafo.append("---VERTICE DESTINO----- " + aux.getDestino() + "-E- " + obtenerEtiqueta(i).toString());
                        } else {
                            grafo.append("---VERTICE DESTINO----- " + aux.getDestino() + "-E- " + obtenerEtiqueta(i).toString() + "--peso-- " + aux.getPeso());

                        }
                    }
                    grafo.append("\n");
                } catch (Exception e) {
                    System.out.println("Error en to String " + e);
                }
            }
        } catch (Exception e) {
        }
        return grafo.toString();
    }
    
    public ListaEnlazada<E> busquedaAnchura (E etiqueta) throws Exception {
        ListaEnlazada<Integer> aux = BPA(obtenerCodigo(etiqueta));
        ListaEnlazada<E> lista = new ListaEnlazada<>();
        //Me guarda los vertices que se encuentran en la ruta
        for(int i = 0; i < aux.getSize(); i++) {
            lista.insertar(obtenerEtiqueta(aux.obtenerDato(i)),0);
        }
        return lista;
    }
    
    public ListaEnlazada<E> BusquedaPorProfundidad (E etiqueta) throws Exception {
        ListaEnlazada<Integer> aux = BPP(obtenerCodigo(etiqueta));
        ListaEnlazada<E> lista = new ListaEnlazada<>();
        //Me guarda los vertices que se encuentran en la ruta
        for(int i = 0; i < aux.getSize(); i++) {
            lista.insertar(obtenerEtiqueta(aux.obtenerDato(i)),0);
        }
        return lista;
    }

}
