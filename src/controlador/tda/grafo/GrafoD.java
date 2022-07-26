/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.tda.grafo;

import controlador.tda.grafo.exception.VerticeException;
import controlador.tda.lista.ListaEnlazada;

/**
 *
 * @author javisarango
 */
public class GrafoD extends Grafo {

    protected Integer numV;
    protected Integer numA;
    protected ListaEnlazada<Adyacencia> listaAdyacente[];

    public GrafoD(Integer numV) {
        this.numV = numV;
        this.numA = 0;
        listaAdyacente = new ListaEnlazada[numV + 1];
        for (int i = 1; i <= this.numV; i++) {
            listaAdyacente[i] = new ListaEnlazada<>();
        }
    }

    @Override
    public Integer numVertices() {
        return this.numV;
    }

    @Override
    public Integer numAristas() {
        return this.numA;
    }
    /**
     * Permite verificar si existe una conexion entre vertices
     * @param i vertice inicial
     * @param j vertice final
     * @return Un arreglo de Objetos. En la posicion 0 devuelve un boolean, y en la posicion 1 devuelve el peso
     * @throws VerticeException 
     */
    @Override
    public Object[] existeArista(Integer i, Integer j) throws VerticeException {
        
        Object[] resultado =  {Boolean.FALSE, Double.NaN};
        if (i <= numV && j <= numV) {
            ListaEnlazada<Adyacencia> lista = listaAdyacente[i];
            for (int k = 0; k < lista.getSize(); k++) {

                try {
                    Adyacencia aux = lista.obtenerDato(k);
                    if (aux.getDestino().intValue() == j.intValue()) {
                        resultado[0] = Boolean.TRUE;
                        resultado[1] = aux.getPeso();
                        break;

                    }
                } catch (Exception e) {
                }
            }
            return resultado;
        } else {
            throw new VerticeException("Algun vertice ingresado no existe");
        }

    }

    @Override
    public Double pesoArista(Integer i, Integer j) throws VerticeException {
        Double peso = Double.NaN;
        Object[] existe = existeArista(i, j);
        if (((Boolean)existe[0])) {
           peso =  (Double)existe[1];
       
        }
        return peso;
    }

    @Override
    public void insertarArista(Integer i, Integer j) throws VerticeException {
        insertarArista(i, j, Double.NaN);
        
    }

    @Override
    public void insertarArista(Integer i, Integer j, Double peso) throws VerticeException {
       if (i > 0 && j > 0 && i <= numV && j <= numV) {
            Object[] existe = existeArista(i, j);
            if (!((Boolean)existe[0])) {
                numA++;
                listaAdyacente[i].insertarCabecera(new Adyacencia(j, peso));
            }
       }else{
           throw new VerticeException("Algun vertice ingresado no existe");
       }
    }

    @Override
    public ListaEnlazada<Adyacencia> adyacentes(Integer i) throws VerticeException {
        return listaAdyacente[i];
    }
    public ListaEnlazada<Integer> BPA(Integer inicio) throws Exception{
        ListaEnlazada<Integer> camino = new ListaEnlazada<>();
        ListaEnlazada<Integer> visitados = new ListaEnlazada<>();
        ListaEnlazada<Integer> pendientes = new ListaEnlazada<>();
        pendientes.insertarCabecera(inicio);
        while(!pendientes.estaVacia()){
            Integer actual = pendientes.eliminarDato(0);
            visitados.insertarCabecera(actual);
            camino.insertarCabecera(actual);
            ListaEnlazada<Adyacencia> lista = listaAdyacente[actual];
            for (int i = 0; i < lista.getSize(); i++) {
                Adyacencia aux = lista.obtenerDato(i);
                if (!visitados.existe(aux.getDestino())){
                    if (!pendientes.existe(aux.getDestino())){
                        pendientes.insertarCabecera(aux.getDestino());
                    }
                }
            }
        }
        return camino;
    }

    public ListaEnlazada<Integer> BPP(Integer inicio) throws Exception{
        ListaEnlazada<Integer> camino = new ListaEnlazada<>();
        ListaEnlazada<Integer> visitados = new ListaEnlazada<>();
        ListaEnlazada<Integer> pendientes = new ListaEnlazada<>();
        pendientes.insertarCabecera(inicio);
        while(!pendientes.estaVacia()){
            Integer actual = pendientes.eliminarDato(0);
            visitados.insertarCabecera(actual);
            camino.insertarCabecera(actual);
            ListaEnlazada<Adyacencia> lista = listaAdyacente[actual];
            for(int i = 0; i < lista.getSize(); i++){
                Adyacencia aux = lista.obtenerDato(i);
                if(!visitados.existe(aux.getDestino())){
                    if(!pendientes.existe(aux.getDestino())){
                        pendientes.insertarCabecera(aux.getDestino());
                    }
                }
            }
        }
        return camino;
    }

}
