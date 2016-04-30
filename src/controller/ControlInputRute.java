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
import view.InputRute;

/**
 *
 * @author Ridwan Wibowo
 */
public class ControlInputRute implements ActionListener {
    
    private Aplikasi model;
    private InputRute view;
    
    public ControlInputRute(Aplikasi model) {
        this.model = model;
        this.view = new InputRute();
        view.addListener(this);
        view.setComboStasiun1(model.getListStasiun());
        view.setComboStasiun2(model.getListStasiun());
        view.setComboKereta(model.getListNamaKereta());
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getButtonKembali())) {
            view.dispose();
            new ControlViewRute(model);
        } else if (source.equals(view.getButtonTambah())) {
            String stasiun1 = view.getComboStasiun1().getSelectedItem().toString();
            String stasiun2 = view.getComboStasiun2().getSelectedItem().toString();
            String kereta = view.getComboKereta().getSelectedItem().toString();
            if (model.tambahRute(stasiun1, stasiun2, kereta)) {
                JOptionPane.showMessageDialog(view, "Sukses menambah rute");
                view.dispose();
                new ControlViewRute(model);
            }
        }
    }
    
}
