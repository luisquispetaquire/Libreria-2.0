/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IG;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author LLLL
 */


public class ControlDeBotonesController implements Initializable {
    
    @FXML
    private JFXButton botonRegistrarDia;

    @FXML
    private JFXButton botonGastos;

    @FXML
    private JFXButton botonCompras;

    @FXML
    private JFXButton BotonBalance;

    @FXML
    private JFXButton BotonTablas;

    @FXML
    private JFXButton salir;

    @FXML
    void cambiarPanel(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch(btn.getText())
        {
            case "Registrar Dia":InterfazPrincipalController.rootP.setStyle("-fx-background-color:#00FF00");
                break;
            case "Gastos":InterfazPrincipalController.rootP.setStyle("-fx-background-color:#0000FF");
                break;
            case "Compras":InterfazPrincipalController.rootP.setStyle("-fx-background-color:#FF0000");
                break;
            case "Balance":InterfazPrincipalController.rootP.setStyle("-fx-background-color:#FF0000");
                break;
            case "Tablas":InterfazPrincipalController.rootP.setStyle("-fx-background-color:#FF0000");
                break;
        }
    }

    @FXML
    void salir(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
