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

public class TelaUsuarioController extends BaseController implements Initializable{

    @FXML
    private AnchorPane AnchorPaneUsuario;

    @FXML
    private Button btnNotificarObjeto;

    @FXML
    private Button btnProcurarObjeto;

    @FXML
    private Button btnSolicitacoes;

    @FXML
    private ImageView imageHome;
    
    @FXML
    private Button btnGoHome;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    @FXML
    void OpenProcurarObjeto(ActionEvent event) { //Forma antiga para servir como pop-up
        AnchorPane a;
        try {  
            a = (AnchorPane)FXMLLoader.load (getClass().getResource("/fxml/telaBusca.fxml"));
            Stage secondStage  = new Stage();
            Scene secondScene = new Scene(a);
            secondStage.setScene(secondScene);
            secondStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void OpenNotificarObjeto(ActionEvent event){
        AnchorPane a;
        try {  
            a = (AnchorPane)FXMLLoader.load (getClass().getResource("/fxml/telaNotificarObjeto.fxml"));
            Stage secondStage  = new Stage();
            Scene secondScene = new Scene(a);
            secondStage.setScene(secondScene);
            secondStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void goHome(ActionEvent event){
        sceneManager.switchScene("/fxml/telaInicial.fxml");  
    }
    

}
