/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import form.IskustvoForma;
import form.RukovodilacForma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import komunikacija.Komunikacija;
import model.KlijentskiZahtev;
import model.ModelTabeleIskustvo;
import model.ModelTabeleRukovodilac;
import model.Operacije;
import model.RadnoIskustvo;
import model.RukovodilacKooperacije;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class RadnoIskustvoNit extends Thread{
    JTable tabela;
    List<RadnoIskustvo>iskustva;
    IskustvoForma is;

    public List<RadnoIskustvo> getIskustva() {
        return iskustva;
    }

    public void setIskustva(List<RadnoIskustvo> iskustva) {
        this.iskustva = iskustva;
    }
    
    public RadnoIskustvoNit(JTable tabela,IskustvoForma is) {
        this.tabela=tabela;
         this.is=is;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                vratiListuSviRadnoIskustvo(iskustva);
                is.setIskustva(iskustva);
                ModelTabeleIskustvo mtr=new ModelTabeleIskustvo(iskustva,is.getJezik());
                tabela.setModel(mtr);
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RukovodilacNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void vratiListuSviRadnoIskustvo(List<RadnoIskustvo> iskustva) {
        KlijentskiZahtev kz=new KlijentskiZahtev(Operacije.VRATIISK, null);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so=Komunikacija.getInstance().primiOdgovor();
        this.iskustva=(List<RadnoIskustvo>) so.getOdgovor();
        if(this.iskustva.isEmpty()){
            JOptionPane.showMessageDialog(is, "Doslo je do greske prilikom vracanja");
            return;
        }
        //is.setIskustva(iskustva);
        
    }
    
}
