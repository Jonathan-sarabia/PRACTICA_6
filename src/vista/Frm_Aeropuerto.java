/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.personaNataly.AeropuertoController;
import controlador.tda.grafo.GrafoEND;
import controlador.tda.lista.ListaEnlazada;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Avion;
import vista.aeropuerto.modelo.ModeloTablaPersona;

/**
 *
 * @author Javier Sarabia
 */
public class Frm_Aeropuerto extends javax.swing.JDialog {

    private AeropuertoController ac;
    private ModeloTablaPersona mtp = new ModeloTablaPersona();

    /**
     * Creates new form Frm_Aerk
     */
    public Frm_Aeropuerto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void crear() throws Exception {
        if (ac == null) {
            ac = new AeropuertoController();
        } else {
            GrafoEND <Avion> nuw = ac.incremento(ac.getGend());
            ac.setGend(nuw);
        }
        cargarTabla();
    }

    private void Limpiar() {
        txtlat.setText("");
        txtlong.setText("");
        txtnombre.setText("");
        ac.setAvion(null);
        btnModificar.setEnabled(false);
        cargarTabla();

    }

    private void cargarcbxVertices() {
        cbxdestino.removeAllItems();
        cbxorigen.removeAllItems();
        cbxnodoinicial.removeAllItems();
        try {
            for (int i = 1; i <= ac.getGend().numVertices(); i++) {
                cbxorigen.addItem(ac.getGend().obtenerEtiqueta(i).toString());
                cbxdestino.addItem(ac.getGend().obtenerEtiqueta(i).toString());
                cbxnodoinicial.addItem(ac.getGend().obtenerEtiqueta(i).toString());
                      
            }
        } catch (Exception e) {

        }

    }

    private void modificar() throws Exception {
        if (txtnombre.getText().trim().length() == 0
                || txtlong.getText().trim().length() == 0
                || txtlat.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Advertencia", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                Integer pos = ac.getGend().obtenerCodigo(ac.getAvion());
                ac.getAvion().setNombre(txtnombre.getText());
                ac.getAvion().getDestinoAeropuerto().setLatitud(Double.parseDouble(txtlat.getText()));
                ac.getAvion().getDestinoAeropuerto().setLongitud(Double.parseDouble(txtlong.getText()));
                ac.getAvion().setPrecio(Double.parseDouble(txtprecio.getText()));
                if (ac.getGend().modificar(ac.getGend().obtenerEtiqueta(pos), ac.getAvion())) {
                    cargarcbxVertices();
                    Limpiar();
                    JOptionPane.showMessageDialog(null, "Datos Modificados", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo Modificar", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void adyacencia() {
        Integer origen = (cbxorigen.getSelectedIndex() + 1);
        Integer destino = (cbxdestino.getSelectedIndex() + 1);
        if (origen == destino) {
            JOptionPane.showMessageDialog(null, "Escoja clientes diferentes", "Advertencia", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Double distancia = ac.calcularDistancia(ac.getGend().obtenerEtiqueta(origen), ac.getGend().obtenerEtiqueta(destino));
                ac.getGend().insertarArista(ac.getGend().obtenerEtiqueta(origen), ac.getGend().obtenerEtiqueta(destino), distancia);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Advertencia", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private void cargarTabla() {
        mtp.setGrafo(ac.getGend());
        mtp.fireTableStructureChanged();
        mtp.fireTableDataChanged();
        tbl_tabla.setModel(mtp);
        tbl_tabla.updateUI();
        System.out.println(ac.getGend().toString());
    }
    
     

    private void cargarVista() {
        Integer fila = -1;
        fila = tbl_tabla.getSelectedRow();
        try {

            if (fila >= 0) {

                ac.setAvion(ac.getGend().obtenerEtiqueta(fila + 1));
                txtlat.setText(String.valueOf(ac.getAvion().getDestinoAeropuerto().getLatitud()));
                txtlong.setText(String.valueOf(ac.getAvion().getDestinoAeropuerto().getLongitud()));
                txtprecio.setText(String.valueOf(ac.getAvion().getPrecio()));
                txtnombre.setText(ac.getAvion().getNombre());
                btnModificar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Elija una fila", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtlong = new javax.swing.JTextField();
        txtlat = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbxorigen = new javax.swing.JComboBox<>();
        btnVincular = new javax.swing.JButton();
        cbxdestino = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_bpa = new javax.swing.JButton();
        btnrpp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxnodoinicial = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel3.add(btnCrear);
        btnCrear.setBounds(10, 20, 190, 22);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 10, 0, 0);

        jLabel2.setText("Agencia");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 70, 150, 16);

        jLabel3.setText("Longitud");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 110, 110, 16);

        jLabel4.setText("Latitud");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 150, 110, 16);
        jPanel3.add(txtnombre);
        txtnombre.setBounds(70, 70, 130, 22);
        jPanel3.add(txtlong);
        txtlong.setBounds(70, 110, 130, 22);
        jPanel3.add(txtlat);
        txtlat.setBounds(70, 150, 130, 22);

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar);
        btnModificar.setBounds(90, 230, 110, 22);

        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(220, 20, 530, 230);

        jLabel5.setText("Precio");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 190, 50, 16);
        jPanel3.add(txtprecio);
        txtprecio.setBounds(70, 190, 130, 22);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 10, 760, 310);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel6.setText("Origen");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(20, 10, 90, 16);

        cbxorigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbxorigen);
        cbxorigen.setBounds(70, 10, 130, 22);

