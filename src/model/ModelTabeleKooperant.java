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
public class ModelTabeleKooperant extends AbstractTableModel{
    private List<Kooperant>kooperanti;
    String []kolone={"naziv","mesto"};
    String []kolone2={"name","location"};
    int jezik;
    public List<Kooperant> getKooperanti() {
        return kooperanti;
    }

    public void setKooperanti(List<Kooperant> kooperanti) {
        this.kooperanti = kooperanti;
    }
    public ModelTabeleKooperant(List<Kooperant>kooperanti,int jezik){
        this.kooperanti=kooperanti;
        this.jezik=jezik;
    }
    @Override
    public int getRowCount() {
        return kooperanti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kooperant ruk=kooperanti.get(rowIndex);
        switch (columnIndex) {
            case 0:return ruk.getNazivKooperanta();
            case 1:return ruk.getMesto();
            

            
                
                
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
