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
public class Stasiun {
    
    private int idStasiun;
    private String namaStasiun;

    public Stasiun() {}

    public Stasiun(int idStasiun, String namaStasiun) {
        this.idStasiun = idStasiun;
        this.namaStasiun = namaStasiun;
    }

    public Stasiun(String namaStasiun) {
        this.namaStasiun = namaStasiun;
    }
    
    public int getIdStasiun() {
        return idStasiun;
    }

    public void setIdStasiun(int idStasiun) {
        this.idStasiun = idStasiun;
    }

    public String getNamaStasiun() {
        return namaStasiun;
    }

    public void setNamaStasiun(String namaStasiun) {
        this.namaStasiun = namaStasiun;
    }
    
}
