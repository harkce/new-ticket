/*
 * Created by Muhammad Habib Fikri Sundayana
 * habibgarut@gmail.com | http://edufi.id/ | http://cingkleung.com
 * Don't lazy to think, feel free to think lazy :)
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Gerbong;
import model.Kereta;
import model.Rute;
import model.Stasiun;

/**
 *
 * @author habib
 */
public class Database {
    
    private final String SERVER = "jdbc:mysql://localhost:3306/pbo";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "";
    Statement statement;
    Connection connection;
    
    public Database() {
        try {
            connection = DriverManager.getConnection(SERVER, DBUSER, DBPASSWORD);
            statement = connection.createStatement();
            System.out.println("Connected");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Tidak dapat conenct ke MySQL");
        }
    }
    
    public void connect() {
        try {
            connection = DriverManager.getConnection(SERVER, DBUSER, DBPASSWORD);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Tidak dapat conenct ke MySQL");
        }
    }
    
    public int login(String username, String password) {
        int type = -1;
        try {
            String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                type = rs.getInt("type");
            }
            return type;
        } catch (SQLException ex) {
            System.out.println("Tidak bisa login");
            return type;
        }
    }
    
    public String[] getListIdKereta() {
        connect();
        try {
            String query = "SELECT idKereta, nama FROM kereta";
            ArrayList<String> listId = new ArrayList<>();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                String id = rs.getString(1);
                listId.add(id);
            }
            String[] s = new String[listId.size()];
            int i = 0;
            for (String x : listId) {
                s[i] = x;
                i++;
            }
            return s;
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan");
            return null;
        }
    }
    
    public Gerbong[] getGerbongList(int idKereta) {
        try {
            ArrayList<Gerbong> listGerbong = new ArrayList<>();
            String query = "SELECT * FROM gerbong WHERE idKereta = " + idKereta;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Gerbong g = new Gerbong();
                g.setIdGerbong(rs.getInt(1));
                g.setJmlKursi(rs.getInt(2));
                g.setKursiAvailable(rs.getInt(3));
                listGerbong.add(g);
            }
            Gerbong[] gerbong = new Gerbong[listGerbong.size()];
            int i = 0;
            for (Gerbong x : listGerbong) {
                gerbong[i] = x;
                i++;
            }
            return gerbong;
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan saat select gerbong list");
            return null;
        }
    }
    
    public Kereta getKereta(int idKereta) {
//        connect();
        try {
            Kereta k = new Kereta();
            Gerbong[] g = getGerbongList(idKereta);
            for (int i = 0; i < g.length; i++) {
                k.addGerbong(g[i]);
            }
            String query = "SELECT * FROM kereta WHERE idKereta = " + idKereta;
            System.out.println(query);
            ResultSet rs  = statement.executeQuery(query);
            while (rs.next()) {
                k.setIdKereta(rs.getInt(1));
                k.setNamaKereta(rs.getString(2));
            }
            return k;
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan saat select kereta");
            return null;
        }
    }
    
    public boolean addKereta(Kereta k) {
        try {
            String query = "INSERT INTO kereta (nama) VALUES ('" + k.getNamaKereta() + "')";
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal insert");
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateKereta(Kereta k) {
        try {
            String query = "UPDATE kereta SET nama = '" + k.getNamaKereta() + "' WHERE idKereta = " + k.getIdKereta();
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal update kereta");
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean hapusKereta(int idKereta) {
        try {
            String query = "DELETE FROM kereta WHERE idKereta = " + idKereta;
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal delete kereta");
            ex.printStackTrace();
            return false;
        }
    }
    
    public String[] getListIdGerbong() {
        try {
            ArrayList<String> listId = new ArrayList<>();
            String query = "SELECT idGerbong FROM gerbong";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
            String[] s = new String[listId.size()];
            int i = 0;
            for (String x : listId) {
                s[i] = x;
                i++;
            }
            return s;
        } catch (SQLException ex) {
            System.out.println("Gagal select gerbong");
            ex.printStackTrace();
            return null;
        }
    }
    
    public Gerbong getGerbong(int idGerbong) {
        try {
            Gerbong g = new Gerbong();
            String query = "SELECT idGerbong, jumlah_kursi, kursi_tersedia, nama FROM gerbong JOIN kereta USING (idKereta) WHERE idGerbong = " + idGerbong;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                g.setIdGerbong(rs.getInt(1));
                g.setJmlKursi(rs.getInt(2));
                g.setKursiAvailable(rs.getInt(3));
                g.setNamaKereta(rs.getString(4));
            }
            return g;
        } catch (SQLException ex) {
            System.out.println("Gagal select gerbong");
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean hapusGerbong(int idGerbong) {
        try {
            String query = "DELETE FROM gerbong WHERE idGerbong = " + idGerbong;
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal delete gerbong");
            ex.printStackTrace();
            return false;
        }
    }
    
    public String[] getListNamaKereta() {
        try {
            String query = "SELECT nama FROM kereta";
            ArrayList<String> nameList = new ArrayList<>();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                nameList.add(rs.getString(1));
            }
            String[] s = new String[nameList.size()];
            int i = 0;
            for (String x : nameList) {
                s[i] = x;
                i++;
            }
            return s;
        } catch (SQLException ex) {
            System.out.println("Gagal mendapatkan list nama kereta");
            ex.printStackTrace();
            return null;
        }
    }
    
    public int getIdKereta(String namaKereta) {
        try {
            String query = "SELECT idKereta FROM kereta WHERE nama = '" + namaKereta + "'";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Gagal mendapatkan id kereta");
            ex.printStackTrace();
            return -1;
        }
    }
    
    public boolean addGerbong(Gerbong g) {
        try {
            String query = "INSERT INTO gerbong (jumlah_kursi, kursi_tersedia, idKereta) VALUES ("
                    + g.getJmlKursi() + "," + g.getKursiAvailable() + "," + g.getIdKereta() + ")";
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal insert gerbong");
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateGerbong(Gerbong g) {
        try {
            String query = "UPDATE gerbong SET jumlah_kursi = " + g.getJmlKursi() + "," +
                    "kursi_tersedia = " + g.getKursiAvailable() + "," +
                    "idKereta = " + g.getIdKereta() + " WHERE idGerbong = " + g.getIdGerbong();
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal update gerbong");
            ex.printStackTrace();
            return false;
        }
    }
    
    public String[] getListStasiun() {
        try {
            String query = "SELECT * FROM stasiun";
            ResultSet rs = statement.executeQuery(query);
            ArrayList<String> stasiunList = new ArrayList<>();
            while (rs.next()) {
                stasiunList.add(rs.getString(2));
            }
            String[] s = new String[stasiunList.size()];
            int i = 0;
            for (String x : stasiunList) {
                s[i] = x;
                i++;
            }
            return s;
        } catch (SQLException ex) {
            System.out.println("Gagal mendapatkan list stasiun");
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean hapusStasiun(String namaStasiun) {
        try {
            String query = "DELETE FROM stasiun WHERE namastasiun = '" + namaStasiun + "'";
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal hapus stasiun");
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean tambahStasiun(Stasiun s) {
        try {
            String query = "INSERT INTO stasiun (namastasiun) VALUES ('" + s.getNamaStasiun() + "')";
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal insert stasiun");
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateStasiun(String namaLama, String namaBaru) {
        try {
            String query = "UPDATE stasiun SET namastasiun = '" + namaBaru + "' WHERE namastasiun = '" + namaLama + "'";
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal update stasiun");
            ex.printStackTrace();
            return false;
        }
    }
    
    public String[] getListRoute() {
        try {
            String query = "SELECT * FROM rute";
            ArrayList<String> listRute = new ArrayList<>();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int idStat1 = rs.getInt(2);
                int idStat2 = rs.getInt(3);
                int idKereta = rs.getInt(4);
//                String querytmp = "SELECT namastasiun FROM stasiun WHERE idStasiun = " + idStat1;
//                ResultSet tmp = statement.executeQuery(querytmp);
//                tmp.next();
//                String jadi = tmp.getString(1);
//                querytmp = "SELECT namastasiun FROM stasiun WHERE idStasiun = " + idStat2;
//                tmp = statement.executeQuery(querytmp);
//                tmp.next();
//                jadi = jadi + " - " + tmp.getString(1);
                String jadi = idStat1 + " - " + idStat2;
                listRute.add(jadi);
            }
            String[] s = new String[listRute.size()];
            int i = 0;
            for (String x : listRute) {
                s[i] = x;
                i++;
            }
            return s;
        } catch (SQLException ex) {
            System.out.println("Gagal mendaparkan rute");
            ex.printStackTrace();
            return null;
        }
    }
    
    public Stasiun getStasiunByName(String namaStasiun) {
        try {
            
            String query = "SELECT * FROM stasiun WHERE namastasiun = '" + namaStasiun + "'";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            Stasiun s = new Stasiun(rs.getInt(1), rs.getString(2));
            return s;
        } catch (SQLException ex) {
            System.out.println("Gagal select id stasiun");
            ex.printStackTrace();
            return null;
        }
    }
    
    public Stasiun getStasiunById(int idStasiun) {
        try {
            
            String query = "SELECT * FROM stasiun WHERE idStasiun = " + idStasiun + "";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            Stasiun s = new Stasiun(rs.getInt(1), rs.getString(2));
            return s;
        } catch (SQLException ex) {
            System.out.println("Gagal select id stasiun");
            ex.printStackTrace();
            return null;
        }
    }
    
    public Kereta getKeretaByName(String namaKereta) {
        try {
            String query = "SELECT * FROM kereta WHERE nama = '" + namaKereta + "'";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            Kereta k = new Kereta(rs.getInt(1), rs.getString(2));
            return k;
        } catch (SQLException ex) {
            System.out.println("Gagal select id kereta");
            ex.printStackTrace();
            return null;
        }
    }
    
    public Kereta getKeretaById(int idKereta) {
        try {
            String query = "SELECT * FROM kereta WHERE idKereta = " + idKereta + "";
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            Kereta k = new Kereta(rs.getInt(1), rs.getString(2));
            return k;
        } catch (SQLException ex) {
            System.out.println("Gagal select id kereta");
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean tambahRute(Rute r) {
        try {
            String query = "INSERT INTO rute (idStasiun1, idStasiun2, idKereta) VALUES (" +
                    r.getStasiun1().getIdStasiun() + ", " +
                    r.getStasiun2().getIdStasiun() + ", " +
                    r.getKereta().getIdKereta() + ")";
            System.out.println(query);
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal insert rute");
            ex.printStackTrace();
            return false;
        }
    }
    
    public String getRute(int idRute) {
        try {
            String query = "SELECT * FROM rute WHERE idRute = " + (idRute+1);
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return "Rute id stasiun " + rs.getInt(2) + " ke stasiun " + rs.getInt(3) + " dengan kereta " + rs.getInt(4);
        } catch (SQLException ex) {
            System.out.println("Gagal select route");
            ex.printStackTrace();
            return null;
        }
    }
    
    public String[] getRuteList() {
        try {
            String query = "SELECT * FROM rute";
            ResultSet rs = statement.executeQuery(query);
            ArrayList<String> ruteList = new ArrayList<>();
            while (rs.next()) {
                ruteList.add(rs.getString(1));
            }
            String[] s = new String[ruteList.size()];
            int i = 0;
            for (String x : ruteList) {
                s[i] = x;
                i++;
            }
            return s;
        } catch (SQLException ex) {
            System.out.println("Gagal select route");
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean tambahTiket(int jumlah, int idRute) {
        try {
            String query = "INSERT INTO tiket (idRute, jumlah) VALUES (" + idRute + "," + jumlah + ")";
            statement.execute(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Gagal insert rute");
            ex.printStackTrace();
            return false;
        }
    }
    
}
