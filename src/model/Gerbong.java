/*
 * Created by Muhammad Habib Fikri Sundayana
 * habibgarut@gmail.com | http://edufi.id/ | http://cingkleung.com
 * Don't lazy to think, feel free to think lazy :)
 */
package model;

/**
 *
 * @author habib
 */
public class Gerbong {
    
    private int idGerbong;
    private int jmlKursi;
    private int kursiAvailable;

    public Gerbong(int idGerbong, int jmlKursi, int kursiAvailable) {
        this.idGerbong = idGerbong;
        this.jmlKursi = jmlKursi;
        this.kursiAvailable = kursiAvailable;
    }

    public Gerbong() {}
    
    public int getIdGerbong() {
        return idGerbong;
    }

    public void setIdGerbong(int idGerbong) {
        this.idGerbong = idGerbong;
    }

    public int getJmlKursi() {
        return jmlKursi;
    }

    public void setJmlKursi(int jmlKursi) {
        this.jmlKursi = jmlKursi;
    }

    public int getKursiAvailable() {
        return kursiAvailable;
    }

    public void setKursiAvailable(int kursiAvailable) {
        this.kursiAvailable = kursiAvailable;
    }
    
    
    
}
