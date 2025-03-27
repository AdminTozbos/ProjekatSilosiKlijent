/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.KooperantForma;
import form.RukovodilacForma;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.Kooperant;
import model.ModelTabeleKooperant;
import model.ModelTabeleRukovodilac;
import model.Operacije;
import model.PoljoprivrednoGazdinstvo;
import model.PoljoprivrednoPreduzece;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class KooperantNit extends Thread{
    JTable tabela;
    List<Kooperant>kooperanti;
    KooperantForma rf;
    public void setRukovodioci(List<Kooperant> kooperanti) {
        this.kooperanti = kooperanti;
       
    }

    public KooperantNit(JTable tabela,KooperantForma rf) {
        this.tabela=tabela;
        this.rf=rf;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                vratiListuSviKooperant(kooperanti);
                rf.setKooperanti(kooperanti);
                ModelTabeleKooperant mtr=new ModelTabeleKooperant(kooperanti,rf.getJezik());
                tabela.setModel(mtr);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(KooperantNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void vratiListuSviKooperant(List<Kooperant> kooperanti) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIPRED, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        List<PoljoprivrednoPreduzece>preduzeca=(List<PoljoprivrednoPreduzece>) so.getOdgovor();
        KlijentskiZahtev kz2=new KlijentskiZahtev(Operacije.VRATIGAZ, null);
        Komunikacija.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2=Komunikacija.getInstance().primiOdgovor();
        List<PoljoprivrednoGazdinstvo>gazdinstva=(List<PoljoprivrednoGazdinstvo>) so2.getOdgovor();
        List<Kooperant>ucitani=new ArrayList<>();
        for (PoljoprivrednoPreduzece poljoprivrednoPreduzece : preduzeca) {
            ucitani.add(poljoprivrednoPreduzece);
        }
        for (PoljoprivrednoGazdinstvo poljoprivrednoGazdinstvo : gazdinstva) {
            ucitani.add(poljoprivrednoGazdinstvo);
        }
        this.kooperanti=ucitani;
        if(this.kooperanti.isEmpty()){
            JOptionPane.showMessageDialog(rf, "Doslo je do greske prilikom vracanja");
            return;
        }
        rf.setKooperanti(kooperanti);
        
    }
    
    
}
