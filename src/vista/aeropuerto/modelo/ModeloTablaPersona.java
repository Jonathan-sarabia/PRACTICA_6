/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.aeropuerto.modelo;

import controlador.tda.grafo.GrafoEND;
import javax.swing.table.AbstractTableModel;
import modelo.Aeropuerto;
import modelo.Avion;

/**
 *
 * @author sebastian
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private GrafoEND<Avion> grafo;

    public GrafoEND<Avion> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoEND<Avion> grafo) {
        this.grafo = grafo;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return grafo.numVertices();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Precio";
            case 3:
                return "Ubicacion";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        try {
            Avion p = grafo.obtenerEtiqueta(arg0 + 1);
            switch (arg1) {
                case 0:
                    return (arg0+1);
                case 1:
                    return p.getNombre();
                case 2:
                    return p.getPrecio().toString();
                case 3:
                    return (p.getDestinoAeropuerto() == null) ? "NO TIENE" : p.getDestinoAeropuerto().toString();
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Error en listado");
            return null;
        }
    }

}
