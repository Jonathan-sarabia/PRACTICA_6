/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Javier Sarabia
 */
public class Avion {
    private Aeropuerto Aeropuerto;
    private Double precio;
    private String nombre;

    public Aeropuerto getDestinoAeropuerto() {
        return Aeropuerto;
    }

    public void setDestinoAeropuerto(Aeropuerto destinoAeropuerto) {
        this.Aeropuerto = destinoAeropuerto;
    }


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
       return nombre +" "+ precio;
    }
    
    
    
    
    
    
}
