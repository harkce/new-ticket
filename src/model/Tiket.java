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
public class Tiket {
    
    private int idTiket;
    private int idPemesan;

    public Tiket() {}

    public Tiket(int idTiket, int idPemesan) {
        this.idTiket = idTiket;
        this.idPemesan = idPemesan;
    }

    public int getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(int idTiket) {
        this.idTiket = idTiket;
    }

    public int getIdPemesan() {
        return idPemesan;
    }

    public void setIdPemesan(int idPemesan) {
        this.idPemesan = idPemesan;
    }
    
    
    
}
