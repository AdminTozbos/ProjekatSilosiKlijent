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
public class ModelTabelePreduzeca extends AbstractTableModel{
    private List<PoljoprivrednoPreduzece>preduzeca;
    String []kolone={"naziv","mesto","zastupnik","pib","email"};
    String []kolone2={"name","location","agent","pib","email"};
    int jezik;
    public List<PoljoprivrednoPreduzece> getPreduzeca() {
        return preduzeca;
    }

    public void setPreduzeca(List<PoljoprivrednoPreduzece> preduzeca) {
        this.preduzeca = preduzeca;
    }
    public ModelTabelePreduzeca(List<PoljoprivrednoPreduzece>preduzeca,int jezik){
        this.preduzeca=preduzeca;
        this.jezik=jezik;
    }
    @Override
    public int getRowCount() {
        return preduzeca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoljoprivrednoPreduzece pp=preduzeca.get(rowIndex);
        switch (columnIndex) {
            case 0:return pp.getNazivKooperanta();
            case 1:return pp.getMesto();
            case 2:return pp.getPravniZastupnik();
            case 3:return pp.getPib();
            case 4:return pp.getEmail();
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
