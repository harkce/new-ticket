/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import view.InputRute;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlViewRute {
    private Aplikasi model;
    private InputRute view;
    
    public ControlViewRute(Aplikasi model){
        this.model=model;
        view=new InputRute();
        view.setVisible(true);
    }
}
