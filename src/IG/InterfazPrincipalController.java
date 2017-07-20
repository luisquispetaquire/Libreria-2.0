/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IG;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author LLLL
 */

public class InterfazPrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;
    /**
     * Initializes the controller class.
     */
    public static AnchorPane rootP;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        rootP = anchorPane;
        
        try {
            VBox box = FXMLLoader.load(getClass().getResource("ControlDeBotones.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(InterfazPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
        });
    }    
    
}
