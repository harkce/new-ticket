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
import model.Kereta;
import model.State;
import view.ViewKereta;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlViewKereta extends MouseAdapter implements ActionListener {
    
    private Aplikasi model;
    private ViewKereta view;
    
    public ControlViewKereta(Aplikasi model) {
        this.model = model;
        view = new ViewKereta();
        view.setVisible(true);
        view.setListId(model.getListIdKereta());
        view.addAdapter(this);
        view.addListener(this);
    }
    
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getListId())) {
            int idKereta = view.getSelectedId();
            Kereta k = model.getKereta(idKereta);
            view.setDetilKereta(k.toString());
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
        } else if (source.equals(view.getBtnTambah())) {
            view.dispose();
            new ControlTambahKereta(model);
        } else if (source.equals(view.getBtnEdit())) {
            int idKereta = view.getSelectedId();
            Kereta k = model.getKereta(idKereta);
            new ControlTambahKereta(model, k);
            view.dispose();
        } else if (source.equals(view.getBtnHapus())) {
            int idKereta = view.getSelectedId();
            if (model.hapusKereta(idKereta)) {
                JOptionPane.showMessageDialog(view, "Sukses delete kereta dengan id = " + idKereta);
                view.dispose();
                new ControlViewKereta(model);
            }
        }
    }
    
}
