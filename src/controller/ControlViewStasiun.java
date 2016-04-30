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
import javax.swing.JOptionPane;
import model.Aplikasi;
import model.State;
import view.InputStasiun;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlViewStasiun extends MouseAdapter implements ActionListener {
    private Aplikasi model;
    private InputStasiun view;
    
    public ControlViewStasiun(Aplikasi model){
        this.model=model;
        view=new InputStasiun();
        view.addAdapter(this);
        view.addListener(this);
        view.setListStasiun(model.getListStasiun());
        view.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getListDaftarStasiun())) {
            String namaKereta = view.getSelectedStasiun();
        }
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
        } else if (source.equals(view.getBtnHapus())) {
            String namaStasiun  =view.getSelectedStasiun();
            if (model.hapusStasiun(namaStasiun)) {
                JOptionPane.showMessageDialog(view, "Sukses hapus stasiun " + namaStasiun);
                new ControlViewStasiun(model);
                view.dispose();
            }
        } else if (source.equals(view.getBtnTambah())) {
            String namaStasiun = view.getTxtStasiun().getText();
            if (model.tambahStasiun(namaStasiun)) {
                JOptionPane.showMessageDialog(view, "Sukses tambah stasiun " + namaStasiun);
                new ControlViewStasiun(model);
                view.dispose();
            }
        } else if (source.equals(view.getBtnEdit())) {
            String namaStasiun = view.getSelectedStasiun();
            new ControlEditStasiun(model, namaStasiun);
            view.dispose();
        }
    }
}
