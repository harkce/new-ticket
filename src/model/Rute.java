/*
 * Created by Muhammad Habib Fikri Sundayana
 * habibgarut@gmail.com | http://edufi.id/ | http://cingkleung.com
 * Don't lazy to think, feel free to think lazy :)
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author habib
 */
public class Rute {
    
    private Stasiun stasiun1;
    private Stasiun stasiun2;
    private Kereta kereta;
    private ArrayList<Tiket> daftarTiket;

    public Rute() {}

    public Rute(Stasiun stasiun1, Stasiun stasiun2, Kereta kereta) {
        this.stasiun1 = stasiun1;
        this.stasiun2 = stasiun2;
        this.kereta = kereta;
    }

    public Stasiun getStasiun1() {
        return stasiun1;
    }

    public void setStasiun1(Stasiun stasiun1) {
        this.stasiun1 = stasiun1;
    }

    public Stasiun getStasiun2() {
        return stasiun2;
    }

    public void setStasiun2(Stasiun stasiun2) {
        this.stasiun2 = stasiun2;
    }

    public Kereta getKereta() {
        return kereta;
    }

    public void setKereta(Kereta kereta) {
        this.kereta = kereta;
    }
    
    public ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }

    public void setDaftarTiket(ArrayList<Tiket> daftarTiket) {
        this.daftarTiket = daftarTiket;
    }
    
    public void createTiket(Date tanggal) {
    }
    
    public Tiket getTiket(int i) {
        return daftarTiket.get(i);
    }

    @Override
    public String toString() {
        return "Rute " + stasiun1.getNamaStasiun() + " - " + stasiun2.getNamaStasiun() + "\n" +
                "Kereta " + kereta.getNamaKereta();
    }
    
}
