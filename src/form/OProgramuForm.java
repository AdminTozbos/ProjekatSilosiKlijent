/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Miloš
 */
public class OProgramuForm extends javax.swing.JFrame {
    int jezik=0;
    /**
     * Creates new form OProgramuForm
     */
    public OProgramuForm() {
        initComponents();
        jTextArea1.setEditable(false);
        jComboBox1.removeAllItems();
        jComboBox1.addItem("SRB");
        jComboBox1.addItem("ENG");
        jTextArea1.setText("Kratko korisnicko uputstvo :\n"
                            + "Prilikom prijavljivanja na sistem korisnik ima 3 pokusaja da unese korisnicko ime i lozinku\n"
                            + "Odabir jezika vrsi se izborom stavke u opadajucem meniju\n"
                            + "Dostupni jezici su srpski i engleski\n"
                            + "Iz trenutnog prozora izlazi se kliikom na dugme nazad (izuzev pocetne i login forme)\n"
                            + "Ukoliko zelite da izvrsite izmenu , brisanje ili detaljan prikaz odredjenog objekta neophodno ga je prvo odabrati iz tabele\n"
                            + "Ukoliko zelite da izvrsite operaciju pretrazivanja \n, unesite celu frazu ili deo fraze u odgovarajuce polje , pri cemu je bitno da li su slova velika ili mala\n"
                            + "Cirilicni ili latinicni znaci sa kvacicama nisu dozvoljeni\n"
                            + "Imena , prezimena i nazivi mesta ne mogu sadrzati specijalne karaktere ili brojeve\n"
                            + "Broj telefona unosi se tako da mora pocinjati sa 06\n"
                            + "Email mora biti unet u formatu mailadresa@domain.com recimo miki@gmail.com , joca@outlook.com\n"
                            + "PIB je neophodno uneti kao broj od 13 cifara\n"
                            + "Pri popunjavanju ostalih polja smeju se koristiti svi karakteri (osim onih koji su prethodno eksplicitno iskljuceni)\n"
                            + "Prilikom unosa potvrde , svaka stavka se moze uneti samo jednom\n"
                            + "Prilikom unosa radnog iskustva rukovodioca iskustvo se moze uneti samo jednom za jednog radnika u jednom preduzecu\n"
                            + "Ukoliko je radnik radio u istom preduzecu u vise navrata , treba uneti godine iskustva zbirno , a opis iskustava odvojiti zarezom , ukoliko je radnik obavljao vise funkcija\n"
                            + "Klikom na dugme odjavi se , program se gasi");
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) jComboBox1.getSelectedItem();

                    if ("SRB".equals(selectedItem)) {
                    
                    jLabel1.setText("Jezik :");
                    
                    jButton1.setText("Nazad");
                    jTextArea1.setText("Kratko korisnicko uputstvo :\n"
                            + "Prilikom prijavljivanja na sistem korisnik ima 3 pokusaja da unese korisnicko ime i lozinku\n"
                            + "Odabir jezika vrsi se izborom stavke u opadajucem meniju\n"
                            + "Dostupni jezici su srpski i engleski\n"
                            + "Iz trenutnog prozora izlazi se kliikom na dugme nazad (izuzev pocetne i login forme)\n"
                            + "Ukoliko zelite da izvrsite izmenu , brisanje ili detaljan prikaz odredjenog objekta neophodno ga je prvo odabrati iz tabele\n"
                            + "Ukoliko zelite da izvrsite operaciju pretrazivanja \n, unesite celu frazu ili deo fraze u odgovarajuce polje , pri cemu je bitno da li su slova velika ili mala\n"
                            + "Cirilicni ili latinicni znaci sa kvacicama nisu dozvoljeni\n"
                            + "Imena , prezimena i nazivi mesta ne mogu sadrzati specijalne karaktere ili brojeve\n"
                            + "Broj telefona unosi se tako da mora pocinjati sa 06\n"
                            + "Email mora biti unet u formatu mailadresa@domain.com recimo miki@gmail.com , joca@outlook.com\n"
                            + "PIB je neophodno uneti kao broj od 13 cifara\n"
                            + "Pri popunjavanju ostalih polja smeju se koristiti svi karakteri (osim onih koji su prethodno eksplicitno iskljuceni)\n"
                            + "Prilikom unosa potvrde , svaka stavka se moze uneti samo jednom\n"
                            + "Prilikom unosa radnog iskustva rukovodioca iskustvo se moze uneti samo jednom za jednog radnika u jednom preduzecu\n"
                            + "Ukoliko je radnik radio u istom preduzecu u vise navrata , treba uneti godine iskustva zbirno , a opis iskustava odvojiti zarezom , ukoliko je radnik obavljao vise funkcija\n"
                            + "Klikom na dugme odjavi se , program se gasi");
                    jezik=0;
                } else if ("ENG".equals(selectedItem)) {
                    
                    jLabel1.setText("Language :");;
                    
                    jButton1.setText("Back");
                    jTextArea1.setText("Short user manual:\n"
    + "When logging into the system, the user has 3 attempts to enter the username and password\n"
    + "Language selection is done by choosing an option from the drop-down menu\n"
    + "Available languages are Serbian and English\n"
    + "You can exit the current window by clicking the back button (except on the start and login form)\n"
    + "If you want to edit, delete or view details of a specific object, you must first select it from the table\n"
    + "If you want to perform a search operation,\n enter the whole phrase or part of the phrase in the corresponding field, where letter casing matters\n"
    + "Cyrillic or Latin characters with diacritics are not allowed\n"
    + "Names, surnames and place names cannot contain special characters or numbers\n"
    + "Phone numbers must start with 06\n"
    + "Email must be entered in the format emailaddress@domain.com, for example miki@gmail.com, joca@outlook.com\n"
    + "PIB must be entered as a 13-digit number\n"
    + "All other fields can contain any characters (except those explicitly excluded above)\n"
    + "When entering confirmations, each item can only be entered once\n"
    + "When entering work experience for a manager, it can be entered only once per employee per company\n"
    + "If the employee worked at the same company multiple times, years of experience should be entered as a total, and the description separated by commas if the employee held multiple positions\n"
    + "By clicking the logout button, the program closes");

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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jButton1.setText("Nazad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Jezik :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(OProgramuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OProgramuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OProgramuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OProgramuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OProgramuForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
