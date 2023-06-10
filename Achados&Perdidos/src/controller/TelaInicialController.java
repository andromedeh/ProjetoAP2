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
        // this.btnStart.setStyle("-fx-background-color: E6BE40;");
        sceneManager.switchScene("/fxml/telaSelecao.fxml");
//        AnchorPane a;
//        try {
//            a = (AnchorPane)FXMLLoader.load (getClass().getResource("/fxml/telaSelecao.fxml"));
//            this.btnStart.setStyle("-fx-background-color: E6BE40;");
//            Stage secondStage  = new Stage();
//            Scene secondScene = new Scene(a);
//            secondStage.setScene(secondScene);
//            secondStage.show();
//            
//        } catch (IOException ex) {
//            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    
}