/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import form.PRRIForm;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miloš
 */
public class ModelTabelePrri extends AbstractTableModel{
    private List<PrRi>prri;
    private List<RukovodilacKooperacije>rukovodioci;
    private List<RadnoIskustvo>iskustva;
    private PRRIForm pf;
    String []kolone={"ime","prezime","firma","staz","opis"};
    String []kolone2={"name","surname","company","years","description"};

    int jezik;
    public List<PrRi> getPrri() {
        return prri;
    }

    public void setPrri(List<PrRi> prri) {
        this.prri = prri;
    }
    public ModelTabelePrri(List<PrRi>prri,PRRIForm pf,int jezik){
        this.prri=prri;
        this.pf=pf;
        this.jezik=jezik;
        rukovodioci=pf.getRukovodioci();
        iskustva=pf.getIskustva();
    }
    @Override
    public int getRowCount() {
        return prri.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        PrRi ruk=prri.get(rowIndex);
        String ime=izvuciIme(ruk);
        String prezime=izvuciPrezime(ruk);
        String firma=izvuciFirmu(ruk);
        switch (columnIndex) {
            case 0:return ime;
            case 1:return prezime;
            case 2:return firma;
            case 3:return ruk.getGodineIskustva();
            case 4:return ruk.getIskustvo();

            
                
                
            default:
                return "n/a";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        if(jezik==0)return kolone[column];
        else return kolone2[column];
    }

    private String izvuciIme(PrRi ruk) {
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            if(rukovodilacKooperacije.getId()==ruk.getIdRukovodilac())return rukovodilacKooperacije.getIme();
        }
        return "";
    }

    private String izvuciPrezime(PrRi ruk) {
        for (RukovodilacKooperacije rukovodilacKooperacije : rukovodioci) {
            if(rukovodilacKooperacije.getId()==ruk.getIdRukovodilac())return rukovodilacKooperacije.getPrezime();
        }
        return "";
    }

    private String izvuciFirmu(PrRi ruk) {
        for (RadnoIskustvo iskustvo : iskustva) {
            if(iskustvo.getIdRadnoIskustvo()==ruk.getIdRadnoIskustvo())return iskustvo.getRadnoMesto();
        }
        return "";
    }
 
    
    
    
}
