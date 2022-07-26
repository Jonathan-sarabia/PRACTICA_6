/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.tda.grafo.exception;

/**
 *
 * @author javisarango
 */
public class GrafoConnectionException extends Exception{

    /**
     * Creates a new instance of <code>GrafoConnectionException</code> without
     * detail message.
     */
    public GrafoConnectionException() {
    }

    /**
     * Constructs an instance of <code>GrafoConnectionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GrafoConnectionException(String msg) {
        super(msg);
    }
}
