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
import model.Kereta;
import view.TambahKereta;
import view.ViewKereta;

/**
 *
 * @author Habib Fikri
 */
public class ControlTambahKereta implements ActionListener {
    
    private Aplikasi model;
    private TambahKereta view;
    private int mode;
    private int idKereta;
    
    public ControlTambahKereta(Aplikasi model) {
        this.model = model;
        view = new TambahKereta();
        view.addListener(this);
        view.getBtnTambah().setText("Tambah");
        view.setVisible(true);
        mode = 1;
    }
    
    public ControlTambahKereta(Aplikasi model, Kereta k) {
        this.model = model;
        view = new TambahKereta();
        view.addListener(this);
        view.getBtnTambah().setText("Edit");
        view.getTxtNamaKereta().setText(k.getNamaKereta());
        view.setVisible(true);
        idKereta = k.getIdKereta();
        mode = 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnKembali())) {
            new ControlViewKereta(model);
            view.dispose();
        } else if (source.equals(view.getBtnTambah())) {
            String namaKereta = view.getTxtNamaKereta().getText();
            if (mode == 1) {
                if (model.addKereta(namaKereta)) {
                    JOptionPane.showMessageDialog(view, "Sukses insert kereta dengan nama " + namaKereta);
                    new ControlViewKereta(model);
                    view.dispose();
                }
            } else {
                if (model.updateKereta(idKereta, namaKereta)) {
                    JOptionPane.showMessageDialog(view, "Sukses update kereta dengan nama " + namaKereta);
                    new ControlViewKereta(model);
                    view.dispose();
                }
            }
        }
    }
}
