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

    public Kereta() {
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
    
}
