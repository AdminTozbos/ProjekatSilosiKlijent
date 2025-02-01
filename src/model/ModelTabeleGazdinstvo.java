/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import form.GazdinstvoForma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miloš
 */
public class ModelTabeleGazdinstvo extends AbstractTableModel{
    private List<PoljoprivrednoGazdinstvo>gazdinstva;
    String []kolone={"naziv","mesto","vlasnik","broj telefona"};

    public List<PoljoprivrednoGazdinstvo> getGazdinstva() {
        return gazdinstva;
    }

    public void setGazdinstva(List<PoljoprivrednoGazdinstvo> gazdinstva) {
        this.gazdinstva = gazdinstva;
    }
    public ModelTabeleGazdinstvo(List<PoljoprivrednoGazdinstvo>gazdinstva){
        this.gazdinstva=gazdinstva;
    }
    @Override
    public int getRowCount() {
        return gazdinstva.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoljoprivrednoGazdinstvo pp=gazdinstva.get(rowIndex);
        switch (columnIndex) {
            case 0:return pp.getNazivKooperanta();
            case 1:return pp.getMesto();
            case 2:return pp.getVlasnikGaz();
            case 3:return pp.getBrojTelefona();
            default:
                return "n/a";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
