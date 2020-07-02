/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import Prioridad.Cola;

/**
 *
 * @author juan
 */
public class VentanaProceso extends javax.swing.JFrame {

    private int numero;
    private int llegada;
    private int rafaga;
    private int prioridad;

    private JTable jTableProcesos;
    private JLabel lblInicio;
    private JTextArea txaConsola;
   

    Cola cola;

    /**
     * Creates new form VentanaProceso
     */
    VentanaProceso(JTable jTableProcesos, JLabel lblInicio, JTextArea area) {
        this.jTableProcesos = jTableProcesos;
        this.lblInicio = lblInicio;
        this.txaConsola = area;
        
        initComponents();
        this.setLocationRelativeTo(null);
        cola = new Cola(area);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNumeroProceso = new javax.swing.JLabel();
        lblRafaga = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNumero = new javax.swing.JTextField();
        txtRafaga = new javax.swing.JTextField();
        lblPrioridad = new javax.swing.JLabel();
        txtPrioridad = new javax.swing.JTextField();

        setTitle("Datos del proceso");
        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Centaur", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Proceso");
        jLabel1.setToolTipText("");

        lblNumeroProceso.setFont(new java.awt.Font("Centaur", 1, 14)); // NOI18N
        lblNumeroProceso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumeroProceso.setText("Número de proceso:");

        lblRafaga.setFont(new java.awt.Font("Centaur", 1, 14)); // NOI18N
        lblRafaga.setText("Tiempo de ráfaga:");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPrioridad.setFont(new java.awt.Font("Centaur", 1, 14)); // NOI18N
        lblPrioridad.setText("Prioridad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(116, 116, 116))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPrioridad)
                        .addGap(96, 96, 96)
                        .addComponent(txtPrioridad))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRafaga)
                            .addComponent(lblNumeroProceso))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRafaga)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRafaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRafaga, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        numero = Integer.parseInt(txtNumero.getText());
        llegada = Integer.parseInt(lblInicio.getText());
        rafaga = Integer.parseInt(txtRafaga.getText());
        prioridad = Integer.parseInt(txtPrioridad.getText());

        cola.insertar(numero, llegada, rafaga, prioridad);
        cola.imprimir(jTableProcesos);
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNumeroProceso;
    private javax.swing.JLabel lblPrioridad;
    private javax.swing.JLabel lblRafaga;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrioridad;
    private javax.swing.JTextField txtRafaga;
    // End of variables declaration//GEN-END:variables

    public int getNumero() {
        return numero;
    }

    public int getLlegada() {
        return llegada;
    }

    public int getRafaga() {
        return rafaga;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

}
