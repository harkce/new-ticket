/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Aplikasi;
import model.State;
import view.LoginForm;

/**
 *
 * @author Habib Fikri
 */
public class ControlLogin implements ActionListener {
    
    LoginForm view;
    Aplikasi model;
    Database con;
    
    public ControlLogin(Aplikasi model) {
        this.model = model;
        con = new Database();
        view = new LoginForm();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogin())) {
            System.out.println("Login Clicked!");
            String username = view.getTxtUsername().getText();
            String password = view.getTxtPassword().getText();
            if (con.login(username, password) == 1) {
                new ControlAdminMainForm(model);
                view.dispose();
                State.type = 1;
            } else if (con.login(username, password) == 2) {
                new ControlCustServMainForm(model);
                view.dispose();
                State.type = 2;
            } else {
                System.out.println("Login Gagal");
            }
        }
    }
    
}
