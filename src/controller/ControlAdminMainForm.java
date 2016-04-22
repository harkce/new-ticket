/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Aplikasi;
import view.AdminMainForm;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlAdminMainForm implements ActionListener {
    
    private Aplikasi model;
    private AdminMainForm view;
    
    public ControlAdminMainForm(Aplikasi model) {
        this.model = model;
        view = new AdminMainForm();
        view.addListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnExit())) {
            System.exit(0);
        }
        if (source.equals(view.getBtnDataKereta())) {
            new ControlViewKereta(model);
            view.dispose();
        }
        if (source.equals(view.getBtnDataGerbong())) {
            new ControlViewGerbong(model);
            view.dispose();
        }
        if (source.equals(view.getBtnDataRute())) {
            new ControlViewRute(model);
            view.dispose();
        }
        if (source.equals(view.getBtnDataStasion())){
            new ControlViewStasiun(model);
            view.dispose();
        }
       
    }
    
}
