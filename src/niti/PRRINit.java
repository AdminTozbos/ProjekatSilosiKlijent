/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.PRRIForm;
import form.RukovodilacForma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabelePrri;
import model.ModelTabeleRukovodilac;
import model.Operacije;
import model.PrRi;
import model.RadnoIskustvo;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class PRRINit extends Thread{
    JTable tabela;
    List<PrRi>prri;
  
    PRRIForm rf;
    public void setPrRi(List<PrRi> prri) {
        this.prri = prri;
       
    }

    public PRRINit(JTable tabela,PRRIForm rf) {
        this.tabela=tabela;
        this.rf=rf;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                vratiListuSviPrri(prri);
                rf.setPrri(prri);
                
                ModelTabelePrri mtr=new ModelTabelePrri(prri,rf);
                tabela.setModel(mtr);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PRRINit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void vratiListuSviPrri(List<PrRi> prri) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIPRRI, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.prri=(List<PrRi>) so.getOdgovor();
        if(this.prri.isEmpty()){
            JOptionPane.showMessageDialog(rf, "Doslo je do greske prilikom vracanja");
            return;
        }
        //rf.setPrri(prri);
        
    }
    
    
}
