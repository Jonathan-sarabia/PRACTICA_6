package controlador.tda.grafo;

import controlador.tda.grafo.exception.VerticeException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sebastian
 */
public class GrafoEND<E> extends GrafoED<E> {

    public GrafoEND(Integer numVertice, Class clazz) {
        super(numVertice, clazz);
    }

    @Override
    public void insertarArista(Integer i, Integer j, Double peso) throws VerticeException {
        if (i > 0 && j > 0 && i <= numV && j <= numV) {
            Object[] existe = existeArista(i, j);
            if (!((Boolean) existe[0])) {
                numA++;
                listaAdyacente[i].insertarCabecera(new Adyacencia(j, peso));
                listaAdyacente[j].insertarCabecera(new Adyacencia(i, peso));
            }
        } else {
            throw new VerticeException("Algun vertice ingresado no existe");
        }
    }

    @Override
    public void insertarArista(E i, E j, Double peso) throws Exception {
        insertarArista(obtenerCodigo(i), obtenerCodigo(j), peso);
        insertarArista(obtenerCodigo(j), obtenerCodigo(i), peso);
    }

}
