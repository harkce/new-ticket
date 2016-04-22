/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import view.InputKereta;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlViewKereta {
    
    private Aplikasi model;
    private InputKereta view;
    
    public ControlViewKereta(Aplikasi model) {
        this.model = model;
        view = new InputKereta();
        view.setVisible(true);
    }
            
}
