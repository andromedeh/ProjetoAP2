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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaAdmController extends BaseController implements Initializable {

    @FXML
    private Button btnVerObjeto;

    @FXML
    private Button btnSolicitacoesAdm;

    @FXML
    private ImageView imageHome;
    
    @FXML
    private Button btnGoHome;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    void handleSolicitacoesAdm(ActionEvent event) {
        AnchorPane e;
        try {
            e = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/telaSolicitacoesAdm.fxml"));
            // this.btnStart.setStyle("-fx-background-color: E6BE40;");
            Stage secondStage = new Stage();
            Scene secondScene = new Scene(e);
            secondStage.setScene(secondScene);
            secondStage.show();

        } catch (IOException ex) {
            Logger.getLogger(TelaAdmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleVerObjeto(ActionEvent event) {
        AnchorPane f;
        try {
            f = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/telaObjetosAdm.fxml"));
            // this.btnStart.setStyle("-fx-background-color: E6BE40;");
            Stage secondStage = new Stage();
            Scene secondScene = new Scene(f);
            secondStage.setScene(secondScene);
            secondStage.show();

        } catch (IOException ex) {
            Logger.getLogger(TelaAdmController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void goHome(ActionEvent event){
        sceneManager.switchScene("/fxml/telaInicial.fxml");  
    }
    /*
    @FXML
            
    void handleSolicitacoesAdm(ActionEvent event){
        sceneManager.switchScene("/fxml/telaSolicitacoes.fxml");
    }
    @FXML
    void handleVerObjeto(ActionEvent event){
        sceneManager.switchScene("/fxml/telaObjetosAdm.fxml");
    }
    */
}
