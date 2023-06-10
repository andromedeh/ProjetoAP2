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

public class TelaSelecaoController extends BaseController {

    @FXML
    private Button btnAdm;
    
    @FXML
    private Button btnUser;
    
    @FXML
    private AnchorPane anchorPaneSelecao;

    public void handlePerfilAdm (ActionEvent event){
        this.btnUser.setStyle("-fx-background-color: EFD481; -fx-background-radius: 20px; -fx-border-radius: 20px;");
        sceneManager.switchScene("/fxml/telaLoginAdm.fxml");   
    }

    public void handlePerfilUser (ActionEvent event) throws Exception {
        this.btnAdm.setStyle("-fx-background-color: EFD481; -fx-background-radius: 20px; -fx-border-radius: 20px;");
        sceneManager.switchScene("/fxml/telaLogin.fxml");
    }
    
}
