/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabelePrri;
import model.ModelTabeleRukovodilac;
import model.Operacije;
import model.PrRi;
import model.RadnoIskustvo;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;
import niti.PRRINit;

/**
 *
 * @author Miloš
 */
public class PRRIForm extends javax.swing.JFrame {
    List<RukovodilacKooperacije>rukovodioci;
    List<PrRi>prri;
    List<PrRi>pom;
    List<RadnoIskustvo>iskustva;
    int jezik=0;
    public List<RukovodilacKooperacije> getRukovodioci() {
        return rukovodioci;
    }

    public void setRukovodioci(List<RukovodilacKooperacije> rukovodioci) {
        this.rukovodioci = rukovodioci;
    }

    public List<PrRi> getPrri() {
        return prri;
    }

    public void setPrri(List<PrRi> prri) {
        this.prri = prri;
        this.pom=prri;
    }

    public int getJezik() {
        return jezik;
    }

    public void setJezik(int jezik) {
        this.jezik = jezik;
    }

    public List<RadnoIskustvo> getIskustva() {
        return iskustva;
    }

    public void setIskustva(List<RadnoIskustvo> iskustva) {
        this.iskustva = iskustva;
    }
    
    /**
     * Creates new form PRRIForm
     */
    public PRRIForm() {
        initComponents();
        popuniRukovodioce();
        popuniIskustvo();
        PRRINit pn=new PRRINit(jTable1, this);
        pn.start();
        ListSelectionModel selectionModel = jTable1.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int izabrani = jTable1.getSelectedRow();
                    if (izabrani != -1) {
                       PrRi pr=pom.get(izabrani);
                       jTextField1.setText(pr.getGodineIskustva()+"");
                       jTextField2.setText(pr.getIskustvo());
                        for(int i=0;i<rukovodioci.size();i++){
                            if(rukovodioci.get(i).getId()==pr.getIdRukovodilac()){
                                jComboBox1.setSelectedIndex(i);
                            }
                        }
                        for(int i=0;i<iskustva.size();i++){
                            if(iskustva.get(i).getIdRadnoIskustvo()==pr.getIdRadnoIskustvo()){
                                jComboBox2.setSelectedIndex(i);
                            }
                        }
                        
                    
                    }
                
                
                }
            }
        });
        } catch (Exception e) {
        }
        jComboBox3.removeAllItems();
        jComboBox3.addItem("SRB");
        jComboBox3.addItem("ENG");
        jComboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) jComboBox3.getSelectedItem();

                    if ("SRB".equals(selectedItem)) {
                    jLabel3.setText("Godine iskustva");
                    jLabel1.setText("Rukovodilac");
                    jLabel2.setText("Firma");
                    jLabel4.setText("Opis iskustva");
                    jLabel5.setText("Jezik :");
                    jButton1.setText("Unesi iskustvo");
                    jButton2.setText("Izmeni iskustvo");
                    jButton3.setText("Obrisi iskustvo");
                    jButton4.setText("Pretrazi iskustvo");
                    jButton5.setText("Nazad");
                    //jButton1.setText("Uloguj se");
                    jezik=0;
                } else if ("ENG".equals(selectedItem)) {
                    jLabel3.setText("Experience (Years)");
                    jLabel1.setText("Manager");
                    jLabel2.setText("Company");
                    jLabel4.setText("Description");
                    jLabel5.setText("Language :");
                    jButton1.setText("Insert experience");
                    jButton2.setText("Update experience");
                    jButton3.setText("Delete experience");
                    jButton4.setText("Search experience");
                    jButton5.setText("Back");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Rukovodilac");

        jLabel2.setText("Firma");

        jLabel3.setText("Godine iskustva");

        jLabel4.setText("Opis iskustva");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jButton1.setText("Unesi iskustvo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Obrisi iskustvo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Promeni iskustvo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Pretrazi iskustvo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Nazad");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setText("Jezik :");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 188, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int staz=0;
        try {
             staz=Integer.parseInt(jTextField1.getText());
             if(staz<1||staz>40)throw new Exception();
        } catch (Exception e) {
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate uneti ceo broj u intervalu 1-40");
            else            JOptionPane.showMessageDialog(this, "You have to enter number in interval 1-40");

            return;
        }
       String iskustvo=jTextField2.getText();
       RukovodilacKooperacije rukov=null;
       String imeprezime=(String) jComboBox1.getSelectedItem();
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            String ip=rukovodilacKooperacije.getIme()+" "+rukovodilacKooperacije.getPrezime();
            if(ip.equals(imeprezime)){
                rukov=rukovodilacKooperacije;
            }
        }
        RadnoIskustvo ri=null;
        String radnomesto=(String) jComboBox2.getSelectedItem();
        for (RadnoIskustvo radnoIskustvo : iskustva) {
            if(radnoIskustvo.getRadnoMesto().equals(radnomesto)){
                ri=radnoIskustvo;
            }
        }
        PrRi unet=new PrRi(rukov.getId(), ri.getIdRadnoIskustvo(), iskustvo, staz);
        kreirajPrri(unet);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int izabrani=jTable1.getSelectedRow();
        if(izabrani==-1){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate izabrati rukovodioca", "Greska", JOptionPane.WARNING_MESSAGE);
            else             JOptionPane.showMessageDialog(this, "You have to choose manager", "Error", JOptionPane.WARNING_MESSAGE);

            return;
        }
        PrRi rk=pom.get(izabrani);
        boolean uspeh=obrisiPrri(rk);
        if(uspeh){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Iskustvo je uspesno obrisano","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else             JOptionPane.showMessageDialog(this, "Experience has been deleted successfully","Potvrda",JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije uspesno izvrsio brisanje","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else             JOptionPane.showMessageDialog(this, "System could not delete record","Error",JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         int izabrani=jTable1.getSelectedRow();
        if(izabrani==-1){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate izabrati iskustvo", "Greska", JOptionPane.WARNING_MESSAGE);
            else            JOptionPane.showMessageDialog(this, "You have to choose experience", "Error", JOptionPane.WARNING_MESSAGE);

            return;
        }
        PrRi rk=pom.get(izabrani);
        
        boolean uspeh=promeniPrri(rk);
        if(uspeh){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Iskustvo je uspesno promenjeno","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else            JOptionPane.showMessageDialog(this, "Experience has been updated successfully","Confirmation",JOptionPane.INFORMATION_MESSAGE);

        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije uspesno izvrsio promenu","Potvrda",JOptionPane.INFORMATION_MESSAGE);
            else            JOptionPane.showMessageDialog(this, "System could not execute update","Error",JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String godine=jTextField1.getText();
        String iskustvo=jTextField2.getText();
        String rukov=(String) jComboBox1.getSelectedItem();
        String isk=(String) jComboBox2.getSelectedItem();
        //String broj=jTextField3.getText();
        List<Object>params=new ArrayList<>();
        params.add(godine);
        params.add(iskustvo);
        params.add(rukov);
        params.add(isk);
        
        
        vratiListuPrri(params, pom);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(PRRIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRRIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRRIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRRIForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRRIForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void popuniRukovodioce() {
        jComboBox1.removeAllItems();
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATILISTURUK, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        rukovodioci=(List<RukovodilacKooperacije>) so.getOdgovor();
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            jComboBox1.addItem(rukovodilacKooperacije.getIme()+" "+rukovodilacKooperacije.getPrezime());
        }
    }

    private void popuniIskustvo() {
        jComboBox2.removeAllItems();
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIISK, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        iskustva=(List<RadnoIskustvo>) so.getOdgovor();
        for (RadnoIskustvo iskustvo : iskustva) {
            jComboBox2.addItem(iskustvo.getRadnoMesto());
        }
    }

    private void kreirajPrri(PrRi unet) {
        boolean ispravan=proveriPrri(unet);
        if(ispravan){
            KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.DODAJPRRI, unet);
            komunikacija.Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
            boolean uspeh=(boolean) so.getOdgovor();
            if(uspeh){
               if(jezik==0)
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio iskustvo");
               else                JOptionPane.showMessageDialog(this, "System has been saved successfully");

            }
            else{
                if(jezik==0)
                JOptionPane.showMessageDialog(this, "Sistem nije zapamtio iskustvo","Greska",JOptionPane.ERROR_MESSAGE);
                else                 JOptionPane.showMessageDialog(this, "System could not save experience","Error",JOptionPane.ERROR_MESSAGE);

            }
            return;
        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Uneli ste nedozvoljenu vrednost polja","Greska",JOptionPane.ERROR_MESSAGE);
            else             JOptionPane.showMessageDialog(this, "You have entered disallowed value","Error",JOptionPane.ERROR_MESSAGE);

        }
    }

    private boolean proveriPrri(PrRi unet) {
        return true;
    }

    private boolean obrisiPrri(PrRi rk) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.OBRISIPRRI, rk);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        boolean uspeh=(boolean) so.getOdgovor();
        return uspeh;
    }

    private boolean promeniPrri(PrRi rk) {
        PrRi test=new PrRi(rk.getIdRukovodilac(), rk.getIdRadnoIskustvo(), "", 0);
        String imeprezime=(String) jComboBox1.getSelectedItem();
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            String rukov=rukovodilacKooperacije.getIme()+" "+rukovodilacKooperacije.getPrezime();
            if(rukov.equals(imeprezime)){
                rk.setIdRukovodilac(rukovodilacKooperacije.getId());
            }
        }
        String isk=(String) jComboBox2.getSelectedItem();
        for (RadnoIskustvo iskustvo : iskustva) {
            if(iskustvo.getRadnoMesto().equals(isk)){
                rk.setIdRadnoIskustvo(iskustvo.getIdRadnoIskustvo());
            }
        }
        try {
            rk.setGodineIskustva(Integer.parseInt(jTextField1.getText()));
            if (rk.getGodineIskustva()<1||rk.getGodineIskustva()>40) {
                throw new Exception();
            }
            rk.setIskustvo(jTextField2.getText());
        } catch (Exception e) {
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate uneti ceo broj u intervalu 1-40");
            else            JOptionPane.showMessageDialog(this, "You have to enter number in interval 1-40");

            return false;
        }
        if(test.getIdRukovodilac()!=rk.getIdRukovodilac()||test.getIdRadnoIskustvo()!=rk.getIdRadnoIskustvo()){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Nije dozvoljena promena rukovodioca i firme\nUkoliko zelite da promenite te podatke obrisite unos i napravite novi");
            else             JOptionPane.showMessageDialog(this, "Updating manager or company is not allowed\nIf you want to change them , delete this record , and save new");

            return false;
        }
        boolean provera=proveriPrri(rk);
        if(!provera){
            return provera;
        }
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.IZMENIPRRI, rk);
        
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        boolean uspeh=(boolean) so.getOdgovor();
        return uspeh;
    }

    private void vratiListuPrri(Object kriterijumPrri, List<PrRi> kk) {
        List<Object>params=(List<Object>) kriterijumPrri;
        String godine=(String) params.get(0);
        String iskustvo=(String) params.get(1);
        String rukov=(String) params.get(2);
        String firma=(String) params.get(3);

        pom=new ArrayList<>();
        for (PrRi lol  : prri) {
            if(lol.getIskustvo().contains(iskustvo)&&String.valueOf(lol.getGodineIskustva()).contains(godine)){
                pom.add(lol);
            }
        }
        List<PrRi>pom2=new ArrayList<>();
        for (PrRi prRi : pom) {
            pom2.add(prRi);
        }
        for (int j=0;j<pom.size();j++) {
            int idrukov=0;
            int idisk=0;
            for (int i=0; i<rukovodioci.size() ; i++) {
                String imeprezime=rukovodioci.get(i).getIme()+" "+rukovodioci.get(i).getPrezime();
                if(imeprezime.equals(rukov)){
                    idrukov=rukovodioci.get(i).getId();
                    break;
                }
               
                
            }
            
            for (int i=0; i<iskustva.size() ; i++) {
                if(iskustva.get(i).getRadnoMesto().equals(firma)){
                    idisk=iskustva.get(i).getIdRadnoIskustvo();
                    break;
                }
                
            }
            if(idisk!=pom.get(j).getIdRadnoIskustvo()||idrukov!=pom.get(j).getIdRukovodilac()||!pom.get(j).getIskustvo().contains(iskustvo)||!String.valueOf(pom.get(j).getGodineIskustva()).contains(godine)){
                PrRi izabrani=null;
                for (PrRi prRi : pom2) {
                    if (prRi.getGodineIskustva()==pom.get(j).getGodineIskustva()&&prRi.getIdRadnoIskustvo()==pom.get(j).getIdRadnoIskustvo()&&prRi.getIdRukovodilac()==pom.get(j).getIdRukovodilac()) {
                        izabrani=prRi;
                    }
                }
                pom2.remove(izabrani);
            }
                
        }
        pom=pom2;
        if(pom.isEmpty()){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije pronasao vrednosti po zadatom kriterijumu");
            else            JOptionPane.showMessageDialog(this, "System could not find values according to given criteria");

            return;
        }
        ModelTabelePrri mtr=new ModelTabelePrri(pom,this,jezik);
        jTable1.setModel(mtr);
    }
}
