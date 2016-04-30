/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Aplikasi;
import view.EditStasiun;

/**
 *
 * @author Habib Fikri
 */
public class ControlEditStasiun implements ActionListener {

    private Aplikasi model;
    private EditStasiun view;
    private String namaStasiun;
    
    public ControlEditStasiun(Aplikasi model, String namaStasiun) {
        this.model = model;
        this.view = new EditStasiun();
        this.namaStasiun = namaStasiun;
        view.getTxtNamaStasiun().setText(namaStasiun);
        view.addListener(this);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnKembali())) {
            view.dispose();
            new ControlViewStasiun(model);
        } else if (source.equals(view.getBtnSimpan())) {
            if (model.updateStasiun(namaStasiun, view.getTxtNamaStasiun().getText())) {
                JOptionPane.showMessageDialog(view, "Sukses update stasiun " + namaStasiun);
                view.dispose();
                new ControlViewStasiun(model);
            }
        }
    }
    
}
