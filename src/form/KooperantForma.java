/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.Kooperant;
import model.ModelTabelaKultura;
import model.ModelTabeleKooperant;
import model.Operacije;
import model.PoljoprivrednaKultura;
import model.PoljoprivrednoGazdinstvo;
import model.PoljoprivrednoPreduzece;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;
import niti.KooperantNit;

/**
 *
 * @author Miloš
 */
public class KooperantForma extends javax.swing.JFrame {
    List<Kooperant>kooperanti;
    List<Kooperant>pom;
    int jezik=0;

    public List<Kooperant> getKooperanti() {
        return kooperanti;
    }

    public int getJezik() {
        return jezik;
    }

    public void setJezik(int jezik) {
        this.jezik = jezik;
    }

    public void setKooperanti(List<Kooperant> kooperanti) {
        this.kooperanti = kooperanti;
        this.pom=kooperanti;
    }
    
    /**
     * Creates new form KooperantForma
     */
    public KooperantForma() {
        initComponents();
        zakljucajPolja();
         ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (source == jCheckBox1) {
                        jCheckBox2.setSelected(false);
                        jTextField5.setEnabled(true);
                        jTextField6.setEnabled(true);
                        jTextField7.setEnabled(true);

                    } else if (source == jCheckBox2) {
                        jCheckBox1.setSelected(false);
                        jTextField3.setEnabled(true);
                        jTextField4.setEnabled(true);
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    
                    if (source == jCheckBox1) {
                        
                        jTextField5.setEnabled(false);
                        jTextField6.setEnabled(false);
                        jTextField7.setEnabled(false);

                    } else if (source == jCheckBox2) {
                        
                        jTextField3.setEnabled(false);
                        jTextField4.setEnabled(false);
                    }
                }
            }
        };

        jCheckBox1.addItemListener(listener);
        jCheckBox2.addItemListener(listener);
        KooperantNit kn=new KooperantNit(jTable1, this);
        kn.start();
        ListSelectionModel selectionModel = jTable1.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int izabrani = jTable1.getSelectedRow();
                    if (izabrani != -1) {
                       Kooperant rk=pom.get(izabrani);
                       jTextField1.setText(rk.getNazivKooperanta());
                       jTextField2.setText(rk.getMesto());
                       if(rk instanceof PoljoprivrednoPreduzece){
                           jCheckBox1.setSelected(true);
                           jTextField5.setText(((PoljoprivrednoPreduzece) rk).getPravniZastupnik());
                           jTextField6.setText(((PoljoprivrednoPreduzece) rk).getPib());
                           jTextField7.setText(((PoljoprivrednoPreduzece) rk).getEmail());
                           jTextField3.setText("");
                           jTextField4.setText("");
                       }
                       else if(rk instanceof PoljoprivrednoGazdinstvo){
                           jCheckBox2.setSelected(true);
                           jTextField5.setText("");
                           jTextField6.setText("");
                           jTextField7.setText("");
                           jTextField3.setText(((PoljoprivrednoGazdinstvo) rk).getVlasnikGaz());
                           jTextField4.setText(((PoljoprivrednoGazdinstvo) rk).getBrojTelefona());
                       }
                    
                    }
                
                
                }
            }
        });
        } catch (Exception e) {
        }
         jComboBox1.removeAllItems();
        jComboBox1.addItem("SRB");
        jComboBox1.addItem("ENG");
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) jComboBox1.getSelectedItem();

                    if ("SRB".equals(selectedItem)) {
                    jLabel3.setText("Vlasnik");
                    jLabel1.setText("Naziv");
                    jLabel2.setText("Mesto");
                    jLabel4.setText("Broj telefona");
                    jLabel5.setText("Zastupnik");
                    jLabel6.setText("PIB");
                    jLabel7.setText("Email");
                    jLabel8.setText("Jezik :");
                    jButton1.setText("Dodaj kooperanta");
                    jButton3.setText("Pretrazi kooperanta");
                    jButton4.setText("Izmeni kooperanta");
                    jButton5.setText("Obrisi kooperanta");
                    jCheckBox1.setText("Preduzece");
                    jCheckBox2.setText("Gazdinstvo");

                    jButton6.setText("Nazad");
                    //jButton1.setText("Uloguj se");
                    jezik=0;
                } else if ("ENG".equals(selectedItem)) {
                    jLabel3.setText("Owner");
                    jLabel1.setText("Name");
                    jLabel2.setText("Hometown");
                    jLabel4.setText("Phone");
                    jLabel5.setText("Agent");
                    jLabel6.setText("PIB");
                    jLabel7.setText("Email");
                    jLabel8.setText("Language :");
                    jButton1.setText("Insert cooperant");
                    jButton3.setText("Search cooperant");
                    jButton4.setText("Update cooperant");
                    jButton5.setText("Delete cooperant");
                    jButton6.setText("Back");
                    jCheckBox1.setText("Company");
                    jCheckBox2.setText("Holding");
                    jezik=1;
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jCheckBox1.setText("Preduzece");

        jCheckBox2.setText("Gazdinstvo");

        jLabel1.setText("Naziv");

        jLabel2.setText("Mesto");

        jLabel3.setText("Vlasnik");

        jLabel4.setText("Broj telefona");

        jLabel5.setText("Zastupnik");

        jLabel6.setText("PIB");

        jLabel7.setText("Email");

        jButton1.setText("Dodaj kooperanta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Pretrazi kooperanta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Izmeni kooperanta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Obrisi kooperanta");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Nazad");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Jezik :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5)
                                        .addComponent(jTextField6)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField3)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(55, 55, 55)
                                .addComponent(jButton3)
                                .addGap(56, 56, 56)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox1)
                                .addComponent(jCheckBox2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(319, 319, 319)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int izabrani=jTable1.getSelectedRow();
        if(izabrani==-1){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate izabrati kooperanta", "Greska", JOptionPane.WARNING_MESSAGE);
            else JOptionPane.showMessageDialog(this, "You have to choose cooperant", "Error", JOptionPane.WARNING_MESSAGE);

            return;
        }
        Kooperant rk=pom.get(izabrani);
        boolean uspeh=obrisiKooperant(rk);
        if(uspeh){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Kooperant je uspesno obrisan","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(this, "Cooperant has been deleted successfully","Confirmation",JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije uspesno izvrsio brisanje","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(this, "System could not delete the cooperant","Error",JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Kooperant k=new Kooperant();
        kreirajKooperanta(k);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int izabrani=jTable1.getSelectedRow();
        if(izabrani==-1){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate izabrati kooperanta", "Greska", JOptionPane.WARNING_MESSAGE);
            else JOptionPane.showMessageDialog(this, "You have to choose the cooperant", "Error", JOptionPane.WARNING_MESSAGE);

            return;
        }
        if(jCheckBox1.isSelected()){
        String email=jTextField7.getText();
        if(!email.matches("[^.]+@[^.]+.com")){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Email nije u ispravnom formatu");
            else{
                JOptionPane.showMessageDialog(this, "Email format is incorrect");
   
            }
            return;
        }
        }
        
        Kooperant rk=pom.get(izabrani);
        boolean uspeh=izmeniKooperant(rk);
        if(uspeh){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Kooperant je uspesno izmenjen","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(this, "Cooperant has been updated successfully","Confirmation",JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije uspesno izvrsio izmenu","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(this, "System has updated the cooperant","Confirmation",JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String naziv=jTextField1.getText();
        String mesto=jTextField2.getText();
        String zastupnik=jTextField3.getText();
        String pib=jTextField4.getText();
        String email=jTextField7.getText();
        String vlasnik=jTextField6.getText();
        String brtel=jTextField7.getText();
        List<Object>params=new ArrayList<>();
        params.add(naziv);
        params.add(mesto);
        params.add(zastupnik);
        params.add(pib);
        params.add(email);
        params.add(vlasnik);
        params.add(brtel);

        vratiListuKooperant(params, pom);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(KooperantForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KooperantForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KooperantForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KooperantForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KooperantForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

    private void zakljucajPolja() {
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        

    }

    private boolean obrisiKooperant(Kooperant rk) {
        KlijentskiZahtev kz;
        if(rk instanceof PoljoprivrednoPreduzece){
         kz=new KlijentskiZahtev(Operacije.OBRISIPRED, rk);
        }
        else{
         kz=new KlijentskiZahtev(Operacije.OBRISIGAZ, rk);

        }
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        boolean uspeh=(boolean) so.getOdgovor();
        return uspeh;
    }

    private void kreirajKooperanta(Kooperant k) {
        if(jCheckBox1.isSelected()){
            PoljoprivrednoPreduzece pp=new PoljoprivrednoPreduzece(jTextField5.getText(), jTextField6.getText(), jTextField7.getText(), PROPERTIES, jTextField1.getText(), jTextField2.getText());
            boolean ispravan=proveriKooperanta(pp);
        if(ispravan){
            KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.DODAJPRED, pp);
            komunikacija.Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
            boolean uspeh=(boolean) so.getOdgovor();
            if(uspeh){
                if(jezik==0)
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio kooperanta");
                else JOptionPane.showMessageDialog(this, "System has saved the cooperant");

            }
            else{
                if(jezik==0)
                JOptionPane.showMessageDialog(this, "Sistem nije zapamtio kooperanta","Greska",JOptionPane.ERROR_MESSAGE);
                else  JOptionPane.showMessageDialog(this, "System could not save the cooperant","Error",JOptionPane.ERROR_MESSAGE);

            
            }
            return;
        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Uneli ste nedozvoljenu vrednost polja","Greska",JOptionPane.ERROR_MESSAGE);
            else           JOptionPane.showMessageDialog(this, "You entered disallowed field value","Error",JOptionPane.ERROR_MESSAGE);

        }
        }
        else if(jCheckBox2.isSelected()){
            PoljoprivrednoGazdinstvo pp=new PoljoprivrednoGazdinstvo(jTextField3.getText(), jTextField4.getText(), PROPERTIES, jTextField1.getText(), jTextField2.getText());
            boolean ispravan=proveriKooperanta(pp);
        if(ispravan){
            KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.DODAJGAZ, pp);
            komunikacija.Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
            boolean uspeh=(boolean) so.getOdgovor();
            if(uspeh){
                if(jezik==0)
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio kooperanta");
                else JOptionPane.showMessageDialog(this, "System has saved the cooperant");

            }
            else{
                if (jezik==0)
                JOptionPane.showMessageDialog(this, "Sistem nije zapamtio kooperanta","Greska",JOptionPane.ERROR_MESSAGE);
                else JOptionPane.showMessageDialog(this, "System could not save the cooperant","Error",JOptionPane.ERROR_MESSAGE);

            }
            return;
        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Uneli ste nedozvoljenu vrednost polja","Greska",JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(this, "You entered disallowed field value","Error",JOptionPane.ERROR_MESSAGE);

        }
        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate izabrati vrstu kooperanta", "Greska", JOptionPane.WARNING_MESSAGE);
            else JOptionPane.showMessageDialog(this, "You have to choose cooperant type", "Error", JOptionPane.WARNING_MESSAGE);

        }
        
        
    }

    private boolean proveriKooperanta(Kooperant kooperant) {
        if(jCheckBox1.isSelected()){
        String email=jTextField7.getText();
        if(!email.matches("[^.]+@[^.]+.com")){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Email nije u ispravnom formatu");
            else{
                JOptionPane.showMessageDialog(this, "Email format is incorrect");
   
            }
            return false;
        }
        }
        if(!kooperant.getMesto().matches("[A-Za-z ]+"))return false;
        if(kooperant instanceof PoljoprivrednoPreduzece){
            if(((PoljoprivrednoPreduzece) kooperant).getPib().length()!=13)return false;
            if(!((PoljoprivrednoPreduzece) kooperant).getPravniZastupnik().matches("[A-Za-z ]+"))return false;
            //if(((PoljoprivrednoPreduzece) kooperant).getEmail().matches(regex))return false;
        }
        else if(kooperant instanceof PoljoprivrednoGazdinstvo){
            if(!((PoljoprivrednoGazdinstvo) kooperant).getVlasnikGaz().matches("[A-Za-z ]+"))return false;
            if(((PoljoprivrednoGazdinstvo) kooperant).getBrojTelefona().length()>12||((PoljoprivrednoGazdinstvo) kooperant).getBrojTelefona().length()<8)return false;
            if(!((PoljoprivrednoGazdinstvo) kooperant).getBrojTelefona().matches("06[0-9]+"))return false;
        }
        return true;
    }

    private boolean izmeniKooperant(Kooperant rk) {
        rk.setNazivKooperanta(jTextField1.getText());
        rk.setMesto(jTextField2.getText());
        if(rk instanceof PoljoprivrednoPreduzece){
            ((PoljoprivrednoPreduzece) rk).setPravniZastupnik(jTextField5.getText());
            ((PoljoprivrednoPreduzece) rk).setPib(jTextField6.getText());
            ((PoljoprivrednoPreduzece) rk).setEmail(jTextField7.getText());
            boolean provera=proveriKooperanta(rk);
            if(!provera){
            return provera;
            }
            KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.IZMENIPRED, rk);
        
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
            boolean uspeh=(boolean) so.getOdgovor();
            return uspeh;
            
        }
        else if(rk instanceof PoljoprivrednoGazdinstvo){
            ((PoljoprivrednoGazdinstvo) rk).setVlasnikGaz(jTextField3.getText());
            ((PoljoprivrednoGazdinstvo) rk).setBrojTelefona(jTextField4.getText());
            
            boolean provera=proveriKooperanta(rk);
            if(!provera){
            return provera;
            }
            KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.IZMENIGAZ, rk);
        
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
            boolean uspeh=(boolean) so.getOdgovor();
            return uspeh;
            
        }
        
        return true;
        
    }

    private void vratiListuKooperant(Object kriterijumKooperant, List<Kooperant> pom) {
        List<Object>params=(List<Object>) kriterijumKooperant;
        String naziv=(String) params.get(0);
        String mesto=(String) params.get(1);
        String zastupnik=(String) params.get(2);
        String pib=(String) params.get(3);
        String email=(String) params.get(4);
        String vlasnik=(String) params.get(5);
        String brtel=(String) params.get(6);

        pom=new ArrayList<>();
       
        
        if(!jCheckBox1.isSelected()&&!jCheckBox2.isSelected()){
            for (Kooperant kooperant : kooperanti) {
                if(kooperant.getNazivKooperanta().contains(naziv)&&kooperant.getMesto().contains(mesto)){
                    pom.add(kooperant);
                }
            }
        }
        else if(jCheckBox1.isSelected()){
            for (Kooperant kooperant : kooperanti) {
                if(kooperant instanceof PoljoprivrednoPreduzece){
                    if(kooperant.getNazivKooperanta().contains(naziv)&&kooperant.getMesto().contains(mesto)&&((PoljoprivrednoPreduzece) kooperant).getPib().contains(pib)&&((PoljoprivrednoPreduzece) kooperant).getPravniZastupnik().contains(zastupnik)){
                        System.out.println(email);
                        System.out.println(((PoljoprivrednoPreduzece) kooperant).getEmail());
                    pom.add(kooperant);
                    }
                }
            }
        }
        else if(jCheckBox2.isSelected()){
            for (Kooperant kooperant : kooperanti) {
                
                if (kooperant instanceof PoljoprivrednoGazdinstvo) {
                    if(kooperant.getNazivKooperanta().contains(naziv)&&kooperant.getMesto().contains(mesto)&&((PoljoprivrednoGazdinstvo) kooperant).getVlasnikGaz().contains(vlasnik)&&((PoljoprivrednoGazdinstvo) kooperant).getBrojTelefona().contains(brtel)){
                    pom.add(kooperant);
                    }
                }
                
            }
        }
        if(pom.isEmpty()){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije pronasao vrednosti po zadatom kriterijumu");
            else            JOptionPane.showMessageDialog(this, "System could not find values according to given criteria");

            return;
        }
        this.pom=pom;
        ModelTabeleKooperant mtr=new ModelTabeleKooperant(pom,jezik);
        jTable1.setModel(mtr);
    }
}

