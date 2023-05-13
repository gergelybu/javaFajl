
package pkg0513;

import java.text.NumberFormat;
import java.text.ParseException;


public class Fuvar {
    private int taxi_id;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetes_modja;
    
    public Fuvar(String sor) throws ParseException{
        //5240;2016-12-15 23:45:00;900;2,5;10,75;2,45;bankkártya
        sor = sor.replace(',', '.'); //kicseréli a régi karaktert az újra
        String[] s = sor.split(";");
        this.taxi_id = Integer.parseInt(s[0]);
        this.indulas = s[1];
        this.idotartam = Integer.parseInt(s[2]);
        NumberFormat nf = NumberFormat.getInstance();
        Number num = nf.parse(s[3]);
        this.tavolsag = num.doubleValue();
        //this.tavolsag = Double.parseDouble(s[3]);    
        this.viteldij = Double.parseDouble(s[4]);      
        this.borravalo = Double.parseDouble(s[5]);
        this.fizetes_modja = s[6];
    }

    public Fuvar(int taxi_id, String indulas, int idotartam, double tavolsag, double viteldij, double borravalo, String fizetes_modja) {
        this.taxi_id = taxi_id;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetes_modja = fizetes_modja;
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    @Override
    public String toString() {
        return "Fuvar{" + "taxi_id=" + taxi_id + ", indulas=" + indulas + ", idotartam=" + idotartam + ", tavolsag=" + tavolsag + ", viteldij=" + viteldij + ", borravalo=" + borravalo + ", fizetes_modja=" + fizetes_modja + '}';
    }
    
    
    
}
