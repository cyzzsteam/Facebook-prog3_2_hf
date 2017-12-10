/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feluletek;

import alaposztalyok.Felhasznalo;
import java.util.List;
import javax.swing.DefaultListModel;
import vezerles.Vezerlo;

/**
 *
 * @author varga
 */
public class FelhasznalokPanel extends javax.swing.JPanel {
    private final int SZELESSEG=150;
    private final int MAGASSAG=450;
    private Vezerlo vezerlo;

    public void setVezerlo(Vezerlo vezerlo) {
        this.vezerlo = vezerlo;
    }
    
    
    /**
     * Creates new form FelhasznalokPanel
     */
    public FelhasznalokPanel() {
        initComponents();
        setSize(SZELESSEG, MAGASSAG);
        LstFelhasznalok.setModel(felhasznaloModell);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKijelzo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LstFelhasznalok = new javax.swing.JList<>();
        btnKoruzenet = new javax.swing.JButton();
        btnSzemelyesUzenet = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(150, 450));
        setMinimumSize(new java.awt.Dimension(150, 450));
        setPreferredSize(new java.awt.Dimension(150, 450));

        lblKijelzo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblKijelzo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKijelzo.setText("Regisztráltak");

        LstFelhasznalok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LstFelhasznalokMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(LstFelhasznalok);

        btnKoruzenet.setText("körüzenet");
        btnKoruzenet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoruzenetActionPerformed(evt);
            }
        });

        btnSzemelyesUzenet.setText("személyes");
        btnSzemelyesUzenet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSzemelyesUzenetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSzemelyesUzenet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblKijelzo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(btnKoruzenet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKijelzo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKoruzenet)
                .addGap(11, 11, 11)
                .addComponent(btnSzemelyesUzenet)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LstFelhasznalokMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LstFelhasznalokMousePressed
        Felhasznalo temp=LstFelhasznalok.getSelectedValue();
        if(temp!=null){
        vezerlo.kivallasztottba(temp);
        }
    }//GEN-LAST:event_LstFelhasznalokMousePressed

    private void btnKoruzenetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoruzenetActionPerformed
        vezerlo.koruzenet();
    }//GEN-LAST:event_btnKoruzenetActionPerformed

    private void btnSzemelyesUzenetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSzemelyesUzenetActionPerformed
        vezerlo.szemelyesUzenet(LstFelhasznalok.getSelectedValue());
    }//GEN-LAST:event_btnSzemelyesUzenetActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Felhasznalo> LstFelhasznalok;
    private javax.swing.JButton btnKoruzenet;
    private javax.swing.JButton btnSzemelyesUzenet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKijelzo;
    // End of variables declaration//GEN-END:variables

    DefaultListModel<Felhasznalo> felhasznaloModell=new DefaultListModel<>();
    
    public void kiir(List<Felhasznalo> felhasznalok) {
        for (Felhasznalo felhasznalo : felhasznalok) {
            felhasznaloModell.addElement(felhasznalo);
        }
    }

    public void ismerosListabaIr(List<Felhasznalo> merosLista) {
        felhasznaloModell.clear();
        for (Felhasznalo felhasznalo : merosLista) {
            felhasznaloModell.addElement(felhasznalo);
        }
        
        lblKijelzo.setText("Ismerosok");
    }
    
}
