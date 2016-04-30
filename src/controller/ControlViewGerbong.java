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
import model.Gerbong;
import model.State;
import view.ViewGerbong;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlViewGerbong extends MouseAdapter implements ActionListener {
    
    private Aplikasi model;
    private ViewGerbong view;
    
    public ControlViewGerbong(Aplikasi model){
        this.model= model;
        view = new ViewGerbong();
        view.setListId(model.getListIdGerbong());
        view.setVisible(true);
        view.addAdapter(this);
        view.addListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getListGerbong())) {
            int idGerbong = view.getSelectedId();
            Gerbong g = model.getGerbong(idGerbong);
            view.setDetilGerbong(g.toString());
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
            int id = view.getSelectedId();
            if (model.hapusGerbong(id)) {
                JOptionPane.showMessageDialog(view, "Gerbong dengan id " + id + " berhasil dihapus!");
                view.dispose();
                new ControlViewGerbong(model);
            }
        } else if (source.equals(view.getBtnTambah())) {
            view.dispose();
            new ControlInputGerbong(model);
        } else if (source.equals(view.getBtnEdit())) {
            view.dispose();
            new ControlInputGerbong(model, view.getSelectedId());
        }
    }
}
