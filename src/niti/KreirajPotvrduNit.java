/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.PoljoprivrednaKultura;

/**
 *
 * @author Miloš
 */
public class KreirajPotvrduNit extends Thread{
    JComboBox<String>kulturecb;
    List<PoljoprivrednaKultura>kulture;
    JTextField poljeCena;
    JTextField poljeIznos;
    JTextField poljeKolicina;

    public KreirajPotvrduNit(JComboBox<String> kulturecb, List<PoljoprivrednaKultura> kulture, JTextField poljeCena, JTextField poljeIznos, JTextField poljeKolicina) {
        this.kulturecb = kulturecb;
        this.kulture = kulture;
        this.poljeCena = poljeCena;
        this.poljeIznos = poljeIznos;
        this.poljeKolicina = poljeKolicina;
    }

    

    @Override
    public void run() {
        while (true) {            
            String izabranaK=(String) kulturecb.getSelectedItem();
            for (PoljoprivrednaKultura poljoprivrednaKultura : kulture) {
                if(poljoprivrednaKultura.getNazivKulture().equals(izabranaK)){
                    poljeCena.setText(poljoprivrednaKultura.getCena()+"");
                }
            }
            try {
                double iznos=Double.parseDouble(poljeCena.getText())*Double.parseDouble(poljeKolicina.getText());
                if(iznos<0){
                    throw new Exception();
                }
                poljeIznos.setText(iznos+"");
                
            } catch (Exception e) {
                poljeIznos.setText("Greska");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(KreirajPotvrduNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
