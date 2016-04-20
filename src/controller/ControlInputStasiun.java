/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import view.InputStasiun;

/**
 *
 * @author Ridwan Wibowo
 */

public class ControlInputStasiun{
    private Aplikasi model;
    private InputStasiun view;
    
    public ControlInputStasiun(Aplikasi model){
        this.model=model;
        view=new InputStasiun();
        view.setVisible(true);
    }

    
    
}
