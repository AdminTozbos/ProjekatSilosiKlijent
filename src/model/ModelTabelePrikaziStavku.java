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
public class ModelTabelePrikaziStavku extends AbstractTableModel{
    List<StavkaPotvrde>stavke;
    List<String>nazivi;
    String []kolone={"rb","ime kulture","cena","kolicina","iznos"};
     String []kolone2={"pos","crop name","price","quantity","total"};
     int jezik;
    String kultura;
    public List<StavkaPotvrde> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaPotvrde> stavke) {
        this.stavke = stavke;
    }

    public ModelTabelePrikaziStavku(List<StavkaPotvrde> stavke,List<String> nazivi,int jezik) {
        this.stavke = stavke;
        this.nazivi=nazivi;
        this.jezik=jezik;
        
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
            case 0:return ri.getRb();
            case 1:return nazivi.get(rowIndex);
            case 2:return ri.getCena();
            case 3:return ri.getKolicina();
            case 4:return ri.getIznos();
                
                
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        if(jezik==0)return kolone[column];
        else return kolone2[column];
    }
    
}

