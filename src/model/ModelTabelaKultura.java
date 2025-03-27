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
public class ModelTabelaKultura extends AbstractTableModel{
    private List<PoljoprivrednaKultura>kulture;
    String []kolone={"naziv","cena","mesec zetve"};
    String []kolone2={"name","price","harvest month"};
    int jezik;
    public List<PoljoprivrednaKultura> getRukovodioci() {
        return kulture;
    }

    public void setKulture(List<PoljoprivrednaKultura> kulture) {
        this.kulture = kulture;
    }
    public ModelTabelaKultura(List<PoljoprivrednaKultura>kulture,int jezik){
        this.kulture=kulture;
        this.jezik=jezik;
    }
    @Override
    public int getRowCount() {
        return kulture.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoljoprivrednaKultura k=kulture.get(rowIndex);
        switch (columnIndex) {
            case 0:return k.getNazivKulture();
            case 1:return k.getCena();
            case 2:return k.getMesecZetve();

            
                
                
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
