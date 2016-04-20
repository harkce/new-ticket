/*
 * Created by Muhammad Habib Fikri Sundayana
 * habibgarut@gmail.com | http://edufi.id/ | http://cingkleung.com
 * Don't lazy to think, feel free to think lazy :)
 */
package ticket;

import controller.ControlAdminMainForm;
import model.Aplikasi;

/**
 *
 * @author habib
 */
public class Ticket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Aplikasi app = new Aplikasi();
        new ControlAdminMainForm(app);
    }
    
}
