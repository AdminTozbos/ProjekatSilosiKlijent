/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.PreduzeceForma;
import form.RukovodilacForma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabelePreduzeca;
import model.ModelTabeleRukovodilac;
import model.Operacije;
import model.PoljoprivrednoPreduzece;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class PreduzeceNit extends Thread{
    JTable tabela;
    List<PoljoprivrednoPreduzece>preduzeca;
    PreduzeceForma pf;
    public void setPreduzeca(List<PoljoprivrednoPreduzece>preduzeca) {
        this.preduzeca = preduzeca;
       
    }

    public PreduzeceNit(JTable tabela,PreduzeceForma pf) {
        this.tabela=tabela;
        this.pf=pf;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                vratiListuSviPoljoprivrednoPreduzece(preduzeca);
                pf.setPreduzeca(preduzeca);
                ModelTabelePreduzeca mtr=new ModelTabelePreduzeca(preduzeca);
                tabela.setModel(mtr);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RukovodilacNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void vratiListuSviPoljoprivrednoPreduzece(List<PoljoprivrednoPreduzece> preduzeca) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIPRED, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.preduzeca=(List<PoljoprivrednoPreduzece>) so.getOdgovor();
        if(this.preduzeca.isEmpty()){
            JOptionPane.showMessageDialog(pf, "Doslo je do greske prilikom vracanja");
            return;
        }
        pf.setPreduzeca(preduzeca);
    }
}
