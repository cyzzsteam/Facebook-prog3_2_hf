/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerles;

/**
 *
 * @author varga
 */
public class FacebookForm extends javax.swing.JFrame {
    private final int MAGASSAG=490;
    private final int SZELESSEG=750;
    
    /**
     * Creates new form FacebookForm
     */
    public FacebookForm() {
        initComponents();
        setSize(SZELESSEG, MAGASSAG);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fejlecPanel2 = new feluletek.FejlecPanel();
        felhasznalokPanel2 = new feluletek.FelhasznalokPanel();
        kozossegiPanel1 = new feluletek.KozossegiPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(fejlecPanel2, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(felhasznalokPanel2, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout kozossegiPanel1Layout = new javax.swing.GroupLayout(kozossegiPanel1);
        kozossegiPanel1.setLayout(kozossegiPanel1Layout);
        kozossegiPanel1Layout.setHorizontalGroup(
            kozossegiPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        kozossegiPanel1Layout.setVerticalGroup(
            kozossegiPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );

        getContentPane().add(kozossegiPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FacebookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacebookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacebookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacebookForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacebookForm().inditas();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private feluletek.FejlecPanel fejlecPanel2;
    private feluletek.FelhasznalokPanel felhasznalokPanel2;
    private feluletek.KozossegiPanel kozossegiPanel1;
    // End of variables declaration//GEN-END:variables

    private void inditas() {
        this.setVisible(true);
        new Vezerlo(kozossegiPanel1, felhasznalokPanel2, fejlecPanel2).start();
    }
}
