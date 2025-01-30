/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miloš
 */
public class ModelTabeleRukovodilac extends AbstractTableModel{
    private List<RukovodilacKooperacije>rukovodioci;
    String []kolone={"ime","prezime","broj telefona"};

    public List<RukovodilacKooperacije> getRukovodioci() {
        return rukovodioci;
    }

    public void setRukovodioci(List<RukovodilacKooperacije> rukovodioci) {
        this.rukovodioci = rukovodioci;
    }
    public ModelTabeleRukovodilac(List<RukovodilacKooperacije>rukovodioci){
        this.rukovodioci=rukovodioci;
    }
    @Override
    public int getRowCount() {
        return rukovodioci.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RukovodilacKooperacije ruk=rukovodioci.get(rowIndex);
        switch (columnIndex) {
            case 0:return ruk.getIme();
            case 1:return ruk.getPrezime();
            case 2:return ruk.getBrojTelefona();

            
                
                
            default:
                return "n/a";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
 
    
    
    
}
