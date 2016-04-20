/*
 * Created by Muhammad Habib Fikri Sundayana
 * habibgarut@gmail.com | http://edufi.id/ | http://cingkleung.com
 * Don't lazy to think, feel free to think lazy :)
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author habib
 */
public class Database {
    
    private final String SERVER = "jdbc:mysql://localhost:3306/tubespbo";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "";
    Statement statement;
    Connection connection;
    
    public void connect() {
        try {
            connection = DriverManager.getConnection(SERVER, DBUSER, DBPASSWORD);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Tidak dapat conenct ke MySQL");
        }
    }
    
}
