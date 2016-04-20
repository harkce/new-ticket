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
    }
    
}
