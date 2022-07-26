/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.personaNataly;

import controlador.tda.grafo.GrafoEND;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Avion;
import modelo.Aeropuerto;

/**
 *
 * @author sebastian
 */
public class AeropuertoController {

    private GrafoEND<Avion> gend;
    private Avion avion = new Avion();
    private GrafoEND<Avion> nuw;

    public GrafoEND<Avion> getGend() {
        return gend;
    }

    public void setGend(GrafoEND<Avion> gend) {
        this.gend = gend;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public AeropuertoController() {
        gend = new GrafoEND<>(1, Avion.class);
        for (int i = 1; i <= 1; i++) {
            Avion p = new Avion();
            p.setPrecio(0.0);
            p.setNombre("sin nombre");
            Aeropuerto u = new Aeropuerto();
            u.setId(i);
            u.setLatitud(0.0);
            u.setLongitud(0.0);
            p.setDestinoAeropuerto(u);
            gend.etiquetarVertice(i, p);
        }
    }

    public GrafoEND<Avion> incremento(GrafoEND viejo) throws Exception {

        nuw = new GrafoEND<>(gend.numVertices() + 1, Avion.class);
        for (int i = 1; i <= gend.numVertices() + 1; i++) {

          

                Avion p = new Avion();
                p.setPrecio(0.0);
                p.setNombre("sin nombre");
                Aeropuerto u = new Aeropuerto();
                u.setId(i);
                u.setLatitud(0.0);
                u.setLongitud(0.0);
                p.setDestinoAeropuerto(u);
                nuw.etiquetarVertice(i, p);

          
//                System.out.println(nuevo.toString());
//                
//                }else {
//                Avion p = new Avion();
//                p.setPrecio(nuevo.getPrecio());
//                p.setNombre(nuevo.getNombre());
//                Aeropuerto u = new Aeropuerto();
//                u.setId(viejo.numVertices() + 1);
//                u.setLatitud(nuevo.getDestinoAeropuerto().getLatitud());
//                u.setLongitud(nuevo.getDestinoAeropuerto().getLongitud());
//                p.setDestinoAeropuerto(u);
//                    nuw.etiquetarVertice(i, p);
//            } catch (Exception e) {
//                e.printStackTrace();
            
        }
        return nuw;

    }

    public Double calcularDistancia(Avion po, Avion pd) {
        Double dis = 0.0;
        //DIstancia = raiz cuadrada de x1 - x2 al cuadrado, más y1 - y2 al cuagrado.
        Double y = po.getDestinoAeropuerto().getLongitud() - pd.getDestinoAeropuerto().getLongitud();
        Double x = po.getDestinoAeropuerto().getLatitud() - pd.getDestinoAeropuerto().getLatitud();
        dis = Math.sqrt((x * x) + (y * y));

        return dis;
    }

}
