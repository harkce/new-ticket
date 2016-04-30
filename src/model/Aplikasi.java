/*
 * Created by Muhammad Habib Fikri Sundayana
 * habibgarut@gmail.com | http://edufi.id/ | http://cingkleung.com
 * Don't lazy to think, feel free to think lazy :)
 */
package model;

import database.Database;

/**
 *
 * @author habib
 */
public class Aplikasi {

    private Database connection;
    
    public Aplikasi() {
        connection = new Database();
    }
    
    public String[] getListIdKereta() {
        return connection.getListIdKereta();
    }
    
    public Kereta getKereta(int idKereta) {
        return connection.getKereta(idKereta);
    }
    
    public boolean addKereta(String namaKereta) {
        Kereta k = new Kereta(namaKereta);
        return connection.addKereta(k);
    }
    
    public boolean updateKereta(int idKereta, String namaKereta) {
        Kereta k = new Kereta(idKereta, namaKereta);
        return connection.updateKereta(k);
    }
    
    public boolean hapusKereta(int idKereta) {
        return connection.hapusKereta(idKereta);
    }
    
    public String[] getListIdGerbong() {
        return connection.getListIdGerbong();
    }
    
    public Gerbong getGerbong(int idGerbong) {
        return connection.getGerbong(idGerbong);
    }
    
    public boolean hapusGerbong(int idGerbong) {
        return connection.hapusGerbong(idGerbong);
    }
    
    public String[] getListNamaKereta() {
        return connection.getListNamaKereta();
    }
    
    public int getIdKereta(String namaKereta) {
        return connection.getIdKereta(namaKereta);
    }
    
    public boolean addGerbong(Gerbong g) {
        return connection.addGerbong(g);
    }
    
    public boolean updateGerbong(Gerbong g) {
        return connection.updateGerbong(g);
    }
    
    public String[] getListStasiun() {
        return connection.getListStasiun();
    }
    
    public boolean hapusStasiun(String namaStasiun) {
        return connection.hapusStasiun(namaStasiun);
    }
    
    public boolean tambahStasiun(String namaStasiun) {
        Stasiun s = new Stasiun(namaStasiun);
        return connection.tambahStasiun(s);
    }
    
    public boolean updateStasiun(String namaLama, String namaBaru) {
        return connection.updateStasiun(namaLama, namaBaru);
    }
    
    public String[] getListRoute() {
        return connection.getListRoute();
    }
    
    public boolean tambahRute(String stasiun1, String stasiun2, String namaKereta) {
        Stasiun asal = connection.getStasiunByName(stasiun1);
        Stasiun tujuan = connection.getStasiunByName(stasiun2);
        Kereta kereta = connection.getKeretaByName(namaKereta);
        Rute rute = new Rute(asal, tujuan, kereta);
        return connection.tambahRute(rute);
    }
    
    public String getRute(int idRute) {
        return connection.getRute(idRute);
    }
    
    public String[] getRuteList() {
        return connection.getRuteList();
    }
    
    public boolean tambahTiket(int jumlah, int idRute) {
        return connection.tambahTiket(jumlah, idRute);
    }
    
}
