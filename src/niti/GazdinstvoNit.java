/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.GazdinstvoForma;
import form.PreduzeceForma;
import form.RukovodilacForma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabeleGazdinstvo;
import model.ModelTabelePreduzeca;
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
public class GazdinstvoNit extends Thread{
    JTable tabela;
    List<PoljoprivrednoGazdinstvo>gazdinstva;
    GazdinstvoForma pf;
    public void setGazdinstva(List<PoljoprivrednoGazdinstvo>gazdinstva) {
        this.gazdinstva = gazdinstva;
       
    }

    public GazdinstvoNit(JTable tabela,GazdinstvoForma pf) {
        this.tabela=tabela;
        this.pf=pf;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                vratiListuSviPoljoprivrednoGazdinstvo(gazdinstva);
                pf.setGazdinstvo(gazdinstva);
                ModelTabeleGazdinstvo mtr=new ModelTabeleGazdinstvo(gazdinstva,pf.getJezik());
                tabela.setModel(mtr);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RukovodilacNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void vratiListuSviPoljoprivrednoGazdinstvo(List<PoljoprivrednoGazdinstvo> gazdinstva) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIGAZ, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.gazdinstva=(List<PoljoprivrednoGazdinstvo>) so.getOdgovor();
        if(this.gazdinstva.isEmpty()){
            JOptionPane.showMessageDialog(pf, "Doslo je do greske prilikom vracanja");
            return;
        }
        
    }
}
