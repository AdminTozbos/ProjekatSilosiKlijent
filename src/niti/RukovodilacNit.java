/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.RukovodilacForma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabeleRukovodilac;
import model.Operacije;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class RukovodilacNit extends Thread{
    JTable tabela;
    List<RukovodilacKooperacije>rukovodioci;
    RukovodilacForma rf;
    public void setRukovodioci(List<RukovodilacKooperacije> rukovodioci) {
        this.rukovodioci = rukovodioci;
       
    }

    public RukovodilacNit(JTable tabela,RukovodilacForma rf) {
        this.tabela=tabela;
         this.rf=rf;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                vratiListuSviRukovodilacKooperacije(rukovodioci);
                rf.setRukovodioci(rukovodioci);
                ModelTabeleRukovodilac mtr=new ModelTabeleRukovodilac(rukovodioci);
                tabela.setModel(mtr);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RukovodilacNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void vratiListuSviRukovodilacKooperacije(List<RukovodilacKooperacije> rukovodioci) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATILISTURUK, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.rukovodioci=(List<RukovodilacKooperacije>) so.getOdgovor();
        if(this.rukovodioci.isEmpty()){
            JOptionPane.showMessageDialog(rf, "Doslo je do greske prilikom vracanja");
            return;
        }
        rf.setRukovodioci(rukovodioci);
        
    }
    
    
}
