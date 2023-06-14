package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TelaSelecaoController extends BaseController implements Initializable {

    @FXML
    private Button btnAdm;
    
    @FXML
    private Button btnUser;
    
    @FXML
    private AnchorPane anchorPaneSelecao;
    
    @FXML
    private Button btnGoBack;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLoginInstanciado("");
    }
    
    public void handlePerfilAdm (ActionEvent event){
        this.btnUser.setStyle("-fx-background-color: EFD481; -fx-background-radius: 20px; -fx-border-radius: 20px;");
        sceneManager.switchScene("/fxml/telaLoginAdm.fxml");   
    }

    public void handlePerfilUser (ActionEvent event) throws Exception {
        this.btnAdm.setStyle("-fx-background-color: EFD481; -fx-background-radius: 20px; -fx-border-radius: 20px;");
        sceneManager.switchScene("/fxml/telaLogin.fxml");
    }
    
    @FXML
    void goBack(ActionEvent event){
        sceneManager.switchScene("/fxml/telaInicial.fxml");  
    }
}
