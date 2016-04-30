/*
 * Created by Muhammad Habib Fikri Sundayana
 * habibgarut@gmail.com | http://edufi.id/ | http://cingkleung.com
 * Don't lazy to think, feel free to think lazy :)
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author habib
 */
public class Kereta {
    
    private LinkedList<Gerbong> daftarGerbong;
    
    private int idKereta;
    private String namaKereta;

    public Kereta() {
        this.daftarGerbong = new LinkedList<>();
    }

    public Kereta(int idKereta, String namaKereta) {
        this.idKereta = idKereta;
        this.namaKereta = namaKereta;
        this.daftarGerbong = new LinkedList<>();
    }
    
    public Kereta(String namaKereta) {
        this.namaKereta = namaKereta;
        this.daftarGerbong = new LinkedList<>();
    }
    
    public void addGerbong(Gerbong g) {
        daftarGerbong.add(g);
    }
    
    public Gerbong getGerbong(int i) {
        return daftarGerbong.get(i);
    }
    
    public void removeGerbong(int i) {
        daftarGerbong.remove(i);
    }

    public int getIdKereta() {
        return idKereta;
    }

    public void setIdKereta(int idKereta) {
        this.idKereta = idKereta;
    }
    
    public String getNamaKereta() {
        return namaKereta;
    }

    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    @Override
    public String toString() {
        String s =  "ID Kereta : " + idKereta + "\n" +
                "Nama Kereta : " + namaKereta + "\n" +
                "Gerbong : [ ";
        int sumKursi = 0;
        int sumAvailable = 0;
        for (Gerbong g : daftarGerbong) {
            s = s + g.getIdGerbong() + " ";
            sumKursi += g.getJmlKursi();
            sumAvailable += g.getKursiAvailable();
        }
        return s + "]\n" + 
                "Jumlah Kursi di Kereta : " + sumKursi + "\n" +
                "Kursi Available : " + sumAvailable;
    }
    
}
