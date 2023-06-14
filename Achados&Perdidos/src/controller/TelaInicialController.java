package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaInicialController extends BaseController implements Initializable  {
    
    @FXML
    private Button btnStart;
    
    @Override
    public void initialize (URL url, ResourceBundle rb) {
       
    }  

    public void handleBtnStart (ActionEvent event) {
        sceneManager.switchScene("/fxml/telaSelecao.fxml");        
    }

    
}