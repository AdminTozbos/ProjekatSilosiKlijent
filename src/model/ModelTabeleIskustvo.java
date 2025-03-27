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
public class ModelTabeleIskustvo extends AbstractTableModel{
    List<RadnoIskustvo>iskustva;
    String []kolone={"ime preduzeca"};
    String []kolone2={"company name"};
    int jezik;
    public List<RadnoIskustvo> getIskustva() {
        return iskustva;
    }

    public void setIskustva(List<RadnoIskustvo> iskustva) {
        this.iskustva = iskustva;
    }

    public ModelTabeleIskustvo(List<RadnoIskustvo> iskustva,int jezik) {
        this.iskustva = iskustva;
        this.jezik=jezik;
    }
    
    @Override
    public int getRowCount() {
        return iskustva.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RadnoIskustvo ri=iskustva.get(rowIndex);
        switch (columnIndex) {
            case 0:return ri.getRadnoMesto();
                
                
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
