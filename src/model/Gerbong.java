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
    private String namaKereta;
    private int idKereta;

    public Gerbong(int jmlKursi, int kursiAvailable, int idKereta) {
        this.jmlKursi = jmlKursi;
        this.kursiAvailable = kursiAvailable;
        this.idKereta = idKereta;
    }

    public Gerbong(int idGerbong, int jmlKursi, int kursiAvailable, String namaKereta, int idKereta) {
        this.idGerbong = idGerbong;
        this.jmlKursi = jmlKursi;
        this.kursiAvailable = kursiAvailable;
        this.namaKereta = namaKereta;
        this.idKereta = idKereta;
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

    public String getNamaKereta() {
        return namaKereta;
    }

    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    public int getIdKereta() {
        return idKereta;
    }

    public void setIdKereta(int idKereta) {
        this.idKereta = idKereta;
    }
    
    @Override
    public String toString() {
        return "Gerbong kereta " + namaKereta + "\n" +
                "Jumlah Kursi : " + jmlKursi + "\n" +
                "Kursi Tersedia : " + kursiAvailable;
    }
    
}
