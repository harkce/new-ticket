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
import view.InputTiket;

/**
 *
 * @author Habib Fikri
 */
public class ControlInputTiket implements ActionListener {
    
    private Aplikasi model;
    private InputTiket view;
    
    public ControlInputTiket(Aplikasi model) {
        this.model = model;
        this.view = new InputTiket();
        view.addListener(this);
        view.setRuteList(model.getRuteList());
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnKembali())) {
            view.dispose();
            new ControlCustServMainForm(model);
        } else if (source.equals(view.getBtnTambah())) {
            int jumlah = Integer.parseInt(view.getTxtJumlah().getText());
            int idRute = 1+view.getRuteCombo().getSelectedIndex();
            if (model.tambahTiket(jumlah, idRute)) {
                JOptionPane.showMessageDialog(view, "Sukses tambah tiket");
                view.dispose();
                new ControlCustServMainForm(model);
            }
        }
    }
    
}
