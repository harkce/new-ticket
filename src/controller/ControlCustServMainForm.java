/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Aplikasi;
import view.CSMainForm;

/**
 *
 * @author Ridwan Wibowo
 */
public class ControlCustServMainForm implements ActionListener {
    
    public Aplikasi model;
    public CSMainForm view;
    
    public ControlCustServMainForm(Aplikasi model) {
        this.model = model;
        this.view = new CSMainForm();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnExit())) {
            System.exit(0);
        } else if (source.equals(view.getBtnDataStasiun())) {
            view.dispose();
            new ControlViewStasiun(model);
        } else if (source.equals(view.getBtnGerbong())) {
            view.dispose();
            new ControlViewGerbong(model);
        } else if (source.equals(view.getBtnKereta())) {
            view.dispose();
            new ControlViewKereta(model);
        } else if (source.equals(view.getBtnRute())) {
            view.dispose();
            new ControlViewRute(model);
        } else if (source.equals(view.getBtnTiket())) {
            view.dispose();
            new ControlInputTiket(model);
        }
    }
    
}
