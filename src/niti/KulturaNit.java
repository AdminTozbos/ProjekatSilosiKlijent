/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.KulturaForma;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabelaKultura;
import model.Operacije;
import model.PoljoprivrednaKultura;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class KulturaNit extends Thread{
    JTable tabela;
    List<PoljoprivrednaKultura>kulture;
    KulturaForma kf;
    public void setRukovodioci(List<PoljoprivrednaKultura> kulture) {
        this.kulture = kulture;
       
    }

    public KulturaNit(JTable tabela,KulturaForma kf) {
        this.tabela=tabela;
         this.kf=kf;
         
        
    }

    @Override
    public void run() {
        while (true) {            
            try {
                
                vratiListuSviPoljoprivrednaKultura(kulture);
                kf.setKulture(kulture);
                ModelTabelaKultura mtr=new ModelTabelaKultura(kulture);
                tabela.setModel(mtr);
               
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                System.out.println("Greska");
            }
        }
    }

    private void vratiListuSviPoljoprivrednaKultura(List<PoljoprivrednaKultura> kulture) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIKUL, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.kulture=(List<PoljoprivrednaKultura>) so.getOdgovor();
        if(this.kulture.isEmpty()){
            JOptionPane.showMessageDialog(kf, "Doslo je do greske prilikom vracanja");
            return;
        }
        kf.setKulture(kulture);
    }
    
}
