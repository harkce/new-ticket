/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import view.InputGerbong;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlViewGerbong {
    
    private Aplikasi model;
    private InputGerbong view;
    
    public ControlViewGerbong(Aplikasi model){
        this.model= model;
        view=new InputGerbong();
        view.setVisible(true);
    }
}
