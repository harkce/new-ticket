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
        connection.connect();
    }
    
}
