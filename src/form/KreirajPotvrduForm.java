/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.Kooperant;
import model.ModelTabeleStavka;
import model.Operacije;
import model.PoljoprivrednaKultura;
import model.PoljoprivrednoGazdinstvo;
import model.PoljoprivrednoPreduzece;
import model.Potvrda;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;
import model.StavkaPotvrde;
import niti.KreirajPotvrduNit;

/**
 *
 * @author Miloš
 */
public class KreirajPotvrduForm extends javax.swing.JFrame {
    List<StavkaPotvrde>stavke;
    List<RukovodilacKooperacije>rukovodioci;
    List<PoljoprivrednoGazdinstvo>gazdinstva;
    List<PoljoprivrednoPreduzece>preduzeca;
    List<PoljoprivrednaKultura>kulture;
    List<String>nazivi;
    Potvrda izabrana;
    int jezik=0;
    /**
     * Creates new form UnosPromene
     */
    public KreirajPotvrduForm() {
        initComponents();
        popuniComboRukovodilac();
        popuniComboKooperant();
        popuniComboKultura();
        PoljeCena.setEnabled(false);
        PoljeIznos.setEnabled(false);
        KreirajPotvrduNit kn=new KreirajPotvrduNit(jComboBox2, kulture, PoljeCena, PoljeIznos, PoljeKolicina);
        kn.start();
        stavke=new ArrayList<>();
        nazivi=new ArrayList<>();
        ModelTabeleStavka mts=new ModelTabeleStavka(stavke,nazivi,jezik);
        jTable1.setModel(mts);
        jComboBox4.removeAllItems();
        jComboBox4.addItem("SRB");
        jComboBox4.addItem("ENG");
        jComboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) jComboBox4.getSelectedItem();

