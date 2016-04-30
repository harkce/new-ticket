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
import model.Gerbong;
import view.InputGerbong;

/**
 *
 * @author Ridwan Wibowo
 */
public class ControlInputGerbong implements ActionListener {
    
    private Aplikasi model;
    private InputGerbong view;
    private int mode;
    private int idGerbong;
    
    public ControlInputGerbong(Aplikasi model) {
        this.model = model;
        this.view = new InputGerbong();
        view.setVisible(true);
        view.addListener(this);
        view.setCombo(model.getListNamaKereta());
        view.getButtonEdit().setText("Tambah");
        mode = 1;
    }
    
    public ControlInputGerbong(Aplikasi model, int idGerbong) {
        this.model = model;
        this.view = new InputGerbong();
        this.idGerbong = idGerbong;
        view.setVisible(true);
        view.addListener(this);
        view.setCombo(model.getListNamaKereta());
        view.getTextJumlahKursi().setText(model.getGerbong(idGerbong).getJmlKursi() + "");
        view.getTextKursiTersedia().setText(model.getGerbong(idGerbong).getKursiAvailable() + "");
        view.getButtonEdit().setText("Edit");
        mode = 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getButtonKembali())) {
            view.dispose();
            new ControlViewGerbong(model);
        } else if (source.equals(view.getButtonEdit())) {
            if (mode == 1) {
                String namaKereta = view.getComboKereta().getSelectedItem().toString();
                System.out.println(namaKereta);
                int idKereta = model.getIdKereta(namaKereta);
                int jmlKursi = Integer.parseInt(view.getTextJumlahKursi().getText());
                int kursiAvailable = Integer.parseInt(view.getTextKursiTersedia().getText());
                Gerbong g = new Gerbong(jmlKursi, kursiAvailable, idKereta);
                if (model.addGerbong(g)) {
                    JOptionPane.showMessageDialog(view, "Sukses insert gerbong ke kereta " + namaKereta);
                    view.dispose();
                    new ControlViewGerbong(model);
                }
            } else if (mode == 2) {
                String namaKereta = view.getComboKereta().getSelectedItem().toString();
                System.out.println(namaKereta);
                int idKereta = model.getIdKereta(namaKereta);
                int jmlKursi = Integer.parseInt(view.getTextJumlahKursi().getText());
                int kursiAvailable = Integer.parseInt(view.getTextKursiTersedia().getText());
                Gerbong g = new Gerbong(idGerbong, jmlKursi, kursiAvailable, namaKereta, idKereta);
                if (model.updateGerbong(g)) {
                    JOptionPane.showMessageDialog(view, "Sukses update gerbong ke kereta " + namaKereta);
                    view.dispose();
                    new ControlViewGerbong(model);
                }
            }
        }
    }
    
}
