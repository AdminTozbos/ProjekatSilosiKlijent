/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miloš
 */
public class ModelTabelaPotvrda extends AbstractTableModel{
    List<Potvrda>potvrde;
    List<RukovodilacKooperacije>rukovodioci;
    List<PoljoprivrednoGazdinstvo>gazdinstva;
    List<PoljoprivrednoPreduzece>preduzeca;
    
    String []kolone={"kooperant","rukovodilac","datum izdavanja","datum vazenja","iznos"};
    public List<Potvrda> getPotvrde() {
        return potvrde;
    }

    public void setPotvrde(List<Potvrda> potvrde) {
        this.potvrde = potvrde;
    }

    public ModelTabelaPotvrda(List<Potvrda>potvrde,List<RukovodilacKooperacije>rukovodioci,List<PoljoprivrednoGazdinstvo>gazdinstva, List<PoljoprivrednoPreduzece>preduzeca){
        this.potvrde=potvrde;
        this.gazdinstva=gazdinstva;
        this.preduzeca=preduzeca;
        this.rukovodioci=rukovodioci;
    }
    
    @Override
    public int getRowCount() {
        return potvrde.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Potvrda ri=potvrde.get(rowIndex);
        String pred="";
        if(ri.getKoopFlag()==0){
            for (PoljoprivrednoPreduzece poljoprivrednoPreduzece : preduzeca) {
                if(poljoprivrednoPreduzece.getIdKooperant()==ri.getIdKooperant()){
                    pred=poljoprivrednoPreduzece.getNazivKooperanta();
                }
            }
        }
        if(ri.getKoopFlag()==1){
            for (PoljoprivrednoGazdinstvo gazdinstvo : gazdinstva) {
                if(gazdinstvo.getIdKooperant()==ri.getIdKooperant()){
                    pred=gazdinstvo.getNazivKooperanta();
                }
            }
        }
        String ime="";
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            if(rukovodilacKooperacije.getId()==ri.getIdRukovodilac()){
                ime=rukovodilacKooperacije.getIme()+" "+rukovodilacKooperacije.getPrezime();
            }
        }
        SimpleDateFormat s=new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:return pred;
            case 1:return ime;
            case 2:return s.format(ri.getDatumIzdavanja());
            case 3:return s.format(ri.getDatumVazenja());
            case 4:return ri.getUkupanIznos();
                
                
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
