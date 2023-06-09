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

public class TelaSelecaoController implements Initializable {

    @FXML
    private Button btnAdm;
    
    @FXML
    private Button btnUser;
    
    @FXML
    private AnchorPane anchorPaneSelecao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  

    public void handlePerfilAdm (ActionEvent event){
        this.btnUser.setStyle("-fx-background-color: EFD481; -fx-background-radius: 20px; -fx-border-radius: 20px;");
        AnchorPane a;
        try {
            a = (AnchorPane)FXMLLoader.load (getClass().getResource("/fxml/telaLoginAdm.fxml"));
            Stage stage  = new Stage();
            Scene secondScene = new Scene(a);
            stage.setScene(secondScene);
            stage.setResizable(true);
            stage.show();
            anchorPaneSelecao.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(TelaSelecaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void handlePerfilUser (ActionEvent event) throws Exception {
        this.btnAdm.setStyle("-fx-background-color: EFD481; -fx-background-radius: 20px; -fx-border-radius: 20px;");
        AnchorPane b;
        try {
            b = (AnchorPane)FXMLLoader.load (getClass().getResource("/fxml/telaLogin.fxml"));
            Stage stage  = new Stage();
            Scene secondScene = new Scene(b);
            stage.setScene(secondScene);
            stage.setResizable(true);
            stage.show();
            anchorPaneSelecao.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(TelaSelecaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
