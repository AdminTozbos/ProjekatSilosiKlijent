/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miloš
 */
public class ModelTabeleStavka extends AbstractTableModel{
    List<StavkaPotvrde>stavke;
    List<String>nazivi;
    String []kolone={"ime kulture","cena","kolicina","iznos"};
    String kultura;
    public List<StavkaPotvrde> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaPotvrde> stavke) {
        this.stavke = stavke;
    }

    public ModelTabeleStavka(List<StavkaPotvrde> stavke,List<String> nazivi) {
        this.stavke = stavke;
        this.kultura=kultura;
        this.nazivi=nazivi;
        
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPotvrde ri=stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:return nazivi.get(rowIndex);
            case 1:return ri.getCena();
            case 2:return ri.getKolicina();
            case 3:return ri.getIznos();
                
                
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
