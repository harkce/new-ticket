/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Aplikasi;
import model.Rute;
import model.State;
import view.ViewRute;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlViewRute extends MouseAdapter implements ActionListener {
    private Aplikasi model;
    private ViewRute view;
    
    public ControlViewRute(Aplikasi model){
        this.model=model;
        view = new ViewRute();
        view.addListener(this);
        view.addAdapter(this);
        view.setListRute(model.getListRoute());
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnKembali())) {
            if (State.type == 1)
                new ControlAdminMainForm(model);
            else
                new ControlCustServMainForm(model);
            view.dispose();
        } else if (source.equals(view.getBtnTambah())) {
            view.dispose();
            new ControlInputRute(model);
        } else if (source.equals(view.getBtnHapus())) {
            
        }
    }
    
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getListRute())) {
            int selected = view.getSelectedRute();
            view.setTxtTiket(model.getRute(selected));
        }
    }
    
}
