/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.tda.grafo.exception;

/**
 *
 * @author javisarango
 */
public class VerticeException extends Exception {

    /**
     * Creates a new instance of <code>VerticeException</code> without detail
     * message.
     */
    public VerticeException() {
    }

    /**
     * Constructs an instance of <code>VerticeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VerticeException(String msg) {
        super(msg);
    }
}
