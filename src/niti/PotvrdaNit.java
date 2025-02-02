/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.KulturaForma;
import form.PotvrdaGlavnaForma;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabelaKultura;
import model.ModelTabelaPotvrda;
import model.Operacije;
import model.PoljoprivrednaKultura;
import model.PoljoprivrednoGazdinstvo;
import model.PoljoprivrednoPreduzece;
import model.Potvrda;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class PotvrdaNit extends Thread{
    JTable tabela;
    List<Potvrda>potvrde;
    List<RukovodilacKooperacije>rukovodioci;
    List<PoljoprivrednoGazdinstvo>gazdinstva;
    List<PoljoprivrednoPreduzece>preduzeca;
    PotvrdaGlavnaForma kf;
    public void setPotvrde(List<Potvrda> potvrde) {
        this.potvrde = this.potvrde;
       
    }

    public PotvrdaNit(JTable tabela,PotvrdaGlavnaForma kf) {
        this.tabela=tabela;
        this.kf=kf;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                vratiListuSviPotvrde(potvrde);
                vratiListuSviPoljoprivrednoGazdinstvo(gazdinstva);
                vratiListuSviPoljoprivrednoPreduzece(preduzeca);
                vratiListuSviRukovodilacKooperacije(rukovodioci);
                kf.setPotvrde(potvrde);
                kf.setRukovodioci(rukovodioci);
                kf.setPreduzeca(preduzeca);
                kf.setGazdinstva(gazdinstva);
                ModelTabelaPotvrda mtr=new ModelTabelaPotvrda(potvrde,rukovodioci,gazdinstva,preduzeca);
                tabela.setModel(mtr);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                System.out.println("Greska");
            }
        }
    }

    private void vratiListuSviPotvrde(List<Potvrda> potvrde) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIPOT, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.potvrde=(List<Potvrda>) so.getOdgovor();
        if(this.potvrde.isEmpty()){
            JOptionPane.showMessageDialog(kf, "Doslo je do greske prilikom vracanja");
            return;
        }
    }
    private void vratiListuSviPoljoprivrednoGazdinstvo(List<PoljoprivrednoGazdinstvo> gazdinstva) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIGAZ, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.gazdinstva=(List<PoljoprivrednoGazdinstvo>) so.getOdgovor();
        if(this.gazdinstva.isEmpty()){
            JOptionPane.showMessageDialog(kf, "Doslo je do greske prilikom vracanja");
            return;
        }
        
    }
    private void vratiListuSviPoljoprivrednoPreduzece(List<PoljoprivrednoPreduzece> preduzeca) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIPRED, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.preduzeca=(List<PoljoprivrednoPreduzece>) so.getOdgovor();
        if(this.preduzeca.isEmpty()){
            JOptionPane.showMessageDialog(kf, "Doslo je do greske prilikom vracanja");
            return;
        }
        
    }
    private void vratiListuSviRukovodilacKooperacije(List<RukovodilacKooperacije> rukovodioci) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATILISTURUK, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.rukovodioci=(List<RukovodilacKooperacije>) so.getOdgovor();
        if(this.rukovodioci.isEmpty()){
            JOptionPane.showMessageDialog(kf, "Doslo je do greske prilikom vracanja");
            return;
        }
      
        
    }
    
    
    
}
