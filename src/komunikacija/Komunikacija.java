/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KlijentskiZahtev;
import model.ServerskiOdgovor;

/**
 *
 * @author Miloš
 */
public class Komunikacija {
    Socket s;
    private static Komunikacija komunikacija;

    private Komunikacija() {
        try {
            s=new Socket("localhost", 9000);
            System.out.println("Klijent je povezan");
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Komunikacija getInstance(){
        if(komunikacija==null){
            komunikacija=new Komunikacija();
        }
        return komunikacija;
    }
    public ServerskiOdgovor primiOdgovor(){
        try {
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
            return (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void posaljiZahtev(KlijentskiZahtev kz){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