                    if ("SRB".equals(selectedItem)) {
                    jLabel2.setText("Rukovodilac kooperacije");
                    jLabel3.setText("Unos stavke");
                    jLabel4.setText("Kultura");
                    jLabel5.setText("Kolicina");
                    jLabel7.setText("Cena po kg");
                    jLabel8.setText("Iznos po stavci");
                    jLabel9.setText("Unete stavke");
                    jLabel1.setText("Datum vazenja");
                    jLabel10.setText("Kooperant");
                    jLabel11.setText("Jezik :");

                    jButton1.setText("Unesi stavku");
                    jButton2.setText("Obrisi stavku");
                    jButton3.setText("Nazad");
                    jButton4.setText("Sacuvaj potvrdu");
                    
                    
                    jezik=0;
                } else if ("ENG".equals(selectedItem)) {
                    jLabel2.setText("Cooperation manager");
                    jLabel3.setText("Item input");
                    jLabel4.setText("Coop");
                    jLabel5.setText("Quantity");
                    jLabel7.setText("Price per kg");
                    jLabel8.setText("Cost per item");
                    jLabel9.setText("Items");
                    jLabel1.setText("Date of validity");
                    jLabel10.setText("Cooperant");
                    jLabel11.setText("Language :");

                    jButton1.setText("Insert item");
                    jButton2.setText("Delete item");
                    jButton3.setText("Back");
                    jButton4.setText("Save recript");
                    jezik=1;
                }
            }
        });
        
    }
    public KreirajPotvrduForm(Potvrda potvrda) {
        initComponents();
        popuniComboRukovodilac();
        popuniComboKooperant();
        popuniComboKultura();
        PoljeCena.setEnabled(false);
        PoljeIznos.setEnabled(false);
        KreirajPotvrduNit kn=new KreirajPotvrduNit(jComboBox2, kulture, PoljeCena, PoljeIznos, PoljeKolicina);
        kn.start();
        stavke=new ArrayList<>();
        nazivi=new ArrayList<>();
        izabrana=potvrda;
        popuniPotvrdu(izabrana);
        jComboBox4.removeAllItems();
        jComboBox4.addItem("SRB");
        jComboBox4.addItem("ENG");
        jComboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) jComboBox4.getSelectedItem();

                    if ("SRB".equals(selectedItem)) {
                    jLabel2.setText("Rukovodilac kooperacije");
                    jLabel3.setText("Unos stavke");
                    jLabel4.setText("Kultura");
                    jLabel5.setText("Kolicina");
                    jLabel7.setText("Cena po kg");
                    jLabel8.setText("Iznos po stavci");
                    jLabel9.setText("Unete stavke");
                    jLabel1.setText("Datum vazenja");
                    jLabel10.setText("Kooperant");
                    jLabel11.setText("Jezik :");

                    jButton1.setText("Unesi stavku");
                    jButton2.setText("Obrisi stavku");
                    jButton3.setText("Nazad");
                    jButton4.setText("Sacuvaj potvrdu");
                    
                    
                    jezik=0;
                } else if ("ENG".equals(selectedItem)) {
                    jLabel2.setText("Cooperation manager");
                    jLabel3.setText("Item input");
                    jLabel4.setText("Coop");
                    jLabel5.setText("Quantity");
                    jLabel7.setText("Price per kg");
                    jLabel8.setText("Cost per item");
                    jLabel9.setText("Items");
                    jLabel1.setText("Date of validity");
                    jLabel10.setText("Cooperant");
                    jLabel11.setText("Language :");

                    jButton1.setText("Insert item");
                    jButton2.setText("Delete item");
                    jButton3.setText("Back");
                    jButton4.setText("Save recript");
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        PoljeKolicina = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PoljeCena = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PoljeIznos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Datum vazenja");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));

        jLabel3.setText("Unos stavke");

        jLabel4.setText("Kultura");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Kolicina");

        jLabel6.setText("kg");

        jLabel7.setText("Cena po kg");

        jLabel8.setText("Iznos po stavci");

        jButton1.setText("Unesi stavku");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PoljeCena))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PoljeKolicina)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(PoljeIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PoljeKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PoljeCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1)
                    .addComponent(PoljeIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

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

        jLabel2.setText("Rukovodilac kooperacije");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Unete stavke");

        jButton2.setText("Obrisi stavku");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Nazad");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setText("Kooperant");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Sacuvaj potvrdu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setText("Jezik :");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1)
                                        .addComponent(jComboBox1, 0, 183, Short.MAX_VALUE)
                                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(255, 255, 255)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(37, 37, 37))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StavkaPotvrde stavka=new StavkaPotvrde();
        if(PoljeIznos.getText().equals("Greska")){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate uneti ispravnu kolicinu","Greska",JOptionPane.WARNING_MESSAGE);
            else JOptionPane.showMessageDialog(this, "You have to enter valid amount","Error",JOptionPane.WARNING_MESSAGE);

            return;
        }
       
        try {
            stavka.setCena(Double.parseDouble(PoljeCena.getText()));
            stavka.setIznos(Double.parseDouble(PoljeIznos.getText()));
            stavka.setKolicina(Double.parseDouble(PoljeKolicina.getText()));
        } catch (Exception e) {
            System.out.println("Nisam jos izracunao");
            return;
        }
        
        for (PoljoprivrednaKultura poljoprivrednaKultura : kulture) {
            if(poljoprivrednaKultura.getNazivKulture().equals((String)jComboBox2.getSelectedItem())){
                stavka.setIdKultura(poljoprivrednaKultura.getIdKultura());
            }
        }
        for (StavkaPotvrde stavkaPotvrde : stavke) {
            if(stavkaPotvrde.getIdKultura()==stavka.getIdKultura()){
                if(jezik==0)
                JOptionPane.showMessageDialog(this, "Stavka za datu kulturu vec postoji");
                else JOptionPane.showMessageDialog(this, "This item already exists on the list");

                return;
            }
        }
        stavke.add(stavka);
        nazivi.add((String) jComboBox2.getSelectedItem());
        ModelTabeleStavka mts=new ModelTabeleStavka(stavke,nazivi,jezik);
        jTable1.setModel(mts);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int izabrani=jTable1.getSelectedRow();
        if(izabrani==-1){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Morate izabrati stavku", "Greska", JOptionPane.WARNING_MESSAGE);
            else JOptionPane.showMessageDialog(this, "You have to choose item", "Error", JOptionPane.WARNING_MESSAGE);

            return;
        }
        stavke.remove(izabrani);
        nazivi.remove(izabrani);
        ModelTabeleStavka mts=new ModelTabeleStavka(stavke,nazivi,jezik);
        jTable1.setModel(mts);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Potvrda p=new Potvrda();
        p.setDatumIzdavanja(new Date());
        try {
            p.setDatumVazenja(new SimpleDateFormat("dd.MM.yyyy").parse(jTextField1.getText()));
            if(p.getDatumVazenja().before(new Date()))throw new IllegalArgumentException();
        } catch (ParseException ex) {
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Datum nije u ispravnom formatu", "Greska", JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(this, "Date format is incorrect", "Error", JOptionPane.ERROR_MESSAGE);

            return;
        }
        catch (IllegalArgumentException ex2) {
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Datum mora biti u buducnosti", "Greska", JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(this, "Date has to be in future", "Error", JOptionPane.ERROR_MESSAGE);

            return;
        }
        Double iznos=0.0;
        for (StavkaPotvrde stavkaPotvrde : stavke) {
            iznos=iznos+stavkaPotvrde.getIznos();
        }
        p.setUkupanIznos(iznos);
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            String ime=rukovodilacKooperacije.getIme()+" "+rukovodilacKooperacije.getPrezime();
            String izabrani=(String) jComboBox1.getSelectedItem();
            if(ime.equals(izabrani)){
                p.setIdRukovodilac(rukovodilacKooperacije.getId());
                break;
            }
        }
        for (PoljoprivrednoPreduzece predzuece : preduzeca) {
            if(predzuece.getNazivKooperanta().equals((String)jComboBox3.getSelectedItem())){
                p.setIdKooperant(predzuece.getIdKooperant());
                p.setKoopFlag(0);
                break;
            }
        }
        for (PoljoprivrednoGazdinstvo gazdinstvo : gazdinstva) {
            if(gazdinstvo.getNazivKooperanta().equals((String)jComboBox3.getSelectedItem())){
                p.setIdKooperant(gazdinstvo.getIdKooperant());
                p.setKoopFlag(1);
                break;
            }
        }
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIPOT, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        List<Potvrda>potvrde=(List<Potvrda>) so.getOdgovor();
        if(potvrde.isEmpty())p.setIdPotvrda(1);
        else if(izabrana!=null){
            p.setIdPotvrda(izabrana.getIdPotvrda());
        }
        else{
            int temp=Integer.MIN_VALUE;
            for (Potvrda potvrda : potvrde) {
                System.out.println(potvrda.getIdPotvrda());
                if(potvrda.getIdPotvrda()>temp)temp=potvrda.getIdPotvrda();
            }
            p.setIdPotvrda(temp+1);
        }
        int pom=0;
        System.out.println("\n");
        for (StavkaPotvrde stavkaPotvrde : stavke) {
            stavkaPotvrde.setIdPotvrda(p.getIdPotvrda());
            System.out.println(stavkaPotvrde.getIdPotvrda());
            stavkaPotvrde.setRb(pom+1);
            pom++;
        }
        if(izabrana!=null){
            izmeniPotvrda(p);
            return;
        }
        KreirajPotvrda(p);
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
            java.util.logging.Logger.getLogger(KreirajPotvrduForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreirajPotvrduForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreirajPotvrduForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreirajPotvrduForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KreirajPotvrduForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PoljeCena;
    private javax.swing.JTextField PoljeIznos;
    private javax.swing.JTextField PoljeKolicina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void popuniComboRukovodilac() {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATILISTURUK, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        rukovodioci=(List<RukovodilacKooperacije>) so.getOdgovor();
        jComboBox1.removeAllItems();
        for (RukovodilacKooperacije rukovodilac : rukovodioci) {
            jComboBox1.addItem(rukovodilac.getIme()+" "+rukovodilac.getPrezime());
        }
    }

    private void popuniComboKooperant() {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIGAZ, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        gazdinstva=(List<PoljoprivrednoGazdinstvo>) so.getOdgovor();
        jComboBox3.removeAllItems();
        KlijentskiZahtev kz1=new KlijentskiZahtev(Operacije.VRATIPRED, null);
        Komunikacija.getInstance().posaljiZahtev(kz1);
        ServerskiOdgovor so1=Komunikacija.getInstance().primiOdgovor();
        preduzeca=(List<PoljoprivrednoPreduzece>) so1.getOdgovor();
        for (PoljoprivrednoPreduzece preduzece : preduzeca) {
            jComboBox3.addItem(preduzece.getNazivKooperanta());
        }
        for (PoljoprivrednoGazdinstvo gazdinstvo : gazdinstva) {
           jComboBox3.addItem(gazdinstvo.getNazivKooperanta());
        }
    }

    private void popuniComboKultura() {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIKUL, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        kulture=(List<PoljoprivrednaKultura>) so.getOdgovor();
        jComboBox2.removeAllItems();
        for (PoljoprivrednaKultura kultura : kulture) {
            jComboBox2.addItem(kultura.getNazivKulture());
        }
    }

    private void KreirajPotvrda(Potvrda p) {
        List<Object>lista=new ArrayList<>();
        lista.add(p);
        lista.add(stavke);
        KlijentskiZahtev kz2=new KlijentskiZahtev(Operacije.DODAJPOT, lista);
        Komunikacija.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2=Komunikacija.getInstance().primiOdgovor();
        boolean uspeh= (boolean) so2.getOdgovor();
        if(uspeh){
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio potvrdu");
            else JOptionPane.showMessageDialog(this, "System has saved your receipt");

        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da zapamti potvrdu","Greska",JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(this, "System could not save the receipt","Error",JOptionPane.ERROR_MESSAGE);

            return;
        }
        
    }

    private void izmeniPotvrda(Potvrda p) {
        List<Object>lista=new ArrayList<>();
        lista.add(p);
        lista.add(stavke);
        KlijentskiZahtev kz2=new KlijentskiZahtev(Operacije.IZMENIPOT, lista);
        Komunikacija.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2=Komunikacija.getInstance().primiOdgovor();
        boolean uspeh= (boolean) so2.getOdgovor();
        if(uspeh){
            if (jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio potvrdu");
            else JOptionPane.showMessageDialog(this, "System has saved the receipt");

        }
        else{
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da zapamti potvrdu","Greska",JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(this, "System could not save the receipt","Error",JOptionPane.ERROR_MESSAGE);

            return;
        }
      /*for (StavkaPotvrde stavkaPotvrde : stavke) {
            KlijentskiZahtev kz3=new KlijentskiZahtev(Operacije.DODAJSTA, stavkaPotvrde);
            Komunikacija.getInstance().posaljiZahtev(kz3);
            ServerskiOdgovor so3=Komunikacija.getInstance().primiOdgovor();
            boolean uspeh1= (boolean) so3.getOdgovor();
            if(!uspeh1){
            
            if(jezik==0)
            JOptionPane.showMessageDialog(this, "Sistem nije uspeo da zapamti potvrdu","Greska",JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(this, "System could not save the receipt","Error",JOptionPane.ERROR_MESSAGE);

            return;
            }
        }*/
    }

    private void popuniPotvrdu(Potvrda izabrana) {
        SimpleDateFormat smp=new SimpleDateFormat("dd.MM.yyyy");
        jTextField1.setText(smp.format(izabrana.getDatumVazenja()));
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATISTA, izabrana);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        stavke=(List<StavkaPotvrde>) so.getOdgovor();
        for (StavkaPotvrde stavkaPotvrde : stavke) {
            for (PoljoprivrednaKultura poljoprivrednaKultura : kulture) {
                if(poljoprivrednaKultura.getIdKultura()==stavkaPotvrde.getIdKultura()){
                    nazivi.add(poljoprivrednaKultura.getNazivKulture());
                }
            }
        }
        ModelTabeleStavka mts=new ModelTabeleStavka(stavke, nazivi,jezik);
        jTable1.setModel(mts);
        RukovodilacKooperacije ruk=vratiRukovodioca(izabrana);
        String test=ruk.getIme()+" "+ruk.getPrezime();
        for (int i = 0; i < jComboBox1.getItemCount(); i++) {
            String item = jComboBox1.getItemAt(i);
            if(test.equals(item)){
            jComboBox1.setSelectedIndex(i);
                break;
            }
            
        }
        Kooperant koop=vratiKooperanta(izabrana);
        String test2=koop.getNazivKooperanta();
        
        for (int i = 0; i < jComboBox3.getItemCount(); i++) {
            String item = jComboBox3.getItemAt(i);
            
            if(test2.equals(item)){
            jComboBox3.setSelectedIndex(i);
                return;
            }
            
        }
    }

    private RukovodilacKooperacije vratiRukovodioca(Potvrda izabrana) {
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            if(rukovodilacKooperacije.getId()==izabrana.getIdRukovodilac())return rukovodilacKooperacije;
        }
        return null;
    }

    private Kooperant vratiKooperanta(Potvrda izabrana) {
        
        if(izabrana.getKoopFlag()==0){
            for (PoljoprivrednoPreduzece poljoprivrednoPreduzece : preduzeca) {
                if(poljoprivrednoPreduzece.getIdKooperant()==izabrana.getIdKooperant())return poljoprivrednoPreduzece;
            }
        }
        else{
            for (PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo : gazdinstva) {
                if(poljoprivrednoGazdinstvo.getIdKooperant()==izabrana.getIdKooperant())return poljoprivrednoGazdinstvo;
            }
        }
        return null;
    }
}