        btnVincular.setText("VINCULAR");
        btnVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularActionPerformed(evt);
            }
        });
        jPanel4.add(btnVincular);
        btnVincular.setBounds(510, 10, 110, 30);

        cbxdestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxdestinoActionPerformed(evt);
            }
        });
        jPanel4.add(cbxdestino);
        cbxdestino.setBounds(350, 10, 130, 22);

        jLabel7.setText("Destino");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(230, 10, 90, 16);

        jButton1.setText("DJKESTRA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(640, 10, 100, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 330, 760, 50);

        btn_bpa.setText("Recorrido Por Anchura");
        btn_bpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bpaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_bpa);
        btn_bpa.setBounds(310, 390, 210, 22);

        btnrpp.setText("Recorrido Por Profundidad");
        btnrpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrppActionPerformed(evt);
            }
        });
        getContentPane().add(btnrpp);
        btnrpp.setBounds(550, 390, 210, 22);

        jLabel8.setText("Numero del nodo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 390, 110, 16);

        cbxnodoinicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbxnodoinicial);
        cbxnodoinicial.setBounds(160, 390, 120, 22);

        setBounds(0, 0, 794, 443);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            // TODO add your handling code here:
            crear();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        try {
            modificar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tbl_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            //Datos a mostrar en pantalla Modificar
            cargarVista();

        }


    }//GEN-LAST:event_tbl_tablaMouseClicked

    private void btnVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularActionPerformed
        // TODO add your handling code here:
        try {
            adyacencia();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnVincularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_bpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bpaActionPerformed
          ListaEnlazada<Avion> camino = new ListaEnlazada<>();
        int inicio = cbxnodoinicial.getSelectedIndex()+1;
        //realizar la busqueda por anchura
        try {
            camino = ac.getGend().busquedaAnchura(ac.getGend().obtenerEtiqueta(inicio));
            String cadena = "";
            for (int i = 0; i < camino.getSize(); i++) {
                cadena += camino.obtenerDato(i).getNombre() + (i == camino.getSize()-1 ? "" : " --> ");
            }
            JOptionPane.showMessageDialog(null, cadena);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la busqueda");
        }
    }//GEN-LAST:event_btn_bpaActionPerformed

    private void btnrppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrppActionPerformed
        ListaEnlazada<Avion> camino = new ListaEnlazada<>();
        int inicio = cbxnodoinicial.getSelectedIndex()+1;
        try {
            camino = ac.getGend().BusquedaPorProfundidad(ac.getGend().obtenerEtiqueta(inicio));
            String cadena = " ";
            for (int i = 0; i < camino.getSize(); i++) {
                cadena += camino.obtenerDato(i).getNombre() + (i == camino.getSize()-1 ? "" : " --> ");
            }
            JOptionPane.showMessageDialog(null, cadena );
        }catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnrppActionPerformed

    private void cbxdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxdestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxdestinoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Aeropuerto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Aeropuerto dialog = new Frm_Aeropuerto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVincular;
    private javax.swing.JButton btn_bpa;
    private javax.swing.JButton btnrpp;
    private javax.swing.JComboBox<String> cbxdestino;
    private javax.swing.JComboBox<String> cbxnodoinicial;
    private javax.swing.JComboBox<String> cbxorigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txtlat;
    private javax.swing.JTextField txtlong;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
